package com.wuyufei.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.wuyufei.util.HibernateUtil;

/**
 * Servlet implementation class DoRegServlet
 */
public class DoRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Session session;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from Userinfo b where b.username = 'wuyufei'";
		List<Userinfo> bs = new ArrayList<Userinfo>();
		bs = session.createQuery(hql).list();
		if(bs.size() != 0){
			Userinfo b = (Userinfo)bs.get(0);
			String username = b.getUsername();
			String password = b.getPassword();
			request.setAttribute("name", username);
			request.setAttribute("psd", password);
		}
		
		session.close();
		RequestDispatcher d = request.getRequestDispatcher("jsp/TestHibernate.jsp");
		d.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
