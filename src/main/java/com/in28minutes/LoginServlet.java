package com.in28minutes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        //System.out.println("Hit Servlet!");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.removeAttribute("errorMessage");
		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserValidation validator = new UserValidation();
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		String password = request.getParameter("password");
		request.setAttribute("password", password);
		
		if (validator.isUserValid(name, password)){
			request.getRequestDispatcher("WEB-INF/views/welcome.jsp").forward(
				request, response);
		} else {
			request.setAttribute("errorMessage", "Wrong Details Entered");
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(
					request, response);
			
			//request.getRequestDispatcher("WEB-INF/views/accessdenied.jsp").forward(request, response);
		}
	}

}
