package entity;

/*
 * 
 * ������
 */
public class Application {
	private String username;//�û�id
	private Integer jid;//ְλid
	private String time;//ʱ��
	private String acceptInf;//�������
	
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
