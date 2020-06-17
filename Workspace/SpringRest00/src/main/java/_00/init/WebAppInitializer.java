package _00.init;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import social.model.bean.MatchingBean;
import social.controller.MatchingFilter;
import social.service.Match;
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// *****動態新增class陣列，{插東西進去}
		// *****RootAppConfig.class代表RootAppConfig物件
		return new Class[] { RootAppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebAppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	protected Filter[] getServletFilters() {
		// ***** 字元filter
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		// ***** HTTP filter
		HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
		return new Filter[] { characterEncodingFilter, hiddenHttpMethodFilter };
		/*
		 * html_form表單只支持GET和POST請求，而DELETE，PUT等方法並不支持，spring3添加了一個過濾器，
		 * 可以將這些請求轉換為標準的http方法，以支持GET，POST，PUT和DELETE請求。
		 */
	}
	
	@Autowired
	static Match matching;
	
	public WebAppInitializer() {
		test();// *****定時功能接寫在建構子
	}
	
	public static void test() {
		System.out.println("定時任務監聽開始");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 00);
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		Date time = calendar.getTime();

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				System.out.println("定時執行時間" + new Date());
//				SessionFactory factory = HibernateUtil.getSessionFactory();
//				Session hSession = factory.getCurrentSession();
//				try {
//					Transaction ts = hSession.beginTransaction();
//					Match matching = new MatchImpl(hSession);
				List<MatchingBean> todayRequest = matching.todayRequest(1);
				List getMatch = matching.getMatch(todayRequest);
				matching.insertMatchResult(getMatch);
//					ts.commit();
//				} catch (Exception e) {
//					hSession.getTransaction().rollback();
//					e.printStackTrace();
//				}
				try {
					// thread to sleep for 23:58:00
					Thread.sleep(86280000);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}, buildTime(), 1000 * 60 * 60 * 24); // 定時功能
	}

	private static Date buildTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date time = calendar.getTime();
		if (time.before(new Date())) {
			// 若果當前時間已經是凌晨1點後，需要往後加1天，否則任務會立即執行。
			// 很多系統往往系統啟動時就需要立即執行一次任務，但下面又需要每天凌晨1點執行，怎麼辦呢？
			// 很簡單，就在系統初始化話時單獨執行一次任務（不需要用定時器，只是執行那段任務的程式碼）
			time = addDay(time, 1);
		}
		return time;
	}

	private static Date addDay(Date date, int days) {
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(Calendar.DAY_OF_MONTH, days);
		return startDT.getTime();
	}
	//*****@Bean註解搭配普通webfilter
//	 @Bean
//	    public FilterRegistrationBean testFilterRegistration() {
//
//	        FilterRegistrationBean registration = new FilterRegistrationBean();
//	        registration.setFilter(new MatchingFilter());
//	        registration.addUrlPatterns("/social/match");
//	        registration.addInitParameter("paramName", "paramValue");
//	        registration.setName("matchingFilter");
//	        registration.setOrder(1);
//	        return registration;
//	    }
	
//	@Bean
//    public FilterRegistrationBean testFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new MatchingFilter());
//        registration.addUrlPatterns("/social/Match.jsp/");
//        registration.addInitParameter("paramName", "paramValue");
//        registration.setName("MatchingFilter");
//        registration.setOrder(5);
//        return registration;
//    }

	/*
	 * @Bean public FilterRegistrationBean testFilterRegistration() {
	 * FilterRegistrationBean registration = new FilterRegistrationBean();
	 * registration.setFilter(new TestFilter()); registration.addUrlPatterns("/*");
	 * registration.addInitParameter("paramName", "paramValue");
	 * registration.setName("testFilter"); registration.setOrder(1); return
	 * registration; } public class SpringFilterRegistrationConfig {
	 * 
	 * 
	 * @Bean public FilterRegistrationBean<Filter> responseFilter() {
	 * FilterRegistrationBean<Filter> registrationBean = new
	 * FilterRegistrationBean<>(); registrationBean.setName("responseFilter");
	 * registrationBean.setOrder(2); registrationBean.setFilter((request, response,
	 * chain) -> { HttpServletResponse servletResponse = (HttpServletResponse)
	 * response; log.info("response status {}", servletResponse.getStatus());
	 * chain.doFilter(request,response); });
	 * registrationBean.addUrlPatterns("/foo/*"); return registrationBean; }
	 * 
	 * @Bean public FilterRegistrationBean<Filter> requestFilter() {
	 * FilterRegistrationBean<Filter> registrationBean = new
	 * FilterRegistrationBean<>(); registrationBean.setName("requestFilter");
	 * registrationBean.setOrder(1); registrationBean.setFilter((request, response,
	 * chain) -> { HttpServletRequest httpServletRequest = (HttpServletRequest)
	 * request; log.info("request from {}", httpServletRequest.getRequestURI());
	 * chain.doFilter(request,response); });
	 * registrationBean.addUrlPatterns("/foo/*"); return registrationBean; }
	 * 
	 */

}
