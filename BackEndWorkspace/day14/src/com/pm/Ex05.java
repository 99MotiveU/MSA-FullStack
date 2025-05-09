package com.pm;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex05 {

	public static void main(String[] args) {
		Date d=new Date();
		SimpleDateFormat sdf;
		sdf=new SimpleDateFormat();
//		sdf.applyPattern("yyyy.MM.dd G 'at' HH:mm:ss z");
		sdf.applyPattern("yyyy MM d  hh : mm : ss");		
		String msg=sdf.format(d);
		System.out.println(msg);
		
		int won = 1000000;
		NumberFormat nf = DecimalFormat.getInstance();
		DecimalFormat df = new DecimalFormat("$ ###,###,###,###.00))");
		String msg2 = df.format(won);
		System.out.println(msg2);
	}

}








