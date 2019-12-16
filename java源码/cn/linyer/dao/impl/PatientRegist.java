package cn.linyer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.linyer.entity.Patient;
import cn.linyer.util.BaseDao;

/**
 * @author Linyer
 * 患者注册
 * 
 */
public class PatientRegist extends BaseDao {
	//提交患者注册信息
	public boolean addPatient(Patient patient) {
		BaseDao bd = new BaseDao();
		String[] params = {patient.getPname(),patient.getPsex(),patient.getPage(),patient.getPphone(),
				patient.getPaddress(),patient.getPemployer(),patient.getPpwd(),patient.getPIDno()};
		String sql = "insert into \"Patients\"(\"Pno\",\"Pname\",\"Psex\",\"Page\",\"Pphone\",\"Paddress\",\"PEnDate\",\"Pemployer\",\"Ppwd\",\"PIDno\") "
				+ "values(PNO_SEQ.NEXTVAL,?,?,?,?,?,SYSDATE,?,?,?)";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			return true;
		}
	}
	//查询患者是否已注册
	public String selPatient(String pIDno) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String pNo = null;
		
		try {
			String sql = "select \"Pno\" from \"Patients\" where \"PIDno\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pIDno);
			rs = pstmt.executeQuery();
			while(rs.next()){
				pNo = rs.getString("Pno");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return pNo;
	}
}
