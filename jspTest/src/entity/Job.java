package entity;

public class Job {
	private Integer jid;
	private String name;//ְλ����
	private Integer salary;//����
	private String cid;//��Ӧ��˾id
	private String desciption;//ְλ����
	public Job(Integer jid, String name, Integer salary, String cid, String desciptioin) {
		setJid(jid);
		setName(name);
		setSalary(salary);
		setCid(cid);
		setDesciption(desciptioin);
	}
	public Job() {
		
	}
	
	public Integer getJid() {
		return jid;
	}
	public void setJid(Integer jid) {
		this.jid = jid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
}
