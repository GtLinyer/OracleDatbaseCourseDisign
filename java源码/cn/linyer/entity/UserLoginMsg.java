package cn.linyer.entity;
/**
 * @author Linyer
 * 用户登录信息
 * 
 */
public class UserLoginMsg {
	private String no = null;
	private String name = null;
	private String pwd = null;
	private String isClinical = null;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getIsClinical() {
		return isClinical;
	}
	public void setIsClinical(String isClinical) {
		this.isClinical = isClinical;
	}
}
