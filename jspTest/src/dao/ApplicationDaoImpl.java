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

public class ApplicationDaoImpl {
	public static ArrayList getCompany() {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Company> arr = new ArrayList<>();
        try {
            con=Dao.getConnection();//1:��ȡ���ݿ������
            //2:��дsql���
            String sql;
        	sql= "select * from company;";
           
            	
            ps=con.prepareStatement(sql);//3��Ԥ����
            //4������ֵ
            rs=ps.executeQuery();//5:ִ��sql���
            while(rs.next()){
                Company c=new Company();
                //�����ݿ��л�ȡֵ���õ�ʵ�����setter������
           
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
            con=Dao.getConnection();//1:��ȡ���ݿ������
            //2:��дsql���
            String sql;
        	sql= "select * from company where username=?;";
           
            	
            ps=con.prepareStatement(sql);//3��Ԥ����
            //4������ֵ
            ps.setString(1, username);
            rs=ps.executeQuery();//5:ִ��sql���
            while(rs.next()){
                Company c=new Company();
                //�����ݿ��л�ȡֵ���õ�ʵ�����setter������
           
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
            con=Dao.getConnection();//1:��ȡ���ݿ������
            //2:��дsql���
            String sql;

        	sql= "select * from job where cid = ?;";
        	ps=con.prepareStatement(sql);
        	
        	ps.setString(1, cid);
        
            //4������ֵ
            rs=ps.executeQuery();//5:ִ��sql���
            while(rs.next()){
                Job job=new Job();
                //�����ݿ��л�ȡֵ���õ�ʵ�����setter������
                
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
            con=Dao.getConnection();//1:��ȡ���ݿ������
            //2:��дsql���
            String sql;
        	sql= "select * from job where jid = ?;";          
        	ps=con.prepareStatement(sql);
        	
        	ps.setInt(1, jid);
        
            //4������ֵ
            rs=ps.executeQuery();//5:ִ��sql���
            while(rs.next()){
                Job job=new Job();
                //�����ݿ��л�ȡֵ���õ�ʵ�����setter������
                
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
            con=Dao.getConnection();//1:��ȡ���ݿ������
            //2:��дsql���
            String sql;
        	sql= "select * from interview where username = ?;";
           
            	
            ps=con.prepareStatement(sql);//3��Ԥ����
            //4������ֵ
            ps.setString(1, username);
            rs=ps.executeQuery();//5:ִ��sql���
            while(rs.next()){
            	Interview i=new Interview();
                //�����ݿ��л�ȡֵ���õ�ʵ�����setter������
           
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
            con=Dao.getConnection();//1:��ȡ���ݿ������
            //2:��дsql���
            String sql;
        	sql= "select * from interview where jid = ?;";
           
            	
            ps=con.prepareStatement(sql);//3��Ԥ����
            //4������ֵ
            ps.setInt(1, jid);
            rs=ps.executeQuery();//5:ִ��sql���
            while(rs.next()){
            	Interview i=new Interview();
                //�����ݿ��л�ȡֵ���õ�ʵ�����setter������
           
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
            con=Dao.getConnection();//1:��ȡ���ݿ������
            //2:��дsql���
            String sql;
        	sql= "select * from application where username = ?;";
           
            	
            ps=con.prepareStatement(sql);//3��Ԥ����
            //4������ֵ
            ps.setString(1, username);
            rs=ps.executeQuery();//5:ִ��sql���
            while(rs.next()){
            	Application a=new Application();
                //�����ݿ��л�ȡֵ���õ�ʵ�����setter������
           
                a.setJid(rs.getInt("jid"));
                a.setUsername(rs.getString("username"));
                a.setTime(rs.getString("time"));
                a.setAcceptInf(rs.getString("acceptInf"));
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
            con=Dao.getConnection();//1:��ȡ���ݿ������
            //2:��дsql���
            String sql;
        	sql= "select * from application where jid = ?;";
           
            	
            ps=con.prepareStatement(sql);//3��Ԥ����
            //4������ֵ
            ps.setInt(1, jid);
            rs=ps.executeQuery();//5:ִ��sql���
            while(rs.next()){
            	Application a=new Application();
                //�����ݿ��л�ȡֵ���õ�ʵ�����setter������
           
                a.setJid(rs.getInt("jid"));
                a.setUsername(rs.getString("username"));
                a.setTime(rs.getString("time"));
                a.setAcceptInf(rs.getString("acceptInf"));
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
        	
 
            con=Dao.getConnection();//1:��ȡ���ݿ������
            //2:��дsql���
            String sql;
            sql="delete form company where name=?;";    	
            ps=con.prepareStatement(sql);//3��Ԥ����
            //4������ֵ
	        ps.setString(1, name);
    
            ps.executeUpdate();//5:ִ��sql���
           
           
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
   
	
	
	}

	public static boolean insertApplication(Integer jid,String username) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Application> arr = new ArrayList<>();
 
        try {
        	
        	//��ȡ���û�������
    		ArrayList<Application> appli = ApplicationDaoImpl.getApplication(username);
    		//�ж��Ƿ������ͬһ�ݹ���
    		for (int i = 0;i < appli.size();i ++) {
    			if (appli.get(i).getJid() == jid) {
    				return false;
    			}
    		}
    		
            con=Dao.getConnection();//1:��ȡ���ݿ������
            //2:��дsql���
            String sql;
            sql="insert into application values(?,?,?,?);";    	
            ps=con.prepareStatement(sql);//3��Ԥ����
            //4������ֵ
            Date day=new Date();    
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	        ps.setInt(1, jid);
            ps.setString(2, username);
            ps.setString(3, df.format(day));
            ps.setString(4, "Waiting");
            
            ps.executeUpdate();//5:ִ��sql���
            return true;
           
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
        return false;
	
		
	}


	public static boolean insertCompany(Company c) {
		Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        try {
        	
 
            con=Dao.getConnection();//1:��ȡ���ݿ������
            //2:��дsql���
            String sql;
            sql="insert into company values(?,?,?);";    	
            ps=con.prepareStatement(sql);//3��Ԥ����
            //4������ֵ
	        ps.setString(1, c.getName());
	        ps.setString(2, c.getUsername());
            ps.setString(3, c.getAddress());
       
            int count = ps.executeUpdate();//5:ִ��sql���
            
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
