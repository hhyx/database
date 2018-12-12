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
 * Servlet implementation class EmployeeShowServlet
 */
@WebServlet("/EmployeeShowServlet")
public class EmployeeShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeShowServlet() {
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
		//System.out.println(u.getUsername() + "!!");
		
		request.setAttribute("user", u);
		//�����ݿ��ȡ�����û�����Ϣ�͹�˾����Ϣ
		
		//��˾��Ϣ
		ArrayList<Company> company = ApplicationDaoImpl.getCompany();
		request.setAttribute("company", company);
		
		
	
		//�û�������Ϣ
		ArrayList<Interview> interview = ApplicationDaoImpl.getInterview(u.getUsername());
		ArrayList<Job> jobForInt = new ArrayList<>();
		for (int i = 0;i < interview.size();i ++) {
			jobForInt.addAll(ApplicationDaoImpl.getJob(interview.get(i).getJid()));
		}
		request.setAttribute("interview", interview);
		request.setAttribute("jobForInt", jobForInt);
		
		//�û�������Ϣ
		ArrayList<Application> application = ApplicationDaoImpl.getApplication(u.getUsername());
		ArrayList<Job> jobForApp = new ArrayList<>();
		for (int i = 0;i < application.size();i ++) {
			jobForApp.addAll(ApplicationDaoImpl.getJob(application.get(i).getJid()));
		}
		//��jsp����
		request.setAttribute("application", application);
		request.setAttribute("jobForApp", jobForApp);
		
		//��ת��employee.jsp
		request.getRequestDispatcher("employee/employee.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubs
		
		
		doGet(request, response);
	}

}
