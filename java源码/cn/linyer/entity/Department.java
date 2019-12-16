package cn.linyer.entity;

/**
 * @author Linyer
 * 科室信息
 * 
 */
public class Department {
	private String DPno = null;
	private String DPname = null;
	private String DPloca = null;
	private String DPbrief = null;
	private String isClinical = null;

	public String getDPno() {
		return DPno;
	}
	public void setDPno(String dPno) {
		DPno = dPno;
	}
	public String getDPname() {
		return DPname;
	}
	public void setDPname(String dPname) {
		DPname = dPname;
	}
	public String getDPloca() {
		return DPloca;
	}
	public void setDPloca(String dPloca) {
		DPloca = dPloca;
	}
	public String getDPbrief() {
		return DPbrief;
	}
	public void setDPbrief(String dPbrief) {
		DPbrief = dPbrief;
	}	
	public String getIsClinical() {
		return isClinical;
	}
	public void setIsClinical(String isClinical) {
		this.isClinical = isClinical;
	}
}
