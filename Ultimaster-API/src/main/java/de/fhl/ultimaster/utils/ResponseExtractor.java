package de.fhl.ultimaster.utils;

import java.nio.charset.StandardCharsets;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.pmw.tinylog.Logger;

public class ResponseExtractor {

	public static String getBody(HttpResponse response) {
		HttpEntity entity = response.getEntity();
		try {
			return EntityUtils.toString(entity, StandardCharsets.UTF_8);
		} catch (Exception e) {
			Logger.error(e.getMessage());
		}
		return "-";
	}

	public static String getContentType(HttpResponse response) {
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			Header contentType = entity.getContentType();
			if (contentType != null) {
				return contentType.getValue();
			}
		}
		return "-";
	}

}
