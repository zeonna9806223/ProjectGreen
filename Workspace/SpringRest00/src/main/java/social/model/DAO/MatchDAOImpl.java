package social.model.DAO;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.collections4.map.HashedMap;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.model.MemberBean;
import social.model.bean.FriendInfoBean;
import social.model.bean.MatchRequestBean;
import social.model.bean.MatchesBean;
import social.model.bean.MatchingBean;
import social.model.bean.MessageBean;

@Repository
public class MatchDAOImpl implements MatchDAO {

	@Autowired
	SessionFactory factory;
	@Autowired
	ServletContext ctx;
//	String jndiString = "java:comp/env/" + "jdbc/ProjectGreen";
	// *****context的NAMEEEEEEEEEEEEEEEEEEEEEEEEEEEE
//	DataSource ds;

	// *****預設建構連線參數
//	private Session session;
//	private SessionFactory factory;

//		public Session getSession() {
//			return session = factory.getCurrentSession();
//		}

	public MatchDAOImpl() {
	}

//	public MatchDAOImpl(Session session) {
//		this.session = session;
//	}

//	public MatchDAOImpl(SessionFactory factory) {
//		this.factory = factory;
//	}

//	public MatchDAOImpl() {
//		try {
//			InitialContext ctx = new InitialContext();
//			ds = (DataSource) ctx.lookup(jndiString);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}

	@Override
	public void insertMatchRequest(MatchRequestBean mrb) {
		Session session = factory.getCurrentSession();
		session.save(mrb);
	}

	public List<MatchingBean> todayRequest(int time) {
		String hql;
		hql = "SELECT new list(mr.matchID, mr.memberID, mr.ageTopLike, mr.ageBottomLike, "
				+ "mr.heightLike, mr.weightLike, mr.genderLike, mr.interestedRestaurantType, "
				+ "mr.tourTypeLike, mr.requestDay, mr.everyday, mr.getMatch, mb.memberName, "
				+ "mf.memberBirthday, mf.profileHeight, mf.profileWeight, "
				+ "mb.gender) FROM MemberBean2 mb, MemberProfileBean mf, MatchRequestBean as mr "
				+ "where mb.memberID = mr.memberID and mr.memberID = mf.memberID "
				+ "and DATEDIFF(day, mr.requestDay, :aaa) = :aaaa ";
		// ****HQL 今天日期current_date()
		List<List> list = new ArrayList<>();
		List<MatchingBean> mbs = new ArrayList<>();
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("aaa", new Date());
		query.setParameter("aaaa", time);
		list = query.list();
		for (List ll : list) {
//			java.sql.Date date9 = (java.sql.Date) ll.get(9);
////			java.util.Date jdate9 = new java.util.Date(date9.getTime()); // *****sql轉util
//			java.sql.Date date13 = (java.sql.Date) ll.get(13);
//			java.util.Date jdate13 = new java.util.Date(date13.getTime());
			MatchingBean mb = new MatchingBean((Integer) ll.get(0), (Integer) ll.get(1), (Integer) ll.get(2),
					(Integer) ll.get(3), (Integer) ll.get(4), (Integer) ll.get(5), (Integer) ll.get(6),
					(String) ll.get(7), (String) ll.get(8), (java.sql.Date) ll.get(9), (Integer) ll.get(10),
					(Integer) ll.get(11), (String) ll.get(12), (java.sql.Date) ll.get(13), (Integer) ll.get(14),
					(Integer) ll.get(15), (Integer) ll.get(16));
			mbs.add(mb);
			mb = null;

		}
		return mbs;
	}

	public void insertMatchResult(List<List<Integer>> matchResult) {
		if (matchResult == null) {
			System.out.println("無人配對");
			throw new IllegalArgumentException();
		}
		Session session = factory.getCurrentSession();
		java.sql.Date pd = new java.sql.Date(new Date().getTime());
		for (int l = 0; l < matchResult.size(); l++) {
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				java.sql.Date date = java.sql.Date.valueOf(sdfst);
			MatchesBean mb = new MatchesBean(matchResult.get(l).get(0), matchResult.get(l).get(1), pd, -1, -1);
			session.save(mb);
		}
	}

