package next.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.db.DataBase;
import next.util.HttpSessionManager;

@WebServlet("/user/list")
public class ListUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", DataBase.findAll());
        HttpSession session = req.getSession();
        System.out.println(session);
        HttpSessionManager manager = new HttpSessionManager();
        RequestDispatcher rd = null;
        if(manager.isLogin(session)) {
        	 	rd = req.getRequestDispatcher("/user/list.jsp");
        }else {
        		rd = req.getRequestDispatcher("/user/login.jsp");
        } 
        rd.forward(req, resp);
    }
}
