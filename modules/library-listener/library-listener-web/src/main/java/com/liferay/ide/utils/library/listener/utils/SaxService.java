package com.liferay.ide.utils.library.listener.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxService {

	public static List<HashMap<String, String>> readXML(InputStream inputStream, String nodeName) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();

			SAXParser sParser = factory.newSAXParser();

			SaxHandler myHandler = new SaxHandler(nodeName);

			sParser.parse(inputStream, myHandler);

			inputStream.close();

			return myHandler.getList();
		}
		catch (Exception e) {
		}

		return null;
	}

}