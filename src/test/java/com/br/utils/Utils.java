package com.br.utils;

public abstract class Utils {
	
	private static String URL = "https://mais.cpb.com.br/meditacoes-diarias/";
	private static boolean FirstLink = false;
	private static int days = 7;

	public static String getURL() {
		return URL;
	}

	public static void setURL(String uRL) {
		URL = uRL;
		setFirstLink(true);
	}

	public boolean getFirstLink() {
		return FirstLink;
	}

	protected static void setFirstLink(boolean firstLink) {
		FirstLink = firstLink;
	}

	public int getDays() {
		return days;
	}

	public static void setDays(int Days) {
		days = Days;
	}
	
}
