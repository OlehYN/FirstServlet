package com.javaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -7980969950032177143L;

	private static final String LOGIN = "admin";
	private static final String PASSWORD = "admin";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Вхід до системи національної безпеки</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<center>");
			out.println("<h1>Вхід</h1>");
			out.println("<form method=\"POST\">");
			out.println("Логін: <input type=\"text\" name=\"login\"><br/><br/>");
			out.println("Пароль: <input type=\"password\" name=\"password\"><br/><br/>");
			out.println("<input type=\"submit\" value=\"Увійти\">");
			out.println("</form>");
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		if (login.equals("") || password.equals(""))
			failEmptyFields(request, response);
		else if (!login.equals(LOGIN) || !password.equals(PASSWORD))
			failWrongData(request, response);
		else
			success(request, response);
	}

	private void failWrongData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Вхід до системи національної безпеки</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<center>");
			out.println("<h1>Помилка</h1>");
			out.println("Неправильні дані!");
			out.println("<br/>");
			out.println("<a href=\"login\">Назад</a>");
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}

	}

	private void success(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Вхід до системи національної безпеки</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<center>");
			out.println("<h1>Секретная інформація</h1>");
			out.println("Корова каже \"Мууу\"");
			out.println("<br/>");
			out.println("<a href=\"login\">Назад</a>");
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}

	}

	private void failEmptyFields(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Вхід до системи національної безпеки</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<center>");
			out.println("<h1>Помилка</h1>");
			out.println("Не всі поля заповнені!");
			out.println("<br/>");
			out.println("<a href=\"login\">Назад</a>");
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}

	}
}
