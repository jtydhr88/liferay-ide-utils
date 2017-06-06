package com.liferay.ide.utils.library.listener.utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

	public static InputStream getXML(final String path) {
		try {
			final URL url = new URL(path);

			if (url != null) {
				final HttpURLConnection connection = (HttpURLConnection) url.openConnection();

				connection.setDoInput(true);
				connection.setConnectTimeout(3000);
				connection.setRequestMethod("GET");

				int requesetCode = connection.getResponseCode();

				if (requesetCode == 200) {
					return connection.getInputStream();
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}