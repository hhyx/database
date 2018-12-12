package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.Employee;
import entity.Employer;
import entity.User;
/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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
		 User user=new User();
		 request.setCharacterEncoding("utf-8");
        //获取login.jsp页面提交的账号和密码
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String userType = request.getParameter("userType");
        
        //测试数据
        //System.out.println(username+" "+password);
        //获取login.jsp页面提交的账号和密码设置到实体类User中
        user.setUsername(username);
        user.setPassword(password);
        user.setUserType(userType);
        //引入数据交互层
        UserDao dao=new UserDaoImpl();
        User us=dao.login(user);
     
        //cookie
        HttpSession session = request.getSession();  
        session.setAttribute("user", us); 
        
        if(us!=null){
            request.setAttribute("info", "Login OK");
        }else{
            request.setAttribute("info", "Login Fail");
        }
        //跳转到info.jsp
        request.getRequestDispatcher("info/info.jsp").forward(request, response);

	}

}
