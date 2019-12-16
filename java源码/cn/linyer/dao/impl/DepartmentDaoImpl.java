package cn.linyer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.linyer.dao.ObjDao;
import cn.linyer.entity.Department;
import cn.linyer.util.BaseDao;

/**
 * @author Linyer
 * 操作数据库科室信息
 * 
 */
public class DepartmentDaoImpl extends BaseDao implements ObjDao {
	//查询科室信息
	public Department selDepartment(String DPno) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Department dp = null;
		
		try {
			String sql = "select * from \"Departments\" where \"DPno\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, DPno);
			rs = pstmt.executeQuery();
			while(rs.next()){
				dp = new Department();
				dp.setDPno(rs.getString("DPno"));
				dp.setDPname(rs.getString("DPname"));
				dp.setDPloca(rs.getString("DPloca"));
				dp.setDPbrief(rs.getString("DPbrief"));
				dp.setIsClinical(rs.getString("isClinical"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return dp;
	}
	//添加科室信息
	public boolean addObj(Object dpObj) {
		Department dp = (Department) dpObj;
		BaseDao bd = new BaseDao();
		String[] params = {dp.getDPname(),dp.getDPloca(),dp.getDPbrief(),dp.getIsClinical()};
		String sql = "insert into \"Departments\"(\"DPno\",\"DPname\",\"DPloca\",\"DPbrief\",\"isClinical\") values(DPNO_SEQ.NEXTVAL,?,?,?,?)";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			return true;
		}
	}
	//添加医师后查看工号
	public String selDpNo(String name) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String num = null;
		
		try {
			String sql = "select \"DPno\" from \"Departments\" where \"DPname\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				num = rs.getString("DPno");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return num;
	}
	//删除科室信息
	public boolean deleObj(String no) {
		BaseDao bd = new BaseDao();
		String[] params = {no};
		String sql = "delete from \"Departments\" where \"DPno\"=?";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			return true;
		}
	}
	//修改科室信息
	public boolean exeObj(Object dpObj) {
		Department dp = (Department) dpObj;
		if(dp.getDPname()==null && dp.getDPloca()==null && dp.getDPbrief()==null && dp.getIsClinical()==null) {
			return false;
		}else {
			BaseDao bd = new BaseDao();
			StringBuffer set = new StringBuffer();
			int i = 0;
			List<String> paramList = new ArrayList<String>();
			if(dp.getDPname()!=null && dp.getDPname().length()!=0) {
				set.append("\"DPname\"=?,");
				paramList.add(0, dp.getDPname());
				i++;
			}
			if(dp.getDPloca()!=null && dp.getDPloca().length()!=0) {
				set.append("\"DPloca\"=?,");
				if(i == 0) {
					paramList.add(0, dp.getDPloca());
					i++;
				}else {
					paramList.add(i, dp.getDPloca());
					i++;
				}
			}
			if(dp.getDPbrief()!=null && dp.getDPbrief().length()!=0) {
				set.append("\"DPbrief\"=?,");
				if(i == 0) {
					paramList.add(0, dp.getDPbrief());
					i++;
				}else {
					paramList.add(i, dp.getDPbrief());
					i++;
				}
			}
			if(dp.getIsClinical()!=null && dp.getIsClinical().length()!=0) {
				set.append("\"isClinical\"=?,");
				if(i == 0) {
					paramList.add(0, dp.getIsClinical());
					i++;
				}else {
					paramList.add(i, dp.getIsClinical());
					i++;
				}
			}
			
			String[] params = new String[paramList.size()+1];
			
			for(int k=0; k<paramList.size() ; k++) {
				params[k] = paramList.get(k);
			}
			params[i] = dp.getDPno();
			
			set.deleteCharAt(set.lastIndexOf(","));
			
			String sql = "update \"Departments\" set "+ set +" where \"DPno\"=?";
			int j = bd.exeUpdate(sql, params);
			if(j == 0){
				return false;
			}else{
				return true;
			}
		}
	}
}
