package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String USER = "ajeet";
	private final static String PASS = "12345";
       
    public LoginServlet() {
        super();
    
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		if(USER.equals(user) && PASS.equals(pass)){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			RequestDispatcher view = request.getRequestDispatcher("purchase_order.jsp");
			view.forward(request, response);
			
		} else {
			
			RequestDispatcher view = request.getRequestDispatcher("login.jsp");
			view.include(request,response); 
		}
	}

}
