package com.web.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/data")
public class BasicDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BasicDataServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//클라이언트가 전송한 데이처 가져오기
		//데이터를 가져오려면 getParameter("key값")메소드를 이용
		String d=request.getParameter("test");
		System.out.println(d);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//데이터 인코딩 처리하기
		//setCharacterEncoding()메소드를 이용
		request.setCharacterEncoding("UTF-8");
		String lunch=request.getParameter("lunch");
		System.out.println(lunch);
		//다수값이 전달됐을때 -> getParameterValues('key') String[]
//		String lang=request.getParameter("lang");
		String[] lang=request.getParameterValues("lang");
		System.out.println(Arrays.toString(lang));
		Arrays.stream(lang).forEach(System.out::println);
	}

}
