package org.blanco.gae.blog;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.blanco.gae.blog.dao.HibernateSessionFactory;
import org.blanco.gae.blog.entities.Entry;
import org.hibernate.Session;

@SuppressWarnings("serial")
public class BlogServlet extends HttpServlet {
	
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		try {
			req.getRequestDispatcher("blog_form.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace(resp.getWriter());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Entry entry = new Entry();
		entry.setAuthor(req.getParameter("author"));
		entry.setEntry(req.getParameter("entry"));
		entry.setDate(new Date(System.currentTimeMillis()));
		
		Session session = (Session) HibernateSessionFactory.getApplicationContext()
				.getBean("session");
		session.persist(entry);
		session.flush();
		session.close();
		req.setAttribute("entry", entry);
		req.getRequestDispatcher("entry_created.jsp").forward(req, resp);
	}
	
}