	public void markMatch(Integer i, Integer ii) {
		String hql = "update MatchesBean m set friends1 = 1 where memberId2 = :oo and "
				+ "memberId1 = :ooo and (delete1 != 1 and delete2 != 1) and "
				+ "pairDate = CONVERT(date, SYSDATETIME())";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("oo", i);
		query.setParameter("ooo", ii);
		query.executeUpdate();
	}

	public void markPairDate(Integer i, Integer ii) {
		String hql = "update MatchesBean set friendDate = :oo where memberId2 = :oo1 and "
				+ "memberId1 = :ooo and (delete1 != 1 and delete2 != 1) and "
				+ "pairDate= CONVERT(date, SYSDATETIME()) and friends2 = 1";
		java.sql.Date fd = new java.sql.Date(new Date().getTime());
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("oo", fd);
		query.setParameter("oo1", i);
		query.setParameter("ooo", ii);
		query.executeUpdate();
	}

	public List<MatchesBean> showMatch(Integer i) {
		List<MatchesBean> showMatch = new ArrayList<>();
		String hql;
		String hql2 = null;
		List<List> list = new ArrayList<>();
		List<List> list2 = new ArrayList<>();
		if (i == 0) {
			hql = "select new list(m.pairId, m.memberId1, m.memberId2, m.friends1, m.friends2, "
					+ "m.pairDate, m.friendDate, m.delete1, m.delete2, mp.profileHeight, mp.profileWeight, "
					+ "mb.memberName, mb.gender, mp.memberBirthday, mp.memberIntroduce) "
					+ "from MatchesBean as m, MemberProfileBean as mp, MemberBean2 as mb "
					+ "where m.memberId2 = mp.memberID and mp.memberID = mb.memberID "
					+ "and m.friends1 = 1 and m.friends2 = 1 and m.delete1 != 1 and m.delete2 != 1";
		} else {
			hql = "select new list(m.pairId, m.memberId1, m.memberId2, m.friends1, m.friends2, "
					+ "m.pairDate, m.friendDate, m.delete1, m.delete2, mp.profileHeight, mp.profileWeight, "
					+ "mb.memberName, mb.gender, mp.memberBirthday, mp.memberIntroduce) "
					+ "from MatchesBean as m, MemberProfileBean as mp, MemberBean2 as mb "
					+ "where m.memberId2 = mp.memberID and mp.memberID = mb.memberID "
					+ "and m.memberId1 = :aa and m.delete1 != 1 ";

			hql2 = "select new list(m.pairId, m.memberId1, m.memberId2, m.friends1, m.friends2, "
					+ "m.pairDate, m.friendDate, m.delete1, m.delete2, mp.profileHeight, mp.profileWeight, "
					+ "mb.memberName, mb.gender, mp.memberBirthday, mp.memberIntroduce) "
					+ "from MatchesBean as m, MemberProfileBean as mp, MemberBean2 as mb "
					+ "where m.memberId1 = mp.memberID and mp.memberID = mb.memberID "
					+ "and m.memberId2 = :aaa and m.delete1 != 1 ";
		}
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		if (i != 0) {
			Query query2 = session.createQuery(hql2);
			query.setParameter("aa", i);
			query2.setParameter("aaa", i);
			list = query.list();
			list2 = query2.list();
		}
//		System.out.println(list.size());
		for (List ll : list) {
			MatchesBean mb = new MatchesBean((Integer) ll.get(0), (Integer) ll.get(1), (Integer) ll.get(2),
					(Integer) ll.get(3), (Integer) ll.get(4), (java.sql.Date) ll.get(5), (java.sql.Date) ll.get(6),
					(Integer) ll.get(7), (Integer) ll.get(8), (Integer) ll.get(9), (Integer) ll.get(10),
					(String) ll.get(11), (Integer) ll.get(12), (java.sql.Date) ll.get(13), (String) ll.get(14));
			showMatch.add(mb);
			mb = null;
		}
		for (List ll : list2) {
			MatchesBean mb = new MatchesBean((Integer) ll.get(0), (Integer) ll.get(2), (Integer) ll.get(1),
					(Integer) ll.get(3), (Integer) ll.get(4), (java.sql.Date) ll.get(5), (java.sql.Date) ll.get(6),
					(Integer) ll.get(7), (Integer) ll.get(8), (Integer) ll.get(9), (Integer) ll.get(10),
					(String) ll.get(11), (Integer) ll.get(12), (java.sql.Date) ll.get(13), (String) ll.get(14));
			showMatch.add(mb);
			mb = null;
		}
		return showMatch;
	}

