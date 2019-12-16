package cn.linyer.gui.doctorGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.linyer.dao.impl.DoctorTreatPatient;
import cn.linyer.entity.Blood;
import cn.linyer.entity.Patient;
import cn.linyer.entity.Stool;
import cn.linyer.entity.Urine;

/**
 * @author Linyer
 * 医师使用界面
 * 
 */
public class DoctorClinicalGui {
	private JFrame frame = new JFrame("医师");
	private JPanel panel = new JPanel();
	private JLabel label;
	//患者信息面板
	private JPanel panelPInfo = new JPanel();
	//选择患者面板
	private JPanel panelPSel = new JPanel();
	//检索患着
	private JLabel selPLabel = new JLabel("检索患者：");
	private JTextField selPField = new JTextField(8);
	private JButton selBtn = new JButton("检索患者");
	//下一个患着
	private JLabel pLabel = new JLabel("病历号：");
	private JTextField pField = new JTextField(8);
	private JButton nextPBtn = new JButton("下一患者");
	//患者信息
	private JTextArea pArea = new JTextArea(10,2);
	//开具检查单面板
	private JPanel panelStatus = new JPanel();
	private JLabel isBloodLabel = new JLabel("血检开单：");
	private JCheckBox isBlood = new JCheckBox();
	private JLabel isUrineLabel = new JLabel("尿检开单：");
	private JCheckBox isUrine = new JCheckBox();
	private JLabel isStoolLabel = new JLabel("便检开单：");
	private JCheckBox isStool = new JCheckBox();
	private JLabel isOkLabel = new JLabel("能否出院：");
	private JCheckBox isOk = new JCheckBox();
	//看病面板
	private JPanel panelTreat = new JPanel();
	//检查结果
	private JPanel panelCheck = new JPanel();
	private JLabel checkLabel = new JLabel("检查结果：");
	private JPanel panelCheckArea = new JPanel();
	private JTextArea checkBloodArea = new JTextArea(6,2);
	private JTextArea checkUrineArea = new JTextArea(6,2);
	private JTextArea checkStoolArea = new JTextArea(6,2);
	private JButton checkBtn = new JButton("查看检查结果");
	//诊疗面板
	private JPanel panelDDT = new JPanel();
	//病情描述
	private JPanel panelDescribe = new JPanel();
	private JLabel describeLabel = new JLabel("病情描述：");
	private JTextArea describeArea = new JTextArea(4,2);
	private JButton yesDescribeBtn = new JButton("提交病情描述");
	//诊断结果
	private JPanel panelDiag = new JPanel();
	private JLabel diagLabel = new JLabel("诊断结果：");
	private JTextArea diagArea = new JTextArea(4,2);
	private JButton yesDiagBtn = new JButton("提交诊断结果");
	//治疗方案
	private JPanel panelTreatment = new JPanel();
	private JLabel treatmentLabel = new JLabel("治疗方案：");
	private JTextArea treatmentArea = new JTextArea(4,2);
	private JButton yesTreatmentBtn = new JButton("提交治疗方案");
	//颜色字体定义
	private Color myBlue = new Color(52, 152, 219);
	private Color myPink = new Color(171, 40, 199);
	
	private Font fontMid = new Font("华文楷体",Font.PLAIN,24);
	
	private String nowPatientNo = null;
	
