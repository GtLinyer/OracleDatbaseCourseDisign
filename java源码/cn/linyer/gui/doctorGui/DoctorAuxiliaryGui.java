package cn.linyer.gui.doctorGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.linyer.dao.impl.DoctorWirteTest;
import cn.linyer.entity.Blood;
import cn.linyer.entity.Patient;
import cn.linyer.entity.Stool;
import cn.linyer.entity.Urine;

/**
 * @author Linyer
 * 检验医师填写报告单
 * 
 */
public class DoctorAuxiliaryGui {
	//主体部分定义
	private JFrame frame = new JFrame("检验医师填写检验报告");
	private JPanel panelNorth = new JPanel();
	private JPanel panelWest = new JPanel();
	private JPanel panelCenter = new JPanel();
	private JPanel panelEast = new JPanel();
	private JPanel panelSouth = new JPanel();
	private JPanel panelBlood = new JPanel();
	private JPanel panelUrine = new JPanel();
	private JPanel panelStool = new JPanel();
	//主提示面板
	private JLabel label;
	private JLabel bloodLabel = new JLabel("                   ↑血检结果↑");
	private JLabel urineLabel = new JLabel("                   ↑尿检结果↑");
	private JLabel stoolLabel = new JLabel("                   ↑便检结果↑");
	//血检部分
	private JLabel bRBCLabel = new JLabel("        RBC：");
	private JLabel HCTLabel = new JLabel("        HCT：");
	private JLabel MCVLabel = new JLabel("        MCV：");
	private JLabel HXFLabel = new JLabel("        HXF：");
	private JLabel HGBLabel = new JLabel("        HGB：");
	private JLabel MCHLabel = new JLabel("        MCH：");
	private JLabel MCHCLabel = new JLabel("        MCHC：");
	private JLabel bWBCLabel = new JLabel("        WBC：");
	private JLabel MONO_perLabel = new JLabel("        MONO%：");
	private JLabel NEUTLabel = new JLabel("        NEUT：");
	private JLabel NEUT_perLabel = new JLabel("        NEUT%：");
	private JLabel LYLabel = new JLabel("        LY：");
	private JLabel LY_perLabel = new JLabel("        LY%：");
	private JLabel PLTLabel = new JLabel("        PLT：");
	private JLabel PDWLabel = new JLabel("        PDW：");
	private JLabel MPVLabel = new JLabel("        MPV：");
	private JLabel P_LCRLabel = new JLabel("        P-LCR：");
	private JLabel PCTLabel = new JLabel("        PCT：");
	private JTextField bRBC = new JTextField(8);
	private JTextField HCT = new JTextField(8);
	private JTextField MCV = new JTextField(8);
	private JTextField HXF = new JTextField(8);
	private JTextField HGB = new JTextField(8);
	private JTextField MCH = new JTextField(8);
	private JTextField MCHC = new JTextField(8);
	private JTextField bWBC = new JTextField(8);
	private JTextField MONO_per = new JTextField(8);
	private JTextField NEUT = new JTextField(8);
	private JTextField NEUT_per = new JTextField(8);
	private JTextField LY = new JTextField(8);
	private JTextField LY_per = new JTextField(8);
	private JTextField PLT = new JTextField(8);
	private JTextField PDW = new JTextField(8);
	private JTextField MPV = new JTextField(8);
	private JTextField P_LCR = new JTextField(8);
	private JTextField PCT = new JTextField(8);
	//尿检部分
	private JLabel PHLabel = new JLabel("        PH：");
	private JLabel SGLabel = new JLabel("        SG：");
	private JLabel UROLabel = new JLabel("        URO：");
	private JLabel BLDLabel = new JLabel("        BLD：");
	private JLabel uWBCLabel = new JLabel("        WBC：");
	private JLabel PROLabel = new JLabel("        PRO：");
	private JLabel GLULabel = new JLabel("        GLU：");
	private JLabel BILLabel = new JLabel("        BIL：");
	private JLabel KETLabel = new JLabel("        KET：");
	private JLabel uRBCLabel = new JLabel("        RBC：");
	private JLabel GOLLabel = new JLabel("        GOL：");
	private JTextField PH = new JTextField(8);
	private JTextField SG = new JTextField(8);
	private JTextField URO = new JTextField(8);
	private JTextField BLD = new JTextField(8);
	private JTextField uWBC = new JTextField(8);
	private JTextField PRO = new JTextField(8);
	private JTextField GLU = new JTextField(8);
	private JTextField BIL = new JTextField(8);
	private JTextField KET = new JTextField(8);
	private JTextField uRBC = new JTextField(8);
	private JTextField GOL = new JTextField(8);
	//便检部分
	private JLabel colorLabel = new JLabel("        Color：");
	private JLabel traitsLabel = new JLabel("        Traits：");
	private JLabel sWBCLabel = new JLabel("        WBC：");
	private JLabel phagocyteLabel = new JLabel("        Phagocyte：");
	private JLabel sRBCLabel = new JLabel("        RBC：");
	private JLabel HBLabel = new JLabel("        HB：");
	private JLabel parasiteLabel = new JLabel("        Parasite：");
	private JLabel FGLabel = new JLabel("        FG");
	private JTextField color = new JTextField(8);
	private JTextField traits = new JTextField(8);
	private JTextField sWBC = new JTextField(8);
	private JTextField phagocyte = new JTextField(8);
	private JTextField sRBC = new JTextField(8);
	private JTextField HB = new JTextField(8);
	private JTextField parasite = new JTextField(8);
	private JTextField FG = new JTextField(8);
	//提交按钮
	private JButton yesBlood = new JButton("提交血检结果");
	private JButton yesUrine = new JButton("提交尿检结果");
	private JButton yesStool = new JButton("提交便检结果");
	//下一患者
	private JLabel pNoLabel = new JLabel("患者病历号：");
	private JTextField pNo = new JTextField(8);
	private JButton nextPatient = new JButton("下一患者");
	//颜色字体定义
	private Color ftColor = new Color(220, 118, 51);
	private Color myBlue = new Color(52, 152, 219);
	private Color myPink = new Color(171, 40, 199);

