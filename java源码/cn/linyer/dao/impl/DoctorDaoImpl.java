package cn.linyer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.linyer.dao.ObjDao;
import cn.linyer.dao.UserQueryDao;
import cn.linyer.entity.Doctor;
import cn.linyer.entity.UserLoginMsg;
import cn.linyer.util.BaseDao;

/**
 * @author Linyer
 * 操作数据库医师基本信息
 * 
 */
public class DoctorDaoImpl extends BaseDao implements UserQueryDao,ObjDao {
	//医师登录信息
	public UserLoginMsg queryUser(String Dno,String Dpwd) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserLoginMsg loginMsg = null;
		
		try {
			String sql = "select \"工号\",\"姓名\",\"密码\",\"是否临床\" from \"DoctorLogin\" where \"工号\"=? and \"密码\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Dno);
			pstmt.setString(2, Dpwd);
			rs = pstmt.executeQuery();
			while(rs.next()){
				loginMsg = new UserLoginMsg();
				loginMsg.setNo(rs.getString("工号"));
				loginMsg.setName(rs.getString("姓名"));
				loginMsg.setPwd(rs.getString("密码"));
				loginMsg.setIsClinical(rs.getString("是否临床"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return loginMsg;
	}
	//查询医师基本信息
	public Doctor selDoctor(String Dno) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Doctor doctor = null;
		
		try {
			String sql = "select \"Dno\",\"Dname\",\"Dsex\",\"Dphone\",\"Demail\",\"Dbrief\",\"Dpwd\",to_char(\"Dbirth\",'yyyy-mm-dd') as \"Dbirth\" from \"Doctors\" where \"Dno\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Dno);
			rs = pstmt.executeQuery();
			while(rs.next()){
				doctor = new Doctor();
				doctor.setDno(rs.getString("Dno"));
				doctor.setDname(rs.getString("Dname"));
				doctor.setDsex(rs.getString("Dsex"));
				doctor.setDbirth(rs.getString("Dbirth"));
				doctor.setDphone(rs.getString("Dphone"));
				doctor.setDemail(rs.getString("Demail"));
				doctor.setDbrief(rs.getString("Dbrief"));
				doctor.setDpwd(rs.getString("Dpwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return doctor;
	}
	
	//添加医师信息
	public boolean addObj(Object doctorObj) {
		Doctor doctor = (Doctor) doctorObj;
		BaseDao bd = new BaseDao();
		String[] params = {doctor.getDname(),doctor.getDsex(),
						doctor.getDbirth(),doctor.getDphone(),
						doctor.getDemail(),doctor.getDbrief(),doctor.getDpwd()};
		String sql = "insert into \"Doctors\"(\"Dno\",\"Dname\",\"Dsex\",\"Dbirth\",\"Dphone\",\"Demail\",\"Dbrief\",\"Dpwd\") " + 
								"values(DNO_SEQ.NEXTVAL,?,?,to_date(?, 'yyyy-mm-dd'),?,?,?,?)";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			return true;
		}
	}
	
	//添加医师后查看工号
	public String selDoctorNo(String name) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String num = null;
		
		try {
			String sql = "select \"Dno\" from \"Doctors\" where \"Dname\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				num = rs.getString("Dno");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return num;
	}
	//删除医师信息
	public boolean deleObj(String no) {
		BaseDao bd = new BaseDao();
		String[] params = {no};
		String sql = "delete from \"Doctors\" where \"Dno\"=?";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			return true;
		}
	}
	//修改医师信息
	public boolean exeObj(Object doctorObj) {
		Doctor doctor = (Doctor) doctorObj;
		if(doctor.getDname()==null && doctor.getDsex()==null &&
		   doctor.getDbirth()==null && doctor.getDphone()==null &&
		   doctor.getDemail()==null && doctor.getDbrief()==null && doctor.getDpwd()==null) {
			return false;
		}else {
			BaseDao bd = new BaseDao();
			StringBuffer set = new StringBuffer();
			int i = 0;
			List<String> paramList = new ArrayList<String>();
			if(doctor.getDname()!=null && doctor.getDname().length()!=0) {
				set.append("\"Dname\"=?,");
				paramList.add(0, doctor.getDname());
				i++;
			}
			if(doctor.getDsex()!=null && doctor.getDsex().length()!=0) {
				set.append("\"Dsex\"=?,");
				if(i == 0) {
					paramList.add(0, doctor.getDsex());
					i++;
				}else {
					paramList.add(i, doctor.getDsex());
					i++;
				}
			}
			if(doctor.getDbirth()!=null && doctor.getDbirth().length()!=0) {
				set.append("\"Dbirth\"=to_date(?,'yyyy-mm-dd'),");
				if(i == 0) {
					paramList.add(0, doctor.getDbirth());
					i++;
				}else {
					paramList.add(i, doctor.getDbirth());
					i++;
				}
			}
			if(doctor.getDphone()!=null && doctor.getDphone().length()!=0) {
				set.append("\"Dphone\"=?,");
				if(i == 0) {
					paramList.add(0, doctor.getDphone());
					i++;
				}else {
					paramList.add(i, doctor.getDphone());
					i++;
				}
			}
			if(doctor.getDemail()!=null && doctor.getDemail().length()!=0) {
				set.append("\"Demail\"=?,");
				if(i == 0) {
					paramList.add(0, doctor.getDemail());
					i++;
				}else {
					paramList.add(i, doctor.getDemail());
					i++;
				}
			}
			if(doctor.getDbrief()!=null && doctor.getDbrief().length()!=0) {
				set.append("\"Dbrief\"=?,");
				if(i == 0) {
					paramList.add(0, doctor.getDbrief());
					i++;
				}else {
					paramList.add(i, doctor.getDbrief());
					i++;
				}
			}
			if(doctor.getDpwd()!=null && doctor.getDpwd().length()!=0) {
				set.append("\"Dpwd\"=?,");
				if(i == 0) {
					paramList.add(0, doctor.getDpwd());
					i++;
				}else {
					paramList.add(i, doctor.getDpwd());
					i++;
				}
			}
			
			String[] params = new String[paramList.size()+1];
			
			for(int k=0; k<paramList.size() ; k++) {
				params[k] = paramList.get(k);
			}
			params[i] = doctor.getDno();
			
			set.deleteCharAt(set.lastIndexOf(","));
			
			String sql = "update \"Doctors\" set "+ set +" where \"Dno\"=?";
			int j = bd.exeUpdate(sql, params);
			if(j == 0){
				return false;
			}else{
				return true;
			}
		}
	}
}
