package com.web.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.Person;

@WebServlet("/persondata.do")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PersonServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		
//		String ageStr=request.getParameter("age");
//		int age=0;
//		if (ageStr!=null&&!ageStr.equals("")) {
//			age=Integer.parseInt(request.getParameter("age")) ;
//		}
		
		int age=0;
		try {
			age= Integer.parseInt(request.getParameter("age")) ;
		} catch (NumberFormatException e) {}
		
		double height=Double.parseDouble(request.getParameter("height"));
		String color=request.getParameter("color");
		String[] animals=request.getParameterValues("animals");
		String lunch=request.getParameter("lunch");
		String info=request.getParameter("info");
		
		
		System.out.println("이름은 "+ name+"입니다.");
		System.out.println("나이는 "+ age+"살 입니다.");
		System.out.println("키는 "+ height+"cm입니다."); 
		System.out.println("좋아하는 색은 " + color +"입니다.");
		System.out.print("좋아하는 동물은 ");
		String animalList=Arrays.stream(animals).collect(Collectors.joining(", "));
		System.out.println(animalList); 
		System.out.println("점심메뉴는 " + lunch +"입니다.");
		System.out.println("자기소개 : " + info);
		
		Person p =Person.builder()
				.name(name)
				.age(age)
				.height(height)
				.color(color)
				.lunch(lunch)
				.animals(animals)
				.info(info)
				.build();
		System.out.println(p);
		
		//다른 서블릿에서 이용할 데이터를 저장하기
		request.setAttribute("person", p);
		
		//다른 서블릿을 호출하기
		RequestDispatcher rd=request.getRequestDispatcher("/View/personview.do");
		rd.forward(request, response);
		
//		response.sendRedirect(request.getContextPath()+"/View/personview.do");
		
//		Map<String, String[]> parameters=request.getParameterMap();
//		parameters.forEach((k,v)->{
//			System.out.println(k);
//			System.out.println(Arrays.toString(v));
//		});
	}

}
