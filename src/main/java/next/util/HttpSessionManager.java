package next.util;

import javax.servlet.http.HttpSession;

import next.model.User;

public class HttpSessionManager {
	public User getUserInSession(HttpSession session) {
		User user = (User) session.getAttribute("user");
		return user == null ? null : user;	
	}
	public boolean isLogin(HttpSession session) {
		return session.getAttribute("user") == null ? false : true;
	}
}
