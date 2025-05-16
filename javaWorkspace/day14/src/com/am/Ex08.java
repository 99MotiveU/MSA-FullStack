package com.am;

import java.util.StringTokenizer;

public class Ex08 {

	public static void main(String[] args) {
		String data = "11 22@22 33@66 77";
		StringTokenizer stk = new StringTokenizer(data, " ");
		int cnt = 0;
		while (stk.hasMoreTokens()) {
			String msg1 = null;
			if (cnt % 2 == 0) {
				msg1 = stk.nextToken();
			} else {
				msg1 = stk.nextToken("@");
			}
			System.out.println(msg1);
		}

	}

}
