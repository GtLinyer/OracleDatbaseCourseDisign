package cn.linyer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.linyer.entity.Blood;
import cn.linyer.entity.Patient;
import cn.linyer.entity.Stool;
import cn.linyer.entity.Urine;
import cn.linyer.util.BaseDao;

/**
 * @author Linyer
 * 医师查询更新患者治疗情况
 * 
 */
public class DoctorTreatPatient extends BaseDao {
	//检索患者
	public Patient selPatient(String dNo,String pNo) {
		Patient patient = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select \"病历号\",\"患者姓名\",\"患者性别\",\"患者年龄\","
					+ "\"患者联系电话\",\"患者住址\",\"患者入院时间\",\"患者职业\",\"是否需要血检\","
					+ "\"是否需要尿检\",\"是否需要便检\",\"是否已看诊\",\"是否可以出院\" "
					+ "from \"SelPatient\" where \"主治医师\"=? and \"病历号\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dNo);
			pstmt.setString(2, pNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				patient = new Patient();
				patient.setPno(rs.getString("病历号"));
				patient.setPname(rs.getString("患者姓名"));
				patient.setPsex(rs.getString("患者性别"));
				patient.setPage(rs.getString("患者年龄"));
				patient.setPphone(rs.getString("患者联系电话"));
				patient.setPaddress(rs.getString("患者住址"));
				patient.setPEnDate(rs.getString("患者入院时间"));
				patient.setPemployer(rs.getString("患者职业"));
				patient.setIsBlood(rs.getString("是否需要血检"));
				patient.setIsUrine(rs.getString("是否需要尿检"));
				patient.setIsStool(rs.getString("是否需要便检"));
				patient.setIsSee(rs.getString("是否已看诊"));
				patient.setIsOk(rs.getString("是否可以出院"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return patient;
	}
	//下一患者
	int i=0;
	public Patient nextPatient(String Dno) {
		Patient patient = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select \"病历号\",\"患者姓名\",\"患者性别\",\"患者年龄\","
					+ "\"患者联系电话\",\"患者住址\",\"患者入院时间\",\"患者职业\" "
					+ "from \"SelPatient\" where \"主治医师\"=? and \"是否已看诊\"='0' and rownum=1 order by \"患者入院时间\"";
			i++;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Dno);
			rs = pstmt.executeQuery();
			while(rs.next()){
				patient = new Patient();
				patient.setPno(rs.getString("病历号"));
				patient.setPname(rs.getString("患者姓名"));
				patient.setPsex(rs.getString("患者性别"));
				patient.setPage(rs.getString("患者年龄"));
				patient.setPphone(rs.getString("患者联系电话"));
				patient.setPaddress(rs.getString("患者住址"));
				patient.setPEnDate(rs.getString("患者入院时间"));
				patient.setPemployer(rs.getString("患者职业"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return patient;
	}
	//血检开单
	public boolean isBlood(String pNo) {
		BaseDao bd = new BaseDao();
		String[] params = {pNo};
		String sql = "update \"PatientStatus\" set \"isBlood\"='1' where \"Pno\"=?";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			return true;
		}
	}
	//尿检开单
	public boolean isUrine(String pNo) {
		BaseDao bd = new BaseDao();
		String[] params = {pNo};
		String sql = "update \"PatientStatus\" set \"isUrine\"='1' where \"Pno\"=?";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			return true;
		}
	}
	//便检开单
	public boolean isStool(String pNo) {
		BaseDao bd = new BaseDao();
		String[] params = {pNo};
		String sql = "update \"PatientStatus\" set \"isStool\"='1' where \"Pno\"=?";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			return true;
		}
	}
	//出院
	public boolean isOk(String pNo) {
		BaseDao bd = new BaseDao();
		String[] params = {pNo};
		String sql = "update \"PatientStatus\" set \"isOk\"='1' where \"Pno\"=?";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			return true;
		}
	}
	//血检结果
	public Blood selBlood(String no) {
		Blood blood = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from \"Blood\" where \"Pno\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()){
				blood = new Blood();
				blood.setCno(rs.getString("Cno"));
				blood.setPno(rs.getString("Pno"));
				blood.setRBC(rs.getString("RBC"));
				blood.setHCT(rs.getString("HCT"));
				blood.setMCV(rs.getString("MCV"));
				blood.setHXF(rs.getString("HXF"));
				blood.setHGB(rs.getString("HGB"));
				blood.setMCH(rs.getString("MCH"));
				blood.setMCHC(rs.getString("MCHC"));
				blood.setWBC(rs.getString("WBC"));
				blood.setMONO_per(rs.getString("MONO%"));
				blood.setNEUT(rs.getString("NEUT"));
				blood.setNEUT_per(rs.getString("NEUT%"));
				blood.setLY(rs.getString("LY"));
				blood.setLY_per(rs.getString("LY%"));
				blood.setPLT(rs.getString("PLT"));
				blood.setPDW(rs.getString("PDW"));
				blood.setMPV(rs.getString("MPV"));
				blood.setP_LCR(rs.getString("P-LCR"));
				blood.setPCT(rs.getString("PCT"));
				blood.setCPno(rs.getString("CPno"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return blood;
	}
	//尿检结果
	public Urine selUrine(String no) {
		Urine urine = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from \"Urine\" where \"Pno\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()){
				urine = new Urine();
				urine.setCno(rs.getString("Cno"));
				urine.setPno(rs.getString("Pno"));
				urine.setPH(rs.getString("PH"));
				urine.setSG(rs.getString("SG"));
				urine.setURO(rs.getString("URO"));
				urine.setBLD(rs.getString("BLD"));
				urine.setWBC(rs.getString("WBC"));
				urine.setPRO(rs.getString("PRO"));
				urine.setGLU(rs.getString("GLU"));
				urine.setBIL(rs.getString("BIL"));
				urine.setKET(rs.getString("KET"));
				urine.setRBC(rs.getString("RBC"));
				urine.setGOL(rs.getString("GOL"));
				urine.setCPno(rs.getString("CPno"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return urine;
	}
	//便检结果
	public Stool selStool(String no) {
		Stool stool = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from \"Stool\" where \"Pno\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()){
				stool = new Stool();
				stool.setCno(rs.getString("Cno"));
				stool.setPno(rs.getString("Pno"));
				stool.setColor(rs.getString("Color"));
				stool.setTraits(rs.getString("Traits"));
				stool.setWBC(rs.getString("WBC"));
				stool.setPhagocyte(rs.getString("phagocyte"));
				stool.setRBC(rs.getString("RBC"));
				stool.setHB(rs.getString("HB"));
				stool.setParasite(rs.getString("Parasite"));
				stool.setFG(rs.getString("FG"));
				stool.setCPno(rs.getString("CPno"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return stool;
	}
	//查询病情描述
	public String describe(String pNo) {
		String des = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select \"describe\" from \"Treatment\" where \"Pno\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pNo);
			rs = pstmt.executeQuery();
			while(rs.next()){
				des = rs.getString("describe");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return des;
	}
	//查询诊断结果
	public String diagnosis(String pNo) {
		String diag = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select \"diagnosis\" from \"Treatment\" where \"Pno\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pNo);
			rs = pstmt.executeQuery();
			while(rs.next()){
				diag = rs.getString("diagnosis");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return diag;
	}
	//查询治疗方案
	public String treat(String pNo) {
		String treat = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select \"treat\" from \"Treatment\" where \"Pno\"=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pNo);
			rs = pstmt.executeQuery();
			while(rs.next()){
				treat = rs.getString("treat");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return treat;
	}
	//描述提交
	public boolean cmtDescribe(String dNo,String pNo,String des) {
		BaseDao bd = new BaseDao();
		String[] params = {dNo,pNo,des};
		String sql = "insert into \"Treatment\"(\"Dno\",\"Pno\",\"describe\") values(?,?,?)";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			this.cgIsSee(pNo);
			return true;
		}
	}
	//诊断结果提交
	public boolean cmtDiagnosis(String pNo,String diag) {
		BaseDao bd = new BaseDao();
		String[] params = {diag,pNo};
		String sql = "update \"Treatment\" set \"diagnosis\"=? where \"Pno\"=?";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			return true;
		}
	}
	//治疗方案提交
	public boolean cmtTreat(String pNo,String tre) {
		BaseDao bd = new BaseDao();
		String[] params = {tre,pNo};
		String sql = "update \"Treatment\" set \"treat\"=? where \"Pno\"=?";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			return true;
		}
	}
	//已看诊
	public void cgIsSee(String pNo) {
		BaseDao bd = new BaseDao();
		String[] params = {pNo};
		String sql = "update \"PatientStatus\" set \"isSee\"='1' where \"Pno\"=?";
		bd.exeUpdate(sql, params);
	}
}
