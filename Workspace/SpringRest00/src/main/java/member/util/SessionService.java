package member.util;

import javax.servlet.http.HttpSession;

public final class SessionService {
	public static boolean isLogined(HttpSession session) {
		if (session == null || session.getAttribute("Member") == null) {
			return false;
		}

		return true;
	}
}
