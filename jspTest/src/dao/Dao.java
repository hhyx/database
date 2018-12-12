package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.mysql.jdbc.Statement; 

public class Dao {
	
	private static String driver;//���ݿ�����
    private static String url;//���ݿ�·�����ҵ���Ӧ�����ݿ�
    private static String user;//���ݿ��˺�
    private static String password;//���ݿ�����
    
    static {
    	driver = "com.mysql.jdbc.Driver";
    	url = "jdbc:mysql://localhost:3306/application?useUnicode=true&characterEncoding=UTF8&useSSL=false";
    	user = "root";
    	password = "root";
    }
	
	public static Connection getConnection() throws ClassNotFoundException,SQLException {
		Class.forName(driver);//�������ݿ�������ע�ᵽ��������	
        Connection con=DriverManager.getConnection(url,user,password);
        if (con != null) {
        	System.out.println("connect successfully");
        } else {
        	System.out.println("fail");
        }
        
        Statement stmt = (Statement) con.createStatement();
        String check[] = new String[] {"show tables like \"application\"",
        	"show tables like \"company\"",
        	"show tables like \"employee\"",
        	"show tables like \"employer\"",
        	"show tables like \"job\"",
        	"show tables like \"interview\""
        };
        String create[] = new String[] { "CREATE TABLE `application` ( `jid` int(11) NOT NULL, `username` varchar(45) NOT NULL,  `time` varchar(45) NOT NULL,  `acceptInf` varchar(45) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8;",
        	"CREATE TABLE `company` ( `name` varchar(45) NOT NULL, `username` varchar(45) NOT NULL,  `address` varchar(45) NOT NULL, PRIMARY KEY (`name`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;"	,
        	"CREATE TABLE `employee` ( `username` varchar(45) CHARACTER SET utf8 NOT NULL,  `password` varchar(45) CHARACTER SET utf8 NOT NULL,  `email` varchar(45) CHARACTER SET utf8 NOT NULL,  `phone` varchar(45) CHARACTER SET utf8 NOT NULL,  `type` varchar(45) CHARACTER SET utf8 NOT NULL,  `name` varchar(45) CHARACTER SET utf8 NOT NULL,  `age` int(11) NOT NULL,  PRIMARY KEY (`username`)) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;",
        	"CREATE TABLE `employer` (    `phone` varchar(45) NOT NULL,  `email` varchar(45) NOT NULL,  `type` varchar(45) NOT NULL,  `name` varchar(45) NOT NULL,  `age` varchar(45) NOT NULL,  `company` varchar(45) NOT NULL,  PRIMARY KEY (`username`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;",
        	"CREATE TABLE `job` (  `jid` int(11) NOT NULL AUTO_INCREMENT,  `cid` varchar(45) NOT NULL,  `name` varchar(45) NOT NULL,  `salary` int(11) NOT NULL,  `desciption` varchar(45) NOT NULL,  PRIMARY KEY (`jid`)) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;",
        	"CREATE TABLE `interview` (  `jid` int(11) NOT NULL,  `username` varchar(45) NOT NULL,  `address` varchar(45) NOT NULL,  `time` varchar(45) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8;"       
        };
          
        for (int i = 0; i < 6; i++) {
        	ResultSet resultSet=stmt.executeQuery(check[i]);
    		if (resultSet.next()) {
//    			System.out.println("table exist!");
    		} else{
                stmt.executeUpdate(create[i]);
//                System.out.println("create table success!");
    		}
        }
		

        
        
        return con;
	}
	
	public static void close(Connection con,PreparedStatement ps,ResultSet rs){
	        if(rs!=null){//�ر���Դ����������쳣
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        if(ps!=null){
	            try {
	                ps.close();
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        if(con!=null){
	            try {
	                con.close();
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	    }

	public static boolean addUpdateDelete(String sql,Object[] arr){
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con=Dao.getConnection();//��һ�� ���������ݿ�Ĳ���
            ps=con.prepareStatement(sql);//�ڶ�����Ԥ����
            //������������ֵ
            if(arr!=null && arr.length!=0){
                for(int i=0;i<arr.length;i++){
                    ps.setObject(i+1, arr[i]);
                }
            }
            
           
            int count=ps.executeUpdate();//���Ĳ���ִ��sql���
            if(count>0){
                return true;
            }else{
                return false;
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        	
            e.printStackTrace();
        }
        return false;
    }
	
	public static void main(String args[]) {
		try {
			Dao d = new Dao();
			d.getConnection();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
}
