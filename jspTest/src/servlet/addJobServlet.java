package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InterviewDaoImpl;
import entity.Job;

/**
 * Servlet implementation class addJobServlet
 */
@WebServlet("/addJobServlet")
public class addJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		Integer jid = 0;
		String cid = request.getParameter("cid");
		String name = request.getParameter("name");
		Integer salary = Integer.parseInt(request.getParameter("salary"));
		String desciption = request.getParameter("desciption");
		
		Job j = new Job(jid, name, salary, cid, desciption);
		
		boolean flag1 = InterviewDaoImpl.insertJob(j);
		if (flag1)
			request.setAttribute("info", "insert Job OK");
		else
			request.setAttribute("info", "insert Job Fail");
		
		request.getRequestDispatcher("info/info.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
