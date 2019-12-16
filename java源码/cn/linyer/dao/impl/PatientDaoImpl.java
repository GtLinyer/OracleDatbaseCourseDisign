package cn.linyer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.linyer.dao.ObjDao;
import cn.linyer.dao.UserQueryDao;
import cn.linyer.entity.Patient;
import cn.linyer.entity.UserLoginMsg;
import cn.linyer.util.BaseDao;
/**
 * @author Linyer
 * 操作患者数据库信息
 * 
 */
public class PatientDaoImpl extends BaseDao implements UserQueryDao,ObjDao {
	//患者登录信息
	public UserLoginMsg queryUser(String Pno,String Ppwd) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserLoginMsg patient = null;
		
		try {
			String sql = "select \"病历号\",\"姓名\",\"密码\" from \"PatientLogin\" where \"病历号\"=? and \"密码\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Pno);
			pstmt.setString(2, Ppwd);
			rs = pstmt.executeQuery();
			while(rs.next()){
				patient = new UserLoginMsg();
				patient.setNo(rs.getString("病历号"));
				patient.setName(rs.getString("姓名"));
				patient.setPwd(rs.getString("密码"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return patient;
	}
	//查询患者基本信息
		public Patient selPatient(String Dno) {
			Connection conn = getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Patient patient = null;
			
			try {
				String sql = "select \"Pno\",\"Pname\",\"Psex\",\"Page\",\"Pphone\","
						+ "\"Paddress\",\"Dno\",to_char(\"PEnDate\",'yyyy-mm-dd HH24:MI:SS') as \"PEnDate\","
						+ "\"Pemployer\",\"Ppwd\",\"PIDno\" from \"Patients\" where \"Pno\"=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, Dno);
				rs = pstmt.executeQuery();
				while(rs.next()){
					patient = new Patient();
					patient.setPno(rs.getString("Pno"));
					patient.setPname(rs.getString("Pname"));
					patient.setPsex(rs.getString("Psex"));
					patient.setPage(rs.getString("Page"));
					patient.setPphone(rs.getString("Pphone"));
					patient.setPaddress(rs.getString("Paddress"));
					patient.setDno(rs.getString("Dno"));
					patient.setPEnDate(rs.getString("PEnDate"));
					patient.setPemployer(rs.getString("Pemployer"));
					patient.setPpwd(rs.getString("Ppwd"));
					patient.setPIDno(rs.getString("PIDno"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeAll(conn, pstmt, rs);
			}
			return patient;
		}
	//添加患者信息
	public boolean addObj(Object patientObj) {
		Patient patient = (Patient) patientObj;
		BaseDao bd = new BaseDao();
		String[] params = {patient.getPname(),patient.getPsex(),
							patient.getPage(),patient.getPphone(),
							patient.getPaddress(),patient.getDno(),
							patient.getPEnDate(),patient.getPemployer(),
							patient.getPpwd(),patient.getPIDno()};
		String sql = "insert into \"Patients\"(\"Pno\",\"Pname\",\"Psex\",\"Page\",\"Pphone\","
					+ "\"Paddress\",\"Dno\",\"PEnDate\",\"Pemployer\",\"Ppwd\",\"PIDno\") " + 
					"values(PNO_SEQ.NEXTVAL,?,?,?,?,?,?,to_date(?,'yyyy-mm-dd HH24:MI:SS'),?,?,?)";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			return true;
		}
	}
	//添加患者后查看工号
	public String selPatientNo(String name) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String num = null;
		
		try {
			String sql = "select \"Pno\" from \"Patients\" where \"Pname\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				num = rs.getString("Pno");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return num;
	}
	//删除患者信息
	public boolean deleObj(String no) {
		BaseDao bd = new BaseDao();
		String[] params = {no};
		String sql = "delete from \"Patients\" where \"Pno\"=?";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			return true;
		}
	}
	//修改患者信息
	public boolean exeObj(Object patientObj) {
		Patient patient = (Patient) patientObj;
		if(patient.getPname()==null && patient.getPsex()==null &&
				patient.getPage()==null && patient.getPphone()==null &&
				patient.getPaddress()==null && patient.getDno()==null &&
				patient.getPEnDate()==null && patient.getPemployer()==null &&
				patient.getPpwd()==null && patient.getPIDno()==null) {
			return false;
		}else {
			BaseDao bd = new BaseDao();
			StringBuffer set = new StringBuffer();
			int i = 0;
			List<String> paramList = new ArrayList<String>();
			if(patient.getPname()!=null && patient.getPname().length()!=0) {
				set.append("\"Pname\"=?,");
				paramList.add(0, patient.getPname());
				i++;
			}
			if(patient.getPsex()!=null && patient.getPsex().length()!=0) {
				set.append("\"Psex\"=?,");
				if(i == 0) {
					paramList.add(0, patient.getPsex());
					i++;
				}else {
					paramList.add(i, patient.getPsex());
					i++;
				}
			}
			if(patient.getPage()!=null && patient.getPage().length()!=0) {
				set.append("\"Page\"=?,");
				if(i == 0) {
					paramList.add(0, patient.getPage());
					i++;
				}else {
					paramList.add(i, patient.getPage());
					i++;
				}
			}
			if(patient.getPphone()!=null && patient.getPphone().length()!=0) {
				set.append("\"Pphone\"=?,");
				if(i == 0) {
					paramList.add(0, patient.getPphone());
					i++;
				}else {
					paramList.add(i, patient.getPphone());
					i++;
				}
			}
			if(patient.getPaddress()!=null && patient.getPaddress().length()!=0) {
				set.append("\"Paddress\"=?,");
				if(i == 0) {
					paramList.add(0, patient.getPaddress());
					i++;
				}else {
					paramList.add(i, patient.getPaddress());
					i++;
				}
			}
			if(patient.getDno()!=null && patient.getDno().length()!=0) {
				set.append("\"Dno\"=?,");
				if(i == 0) {
					paramList.add(0, patient.getDno());
					i++;
				}else {
					paramList.add(i, patient.getDno());
					i++;
				}
			}
			if(patient.getPEnDate()!=null && patient.getPEnDate().length()!=0) {
				set.append("\"PEnDate\"=?,");
				if(i == 0) {
					paramList.add(0, patient.getPEnDate());
					i++;
				}else {
					paramList.add(i, patient.getPEnDate());
					i++;
				}
			}
			if(patient.getPemployer()!=null && patient.getPemployer().length()!=0) {
				set.append("\"Pemployer\"=?,");
				if(i == 0) {
					paramList.add(0, patient.getPemployer());
					i++;
				}else {
					paramList.add(i, patient.getPemployer());
					i++;
				}
			}
			if(patient.getPpwd()!=null && patient.getPpwd().length()!=0) {
				set.append("\"Ppwd\"=?,");
				if(i == 0) {
					paramList.add(0, patient.getPpwd());
					i++;
				}else {
					paramList.add(i, patient.getPpwd());
					i++;
				}
			}
			if(patient.getPIDno()!=null && patient.getPIDno().length()!=0) {
				set.append("\"PIDno\"=?,");
				if(i == 0) {
					paramList.add(0, patient.getPIDno());
					i++;
				}else {
					paramList.add(i, patient.getPIDno());
					i++;
				}
			}
			
			String[] params = new String[paramList.size()+1];
			
			for(int k=0; k<paramList.size() ; k++) {
				params[k] = paramList.get(k);
			}
			params[i] = patient.getPno();
			
			set.deleteCharAt(set.lastIndexOf(","));
			
			String sql = "update \"Patients\" set "+ set +" where \"Pno\"=?";
			int j = bd.exeUpdate(sql, params);
			if(j == 0){
				return false;
			}else{
				return true;
			}
	
		}
	}
}
