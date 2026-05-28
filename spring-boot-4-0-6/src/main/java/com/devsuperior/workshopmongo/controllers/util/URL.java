package com.devsuperior.workshopmongo.controllers.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.time.Instant;

public class URL {

	public static String decodeParam(String text) throws UnsupportedEncodingException {
		return URLDecoder.decode(text, "UTF-8");
	}

	public static Instant convertDate(String textDate, Instant defaultValue) throws ParseException {
		if (textDate.isEmpty())
			return defaultValue;

		return Instant.parse(textDate);
	}
}
