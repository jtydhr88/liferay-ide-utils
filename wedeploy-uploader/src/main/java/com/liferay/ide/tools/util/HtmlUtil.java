/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.ide.tools.util;

import com.liferay.ide.tools.LogConstants;
import com.liferay.ide.tools.build.Result.FailureTestResult;

import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BinaryOperator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

/**
 * @author Haoyi Sun
 */
public class HtmlUtil {

	public static Element createCheckerItems(String checkerName, String checkerNumber) {
		Element item = new Element("div");

		item.attr("class", "accordion-group");

		item.attr("id", checkerName + checkerNumber + LogConstants.ITEM_ID_SUFFIX);

		Element accordionHeading = new Element("div");

		accordionHeading.attr("class", "accordion-heading");

		Element a = new Element("a");

		a.attr("class", "accordion-toggle");

		a.attr("data-parent", "#" + checkerName);

		a.attr(
			"href",
			"." + File.separator + checkerName + File.separator + checkerNumber + File.separator + checkerName +
				checkerNumber + LogConstants.SIMPLE_LOG_FILE_SUFFIX);

		a.appendText(checkerName + "#" + checkerNumber);

		a.appendTo(accordionHeading);

		accordionHeading.appendTo(item);

		return item;
	}

	public static void createCompleteLog(Document completeLogHtml, String consoleText) {
		Element body = completeLogHtml.body();

		String[] lines = consoleText.split("\\n");

		for (String line : lines) {
			Element p = new Element("p");

			if (line.contains("at ") || line.contains("Exception")) {
				p.attr("style", "color:red");
			}

			p.appendText(line);
			p.appendTo(body);
		}
	}

	public static Element createFailedBuildPanel(
		String headingId, String parentId, String panelBodyId, String title, String consoleText) {

		Element panel = new Element("div");

		panel.attr("class", "panel panel-default");

		Element panelHeading = new Element("div");

		panelHeading.attr("class", "panel-heading");

		panelHeading.attr("role", "tab");

		panelHeading.attr("id", headingId);

		Element h4 = new Element("h4");

		h4.attr("class", "panel-title");

		Element a = new Element("a");

		a.attr("class", "collapsed");

		a.attr("role", "button");

		a.attr("data-toggle", "collapse");

		a.attr("data-parent", "#" + parentId);

		a.attr("href", "#" + panelBodyId);

		a.attr("aria-expanded", "false");

		a.attr("aria-controls", panelBodyId);

		a.appendText(title);

		a.appendTo(h4);

		h4.appendTo(panelHeading);

		panelHeading.appendTo(panel);

		Element bodyDiv = new Element("div");

		bodyDiv.attr("id", panelBodyId);
		bodyDiv.attr("class", "panel-collapse collapse");
		bodyDiv.attr("role", "tabpanel");
		bodyDiv.attr("aria-labelledby", headingId);

		Element panelBody = new Element("div");

		panelBody.attr("class", "panel-body");

		Element h1 = new Element("h1");

		h1.attr("class", "simple-result-regression");

		h1.appendText(LogConstants.FAILED);

		Element pre1 = new Element("pre");

		pre1.appendText(consoleText);

		h1.appendTo(panelBody);

		pre1.appendTo(panelBody);

		panelBody.appendTo(bodyDiv);

		bodyDiv.appendTo(panel);

		return panel;
	}

	public static Element createNavigatorElement(String navName) {
		Element navElement = new Element("li");

		navElement.attr("id", navName + LogConstants.NAV_ID_SUFFIX);

		Element navHref = new Element("a");

		navHref.attr("href", "#");

		navHref.attr("onclick", "showList('" + navName + "')");

		navHref.appendText(navName);

		navHref.appendTo(navElement);

		return navElement;
	}

