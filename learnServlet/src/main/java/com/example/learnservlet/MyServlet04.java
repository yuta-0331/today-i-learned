package com.example.learnservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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

		String gallonStr = request.getParameter("gallon");
		String yardStr = request.getParameter("yard");
		String poundStr = request.getParameter("pound");
		String literStr = request.getParameter("liter");
		String metersStr = request.getParameter("meters");
		String kiloGramStr = request.getParameter("kiloGram");
		ArrayList<String> strings = new ArrayList<>(Arrays.asList(
				gallonStr, yardStr, poundStr, literStr, metersStr, kiloGramStr)
		);

		Double gallon = null;
		Double yard = null;
		Double pound = null;
		Double liter = null;
		Double meters = null;
		Double kiloGram = null;
		ArrayList<Double> doubles = new ArrayList<>(Arrays.asList(gallon, yard, pound, liter, meters, kiloGram));

		// リストを使ってダブル型変数に値をセット
		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i) != null && !"".equals(strings.get(i))) {
				try {
					doubles.set(i, Double.parseDouble(strings.get(i)));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
		}

		// リストを使って属性をセット
		for (int i = 0; i < strings.size(); i++) {{
			request.setAttribute(strings.get(i), doubles.get(i));
		}}

		String jspPath = "/WEB-INF/index.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(jspPath);
	}

}
