package entity;

/*
 * 
 * 申请类
 */
public class Application {
	private String username;//用户id
	private Integer jid;//职位id
	private String time;//时间
	private String acceptInf;//申请接受
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getJid() {
		return jid;
	}
	public void setJid(Integer jid) {
		this.jid = jid;
	}
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAcceptInf() {
		return acceptInf;
	}
	public void setAcceptInf(String acceptInf) {
		this.acceptInf = acceptInf;
	}
}
