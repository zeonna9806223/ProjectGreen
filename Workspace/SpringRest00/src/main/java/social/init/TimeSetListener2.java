//package social.init;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.Timer;
//import java.util.TimerTask;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//import social.bean.MatchingBean;
//import social.service.Match;
//*****事件監聽功能
//@Component
//public class TimeSetListener2 {
//	@Autowired
//	static Match matching;
//	
//	@EventListener
//	public void everydatMatch(ApplicationEvent event) {
//		
//		test();// 每天0點配對的timer
//	}
//	public static void test() {
//		System.err.println("定時監聽開始");
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.HOUR_OF_DAY, 00);
//		calendar.set(Calendar.MINUTE, 00);
//		calendar.set(Calendar.SECOND, 00);
//		Date time = calendar.getTime();
//
//		Timer timer = new Timer();
//		timer.scheduleAtFixedRate(new TimerTask() {
//			public void run() {
//				System.out.println("定時執行時間" + new Date());
////				SessionFactory factory = HibernateUtil.getSessionFactory();
////				Session hSession = factory.getCurrentSession();
////				try {
////					Transaction ts = hSession.beginTransaction();
////					Match matching = new MatchImpl(hSession);
//				List<MatchingBean> todayRequest = matching.todayRequest(1);
//				List getMatch = matching.getMatch(todayRequest);
//				matching.insertMatchResult(getMatch);
////					ts.commit();
////				} catch (Exception e) {
////					hSession.getTransaction().rollback();
////					e.printStackTrace();
////				}
//				try {
//					// thread to sleep for 23:58:00
//					Thread.sleep(86280000);
//				} catch (Exception e) {
//					System.out.println(e);
//				}
//			}
//		}, buildTime(), 1000 * 60 * 60 * 24); // 定時功能
//	}
//
//	private static Date buildTime() {
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.HOUR_OF_DAY, 0);
//		calendar.set(Calendar.MINUTE, 0);
//		calendar.set(Calendar.SECOND, 0);
//		Date time = calendar.getTime();
//		if (time.before(new Date())) {
//			// 若果當前時間已經是凌晨1點後，需要往後加1天，否則任務會立即執行。
//			// 很多系統往往系統啟動時就需要立即執行一次任務，但下面又需要每天凌晨1點執行，怎麼辦呢？
//			// 很簡單，就在系統初始化話時單獨執行一次任務（不需要用定時器，只是執行那段任務的程式碼）
//			time = addDay(time, 1);
//		}
//		return time;
//	}
//
//	private static Date addDay(Date date, int days) {
//		Calendar startDT = Calendar.getInstance();
//		startDT.setTime(date);
//		startDT.add(Calendar.DAY_OF_MONTH, days);
//		return startDT.getTime();
//	}
//
//	
//}