	public static void createSimpleLogToFailedBuild(
		Document simpleLogHtml, String buildName, String failedTestName, String completeFileName, String title,
		String consoleText) {

		Element body = simpleLogHtml.body();

		Element simpleButtonDiv = _createSimpleButtonsDiv(buildName, failedTestName, completeFileName);

		simpleButtonDiv.appendTo(body);

		Element separateDiv = _createSeparateDiv();

		separateDiv.appendTo(body);

		Element panelGroup = _createPanelGroup(buildName);

		String headingId = buildName + "heading";

		String panelBodyId = buildName + "collapse";

		Element failedBuildPanel = createFailedBuildPanel(headingId, buildName, panelBodyId, title, consoleText);

		failedBuildPanel.appendTo(panelGroup);

		panelGroup.appendTo(body);
	}

	public static void createSimpleLogToUnstableBuild(
		Document simpleLogHtml, List<FailureTestResult> results, String buildName, String failedTestName,
		String completeFileName) {

		Element body = simpleLogHtml.body();

		Element simpleButtonDiv = _createSimpleButtonsDiv(buildName, failedTestName, completeFileName);

		simpleButtonDiv.appendTo(body);

		Element separateDiv = _createSeparateDiv();

		separateDiv.appendTo(body);

		Element panelGroup = _createPanelGroup(buildName);

		AtomicInteger count = new AtomicInteger();

		results.forEach(
			result -> {
				int idCount = count.getAndIncrement();

				String headingId = buildName + "heading" + idCount;

				String panelBodyId = buildName + "collapse" + idCount;

				String regression = result.getRegression();

				String errorMessage = result.getErrorMessage();

				String stackTrace = result.getStackTrace();

				if (errorMessage == null) {
					errorMessage = "nothing";
				}

				Element errorInfoElement = _createErrorInfo(
					headingId, buildName, panelBodyId, regression, errorMessage, stackTrace);

				errorInfoElement.appendTo(panelGroup);
			});

		panelGroup.appendTo(body);
	}

	public static void deleteElementById(Document document, String navName) {
		Element body = document.body();

		Element element = body.getElementById(navName + LogConstants.NAV_ID_SUFFIX);

		element.remove();
	}

	public static String getCommitMessageFromHtml(String html) {
		Document document = Jsoup.parse(html);

		Element body = document.body();

		Elements tables = body.getElementsByTag("table");

		AtomicReference<String> commitMessage = new AtomicReference<>();

		tables.forEach(
			table -> {
				Elements trs = table.getElementsByTag("tr");

				trs.forEach(
					tr -> {
						Elements tds = tr.getElementsByTag("td");

						tds.forEach(
							td -> {
								Elements ols = td.getElementsByTag("ol");

								ols.forEach(
									ol -> {
										Elements lis = ol.getElementsByTag("li");

										lis.forEach(
											li -> {
												commitMessage.accumulateAndGet(
													li.ownText(),
													(s1, s2) -> {
														if (s1 == null) {
															return s2;
														}
														else {
															return s1 + s2;
														}
													});
											});
									});
							});
					});
			});

		return commitMessage.get();
	}

	public static String getFailedTestNameFromHtml(String html) {
		Document testReportHtml = Jsoup.parse(html);

		Element testReportBody = testReportHtml.body();

		Elements h2Tags = testReportBody.getElementsByTag("h2");

		AtomicReference<String> failedTestName = new AtomicReference<>();

		h2Tags.forEach(
			h2 -> {
				String text = h2.ownText();

				if (text.equals(LogConstants.FAILED_TESTS)) {
					Element h3 = h2.nextElementSibling();

					Elements elements = h3.getElementsByAttribute("name");

					elements.forEach(
						element -> {
							failedTestName.set(element.attr("name"));
						});
				}
			});

		return failedTestName.get();
	}

	public static List<String> getFailedTestUrlsFromWeb(String url, String buildName) {
		Optional<String> html = LogUtil.getHtmlFromWeb(url);

		List<String> urls = new ArrayList<>();

		if (html.isPresent()) {
			String content = html.get();

			Document document = Jsoup.parse(content);

			Element body = document.body();

			Elements elements = body.getElementsByClass("shown");

			elements.forEach(
				element -> {
					List<Node> nodes = element.childNodes();

					nodes.forEach(
						node -> {
							Attributes attribute = node.attributes();

							String href = attribute.get("href");

							href = href.replace("..", "");

							String completeUrl =
								LogUtil.getPropertyFromProperties(LogConstants.SERVER_IP_KEY) + "/" + LogConstants.JOB +
									"/" + buildName + href;

							urls.add(completeUrl);
						});
				});

			urls.addAll(getHiddenFailedPageUrls(body, buildName));
		}

		return urls;
	}

