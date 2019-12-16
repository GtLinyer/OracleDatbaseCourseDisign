package cn.linyer.gui.patientGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import cn.linyer.dao.impl.PatientSelDoctor;
import cn.linyer.entity.Department;
import cn.linyer.entity.DocInfo;

/**
 * @author Linyer
 * 患者选择医师
 * 
 */
public class PatientSelDoctorGui {
	private JFrame frame = new JFrame("选择就诊医师");
	private JPanel panelNorth = new JPanel();
	private JPanel panelCenter = new JPanel();
	private JLabel label;
	private JPanel panelSelDoc = new JPanel();
	private JPanel panelYesDoc = new JPanel();
	//选择科室
	private JLabel selDepLabel = new JLabel("选择科室：");
	private JComboBox<String> selDep = new JComboBox<String>();
	//选择普通、专家
	private JLabel selDLLabel = new JLabel("医师类型：");
	private JComboBox<String> selDL = new JComboBox<String>();
	//显示信息面板
	private JTextArea showInfo = new JTextArea(18,28);
	private JScrollPane scrollPane = new JScrollPane(showInfo);
	//选择医师
	private JLabel selDocLabel = new JLabel("选择医师（工号）：");
	private JComboBox<String> selDoc = new JComboBox<String>();
	//科室链表
	List<Department> depList;
	//医师链表
	List<DocInfo> docInfoList;
	//确定按钮
	private JButton yesBtn = new JButton("确定就诊");
	//科室编号、名称、位置
	String dpNo = null;
	String dpName = null;
	String dpLocaToNext = null;
	//医师类型、姓名
	int dL = 0;
	String dNameToNext = null;
	//字体颜色
	private Color ftColor = new Color(220, 118, 51);
	private Font fontBig = new Font("华文华文琥珀",Font.BOLD,36);
	private Font fontMid = new Font("华文楷体",Font.PLAIN,24);
	
	public PatientSelDoctorGui(String ptName,String Pno) {
		//欢迎患者
		label = new JLabel("患者：" + ptName + "，欢迎您！");
		//布局
		frame.setLayout(new BorderLayout());
		panelCenter.setLayout(new BorderLayout());
		panelSelDoc.setLayout(new GridLayout(2,2));
		panelYesDoc.setLayout(new GridLayout(1,2));
		//设置字体、颜色
		label.setFont(fontBig);
		label.setForeground(ftColor);
		selDepLabel.setFont(fontMid);
		selDep.setFont(fontMid);
		selDLLabel.setFont(fontMid);
		selDL.setFont(fontMid);
		showInfo.setFont(fontMid);
		selDocLabel.setFont(fontMid);
		selDoc.setFont(fontMid);
		yesBtn.setFont(fontMid);
		
		showInfo.setEditable(false);
		
		//添加模块
		frame.add(panelNorth,BorderLayout.NORTH);
		frame.add(panelCenter,BorderLayout.CENTER);
		frame.add(yesBtn,BorderLayout.SOUTH);
		panelNorth.add(label);
		panelCenter.add(panelSelDoc,BorderLayout.NORTH);
		panelCenter.add(scrollPane,BorderLayout.CENTER);
		panelCenter.add(panelYesDoc,BorderLayout.SOUTH);
		panelSelDoc.add(selDepLabel);
		panelSelDoc.add(selDep);
		panelSelDoc.add(selDLLabel);
		panelSelDoc.add(selDL);
		panelYesDoc.add(selDocLabel);
		panelYesDoc.add(selDoc);
		
		selDep.addItem(null);
		
		selDL.addItem(null);
		selDL.addItem("普通门诊");
		selDL.addItem("专家门诊");
		
		PatientSelDoctor psd = new PatientSelDoctor();
		//先查询出所有科室
		depList = psd.selDep();
		for(int i = 0; i < depList.size(); i ++) {
			dpName = depList.get(i).getDPname();
			selDep.addItem(dpName);
		}
		//选择科室监听器
		class SelDepBox implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				showInfo.setText(null);
				int no = selDep.getSelectedIndex()-1;
				if(no >= 0) {
					Department depInfo = depList.get(no);
					dpLocaToNext = depInfo.getDPloca();
					dpNo = depInfo.getDPno();
					String show = "科室编号：" + depInfo.getDPno() +
								"\n科室名称：" + depInfo.getDPname() +
								"\n科室位置：" + depInfo.getDPloca() +
								"\n科室简介：" + depInfo.getDPbrief();
					selDL.setSelectedIndex(0);
					showInfo.setText(show);
				}else {
					showInfo.setText(null);
				}
			}
		}
		//选择医师类型监听器
		class SelDLBox implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				showInfo.setText(null);
				dL = selDL.getSelectedIndex();
				//判断医师类型是否选择
				if(dL > 0) {
					if(dpNo != null) {
						docInfoList = psd.selDoc(dpNo, dL);
						StringBuffer dovInfoBuffer = new StringBuffer();
						selDoc.removeAllItems();
						selDoc.addItem(null);
						for(int j = 0; j < docInfoList.size(); j ++) {
							selDoc.addItem(docInfoList.get(j).getDno());
							DocInfo aDoc = docInfoList.get(j);
							dovInfoBuffer.append("医师工号：" + aDoc.getDno() +
											   "\n医师姓名：" + aDoc.getDname() +
											   "\n医师性别：" + aDoc.getDsex() +
											   "\n医师邮箱：" + aDoc.getDemail() +
											   "\n医师职称：" + aDoc.getLname() +
											   "\n医师学历：" + aDoc.getDxl() +
											   "\n医师年资：" + aDoc.getDyear() +
											   "\n所属科室：" + aDoc.getDPname() +
											   "\n医师简介：" + aDoc.getDbrief() +
											   "\n=================================\n");
						}
						showInfo.setText(dovInfoBuffer.toString());
					}else {
						showInfo.setText("请先选择科室，再选择医师类型！");
						JOptionPane.showMessageDialog(frame, "请先选择科室，再选择医师类型！","选择顺序错误提示",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		//确定就诊按钮监听器
		class YesButton implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(selDoc.getSelectedIndex() > 0) {
					psd.addDocForPatient((String) selDoc.getSelectedItem(),Pno);
					dNameToNext = docInfoList.get(selDoc.getSelectedIndex()-1).getDname();
					new PatientSeeDoctorGui(dNameToNext,dpLocaToNext,Pno,ptName);
					frame.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(frame, "请选择就诊医师！","未选择医师提示",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		SelDepBox selDepBox = new SelDepBox();
		selDep.addActionListener(selDepBox);
		
		SelDLBox selDLBox = new SelDLBox();
		selDL.addActionListener(selDLBox);
		
		YesButton yesButton = new YesButton();
		yesBtn.addActionListener(yesButton);
		
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
