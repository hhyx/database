package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import entity.*;
/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("utf-8");
        //获取login.jsp页面提交的账号和密码
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        String userType=request.getParameter("userType");
        String name=request.getParameter("name");
        Integer age=Integer.parseInt(request.getParameter("age"));
        String company =request.getParameter("company");
        String address = request.getParameter("address");
        //获取register.jsp页面提交的账号和密码设置到实体类User中
        UserDao dao=new UserDaoImpl();
        boolean flag;
        if (userType.equals("Employee")) {
        	Employee e = new Employee();
	        e.setUsername(username);
	        e.setPassword(password);
	        e.setEmail(email);
	        e.setPhone(phone);
	        e.setUserType(userType);
	        e.setName(name);
	        e.setAge(age);
	        flag=dao.register(e);
        } else {
        	System.out.println("haha");
        	Employer e = new Employer();
        	e.setUsername(username);
 	        e.setPassword(password);
 	        e.setEmail(email);
 	        e.setPhone(phone);
 	        e.setUserType(userType);
 	        e.setName(name);
 	        e.setAge(age);
 	        Company c = new Company(company,username,address);
 	        flag = ApplicationDaoImpl.insertCompany(c);
 	        if (!flag) {
 	        	request.setAttribute("info", "Register Fail");
 	        	request.getRequestDispatcher("info/info.jsp").forward(request, response);
 	        	return;
 	        }
 	        e.setCompany(company);
 	        flag=dao.register(e);
 	        if (!flag) {
 	        	ApplicationDaoImpl.deleteCompany(company);
 	        }
        }
        //System.out.println(e.getUserType());
        
        //引入数据交互层
       
        
       
        if(flag){
            request.setAttribute("info", "Register OK");
        }else{
            request.setAttribute("info", "Register Fail");
        }
        
        request.getRequestDispatcher("info/info.jsp").forward(request, response);
	}

}
