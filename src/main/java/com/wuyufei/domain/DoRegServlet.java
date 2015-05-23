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
		String hql2 = "from HotNews h order by h.id desc";
		List<Userinfo> bs = new ArrayList<Userinfo>();
		List<HotNews> hn = new ArrayList<HotNews>();
		List<HotNews> s = new ArrayList<HotNews>();
		bs = session.createQuery(hql).list();
		hn = session.createQuery(hql2).list();
//		System.out.println(hn.get(0).getUrl());
		if(hn.size() != 0){
			Userinfo b = (Userinfo)bs.get(0);
			for(int i = 0;i < 7;i++){     //retrieve the first 7 urls
				s.add((HotNews)hn.get(i));
			}
			String username = b.getUsername();
			String password = b.getPassword();
			request.setAttribute("name", username);
			request.setAttribute("psd", password);
			request.setAttribute("url", s);
		}
		
		session.close();
		RequestDispatcher d = request.getRequestDispatcher("jsp/index.jsp");
		d.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
