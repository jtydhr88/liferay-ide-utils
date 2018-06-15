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

package com.liferay.ide.tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Map;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Haoyi Sun
 */
public class LogUtil {

	public static void addErrorHrefToNewItem(String buildNumber, String htmlName, Element newItem) {
		Element href = new Element("a");

		href.attr("href", "../" + buildNumber + "/" + htmlName + ".html");
		href.appendText(htmlName);
		href.appendTo(newItem);

		newItem.appendElement("br");
	}

	public static boolean createHtml(String log, File folder, String htmlName) {
		File html = new File(folder, htmlName + ".html");

		try {
			html.createNewFile();
		}
		catch (IOException ioe) {
			System.out.println("Create html " + htmlName + " error!");

			ioe.printStackTrace();

			return false;
		}

		try (FileWriter writer = new FileWriter(html)) {
			String[] lines = log.split("\\n");

			for (String line : lines) {

				if (line.contains("at ") || line.contains("Exception")) {
					line = "<p style=\"color:red\">" + line + "</p>";
				}
				else {
					line = "<p>" + line + "</p>";
				}

				writer.write(line);
			}
		}
		catch (Exception e) {
			System.out.println("Write file: " + htmlName + " error!");

			e.printStackTrace();

			return false;
		}

		return true;
	}

	public static Element createNewItem(String buildNumber) {
		Element newItem = new Element("div");

		newItem.addClass("ErrorReport");
		newItem.attr("id", String.valueOf(buildNumber));

		Element h1 = new Element("h1");

		h1.appendText("build #" + buildNumber);

		h1.appendTo(newItem);

		return newItem;
	}

	public static void deleteFolder(File folder) {
		if (fileExist(folder)) {
			try {
				FileUtils.deleteDirectory(folder);
			}
			catch (IOException ioe) {
				System.out.print("Delete log folder error!");
				ioe.printStackTrace();
			}
		}
	}

	public static boolean fileExist(File file) {
		if ((file != null) && file.exists()) {
			return true;
		}

		return false;
	}

	public static String getBuildArg(String[] args, int n) {
		if ((args.length == 0) || (args[n] == null) || args[n].equals("")) {
			if (n == 0) {
				System.out.println("Must have build number!");
			}

			if (n == 1) {
				System.out.println("Must have build name!");
			}

			return "-1";
		}

		return args[n];
	}

	public static String getBuildName(String[] args) {
		return getBuildArg(args, 1);
	}

	public static String getBuildNumber(String[] args) {
		String number = getBuildArg(args, 0);

		if (number.equals(-1)) {
			return number;
		}

		try {
			int buildNumber = parseInt(number);

			if (buildNumber < 0) {
				System.out.println("The build number must greater than 0!");
			}
			else {
				return number;
			}
		}
		catch (Exception e) {
			System.out.println("The build number must be integer!");

			e.printStackTrace();
		}

		return "-1";
	}

	public static Optional<String> getLogFromWeb(String url) {
		HttpGet request = new HttpGet(url);

		HttpClient client = HttpClientBuilder.create().build();

		Optional<String> log = Optional.empty();

		try {
			HttpResponse response = client.execute(request);

			StatusLine statusLine = response.getStatusLine();

			if (statusLine.getStatusCode() != 200) {
				System.out.println("Response status is not 200!");

				return log;
			}

			HttpEntity entity = response.getEntity();

			String entityContent = EntityUtils.toString(entity, "utf-8");

			log = Optional.of(entityContent);
		}
		catch (Exception e) {
			System.out.println("Unable to get log from server!");

			e.printStackTrace();
		}

		return log;
	}

	public static boolean isNotEmpty(String s) {
		boolean notEmpty = (s != null) && (!s.isEmpty());

		return  notEmpty;
	}

	public static int parseInt(String s) {
		int i = -1;

		try {
			i = Integer.parseInt(s);
		}
		catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}

		return i;
	}

	public static String removeExtraElement(Elements items) {
		String removedElementId = null;

		if (items.size() >= Log.MAX) {
			Element removedElement = items.remove(items.size() - 1);

			removedElementId = removedElement.id();
		}

		return removedElementId;
	}

	public static String updateItems(File itemsHtml, Map<String, String> items, String buildNumber) {
		Element newItem = createNewItem(buildNumber);

		items.forEach((jobName, jobNumber) -> addErrorHrefToNewItem(buildNumber, jobName, newItem));

		String removedElementId = updateItemsHtmlBody(itemsHtml, newItem);

		return removedElementId;
	}

	public static String updateItems(File itemsHtml, String commitMessage, String buildNumber) {
		Element newItem = createNewItem(buildNumber);

		addErrorHrefToNewItem(buildNumber, commitMessage, newItem);

		String removedElementId = updateItemsHtmlBody(itemsHtml, newItem);

		return removedElementId;
	}

	public static String updateItemsHtmlBody(File itemsHtml, Element newItem) {
		PrintWriter writer = null;

		String removedElementId = null;

		try {
			Document document = Jsoup.parse(itemsHtml, "utf-8");

			Elements elements = document.getElementsByClass("ErrorReport");

			removeExtraElement(elements);

			elements.add(0, newItem);

			Element newBody = new Element("body");

			newBody.append(elements.outerHtml());

			Element body = document.body();

			body.replaceWith(newBody);

			writer = new PrintWriter(itemsHtml, "utf-8");

			writer.write(document.html());
		}
		catch (IOException ioe) {
			System.out.println("Parse html items failure!");

			ioe.printStackTrace();

			return removedElementId;
		}
		finally {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
		}

		return removedElementId;
	}

	public static void waitForUpload(Process upload, int timeout) {
		long overTime = System.currentTimeMillis() + timeout;

		long waitTime = 5 * 1000;

		int exitValue = -1;

		while (true) {
			try {
				if ((exitValue == 0) || (System.currentTimeMillis() >= overTime)) {
					break;
				}
				else {
					Thread.sleep(waitTime);
				}

				exitValue = upload.exitValue();
			}
			catch (IllegalThreadStateException ie) {
			}
			catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

}
