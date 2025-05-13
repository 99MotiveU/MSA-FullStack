package com.myframework;

import javax.servlet.http.HttpServletRequest;

public interface Controller {
	String execute(HttpServletRequest req);
}
