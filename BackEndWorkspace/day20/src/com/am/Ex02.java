package com.am;

import java.net.MalformedURLException;
import java.net.URL;

public class Ex02 {

	public static void main(String[] args) {
//		 String msg="https://www.google.com/search?sca_esv=034baad0715ecaf6&q=%EB%8F%84%EB%A9%94%EC%9D%B8+%EA%B5%AC%EB%A7%A4&udm=2&fbs=ABzOT_CZsxZeNKUEEOfuRMhc2yCIle3NjqrdI1yz4YBXXweAYROj_ssEdoGUqgqRO4_tQus9UEXRd2cQ6AZUANa6BbALH9VlD13tY4dy6_S1MxiV5njdIGzcurINDFIuBw78-Z7mQWVkKsUGuBpL4lEoDnvD3qhWyQtn0_gvPEVU-UiHOKxWYE6GZkzloQ6wYB_W9a3rdJWYWwyj-cMrPsBgBuDlxG2EBQ&sa=X&ved=2ahUKEwiH6tnOrLOMAxWYbvUHHTWxFqgQtKgLegQIGRAB&biw=1016&bih=642&dpr=1";
//		 String msg="http://127.0.0.1:9092";
//		 String msg="http://127.0.0.1:80"; ����Ʈ
		 String msg="https://getbootstrap.com/docs/3.4/css/#buttons";
		 java.net.URL url=null;
		 
		 try {
			url=new URL(msg);
			System.out.println(url.getProtocol()); // ��Ź��
			System.out.println(url.getHost()); // ������ -> ip
			System.out.println(url.getPort()); // http:80 / https:443 
			System.out.println(url.getDefaultPort());
			System.out.println(url.getPath()); // ��û��� �� ����
			System.out.println(url.getQuery()); // �߰� ���� ��û���� (key = val ���� ��û ����)
			System.out.println(url.getRef()); // ��ġ ����
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}









