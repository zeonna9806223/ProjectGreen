//package social.controller;
//
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
//import social.bean.RestaurantTypeBean;
//import social.service.RestaurantType;
//import social.service.RestaurantTypeImpl;
//
///**
// * Application Lifecycle Listener implementation class TestListener
// *
// */
//@WebListener
//public class TestListener implements ServletContextListener {
//
//	public TestListener() {
//	}
//
//	public void contextDestroyed(ServletContextEvent sce ) {
//	}
//
//	public void contextInitialized(ServletContextEvent sce) {
//		RestaurantType rst = new RestaurantTypeImpl();
//		List<RestaurantTypeBean> listt = rst.queryRestaurantTypes();
//		sce.getServletContext().setAttribute("resTypes",listt);
//		return;
//	}
//
//}
