package cn.linyer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.linyer.dao.ObjDao;
import cn.linyer.entity.DoctorEmp;
import cn.linyer.util.BaseDao;

/**
 * @author Linyer
 * 操作数据库医师职业信息
 * 
 */
public class DoctorEmpDaoIpml extends BaseDao implements ObjDao {
	//查询医师职业信息
	public DoctorEmp selDoctorEmp(String Dno) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DoctorEmp doctorEmp = null;
		
		try {
			String sql = "select * from \"DocEmp\" where \"Dno\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Dno);
			rs = pstmt.executeQuery();
			while(rs.next()){
				doctorEmp = new DoctorEmp();
				doctorEmp.setDno(rs.getString("Dno"));
				doctorEmp.setDPno(rs.getString("DPno"));
				doctorEmp.setDwork(rs.getString("Dwork"));
				doctorEmp.setLno(rs.getString("Lno"));
				doctorEmp.setDxl(rs.getString("Dxl"));
				doctorEmp.setDyear(rs.getString("Dyear"));
				doctorEmp.setDsalary(rs.getString("Dsalary"));
				doctorEmp.setDsuperNo(rs.getString("DsuperNo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return doctorEmp;
	}
	//增加医师职业信息
	public boolean addObj(Object doctorObj) {
		DoctorEmp doctorEmp = (DoctorEmp) doctorObj;
		BaseDao bd = new BaseDao();
		String[] params = {doctorEmp.getDno(),doctorEmp.getDPno(),
							doctorEmp.getDwork(),doctorEmp.getLno(),
							doctorEmp.getDxl(),doctorEmp.getDyear(),
							doctorEmp.getDsalary(),doctorEmp.getDsuperNo()};
		String sql = "insert into \"DocEmp\"(\"Dno\",\"DPno\",\"Dwork\",\"Lno\",\"Dxl\",\"Dyear\",\"Dsalary\",\"DsuperNo\") values(?,?,?,?,?,?,?,?)";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			return true;
		}
	}
	//删除医师职业信息
	public boolean deleObj(String no) {
		BaseDao bd = new BaseDao();
		String[] params = {no};
		String sql = "delete from \"DocEmp\" where \"Dno\"=?";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			return true;
		}
	}
	//修改医师职业信息
	public boolean exeObj(Object doctorEmpObj) {
		DoctorEmp doctorEmp = (DoctorEmp) doctorEmpObj;
		if(doctorEmp.getDPno()==null && doctorEmp.getDwork()==null &&
			doctorEmp.getLno()==null && doctorEmp.getDxl()==null &&
			doctorEmp.getDyear()==null && doctorEmp.getDsalary()==null && doctorEmp.getDsuperNo()==null) {
			return false;
		}else {
			BaseDao bd = new BaseDao();
			StringBuffer set = new StringBuffer();
			int i = 0;
			List<String> paramList = new ArrayList<String>();
			if(doctorEmp.getDPno()!=null && doctorEmp.getDPno().length()!=0) {
				set.append("\"DPno\"=?,");
				paramList.add(0, doctorEmp.getDPno());
				i++;
			}
			if(doctorEmp.getDwork()!=null && doctorEmp.getDwork().length()!=0) {
				set.append("\"Dwork\"=?,");
				if(i == 0) {
					paramList.add(0, doctorEmp.getDwork());
					i++;
				}else {
					paramList.add(i, doctorEmp.getDwork());
					i++;
				}
			}
			if(doctorEmp.getLno()!=null && doctorEmp.getLno().length()!=0) {
				set.append("\"Lno\"=?,");
				if(i == 0) {
					paramList.add(0, doctorEmp.getLno());
					i++;
				}else {
					paramList.add(i, doctorEmp.getLno());
					i++;
				}
			}
			if(doctorEmp.getDxl()!=null && doctorEmp.getDxl().length()!=0) {
				set.append("\"Dxl\"=?,");
				if(i == 0) {
					paramList.add(0, doctorEmp.getDxl());
					i++;
				}else {
					paramList.add(i, doctorEmp.getDxl());
					i++;
				}
			}
			if(doctorEmp.getDyear()!=null && doctorEmp.getDyear().length()!=0) {
				set.append("\"Dyear\"=?,");
				if(i == 0) {
					paramList.add(0, doctorEmp.getDyear());
					i++;
				}else {
					paramList.add(i, doctorEmp.getDyear());
					i++;
				}
			}
			if(doctorEmp.getDsalary()!=null && doctorEmp.getDsalary().length()!=0) {
				set.append("\"Dsalary\"=?,");
				if(i == 0) {
					paramList.add(0, doctorEmp.getDsalary());
					i++;
				}else {
					paramList.add(i, doctorEmp.getDsalary());
					i++;
				}
			}
			if(doctorEmp.getDsuperNo()!=null && doctorEmp.getDsuperNo().length()!=0) {
				set.append("\"DsuperNo\"=?,");
				if(i == 0) {
					paramList.add(0, doctorEmp.getDsuperNo());
					i++;
				}else {
					paramList.add(i, doctorEmp.getDsuperNo());
					i++;
				}
			}
			
			String[] params = new String[paramList.size()+1];
			
			for(int k=0; k<paramList.size() ; k++) {
				params[k] = paramList.get(k);
			}
			params[i] = doctorEmp.getDno();
			
			set.deleteCharAt(set.lastIndexOf(","));
			
			String sql = "update \"DocEmp\" set "+ set +" where \"Dno\"=?";
			int j = bd.exeUpdate(sql, params);
			if(j == 0){
				return false;
			}else{
				return true;
			}
		}
	}
}
