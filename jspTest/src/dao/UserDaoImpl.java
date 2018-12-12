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
            con=Dao.getConnection();//1:��ȡ���ݿ������
            //2:��дsql���
            String sql;
            if (user.getUserType().equals("Employee"))
            	sql= "select * from employee where username=? and password=? ;";
            else 
            	sql= "select * from employer where username=? and password=? ;";
            ps=con.prepareStatement(sql);//3��Ԥ����
            //4������ֵ
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            rs=ps.executeQuery();//5:ִ��sql���
            User users=null;
            if(rs.next()){
                users=new User();
                //�����ݿ��л�ȡֵ���õ�ʵ�����setter����
                
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
