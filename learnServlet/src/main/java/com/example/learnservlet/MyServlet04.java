package com.example.learnservlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet04
 */
@WebServlet("/myServlet04")
public class MyServlet04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		request.setAttribute("name", name);
		System.out.println(name);

		String gallonStr = request.getParameter("gallon");
		String yardStr = request.getParameter("yard");
		String poundStr = request.getParameter("pound");
		String literStr = request.getParameter("liter");
		String metersStr = request.getParameter("meters");
		String kiloGramStr = request.getParameter("kiloGram");

		Double gallon = null;
		Double yard = null;
		Double pound = null;
		Double liter = null;
		Double meters = null;
		Double kiloGram = null;

		if (gallonStr != null && !gallonStr.equals("")) {
			gallon = Double.parseDouble(gallonStr);
		}
		if (yardStr != null && !yardStr.equals("")) {
			yard = Double.parseDouble(yardStr);
		}

		request.setAttribute("gallon",gallon);

		String jspPath = "/WEB-INF/index.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(jspPath);
		dispatcher.forward(request, response);
	}

}
