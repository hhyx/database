package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ApplicationDaoImpl;
import entity.Application;
import entity.Company;
import entity.Interview;
import entity.Job;
import entity.User;

/**
 * Servlet implementation class EmployerShowServlet
 */
@WebServlet("/EmployerShowServlet")
public class EmployerShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployerShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();  
		User u = (User)session.getAttribute("user"); 
		
		
		

		ArrayList<Company> company = ApplicationDaoImpl.getCompany(u.getUsername());
		//职位信息
		ArrayList<Job> job = ApplicationDaoImpl.getJob(company.get(0).getName());		
		
		//申请信息
		ArrayList<Application> appli = new ArrayList<>();
		for (int i = 0;i < job.size();i ++) {
			 appli.addAll(ApplicationDaoImpl.getApplication(job.get(i).getJid()));
		}
		//给jsp传参
		request.setAttribute("company", company);
		request.setAttribute("job", job);
		request.setAttribute("application", appli);
		for(int i = 0;i < appli.size();i ++) {
			System.out.println(appli.get(i).getTime());
		}
		
		
		//面试信息
		ArrayList<Interview> interview = new ArrayList<>();
		for (int i = 0;i < job.size();i ++) {
			 interview.addAll(ApplicationDaoImpl.getInterview(job.get(i).getJid()));
		}
		
		
		request.setAttribute("interview", interview);
		//
		request.getRequestDispatcher("employer/employer.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