	public DoctorClinicalGui(String dtName,String dtNo) {
		//欢迎医师
		label = new JLabel("医师：" + dtName + "，欢迎您！");
		//布局
		frame.setLayout(new BorderLayout());
		panelPInfo.setLayout(new BorderLayout());
		panelPSel.setLayout(new GridLayout(2,3));
		panelTreat.setLayout(new BorderLayout());
		panelCheck.setLayout(new BorderLayout());
		panelCheckArea.setLayout(new GridLayout(1,3));
		panelDDT.setLayout(new BorderLayout());
		panelDescribe.setLayout(new GridLayout(1,3));
		panelDiag.setLayout(new GridLayout(1,3));
		panelTreatment.setLayout(new GridLayout(1,3));
		//设置字体、颜色
		label.setFont(new Font("华文琥珀",Font.PLAIN,36));
		label.setForeground(new Color(220, 118, 51));
		selPLabel.setFont(fontMid);
		selPField.setFont(fontMid);
		selBtn.setFont(fontMid);
		pLabel.setFont(fontMid);
		pLabel.setForeground(myPink);
		pField.setFont(fontMid);
		nextPBtn.setFont(fontMid);
		pArea.setFont(fontMid);
		isBloodLabel.setFont(fontMid);
		isBlood.setFont(fontMid);
		isUrineLabel.setFont(fontMid);
		isUrine.setFont(fontMid);
		isStoolLabel.setFont(fontMid);
		isStool.setFont(fontMid);
		isOkLabel.setFont(fontMid);
		isOk.setFont(fontMid);
		checkLabel.setFont(fontMid);
		checkLabel.setForeground(myBlue);
		checkBloodArea.setFont(fontMid);
		checkUrineArea.setFont(fontMid);
		checkStoolArea.setFont(fontMid);
		checkBtn.setFont(fontMid);
		describeLabel.setFont(fontMid);
		describeArea.setFont(fontMid);
		diagLabel.setFont(fontMid);
		diagArea.setFont(fontMid);
		treatmentLabel.setFont(fontMid);
		treatmentArea.setFont(fontMid);
		yesDescribeBtn.setFont(fontMid);
		yesDiagBtn.setFont(fontMid);
		yesTreatmentBtn.setFont(fontMid);
		//设置文本域不可编辑
		pField.setEditable(false);
		pArea.setEditable(false);
		checkBloodArea.setEditable(false);
		checkUrineArea.setEditable(false);
		checkStoolArea.setEditable(false);
		
		//添加模块
		frame.add(panel,BorderLayout.NORTH);
		frame.add(panelPInfo,BorderLayout.CENTER);
		frame.add(panelTreat,BorderLayout.SOUTH);
		panel.add(label);
		panelPInfo.add(panelPSel,BorderLayout.NORTH);
		panelPInfo.add(pArea,BorderLayout.CENTER);
		panelTreat.add(panelStatus,BorderLayout.NORTH);
		panelTreat.add(panelCheck,BorderLayout.CENTER);
		panelTreat.add(panelDDT,BorderLayout.SOUTH);
		panelCheck.add(checkLabel,BorderLayout.NORTH);
		
		panelCheck.add(panelCheckArea,BorderLayout.CENTER);
		panelCheck.add(checkBtn,BorderLayout.SOUTH);
		panelDDT.add(panelDescribe,BorderLayout.NORTH);
		panelDDT.add(panelDiag,BorderLayout.CENTER);
		panelDDT.add(panelTreatment,BorderLayout.SOUTH);
		//选择患者
		panelPSel.add(selPLabel);
		panelPSel.add(selPField);
		panelPSel.add(selBtn);
		//下一个患者
		panelPSel.add(pLabel);
		panelPSel.add(pField);
		panelPSel.add(nextPBtn);
		//开具检查单
		panelStatus.add(isBloodLabel);
		panelStatus.add(isBlood);
		panelStatus.add(isUrineLabel);
		panelStatus.add(isUrine);
		panelStatus.add(isStoolLabel);
		panelStatus.add(isStool);
		panelStatus.add(isOkLabel);
		panelStatus.add(isOk);
		//检查结果
		panelCheckArea.add(checkBloodArea);
		panelCheckArea.add(checkUrineArea);
		panelCheckArea.add(checkStoolArea);
		//病情描述
		panelDescribe.add(describeLabel);
		panelDescribe.add(describeArea);
		panelDescribe.add(yesDescribeBtn);
		//诊断结果
		panelDiag.add(diagLabel);
		panelDiag.add(diagArea);
		panelDiag.add(yesDiagBtn);
		//治疗方案
		panelTreatment.add(treatmentLabel);
		panelTreatment.add(treatmentArea);
		panelTreatment.add(yesTreatmentBtn);
		
		DoctorTreatPatient dtp = new DoctorTreatPatient();
		//选择患者按钮监听器
		class SelButton implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				nowPatientNo = null;
				String pno = selPField.getText();
				if(pno.length()!=0) {
					Patient patient = dtp.selPatient(dtNo,pno);
					String des = dtp.describe(pno);
					String diag = dtp.diagnosis(pno);
					String tre = dtp.treat(pno);
					if(patient != null) {
						nowPatientNo = patient.getPno();
						String txt = "病历号：" + patient.getPno()
								 +"\n患者姓名：" + patient.getPname()
								 +"\n患者性别：" + patient.getPsex()
								 +"\n患者年龄：" + patient.getPage()
								 +"\n患者联系电话：" + patient.getPphone()
								 +"\n患者住址：" + patient.getPaddress()
								 +"\n患者入院时间：" + patient.getPEnDate()
								 +"\n患者职业：" + patient.getPemployer()
								 +"\n是否已看诊：" + patient.getIsSee();
						pArea.setText(txt);
						if(patient.getIsBlood().equals("0")) {
							isBlood.setSelected(false);
							isBlood.setEnabled(true);
						}else {
							isBlood.setSelected(true);
							isBlood.setEnabled(false);
						}
						if(patient.getIsUrine().equals("0")) {
							isUrine.setSelected(false);
							isUrine.setEnabled(true);
						}else {
							isUrine.setSelected(true);
							isUrine.setEnabled(false);
						}
						if(patient.getIsStool().equals("0")) {
							isStool.setSelected(false);
							isStool.setEnabled(true);
						}else {
							isStool.setSelected(true);
							isStool.setEnabled(false);
						}
						if(patient.getIsOk().equals("0")) {
							describeArea.setEditable(true);
							diagArea.setEditable(true);
							treatmentArea.setEditable(true);
						}else {
							describeArea.setEditable(false);
							diagArea.setEditable(false);
							treatmentArea.setEditable(false);
						}
						if(des!=null) {
							describeArea.setText(des);
							describeArea.setEditable(false);
							yesDescribeBtn.setEnabled(false);
						}else {
							describeArea.setEditable(true);
							yesDescribeBtn.setEnabled(true);
						}
						if(diag!=null) {
							diagArea.setText(diag);
							diagArea.setEditable(false);
							yesDiagBtn.setEnabled(false);
						}else {
							diagArea.setEditable(true);
							yesDiagBtn.setEnabled(true);
						}
						if(tre!=null) {
							treatmentArea.setText(tre);
							treatmentArea.setEditable(false);
							yesTreatmentBtn.setEnabled(false);
						}else {
							treatmentArea.setEditable(true);
							yesTreatmentBtn.setEnabled(true);
						}
					}else {
						JOptionPane.showMessageDialog(frame, "无此患者，或者此患者不是您的病人！","检索患者提示",JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(frame, "请输入患者病历号！","检索患者提示",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		//下一患者按钮监听器
		class NextPButton implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				nowPatientNo = null;
				Patient patient = dtp.nextPatient(dtNo);
				if(patient != null) {
					nowPatientNo = patient.getPno();
					String txt = "病历号：" + patient.getPno()
							 + "\n患者姓名：" + patient.getPname()
							 + "\n患者性别：" + patient.getPsex()
							 + "\n患者年龄：" + patient.getPage()
							 + "\n患者联系电话：" + patient.getPphone()
							 + "\n患者住址：" + patient.getPaddress()
							 + "\n患者入院时间：" + patient.getPEnDate()
							 + "\n患者职业：" + patient.getPemployer();
					pArea.setText(txt);
					isBlood.setEnabled(true);
					isBlood.setSelected(false);
					isUrine.setEnabled(true);
					isUrine.setSelected(false);
					isStool.setEnabled(true);
					isStool.setSelected(false);
					describeArea.setEditable(true);
					yesDescribeBtn.setEnabled(true);
					diagArea.setEditable(true);
					yesDiagBtn.setEnabled(true);
					treatmentArea.setEditable(true);
					yesTreatmentBtn.setEnabled(true);
				}else {
					JOptionPane.showMessageDialog(frame, "没有患者了！","下一患者患者提示",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		//开血检
		class IsBlood implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(isBlood.isSelected()) {
					if(nowPatientNo!=null) {
						dtp.isBlood(nowPatientNo);
						isBlood.setEnabled(false);
					}else {
						JOptionPane.showMessageDialog(frame, "无患者信息！","错误提示",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		//开尿检
		class IsUrine implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(isUrine.isSelected()) {
					if(nowPatientNo!=null) {
						dtp.isUrine(nowPatientNo);
						isUrine.setEnabled(false);
					}else {
						JOptionPane.showMessageDialog(frame, "无患者信息！","错误提示",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		//开便检
		class IsStool implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(isStool.isSelected()) {
					if(nowPatientNo!=null) {
						dtp.isStool(nowPatientNo);
						isStool.setEnabled(false);
					}else {
						JOptionPane.showMessageDialog(frame, "无患者信息！","错误提示",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		//可否出院
		class IsOk implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(isOk.isSelected()) {
					if(nowPatientNo!=null) {
						dtp.isOk(nowPatientNo);
						isOk.setEnabled(false);
					}else {
						JOptionPane.showMessageDialog(frame, "无患者信息！","错误提示",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		//检查结果按钮监听器
		class CheckBtn implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Blood blood = dtp.selBlood(nowPatientNo);
				Urine urine = dtp.selUrine(nowPatientNo);
				Stool stool = dtp.selStool(nowPatientNo);
				if(blood != null) {
					String bloodTxt = "检查号：" + blood.getCno()
								  + "\n病历号：" + blood.getPno()
								  + "\nRBC：" + blood.getRBC()
								  + "\nHCT：" + blood.getHCT()
								  + "\nMCV：" + blood.getMCV()
								  + "\nHXF：" + blood.getHXF()
								  + "\nHGB：" + blood.getHGB()
								  + "\nMCH：" + blood.getMCH()
								  + "\nMCHC：" + blood.getMCHC()
								  + "\nWBC：" + blood.getWBC()
								  + "\nMONO%：" + blood.getMONO_per()
								  + "\nNEUT：" + blood.getNEUT()
								  + "\nNEUT%：" + blood.getNEUT_per()
								  + "\nLY：" + blood.getLY()
								  + "\nLY%：" + blood.getLY_per()
								  + "\nPLT：" + blood.getPLT()
								  + "\nPDW：" + blood.getPDW()
								  + "\nMPV：" + blood.getMPV()
								  + "\nP-LCR：" + blood.getP_LCR()
								  + "\nPCT：" + blood.getPCT()
								  + "\n检验医师工号：" + blood.getCPno();
					checkBloodArea.setText(bloodTxt);
				}else {
					checkBloodArea.setText("暂无结果！");
				}
				if(urine != null) {
					String urineTxt = "检查号：" + urine.getCno()
								  + "\n病历号：" + urine.getPno()
								  + "\nPH：" + urine.getPH()
								  + "\nSG：" + urine.getSG()
								  + "\nURO：" + urine.getURO()
								  + "\nBLD：" + urine.getBLD()
								  + "\nWBC：" + urine.getWBC()
								  + "\nPRO：" + urine.getPRO()
								  + "\nGLU：" + urine.getGLU()
								  + "\nBIL：" + urine.getBIL()
								  + "\nKET：" + urine.getKET()
								  + "\nRBC：" + urine.getRBC()
								  + "\nGOL：" + urine.getGOL()
								  + "\n检验医师工号：" + urine.getCPno();
					checkUrineArea.setText(urineTxt);
				}else {
					checkUrineArea.setText("暂无结果！");
				}
				if(stool != null) {
					String stoolTxt = "检查号：" + stool.getCno()
					  			  + "\n病历号：" + stool.getPno()
					  			  + "\nColor：" + stool.getColor()
					  			  + "\nTraits：" + stool.getTraits()
					  			  + "\nWBC：" + stool.getWBC()
					  			  + "\nphagocyte：" + stool.getPhagocyte()
					  			  + "\nRBC：" + stool.getRBC()
					  			  + "\nHB：" + stool.getHB()
					  			  + "\nParasite：" + stool.getParasite()
					  			  + "\nFG：" + stool.getFG()
					  			  + "\n检验医师工号：" + stool.getCPno();
					checkStoolArea.setText(stoolTxt);
				}else {
					checkStoolArea.setText("暂无结果！");
				}
			}
		}
		//确定提交病情描述按钮监听器
		class YesDescribeButton implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String des = describeArea.getText();
				if(dtp.cmtDescribe(dtNo, nowPatientNo, des)) {
					JOptionPane.showMessageDialog(frame,"提交成功！","提交提示",JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(frame, "提交失败！","提交提示",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		//确定提交诊断结果按钮监听器
		class YesDiagButton implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String diagnosis = diagArea.getText();
				if(dtp.cmtDiagnosis(nowPatientNo, diagnosis)) {
					JOptionPane.showMessageDialog(frame,"提交成功！","提交提示",JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(frame, "提交失败！","提交提示",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		//确定提交治疗方案按钮监听器
		class YesTreatmentButton implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String tre = treatmentArea.getText();
				if(dtp.cmtTreat(nowPatientNo, tre)) {
					JOptionPane.showMessageDialog(frame,"提交成功！","提交提示",JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(frame, "提交失败！","提交提示",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		SelButton selButton = new SelButton();
		selBtn.addActionListener(selButton);
		
		NextPButton nextPButton = new NextPButton();
		nextPBtn.addActionListener(nextPButton);
		
		IsBlood isBloodBox = new IsBlood();
		isBlood.addActionListener(isBloodBox);
		
		IsUrine isUrineBox = new IsUrine();
		isUrine.addActionListener(isUrineBox);
		
		IsStool isStoolBox = new IsStool();
		isStool.addActionListener(isStoolBox);
		
		IsOk isOkBox = new IsOk();
		isOk.addActionListener(isOkBox);
		
		CheckBtn checkButton = new CheckBtn();
		checkBtn.addActionListener(checkButton);
		
		YesDescribeButton yesDescribeButton = new YesDescribeButton();
		yesDescribeBtn.addActionListener(yesDescribeButton);
		
		YesDiagButton yesDiagButton = new YesDiagButton();
		yesDiagBtn.addActionListener(yesDiagButton);
		
		YesTreatmentButton yesTreatmentButton = new YesTreatmentButton();
		yesTreatmentBtn.addActionListener(yesTreatmentButton);
		
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
