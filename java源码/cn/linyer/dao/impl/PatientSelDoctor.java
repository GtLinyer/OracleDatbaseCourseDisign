package cn.linyer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.linyer.entity.Department;
import cn.linyer.entity.DocInfo;
import cn.linyer.util.BaseDao;

/**
 * @author Linyer
 * 病人看病操作数据库
 * 
 */
public class PatientSelDoctor extends BaseDao {
	//查询科室信息
	public List<Department> selDep() {
		List<Department> depList = new ArrayList<Department>();
		Department department = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int i = 0;
		
		try {
			String sql = "select * from \"Departments\"";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				department = new Department();
				department.setDPno(rs.getString("DPno"));
				department.setDPname(rs.getString("DPname"));
				department.setDPloca(rs.getString("DPloca"));
				department.setDPbrief(rs.getString("DPbrief"));
				depList.add(i,department);
				i ++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return depList;
	}
	//查询医师信息
	public List<DocInfo> selDoc(String dp,int dL) {
		List<DocInfo> docInfoList = new ArrayList<DocInfo>();
		DocInfo docInfo = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String where = null;
		//医师类型（普通还是专家）
		int i = 0;
		if(dL == 1) {
			where = "\"医师职称编号\"='2'";
		}else {
			where = "(\"医师职称编号\"='3' or \"医师职称编号\"='4')";
		}
		
		try {
			String sql = "select * from \"DocInfo\" where \"所属科室编号\"=? and " + where;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dp);
			rs = pstmt.executeQuery();
			while(rs.next()){
				docInfo = new DocInfo();
				docInfo.setDno(rs.getString("医师工号"));
				docInfo.setDname(rs.getString("医师姓名"));
				docInfo.setDsex(rs.getString("医师性别"));
				docInfo.setDemail(rs.getString("医师邮箱"));
				docInfo.setDPname(rs.getString("所属科室名称"));
				docInfo.setLname(rs.getString("医师职称"));
				docInfo.setDxl(rs.getString("医师学历"));
				docInfo.setDyear(rs.getString("医师年资"));
				docInfo.setDbrief(rs.getString("医师简介"));
				docInfoList.add(i,docInfo);
				i ++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return docInfoList;
	}
	//病人选择要看的医师后，更新数据库中的信息
	public boolean addDocForPatient(String dNo,String pNo) {
		BaseDao bd = new BaseDao();
		String[] params = {dNo,pNo};
		String sql = "update \"Patients\" set \"Dno\"=? where \"Pno\"=?";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			return true;
		}
	}
}
