package _00_init.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OpenSessionViewFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			System.out.println("Transaction Begin.");
			chain.doFilter(request, response);
			System.out.println("第一次交易done");
			session.getTransaction().commit();
			System.out.println("Transaction Commit.");
//			 session.close();
//			 System.out.println("Session Closed.");
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Transaction RollBack.");
//            e.printStackTrace();
//            session.close();
//            System.out.println("Session Closed.");
//		} finally {
//			System.out.println("Session Closed.");
		}
//		HibernateUtil.closeSessionFactory();
	}

	@Override
	public void destroy() {
	}

}