	public static FailureTestResult getFailureTestInfoFromWeb(String url) {
		Optional<String> html = LogUtil.getHtmlFromWeb(url);

		FailureTestResult result = new FailureTestResult();

		if (html.isPresent()) {
			String content = html.get();

			Document document = Jsoup.parse(content);

			Element body = document.body();

			Elements h1 = body.getElementsByTag("h1");

			h1.forEach(
				element -> {
					String text = element.ownText();

					if (text.equals(LogConstants.REGRESSION) || text.equals(LogConstants.FAILED)) {
						Element p = element.nextElementSibling();

						Elements spans = p.getElementsByTag("span");

						spans.forEach(
							span -> {
								String regression = span.ownText();

								result.setRegression(regression);
							});
					}
				});

			Elements h3 = body.getElementsByTag("h3");

			h3.forEach(
				element -> {
					String text = element.ownText();

					if (text.equals(LogConstants.ERROR_MESSAGE)) {
						Element errorMessageElement = element.nextElementSibling();

						String errorMessage = errorMessageElement.ownText();

						result.setErrorMessage(errorMessage);
					}

					if (text.equals(LogConstants.STACK_TRACE)) {
						Element stackTraceElement = element.nextElementSibling();

						String stackTrace = stackTraceElement.ownText();

						result.setStackTrace(stackTrace);
					}
				});
		}

		return result;
	}

	public static List<String> getHiddenFailedPageUrls(Element body, String buildName) {
		List<String> urls = new ArrayList<>();

		Elements hidden = body.getElementsByClass("hidden");

		hidden.forEach(
			element -> {
				Elements a = element.getElementsByTag("a");

				a.forEach(
					element1 -> {
						String href = element1.attr("href");

						href = href.replace("../", "");

						String completeUrl =
							LogUtil.getPropertyFromProperties(LogConstants.SERVER_IP_KEY) + "/" + LogConstants.JOB +
								"/" + buildName + href;

						urls.add(completeUrl);
					});
			});

		return urls;
	}

	public static String getModuleBuildsFromHtml(String html) {
		Document document = Jsoup.parse(html);

		Element body = document.body();

		Elements elements = body.getElementsMatchingOwnText(LogConstants.MODULE_BUILDS);

		AtomicReference<String> moduleName = new AtomicReference<>();

		elements.forEach(
			element -> {
				Element moduleBuilds = element.nextElementSibling();

				Elements tr = moduleBuilds.getElementsByTag("tr");

				tr.forEach(
					t -> {
						Elements td = t.getElementsByTag("td");

						td.forEach(
							d -> {
								Elements hrefs = d.getElementsByTag("a");

								String content = moduleName.get();

								if (content == null) {
									if ((hrefs.size() == 0)) {
										moduleName.set(d.ownText());
									}
									else {
										hrefs.forEach(a -> {
											moduleName.set(a.text());
										});
									}
								}
							});

					});
			});

		return moduleName.get();
	}

	public static String updateHomeContent(Document document, String checkerName, String checkerNumber) {
		Element body = document.body();

		Element nav = body.getElementById("checker-logger-nav");

		Element navElement = nav.getElementById(checkerName + LogConstants.NAV_ID_SUFFIX);

		if (navElement == null) {
			navElement = createNavigatorElement(checkerName);

			navElement.appendTo(nav);

			Element checker = new Element("div");

			checker.attr("class", "accordion");

			checker.attr("id", checkerName);

			checker.appendTo(body);
		}

		Element checkerItem = body.getElementById(checkerName);

		Elements items = checkerItem.getElementsByClass("accordion-group");

		String removedNumber = null;

		if (items.size() >= LogConstants.LOG_COUNT_MAX) {
			Element removedElement = items.get(0);

			String text = removedElement.text();

			String[] nameAndNumber = text.split("#");

			removedNumber = nameAndNumber[1];

			String id = removedElement.attr("id");

			deleteElementById(document, id);
		}

		Element item = createCheckerItems(checkerName, checkerNumber);

		item.appendTo(checkerItem);

		return removedNumber;
	}

