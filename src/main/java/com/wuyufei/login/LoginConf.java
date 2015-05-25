package com.wuyufei.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginConf
 */
public class LoginConf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginConf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("uname");
		String password=request.getParameter("upsw");
		
		LoginCheck lc = new LoginCheck();
		if(lc.isLogin(name, password)){
			System.out.println("ok");
			request.setAttribute("login", "true");
			request.getRequestDispatcher("jsp/login_success.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("jsp/login_failure.jsp").forward(request, response);
		}
	}

}
