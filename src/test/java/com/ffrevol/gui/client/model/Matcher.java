package com.ffrevol.gui.client.model;

public class Matcher {
		public static final int INDEX_NOT_FOUND = -1; 
		public static final String EMPTY = ""; 

		public static int countMatches(String str, String sub) {
			if (isEmpty(str) || isEmpty(sub)) {
				return 0;
			}
			int count = 0;
			int idx = 0;
			while ((idx = str.indexOf(sub, idx)) != INDEX_NOT_FOUND) {
				count++;
				idx += sub.length();
			}
			return count;
		}

		private static boolean isEmpty(String str) {
			if(str == null) return true;
			if(str.compareTo(EMPTY) == 0) return true;
			return false;
		}
}
