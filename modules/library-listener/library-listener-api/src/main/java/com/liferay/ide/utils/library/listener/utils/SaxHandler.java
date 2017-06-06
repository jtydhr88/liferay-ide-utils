package com.liferay.ide.utils.library.listener.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
	private List<HashMap<String, String>> list = null;
	private HashMap<String, String> map = null; 
	private String currentTag = null;
	private String currentValue = null;
	private String nodeName = null;

	public SaxHandler(String nodeName) {
		this.nodeName = nodeName;
	}

	@Override
	public void startDocument() throws SAXException {
		list = new ArrayList<HashMap<String, String>>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals(nodeName)) {
			map = new HashMap<String, String>();
		}
		if (attributes != null && map != null) {
			for (int i = 0; i < attributes.getLength(); i++) {
				map.put(attributes.getQName(i), attributes.getValue(i));
			}
		}
		currentTag = qName;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (currentTag != null && map != null) {
			currentValue = new String(ch, start, length);
			if (currentValue != null && !currentValue.equals("") && !currentValue.equals("\n")) {
				map.put(currentTag, currentValue);
			}
		}
		currentTag = null;
		currentValue = null;
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals(nodeName)) {
			list.add(map);
			map = null;
		}
	}

	public List<HashMap<String, String>> getList() {
		return list;
	}
}