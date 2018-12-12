package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entity.Application;
import entity.Company;
import entity.Interview;
import entity.Job;

public class InterviewDaoImpl {
	public static ArrayList getCompany() {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Company> arr = new ArrayList<>();
        try {
            con=Dao.getConnection();//1:获取数据库的连接
            //2:书写sql语句
            String sql;
        	sql= "select * from company;";
           
            	
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
            rs=ps.executeQuery();//5:执行sql语句
            while(rs.next()){
                Company c=new Company();
                //从数据库中获取值设置到实体类的setter方法中
           
                c.setName(rs.getString("name"));
                c.setAddress(rs.getString("address"));
             
                arr.add(c);
            }
           
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
        return arr;
	}
	
	public static ArrayList getCompany(String username) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Company> arr = new ArrayList<>();
        try {
            con=Dao.getConnection();//1:获取数据库的连接
            //2:书写sql语句
            String sql;
        	sql= "select * from company where username=?;";
           
            	
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
            ps.setString(1, username);
            rs=ps.executeQuery();//5:执行sql语句
            while(rs.next()){
                Company c=new Company();
                //从数据库中获取值设置到实体类的setter方法中
           
                c.setName(rs.getString("name"));
                c.setAddress(rs.getString("address"));
             
                arr.add(c);
            }
           
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
        return arr;
	}
	
	public static ArrayList getJob(String cid) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Job> arr = new ArrayList<>();
        try {
            con=Dao.getConnection();//1:获取数据库的连接
            //2:书写sql语句
            String sql;

        	sql= "select * from job where cid = ?;";
        	ps=con.prepareStatement(sql);
        	
        	ps.setString(1, cid);
        
            //4：设置值
            rs=ps.executeQuery();//5:执行sql语句
            while(rs.next()){
                Job job=new Job();
                //从数据库中获取值设置到实体类的setter方法中
                
                job.setName(rs.getString("name"));
                job.setJid(rs.getInt("jid"));
                job.setCid(rs.getString("cid"));
                job.setSalary(rs.getInt("salary"));
                job.setDesciption(rs.getString("desciption"));
                arr.add(job);
            }
           
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return arr;
	}
	
	public static ArrayList getJob(Integer jid) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Job> arr = new ArrayList<>();
        try {
            con=Dao.getConnection();//1:获取数据库的连接
            //2:书写sql语句
            String sql;
        	sql= "select * from job where jid = ?;";          
        	ps=con.prepareStatement(sql);
        	
        	ps.setInt(1, jid);
        
            //4：设置值
            rs=ps.executeQuery();//5:执行sql语句
            while(rs.next()){
                Job job=new Job();
                //从数据库中获取值设置到实体类的setter方法中
                
                job.setName(rs.getString("name"));
                job.setJid(rs.getInt("jid"));
                job.setCid(rs.getString("cid"));
                job.setSalary(rs.getInt("salary"));
                job.setDesciption(rs.getString("desciption"));
                arr.add(job);
            }
           
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return arr;
	}
		
	public static ArrayList getInterview(String username) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Interview> arr = new ArrayList<>();
        try {
            con=Dao.getConnection();//1:获取数据库的连接
            //2:书写sql语句
            String sql;
        	sql= "select * from interview where username = ?;";
           
            	
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
            ps.setString(1, username);
            rs=ps.executeQuery();//5:执行sql语句
            while(rs.next()){
            	Interview i=new Interview();
                //从数据库中获取值设置到实体类的setter方法中
           
                i.setJid(rs.getInt("jid"));
                i.setUsername(rs.getString("username"));
                i.setAddress(rs.getString("address"));
                i.setTime(rs.getString("time"));
                arr.add(i);
            }
           
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
        return arr;
	}
	
	public static ArrayList getInterview(Integer jid) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Interview> arr = new ArrayList<>();
        try {
            con=Dao.getConnection();//1:获取数据库的连接
            //2:书写sql语句
            String sql;
        	sql= "select * from interview where jid = ? and username = ?;";
           
            	
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
            ps.setInt(1, jid);        
            rs=ps.executeQuery();//5:执行sql语句
            while(rs.next()){
            	Interview i=new Interview();
                //从数据库中获取值设置到实体类的setter方法中
           
                i.setJid(rs.getInt("jid"));
                i.setUsername(rs.getString("username"));
                i.setAddress(rs.getString("address"));
                i.setTime(rs.getString("time"));
                arr.add(i);
            }
           
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
        return arr;
	}

	public static ArrayList getApplication(String username) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Application> arr = new ArrayList<>();
        try {
            con=Dao.getConnection();//1:获取数据库的连接
            //2:书写sql语句
            String sql;
        	sql= "select * from application where username = ?;";
           
            	
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
            ps.setString(1, username);
            rs=ps.executeQuery();//5:执行sql语句
            while(rs.next()){
            	Application a=new Application();
                //从数据库中获取值设置到实体类的setter方法中
           
                a.setJid(rs.getInt("jid"));
                a.setUsername(rs.getString("username"));
                a.setTime(rs.getString("time"));
                arr.add(a);
            }
           
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
        return arr;
	
	}
	
	public static ArrayList getApplication(Integer jid) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Application> arr = new ArrayList<>();
        try {
            con=Dao.getConnection();//1:获取数据库的连接
            //2:书写sql语句
            String sql;
        	sql= "select * from application where jid = ?;";
           
            	
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
            ps.setInt(1, jid);
            rs=ps.executeQuery();//5:执行sql语句
            while(rs.next()){
            	Application a=new Application();
                //从数据库中获取值设置到实体类的setter方法中
           
                a.setJid(rs.getInt("jid"));
                a.setUsername(rs.getString("username"));
                a.setTime(rs.getString("time"));
                arr.add(a);
            }
           
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
        return arr;
	
	}
	
	public static void deleteCompany(String name) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        try {
        	
 
            con=Dao.getConnection();//1:获取数据库的连接
            //2:书写sql语句
            String sql;
            sql="delete form company where name=?;";    	
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
	        ps.setString(1, name);
    
            ps.executeUpdate();//5:执行sql语句
           
           
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
   
	
	
	}

	public static boolean insertCompany(Company c) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        try {
        	
            con=Dao.getConnection();//1:获取数据库的连接
            //2:书写sql语句
            String sql;
            sql="insert into company values(?,?,?);";    	
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
	        ps.setString(1, c.getName());
	        ps.setString(2, c.getUsername());
            ps.setString(3, c.getAddress());
       
            int count = ps.executeUpdate();//5:执行sql语句
            
            if (count > 0) return true;
            else return false;
           
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
        return false;
	
	}

	public static boolean insertJob(Job j) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        try {
        	
            con=Dao.getConnection();//1:获取数据库的连接
            //2:书写sql语句
            String sql;
            sql="insert into Job (cid, name, salary, desciption) values (?,?,?,?);";    
            
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
            
	        ps.setString(1, j.getCid());
            ps.setString(2, j.getName());
            ps.setInt(3, j.getSalary());
            ps.setString(4, j.getDesciption());
       
            int count = ps.executeUpdate();//5:执行sql语句
            
            if (count > 0) return true;
            else return false;
           
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		return false;
	}

	public static boolean insertInterview(Interview i) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        try {
        	
            con=Dao.getConnection();//1:获取数据库的连接
            //2:书写sql语句
            String sql;
            sql="insert into interview values(?,?,?,?);";    	
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
	        ps.setInt(1, i.getJid());
	        ps.setString(2, i.getUsername());
            ps.setString(3, i.getAddress());
            ps.setString(4, i.getTime());
       
            int count = ps.executeUpdate();//5:执行sql语句
            
            if (count > 0) return true;
            else return false;
           
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		return false;
	}

	public static boolean updateApplicationaccepted(Integer jid, String username) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        try {
        	
            con=Dao.getConnection();//1:获取数据库的连接
            //2:书写sql语句
            String sql;
            sql="update Application set acceptInf='accepted' where jid=? and username=? "; 	
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
            ps.setInt(1, jid);
            ps.setString(2, username);
            int count = ps.executeUpdate();//5:执行sql语句
            
            if (count > 0) return true;
            else return false;
           
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		return false;
	}
	
	public static boolean updateApplicationrefused(Integer jid, String username) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        try {
        	
            con=Dao.getConnection();//1:获取数据库的连接
            //2:书写sql语句
            String sql;
            sql="update application set acceptInf='refused' where jid=? and username=?"; 	
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
            ps.setInt(1, jid);
            ps.setString(2, username);
            int count = ps.executeUpdate();//5:执行sql语句
            
            if (count > 0) return true;
            else return false;
           
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		return false;
	}
}