	private static Element _createErrorInfo(
		String headingId, String parentId, String panelBodyId, String regression, String errorMessage,
		String stackTrace) {

		Element panel = new Element("div");

		panel.attr("class", "panel panel-default");

		Element panelHeading = new Element("div");

		panelHeading.attr("class", "panel-heading");

		panelHeading.attr("role", "tab");

		panelHeading.attr("id", headingId);

		Element h4 = new Element("h4");

		h4.attr("class", "panel-title");

		Element a = new Element("a");

		a.attr("class", "collapsed");

		a.attr("role", "button");

		a.attr("data-toggle", "collapse");

		a.attr("data-parent", "#" + parentId);

		a.attr("href", "#" + panelBodyId);

		a.attr("aria-expanded", "false");

		a.attr("aria-controls", panelBodyId);

		a.appendText(regression);

		a.appendTo(h4);

		h4.appendTo(panelHeading);

		panelHeading.appendTo(panel);

		Element bodyDiv = new Element("div");

		bodyDiv.attr("id", panelBodyId);
		bodyDiv.attr("class", "panel-collapse collapse");
		bodyDiv.attr("role", "tabpanel");
		bodyDiv.attr("aria-labelledby", headingId);

		Element panelBody = new Element("div");

		panelBody.attr("class", "panel-body");

		Element h1 = new Element("h1");

		h1.attr("class", "simple-result-regression");

		h1.appendText(LogConstants.REGRESSION);

		Element p = new Element("p");

		Element span = new Element("span");

		span.attr("class", "simple-span");

		span.appendText(regression);

		Element errorMessageH3 = new Element("h3");

		errorMessageH3.appendText(LogConstants.ERROR_MESSAGE);

		Element pre1 = new Element("pre");

		pre1.appendText(errorMessage);

		Element stackTraceH3 = new Element("h3");

		stackTraceH3.appendText(LogConstants.STACK_TRACE);

		Element pre2 = new Element("pre");

		pre2.appendText(stackTrace);

		h1.appendTo(panelBody);

		span.appendTo(p);

		p.appendTo(panelBody);

		errorMessageH3.appendTo(panelBody);

		pre1.appendTo(panelBody);

		stackTraceH3.appendTo(panelBody);

		pre2.appendTo(panelBody);

		panelBody.appendTo(bodyDiv);

		bodyDiv.appendTo(panel);

		return panel;
	}

	private static Element _createPanelGroup(String accordionId) {
		Element panelGroup = new Element("div");

		panelGroup.attr("class", "panel-group");
		panelGroup.attr("id", accordionId);
		panelGroup.attr("role", "tablist");
		panelGroup.attr("aria-multiselectable", "true");

		return panelGroup;
	}

	private static Element _createSeparateDiv() {
		Element div = new Element("div");

		Element p = new Element("p");

		p.appendTo(div);

		return div;
	}

	private static Element _createSimpleButtonsDiv(String accordionId, String failedTestName, String completeFileName) {
		Element div = new Element("div");

		Element switchButton = new Element("button");

		switchButton.attr("type", "button");
		switchButton.attr("class", "btn btn-danger simple-main-switch");
		switchButton.attr("data-toggle", "collapse");
		switchButton.attr("data-target", accordionId);
		switchButton.appendText(failedTestName);

		Element completeButton = new Element("button");

		completeButton.attr("type", "button");
		completeButton.attr("class", "complete-button");
		completeButton.attr("onclick", "javascript:window.location.href= '" + completeFileName + "'");
		completeButton.appendText("complete-log");

		switchButton.appendTo(div);
		completeButton.appendTo(div);

		return div;
	}

}
