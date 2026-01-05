package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServlet클래스를 상속받는 클래스를 선언
public class BasicServlet extends HttpServlet{
	//doGet(), doPost() 메소드를 재정의해서 사용
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//메소드는 클라이언트가 get 매소드로 요청을 보내면 실행함
		System.out.println("get로 요청");
		
		//전역 초기화값
		String path=getServletContext().getInitParameter("downloaddir");
		System.out.println(path);
		
		//서블릿 초기화값
		String initData=getInitParameter("configFile");
		System.out.println(initData);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		//클라이언트가 post 메소드로 요청을 했을때 실핼
		System.out.println("post로 요청");
	}
}
