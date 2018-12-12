package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Employee;
import entity.Employer;
import entity.User;
public class UserDaoImpl implements UserDao{
	

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con=Dao.getConnection();//1:获取数据库的连接
            //2:书写sql语句
            String sql;
            if (user.getUserType().equals("Employee"))
            	sql= "select * from employee where username=? and password=? ;";
            else 
            	sql= "select * from employer where username=? and password=? ;";
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs=ps.executeQuery();//5:执行sql语句
            User users=null;
            if(rs.next()){
                users=new User();
                //从数据库中获取值设置到实体类的setter方法
                
                users.setUsername(rs.getString("username"));
                users.setPassword(rs.getString("password"));
                users.setEmail(rs.getString("email"));
                users.setPhone(rs.getString("phone"));
                
                return users;
            }else{
                return null;
            }
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      return null;
	}

	@Override
    public boolean register(User user) {
		boolean flag;
		if (user.getUserType().equals("Employee")) {
			Employee e = (Employee)user;
	        String sql="insert into employee values(?,?,?,?,?,?,?);";
	        ArrayList<Object> list=new ArrayList<Object>();
	        list.add(e.getUsername());
	        list.add(e.getPassword());
	        list.add(e.getPhone());
	        list.add(e.getEmail());
	        list.add(e.getUserType());
	        list.add(e.getName());
	        list.add(e.getAge());
	        
	        
	       
	        flag=Dao.addUpdateDelete(sql,list.toArray());
	        
		} else {
			Employer e = (Employer)user;
	        String sql="insert into employer values(?,?,?,?,?,?,?,?);";
	        ArrayList<Object> list=new ArrayList<Object>();
	        list.add(e.getUsername());
	        list.add(e.getPassword());
	        list.add(e.getPhone());
	        list.add(e.getEmail());
	        list.add(e.getUserType());
	        list.add(e.getName());
	        list.add(e.getAge());
	        list.add(e.getCompany());
	        flag=Dao.addUpdateDelete(sql,list.toArray());
		}
		if(flag){
            return true;
        }else{
            return false;
        }
		
    }

}
