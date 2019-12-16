package cn.linyer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.linyer.util.BaseDao;

/**
 * @author Linyer
 * 患者看病查询数据库
 * 
 */
public class PatientSeeDoctor extends BaseDao {
	//查询诊断结果
	public String selDiag(String pNo) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String diagMsg = null;
		
		try {
			String sql = "select \"diagnosis\" from \"Treatment\" where \"Pno\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pNo);
			rs = pstmt.executeQuery();
			while(rs.next()){
				diagMsg = rs.getString("diagnosis");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return diagMsg;
	}
	//查询治疗方案
	public String selTreat(String pNo) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String treatMsg = null;
		
		try {
			String sql = "select \"treat\" from \"Treatment\" where \"Pno\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pNo);
			rs = pstmt.executeQuery();
			while(rs.next()){
				treatMsg = rs.getString("treat");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return treatMsg;
	}
}
