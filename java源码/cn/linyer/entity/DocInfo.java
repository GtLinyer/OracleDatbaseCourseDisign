package cn.linyer.entity;

/**
 * @author Linyer
 * 给患者看到的医师信息
 * 
 */
public class DocInfo {
	private String Dno = null;
	private String Dname = null;
	private String Dsex = null;
	private String Demail = null;
	private String DPname = null;
	private String Lname = null;
	private String Dxl = null;
	private String Dyear = null;
	private String Dbrief = null;

	public String getDno() {
		return Dno;
	}
	public void setDno(String dno) {
		Dno = dno;
	}
	public String getDname() {
		return Dname;
	}
	public void setDname(String dname) {
		Dname = dname;
	}
	public String getDsex() {
		return Dsex;
	}
	public void setDsex(String dsex) {
		Dsex = dsex;
	}
	public String getDemail() {
		return Demail;
	}
	public void setDemail(String demail) {
		Demail = demail;
	}
	public String getDPname() {
		return DPname;
	}
	public void setDPname(String dPname) {
		DPname = dPname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getDxl() {
		return Dxl;
	}
	public void setDxl(String dxl) {
		Dxl = dxl;
	}
	public String getDyear() {
		return Dyear;
	}
	public void setDyear(String dyear) {
		Dyear = dyear;
	}	
	public String getDbrief() {
		return Dbrief;
	}
	public void setDbrief(String dbrief) {
		Dbrief = dbrief;
	}
}
