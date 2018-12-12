package entity;

public class Interview {
	private Integer jid;
	private String username;
	private String address;
	private String time;
	public Interview(Integer jid,String username,String address,String time) {
		setJid(jid);
		setUsername(username);
		setAddress(address);
		setTime(time);
	}
	
	public Interview() {
		
	}
	public Integer getJid() {
		return jid;
	}
	public void setJid(Integer jid) {
		this.jid = jid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
