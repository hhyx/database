package dao;

import entity.*;
public interface UserDao {
	 /***
     * �û���½�ķ�������
     * @param user
     * @return
     */
    public User login(User user);
    
    /***
     * �û�ע��ķ�������
     * @param user
     * @return
     */
    public boolean register(User user);

}
