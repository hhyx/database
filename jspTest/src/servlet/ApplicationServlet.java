package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import dao.ApplicationDaoImpl;
import dao.InterviewDaoImpl;
import entity.Interview;
import entity.Application;
import entity.User;

/**
 * Servlet implementation class ApplicationServlet
 */
@WebServlet("/ApplicationServlet")
public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String acceptInf = request.getParameter("acceptInf");
		
		System.out.println(acceptInf);
		
		
		if (acceptInf.equals("refused")) {
			Integer jid = Integer.parseInt(request.getParameter("jid"));
			String username = request.getParameter("username");
			System.out.println(jid);System.out.println(username);
			
			boolean flag = InterviewDaoImpl.updateApplicationrefused(jid, username);
			if (flag)
				request.setAttribute("info", "refused Application OK");
			else
				request.setAttribute("info", "refused Application Fail");
			
			request.getRequestDispatcher("info/info.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		String acceptInf = request.getParameter("acceptInf");
		System.out.println(acceptInf);
		if (acceptInf.equals("accepted")) {
			String address = request.getParameter("address");
			String time = request.getParameter("time");
			Integer jid = Integer.parseInt(request.getParameter("jid"));
			String username = request.getParameter("username");
			
			Interview i = new Interview(jid, username, address, time);
			boolean flag1 = InterviewDaoImpl.insertInterview(i);
			if (flag1)
				request.setAttribute("info", "insert Interview OK");
			else
				request.setAttribute("info", "insert Interview Fail");
				
			System.out.println(username);
			boolean flag = InterviewDaoImpl.updateApplicationaccepted(jid, username);
			if (flag)
				request.setAttribute("info", "accepted Application OK");
			else
				request.setAttribute("info", "accepted Application Fail");
			
			
			
		}
		request.getRequestDispatcher("info/info.jsp").forward(request, response);
	}

}
