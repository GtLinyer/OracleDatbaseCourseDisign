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
 * 检验医师提交检验报告
 * 
 */
public class DoctorWirteTest extends BaseDao {
	//添加血检结果
	public boolean addBlood(Blood blood) {
		BaseDao bd = new BaseDao();
		String[] params = {blood.getPno(),blood.getCPno(),blood.getRBC(),blood.getHCT(),
				blood.getMCV(),blood.getHXF(),blood.getHGB(),blood.getMCH(),
				blood.getMCHC(),blood.getWBC(),blood.getMONO_per(),blood.getNEUT(),
				blood.getNEUT_per(),blood.getLY(),blood.getLY_per(),blood.getPLT(),
				blood.getPDW(),blood.getMPV(),blood.getP_LCR(),blood.getPCT()};
		String sql = "insert into \"Blood\"(\"Cno\",\"Pno\",\"CPno\",\"RBC\",\"HCT\",\"MCV\","
				+ "\"HXF\",\"HGB\",\"MCH\",\"MCHC\",\"WBC\",\"MONO%\",\"NEUT\",\"NEUT%\","
				+ "\"LY\",\"LY%\",\"PLT\",\"PDW\",\"MPV\",\"P-LCR\",\"PCT\") "
				+ "values(BCNO_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			this.isCheck(blood.getPno(), "isBlood");
			return true;
		}
	}
	//添加尿检结果
	public boolean addUrine(Urine urine) {
		BaseDao bd = new BaseDao();
		String[] params = {urine.getPno(),urine.getCPno(),urine.getPH(),urine.getSG(),
				urine.getURO(),urine.getBLD(),urine.getWBC(),urine.getPRO(),urine.getGLU(),
				urine.getBIL(),urine.getKET(),urine.getRBC(),urine.getGOL()};
		String sql = "insert into \"Urine\"(\"Cno\",\"Pno\",\"CPno\",\"PH\",\"SG\",\"URO\","
				+ "\"BLD\",\"WBC\",\"PRO\",\"GLU\",\"BIL\",\"KET\",\"RBC\",\"GOL\") "
				+ "values(UCNO_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			this.isCheck(urine.getPno(), "isUrine");
			return true;
		}
	}
	//添加便检结果
	public boolean addStool(Stool stool) {
		BaseDao bd = new BaseDao();
		String[] params = {stool.getPno(),stool.getCPno(),stool.getColor(),
				stool.getTraits(),stool.getWBC(),stool.getPhagocyte(),
				stool.getRBC(),stool.getHB(),stool.getParasite(),stool.getFG()};
		String sql = "insert into \"Stool\"(\"Cno\",\"Pno\",\"CPno\",\"Color\",\"Traits\","
				+ "\"WBC\",\"Phagocyte\",\"RBC\",\"HB\",\"Parasite\",\"FG\") "
				+ "values(UCNO_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
		int i = bd.exeUpdate(sql, params);
		if(i == 0){
			return false;
		}else{
			this.isCheck(stool.getPno(), "isStool");
			return true;
		}
	}
	//下一个患者
	public Patient nextPatient() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Patient pt = null;
		
		try {
			String sql = "select \"病历号\",\"是否需要血检\",\"是否需要尿检\",\"是否需要便检\" "
					+ "from \"SelPatient\" "
					+ "where (\"是否需要血检\"='1' or \"是否需要尿检\"='1' or \"是否需要便检\"='1') "
					+ "and rownum=1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				pt = new Patient();
				pt.setPno(rs.getString("病历号"));
				pt.setIsBlood(rs.getString("是否需要血检"));
				pt.setIsUrine(rs.getString("是否需要尿检"));
				pt.setIsStool(rs.getString("是否需要便检"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return pt;
	}
	//设置完成检验
	public void isCheck(String pNo,String check) {
		BaseDao bd = new BaseDao();
		String[] params = {pNo};
		String sql = "update \"PatientStatus\" set \""+ check +"\"='2' where \"Pno\"=?";
		bd.exeUpdate(sql, params);
	}
}
