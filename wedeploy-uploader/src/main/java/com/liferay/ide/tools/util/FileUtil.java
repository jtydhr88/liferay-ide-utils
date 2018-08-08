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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileUtils;

import org.jsoup.nodes.Document;

/**
 * @author Haoyi Sun
 */
public class FileUtil {

	public static File copyFile(File srcFile, File destDir, String newName) {
		File oldNameFile = null;

		File newNameFile = null;

		try {
			FileUtils.copyFileToDirectory(srcFile, destDir);

			if (newName != null) {
				oldNameFile = new File(destDir, srcFile.getName());

				File parentFile = oldNameFile.getParentFile();

				newNameFile = new File(parentFile, newName);

				oldNameFile.renameTo(newNameFile);
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return newNameFile;
	}

	public static File createLogFolder(File contentFolder, String checkerName, String buildNumber) {
		File htmlFolder = new File(contentFolder, "html");

		File checkerFolder = new File(htmlFolder, checkerName);

		if (!fileExist(checkerFolder)) {
			checkerFolder.mkdir();
		}

		File logFolder = new File(checkerFolder, buildNumber);

		if (fileExist(logFolder)) {
			deleteFolder(logFolder);
		}

		logFolder.mkdir();

		return logFolder;
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

	public static String readFile(File file) {
		String content = "";

		try (FileReader reader = new FileReader(file)) {
			char[] chars = new char[1024];

			while (reader.read(chars) != -1) {
				content = content + new String(chars);
			}
		}
		catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return content;
	}

	public static void writeFile(File file, Document document) {
		try (FileWriter writer = new FileWriter(file)) {
			String html = document.html();

			writer.write(html);
		}
		catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}