	// ajax找單筆朋友資訊
	public FriendInfoBean showFriendInfo(Integer i) {
		FriendInfoBean fi = new FriendInfoBean();
		List<List> list = new ArrayList<>();
		String hql = "select new list(mb.memberID, mb.memberName, mb.gender, mp.memberBirthday, "
				+ "mp.memberIntroduce, mp.profileHeight, mp.profileWeight, mb.image) "
				+ "from MemberProfileBean as mp, MemberBean2 as mb "
				+ "where mp.memberID = mb.memberID and mb.memberID= :aaa ";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("aaa", i);
		list = query.list();
		for (List ll : list) {
			String imageJson = friendProfileJson((Blob) ll.get(7));
			fi = new FriendInfoBean((Integer) ll.get(0), (String) ll.get(1), (Integer) ll.get(2),
					(java.sql.Date) ll.get(3), (String) ll.get(4), (Integer) ll.get(5), (Integer) ll.get(6), imageJson);
		}
		return fi;
	}

	public String friendProfileJson(Blob image) {
		String iamgeData = null;
		try {
			StringBuffer sb = new StringBuffer();
//			String fileName = bean.getFileName();
//			String mimeType = ctx.getMimeType(fileName);
			String mimeType = "image/jpeg";
//			Blob blob = friendInfoBean.getImage();
			byte[] bytes = image.getBytes(1, (int) image.length());
			String prefix = "data:" + mimeType + ";base64,";
			sb.append(prefix);
			Base64.Encoder be = Base64.getEncoder();
			String str = new String(be.encode(bytes));
			sb.append(str);
			iamgeData = sb.toString();
//			fp = new FriendInfoBeanWithProfile(friendInfoBean, iamgeData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iamgeData;
	}

	public void deleteFriend(Integer i, Integer ii) {
		String hql = "update MatchesBean set delete1 = 1 where memberId2 = :oo and "
				+ "memberId1 = :ooo and (delete1 != 1) and (delete1 != 1 and delete2 != 1)";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("oo", i);
		query.setParameter("ooo", ii);
		query.executeUpdate();
	}

	public void saveMessage(Integer pairId, Integer id1, Integer id2, String text) {
		Session session = factory.getCurrentSession();
		Date date = new Date();
		MessageBean messageBean = new MessageBean(pairId, id1, id2, id1, text, new java.sql.Timestamp(date.getTime()));
		session.save(messageBean);
	}

	public List showMessage(Integer pair, Integer i) {
		List rList = new ArrayList<>();
		List<MessageBean> list = new ArrayList<>();
		String hql;
		Integer be = (1+i-1)*20+1;
		Integer la = (1+i)*20;
		Session session = factory.getCurrentSession();
		Query query;
		try {
			if (i == 0) {
				hql = "SELECT top 20 * FROM Friends a WHERE MatchId = :ww order by MessageId desc";
//				hql = "FROM MessageBean m WHERE m.matchId = :pair order by m.messageId desc ";
				query = session.createNativeQuery(hql,MessageBean.class);
			} else {
//				hql = "top 20 FROM MessageBean m WHERE m.matchId = :pair order by m.messageId desc ";
				hql = "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY MessageId DESC) as ROWNUM"
						+ "  FROM Friends WHERE MatchId = :ww) as a WHERE ROWNUM >= :xx and ROWNUM <= :oo";
				query = session.createNativeQuery(hql,MessageBean.class);
				query.setParameter("xx", be);
				query.setParameter("oo", la);
			}
			query.setParameter("ww", pair);
			query.setFetchSize(20);
			list =query.getResultList();
//				System.out.println("哈哈"+list.get(list.size()-1).getText()); 
//			list = query.getResultList();
//			Iterator iii = list.iterator();
//			for(int a=0; a<list.size();a++) {
//				System.out.println("哈哈"+list.get(a).getRowNumber()); *****→沒映射的class property為null
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
