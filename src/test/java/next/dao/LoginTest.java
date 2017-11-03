package next.dao;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.mock.web.MockHttpSession;

import core.db.DataBase;
import next.model.User;
import next.util.HttpSessionManager;

public class LoginTest {

    @Test
    public void loginTest() throws Exception {
        User user = new User("userId", "password", "name", "javajigi@email.com");
        DataBase.findUserById("userId");
        assertEquals(true, user.loginCheck("password"));
    }
    
    @Test
    public void HttpSessionManagerTest() throws Exception{
//    		HttpSession session = new HttpSession();
//    		HttpSessionManager manager = new HttpSessionManager();
//    		manager.getUserInSession(session)
    	
    		MockHttpSession session = new MockHttpSession();
    		session.setAttribute("user", "user");
    		
    }

}
