package cn.linyer.gui.patientGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import cn.linyer.dao.impl.PatientSeeDoctor;

/**
 * @author Linyer
 * 患者就诊界面
 * 
 */
public class PatientSeeDoctorGui {
	private JFrame frame = new JFrame("患者就诊");
	private JPanel panelCenter = new JPanel();
	private JPanel panelSouth = new JPanel();
	private JPanel paneldiag = new JPanel();
	private JPanel paneltreat = new JPanel();
	private JLabel label;
	//显示就诊信息
	private JLabel dNameLabel;
	private JLabel dpLocaLabel;
	//查询诊断结果
	private JButton diagBtn = new JButton("查看诊断结果");
	private JTextArea diag = new JTextArea(6,12);
	//查询治疗方案
	private JButton treatBtn = new JButton("查看治疗方案");
	private JTextArea treat = new JTextArea(6,12);
	//字体颜色
	private Color ftColor = new Color(220, 118, 51);
	private Color myBlue = new Color(52, 152, 219);
	private Font fontBig = new Font("华文琥珀",Font.BOLD,36);
	private Font fontMid = new Font("华文楷体",Font.PLAIN,24);
	
	public PatientSeeDoctorGui(String dName,String dpLoca,String ptNo,String ptName) {
		//欢迎患者
		label = new JLabel("患者：" + ptName + "，欢迎您！");
		//医师姓名、科室位置
		dNameLabel = new JLabel("您的主治医师为：" + dName + " 医师");
		dpLocaLabel = new JLabel("请到：" + dpLoca + " 就诊");
		//布局
		frame.setLayout(new BorderLayout());
		panelCenter.setLayout(new GridLayout(2,1));
		panelSouth.setLayout(new BorderLayout());
		paneldiag.setLayout(new BorderLayout());
		paneltreat.setLayout(new BorderLayout());
		//设置字体颜色
		label.setForeground(ftColor);
		label.setFont(fontBig);
		dNameLabel.setForeground(myBlue);
		dNameLabel.setFont(fontMid);
		dpLocaLabel.setForeground(myBlue);
		dpLocaLabel.setFont(fontMid);
		diagBtn.setFont(fontMid);
		diag.setFont(fontMid);
		treatBtn.setFont(fontMid);
		treat.setFont(fontMid);
		//添加模块
		frame.add(label,BorderLayout.NORTH);
		frame.add(panelCenter,BorderLayout.CENTER);
		frame.add(panelSouth,BorderLayout.SOUTH);
		panelCenter.add(dNameLabel);
		panelCenter.add(dpLocaLabel);
		panelSouth.add(paneldiag,BorderLayout.NORTH);
		panelSouth.add(paneltreat,BorderLayout.SOUTH);
		paneldiag.add(diagBtn,BorderLayout.NORTH);
		paneldiag.add(diag,BorderLayout.SOUTH);
		paneltreat.add(treatBtn,BorderLayout.NORTH);
		paneltreat.add(treat,BorderLayout.SOUTH);
		
		PatientSeeDoctor psd = new PatientSeeDoctor();
		
		//查询诊断结果按钮监听器
		class DiagMsg implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String diagMsg0 = psd.selDiag(ptNo);
				StringBuffer diagMsg = new StringBuffer();
				if(diagMsg0 != null) {
					for(int i=0; i<diagMsg0.length(); i++) {
						diagMsg.append(diagMsg0.charAt(i));
						if(i%8==0) {
							diagMsg.append("\n");
						}
					}
				}else {
					diagMsg.append("暂无结果！请稍后查询！");
				}
				diag.setText(diagMsg.toString());
			}
		}
		//查询治疗方案按钮监听器
		class TreatMsg implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String treatMsg0 = psd.selDiag(ptNo);
				StringBuffer treatMsg = new StringBuffer();
				if(treatMsg0 != null) {
					for(int i=0; i<treatMsg0.length(); i++) {
						treatMsg.append(treatMsg0.charAt(i));
						if(i%8==0) {
							treatMsg.append("\n");
						}
					}
				}else {
					treatMsg.append("暂无结果！请稍后查询！");
				}
				treat.setText(treatMsg.toString());
			}
			
		}
		
		DiagMsg diagMsg = new DiagMsg();
		diagBtn.addActionListener(diagMsg);
		
		TreatMsg treatMsg = new TreatMsg();
		treatBtn.addActionListener(treatMsg);
		
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
