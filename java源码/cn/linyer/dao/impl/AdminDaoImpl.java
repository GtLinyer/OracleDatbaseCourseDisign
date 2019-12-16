package cn.linyer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import cn.linyer.dao.UserQueryDao;
import cn.linyer.entity.UserLoginMsg;
import cn.linyer.util.BaseDao;
/**
 * @author Linyer
 * 操作管理员数据库信息
 * 
 */
public class AdminDaoImpl extends BaseDao implements UserQueryDao {
	//管理员登录信息
	public UserLoginMsg queryUser(String no,String pwd) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserLoginMsg admin = null;
		
		try {
			String sql = "select \"Ano\",\"Aname\",\"Apwd\" from \"Admin\" where \"Ano\"=? and \"Apwd\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			while(rs.next()){
				admin = new UserLoginMsg();
				admin.setNo(rs.getString("Ano"));
				admin.setName(rs.getString("Aname"));
				admin.setPwd(rs.getString("Apwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return admin;
	}
}