	private Font fontBig = new Font("华文琥珀",Font.BOLD,36);
	private Font fontMid = new Font("华文楷体",Font.PLAIN,24);
	
	public DoctorAuxiliaryGui(String dName,String dNo) {
		//欢迎医师
		label = new JLabel("欢迎您！"  + dName + " 医师");
		//布局
		frame.setLayout(new BorderLayout());
		panelWest.setLayout(new BorderLayout());
		panelCenter.setLayout(new BorderLayout());
		panelEast.setLayout(new BorderLayout());
		panelSouth.setLayout(new BorderLayout());
		panelBlood.setLayout(new GridLayout(18,2));
		panelUrine.setLayout(new GridLayout(11,2));
		panelStool.setLayout(new GridLayout(8,2));
		//设置字体
		label.setFont(fontBig);
		label.setForeground(ftColor);
		bloodLabel.setFont(fontMid);
		bloodLabel.setForeground(myBlue);
		urineLabel.setFont(fontMid);
		urineLabel.setForeground(myBlue);
		stoolLabel.setFont(fontMid);
		stoolLabel.setForeground(myBlue);
		yesBlood.setFont(fontMid);
		yesUrine.setFont(fontMid);
		yesStool.setFont(fontMid);
		pNoLabel.setFont(fontMid);
		pNoLabel.setForeground(myPink);
		pNo.setFont(fontMid);
		nextPatient.setFont(fontMid);
		pNo.setForeground(myPink);
		//血检部分字体
		bRBCLabel.setFont(fontMid);
		HCTLabel.setFont(fontMid);
		MCVLabel.setFont(fontMid);
		HXFLabel.setFont(fontMid);
		HGBLabel.setFont(fontMid);
		MCHLabel.setFont(fontMid);
		MCHCLabel.setFont(fontMid);
		bWBCLabel.setFont(fontMid);
		MONO_perLabel.setFont(fontMid);
		NEUTLabel.setFont(fontMid);
		NEUT_perLabel.setFont(fontMid);
		LYLabel.setFont(fontMid);
		LY_perLabel.setFont(fontMid);
		PLTLabel.setFont(fontMid);
		PDWLabel.setFont(fontMid);
		MPVLabel.setFont(fontMid);
		P_LCRLabel.setFont(fontMid);
		PCTLabel.setFont(fontMid);
		bRBC.setFont(fontMid);
		HCT.setFont(fontMid);
		MCV.setFont(fontMid);
		HXF.setFont(fontMid);
		HGB.setFont(fontMid);
		MCH.setFont(fontMid);
		MCHC.setFont(fontMid);
		bWBC.setFont(fontMid);
		MONO_per.setFont(fontMid);
		NEUT.setFont(fontMid);
		NEUT_per.setFont(fontMid);
		LY.setFont(fontMid);
		LY_per.setFont(fontMid);
		PLT.setFont(fontMid);
		PDW.setFont(fontMid);
		MPV.setFont(fontMid);
		P_LCR.setFont(fontMid);
		PCT.setFont(fontMid);
		//尿检部分字体
		PHLabel.setFont(fontMid);
		SGLabel.setFont(fontMid);
		UROLabel.setFont(fontMid);
		BLDLabel.setFont(fontMid);
		uWBCLabel.setFont(fontMid);
		PROLabel.setFont(fontMid);
		GLULabel.setFont(fontMid);
		BILLabel.setFont(fontMid);
		KETLabel.setFont(fontMid);
		uRBCLabel.setFont(fontMid);
		GOLLabel.setFont(fontMid);
		PH.setFont(fontMid);
		SG.setFont(fontMid);
		URO.setFont(fontMid);
		BLD.setFont(fontMid);
		uWBC.setFont(fontMid);
		PRO.setFont(fontMid);
		GLU.setFont(fontMid);
		BIL.setFont(fontMid);
		KET.setFont(fontMid);
		uRBC.setFont(fontMid);
		GOL.setFont(fontMid);
		//便检部分字体
		colorLabel.setFont(fontMid);
		traitsLabel.setFont(fontMid);
		sWBCLabel.setFont(fontMid);
		phagocyteLabel.setFont(fontMid);
		sRBCLabel.setFont(fontMid);
		HBLabel.setFont(fontMid);
		parasiteLabel.setFont(fontMid);
		FGLabel.setFont(fontMid);
		color.setFont(fontMid);
		traits.setFont(fontMid);
		sWBC.setFont(fontMid);
		phagocyte.setFont(fontMid);
		sRBC.setFont(fontMid);
		HB.setFont(fontMid);
		parasite.setFont(fontMid);
		FG.setFont(fontMid);
		
		pNo.setEnabled(false);
		
		//添加主模块
		frame.add(panelNorth,BorderLayout.NORTH);
		frame.add(panelWest,BorderLayout.WEST);
		frame.add(panelCenter,BorderLayout.CENTER);
		frame.add(panelEast,BorderLayout.EAST);
		frame.add(panelSouth,BorderLayout.SOUTH);
		panelNorth.add(label);
		panelWest.add(panelBlood,BorderLayout.NORTH);
		panelWest.add(bloodLabel,BorderLayout.CENTER);
		panelWest.add(yesBlood,BorderLayout.SOUTH);
		panelCenter.add(panelUrine,BorderLayout.NORTH);
		panelCenter.add(urineLabel,BorderLayout.CENTER);
		panelCenter.add(yesUrine,BorderLayout.SOUTH);
		panelEast.add(panelStool,BorderLayout.NORTH);
		panelEast.add(stoolLabel,BorderLayout.CENTER);
		panelEast.add(yesStool,BorderLayout.SOUTH);
		panelSouth.add(pNoLabel,BorderLayout.WEST);
		panelSouth.add(pNo,BorderLayout.CENTER);
		panelSouth.add(nextPatient,BorderLayout.EAST);
		//添加血检部分
		panelBlood.add(bRBCLabel);
		panelBlood.add(bRBC);
		panelBlood.add(HCTLabel);
		panelBlood.add(HCT);
		panelBlood.add(MCVLabel);
		panelBlood.add(MCV);
		panelBlood.add(HXFLabel);
		panelBlood.add(HXF);
		panelBlood.add(HGBLabel);
		panelBlood.add(HGB);
		panelBlood.add(MCHLabel);
		panelBlood.add(MCH);
		panelBlood.add(MCHCLabel);
		panelBlood.add(MCHC);
		panelBlood.add(bWBCLabel);
		panelBlood.add(bWBC);
		panelBlood.add(MONO_perLabel);
		panelBlood.add(MONO_per);
		panelBlood.add(NEUTLabel);
		panelBlood.add(NEUT);
		panelBlood.add(NEUT_perLabel);
		panelBlood.add(NEUT_per);
		panelBlood.add(LYLabel);
		panelBlood.add(LY);
		panelBlood.add(LY_perLabel);
		panelBlood.add(LY_per);
		panelBlood.add(PLTLabel);
		panelBlood.add(PLT);
		panelBlood.add(PDWLabel);
		panelBlood.add(PDW);
		panelBlood.add(MPVLabel);
		panelBlood.add(MPV);
		panelBlood.add(P_LCRLabel);
		panelBlood.add(P_LCR);
		panelBlood.add(PCTLabel);
		panelBlood.add(PCT);
		//添加尿检部分
		panelUrine.add(PHLabel);
		panelUrine.add(PH);
		panelUrine.add(SGLabel);
		panelUrine.add(SG);
		panelUrine.add(UROLabel);
		panelUrine.add(URO);
		panelUrine.add(BLDLabel);
		panelUrine.add(BLD);
		panelUrine.add(uWBCLabel);
		panelUrine.add(uWBC);
		panelUrine.add(PROLabel);
		panelUrine.add(PRO);
		panelUrine.add(GLULabel);
		panelUrine.add(GLU);
		panelUrine.add(BILLabel);
		panelUrine.add(BIL);
		panelUrine.add(KETLabel);
		panelUrine.add(KET);
		panelUrine.add(uRBCLabel);
		panelUrine.add(uRBC);
		panelUrine.add(GOLLabel);
		panelUrine.add(GOL);
		//添加便检部分
		panelStool.add(colorLabel);
		panelStool.add(color);
		panelStool.add(traitsLabel);
		panelStool.add(traits);
		panelStool.add(sWBCLabel);
		panelStool.add(sWBC);
		panelStool.add(phagocyteLabel);
		panelStool.add(phagocyte);
		panelStool.add(sRBCLabel);
		panelStool.add(sRBC);
		panelStool.add(HBLabel);
		panelStool.add(HB);
		panelStool.add(parasiteLabel);
		panelStool.add(parasite);
		panelStool.add(FGLabel);
		panelStool.add(FG);
		
		DoctorWirteTest dwt = new DoctorWirteTest();
		
		class yesBlood implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Blood blood = new Blood();
				blood.setCPno(dNo);
				blood.setPno(pNo.getText());
				blood.setRBC(bRBC.getText());
				blood.setHCT(HCT.getText());
				blood.setMCV(MCV.getText());
				blood.setHXF(HXF.getText());
				blood.setHGB(HGB.getText());
				blood.setMCH(MCH.getText());
				blood.setMCHC(MCHC.getText());
				blood.setWBC(bWBC.getText());
				blood.setMONO_per(MONO_per.getText());
				blood.setNEUT(NEUT.getText());
				blood.setNEUT_per(NEUT_per.getText());
				blood.setLY(LY.getText());
				blood.setLY_per(LY_per.getText());
				blood.setPLT(PLT.getText());
				blood.setPDW(PDW.getText());
				blood.setMPV(MPV.getText());
				blood.setP_LCR(P_LCR.getText());
				blood.setPCT(PCT.getText());
				if(dwt.addBlood(blood)) {
					JOptionPane.showMessageDialog(frame,"提交血检结果成功！","提交提示",JOptionPane.PLAIN_MESSAGE);
					bRBC.setText(null);
					HCT.setText(null);
					MCV.setText(null);
					HXF.setText(null);
					HGB.setText(null);
					MCH.setText(null);
					MCHC.setText(null);
					bWBC.setText(null);
					MONO_per.setText(null);
					NEUT.setText(null);
					NEUT_per.setText(null);
					LY.setText(null);
					LY_per.setText(null);
					PLT.setText(null);
					PDW.setText(null);
					MPV.setText(null);
					P_LCR.setText(null);
					PCT.setText(null);
					bRBC.setEditable(false);
					HCT.setEditable(false);
					MCV.setEditable(false);
					HXF.setEditable(false);
					HGB.setEditable(false);
					MCH.setEditable(false);
					MCHC.setEditable(false);
					bWBC.setEditable(false);
					MONO_per.setEditable(false);
					NEUT.setEditable(false);
					NEUT_per.setEditable(false);
					LY.setEditable(false);
					LY_per.setEditable(false);
					PLT.setEditable(false);
					PDW.setEditable(false);
					MPV.setEditable(false);
					P_LCR.setEditable(false);
					PCT.setEditable(false);
				}else {
					JOptionPane.showMessageDialog(frame, "提交血检结果失败！请检查数据！","提交提示",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		
		class yesUrine implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Urine urine = new Urine();
				urine.setCPno(dNo);
				urine.setPno(pNo.getText());
				urine.setPH(PH.getText());
				urine.setSG(SG.getText());
				urine.setURO(URO.getText());
				urine.setBLD(BLD.getText());
				urine.setWBC(uWBC.getText());
				urine.setPRO(PRO.getText());
				urine.setGLU(GLU.getText());
				urine.setBIL(BIL.getText());
				urine.setKET(KET.getText());
				urine.setRBC(uRBC.getText());
				urine.setGOL(GOL.getText());
				if(dwt.addUrine(urine)) {
					JOptionPane.showMessageDialog(frame,"提交尿检结果成功！","提交提示",JOptionPane.PLAIN_MESSAGE);
					PH.setText(null);
					SG.setText(null);
					URO.setText(null);
					BLD.setText(null);
					uWBC.setText(null);
					PRO.setText(null);
					GLU.setText(null);
					BIL.setText(null);
					KET.setText(null);
					uRBC.setText(null);
					GOL.setText(null);
					PH.setEditable(false);
					SG.setEditable(false);
					URO.setEditable(false);
					BLD.setEditable(false);
					uWBC.setEditable(false);
					PRO.setEditable(false);
					GLU.setEditable(false);
					BIL.setEditable(false);
					KET.setEditable(false);
					uRBC.setEditable(false);
					GOL.setEditable(false);
				}else {
					JOptionPane.showMessageDialog(frame, "提交尿检结果失败！请检查数据！","提交提示",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		class YesStool implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Stool stool = new Stool();
				stool.setCPno(dNo);
				stool.setPno(pNo.getText());
				stool.setColor(color.getText());
				stool.setTraits(traits.getText());
				stool.setWBC(sWBC.getText());
				stool.setPhagocyte(phagocyte.getText());
				stool.setRBC(sRBC.getText());
				stool.setHB(HB.getText());
				stool.setParasite(parasite.getText());
				stool.setFG(FG.getText());
				if(dwt.addStool(stool)) {
					JOptionPane.showMessageDialog(frame,"提交便检结果成功！","提交提示",JOptionPane.PLAIN_MESSAGE);
					color.setText(null);
					traits.setText(null);
					sWBC.setText(null);
					phagocyte.setText(null);
					sRBC.setText(null);
					HB.setText(null);
					parasite.setText(null);
					FG.setText(null);
					color.setEditable(false);
					traits.setEditable(false);
					sWBC.setEditable(false);
					phagocyte.setEditable(false);
					sRBC.setEditable(false);
					HB.setEditable(false);
					parasite.setEditable(false);
					FG.setEditable(false);
				}else {
					JOptionPane.showMessageDialog(frame, "提交便检结果失败！请检查数据！","提交提示",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		
		//下一患者按钮监听器
		class NextPt implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(dwt.nextPatient() != null) {
					Patient pt = dwt.nextPatient();
					pNo.setText(pt.getPno());
					if(pt.getIsBlood().equals("1")) {
						bRBC.setEditable(true);
						HCT.setEditable(true);
						MCV.setEditable(true);
						HXF.setEditable(true);
						HGB.setEditable(true);
						MCH.setEditable(true);
						MCHC.setEditable(true);
						bWBC.setEditable(true);
						MONO_per.setEditable(true);
						NEUT.setEditable(true);
						NEUT_per.setEditable(true);
						LY.setEditable(true);
						LY_per.setEditable(true);
						PLT.setEditable(true);
						PDW.setEditable(true);
						MPV.setEditable(true);
						P_LCR.setEditable(true);
						PCT.setEditable(true);
					}else {
						bRBC.setEditable(false);
						HCT.setEditable(false);
						MCV.setEditable(false);
						HXF.setEditable(false);
						HGB.setEditable(false);
						MCH.setEditable(false);
						MCHC.setEditable(false);
						bWBC.setEditable(false);
						MONO_per.setEditable(false);
						NEUT.setEditable(false);
						NEUT_per.setEditable(false);
						LY.setEditable(false);
						LY_per.setEditable(false);
						PLT.setEditable(false);
						PDW.setEditable(false);
						MPV.setEditable(false);
						P_LCR.setEditable(false);
						PCT.setEditable(false);
					}
					if(pt.getIsUrine().equals("1")) {
						PH.setEditable(true);
						SG.setEditable(true);
						URO.setEditable(true);
						BLD.setEditable(true);
						uWBC.setEditable(true);
						PRO.setEditable(true);
						GLU.setEditable(true);
						BIL.setEditable(true);
						KET.setEditable(true);
						uRBC.setEditable(true);
						GOL.setEditable(true);
					}else {
						PH.setEditable(false);
						SG.setEditable(false);
						URO.setEditable(false);
						BLD.setEditable(false);
						uWBC.setEditable(false);
						PRO.setEditable(false);
						GLU.setEditable(false);
						BIL.setEditable(false);
						KET.setEditable(false);
						uRBC.setEditable(false);
						GOL.setEditable(false);
					}
					if(pt.getIsStool().equals("1")) {
						color.setEditable(true);
						traits.setEditable(true);
						sWBC.setEditable(true);
						phagocyte.setEditable(true);
						sRBC.setEditable(true);
						HB.setEditable(true);
						parasite.setEditable(true);
						FG.setEditable(true);
					}else {
						color.setEditable(false);
						traits.setEditable(false);
						sWBC.setEditable(false);
						phagocyte.setEditable(false);
						sRBC.setEditable(false);
						HB.setEditable(false);
						parasite.setEditable(false);
						FG.setEditable(false);
					}
				}else {
					JOptionPane.showMessageDialog(frame, "无患者！","患者提示",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		yesBlood yesBloodBtn = new yesBlood();
		yesBlood.addActionListener(yesBloodBtn);
		
		yesUrine yesUrineBtn = new yesUrine();
		yesUrine.addActionListener(yesUrineBtn);
		
		YesStool yesStoolBtn = new YesStool();
		yesStool.addActionListener(yesStoolBtn);
		
		NextPt nextPt = new NextPt();
		nextPatient.addActionListener(nextPt);
		
		frame.setResizable(false);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
