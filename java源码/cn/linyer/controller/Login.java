package cn.linyer.controller;

import cn.linyer.dao.UserQueryDao;
import cn.linyer.dao.impl.AdminDaoImpl;
import cn.linyer.dao.impl.DoctorDaoImpl;
import cn.linyer.dao.impl.PatientDaoImpl;
import cn.linyer.entity.UserLoginMsg;
/**
 * @author Linyer
 * 用户登录控制
 * 
 */
public class Login {
	private String userNo = "error";
	private String userName = "error";
	private String userPwd = "error";
	private String isClinical = null;
	
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getIsClinical() {
		return isClinical;
	}
	public void setIsClinical(String isClinical) {
		this.isClinical = isClinical;
	}
	
	public Boolean selectPatient() {
		UserQueryDao patientDao = new PatientDaoImpl();
		UserLoginMsg patient = patientDao.queryUser(this.getUserNo(), this.getUserPwd());
		if(patient!=null) {
			this.setUserName(patient.getName());
			return true;
		}else {
			return false;
		}
	}
	public Boolean selectAdmin() {
		UserQueryDao AdminDao = new AdminDaoImpl();
		UserLoginMsg admin = AdminDao.queryUser(this.getUserNo(), this.getUserPwd());
		if(admin!=null) {
			this.setUserName(admin.getName());
			return true;
		}else {
			return false;
		}
	}
	public Boolean selectDoctor() {
		UserQueryDao DoctorDao = new DoctorDaoImpl();
		UserLoginMsg doctor = DoctorDao.queryUser(this.getUserNo(), this.getUserPwd());
		if(doctor!=null) {
			this.setUserName(doctor.getName());
			if(doctor.getIsClinical().equals("1")) {
				this.setIsClinical("1");
			}else {
				this.setIsClinical("0");
			}
			return true;
		}else {
			return false;
		}
	}
}
