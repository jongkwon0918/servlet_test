package com.web.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExtraDataServlet
 */
@WebServlet("/extradata.do")
public class ExtraDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExtraDataServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String file = getServletContext().getInitParameter("configfile");
		String path = ExtraDataServlet.class.getResource(file).getPath();
		System.out.println(path);
		Properties config=new Properties();
		config.load(new FileReader(path));
		
		System.out.println(config);
		System.out.println(config.getProperty("driver"));
		System.out.println(config.getProperty("url"));
		
		String prevPage=request.getHeader("Referer");
		System.out.println(prevPage);
		
		String url=request.getRequestURL().toString();
		String url2=request.getRequestURI();
		System.out.println(url);
		System.out.println(url2);
		
		String contextPath=request.getContextPath();
		System.out.println(contextPath);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
