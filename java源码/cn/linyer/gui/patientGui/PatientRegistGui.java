package cn.linyer.gui.patientGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.linyer.dao.impl.PatientRegist;
import cn.linyer.entity.Patient;
import cn.linyer.gui.LoginGui;

/**
 * @author Linyer
 * 患者注册界面
 * 
 */
public class PatientRegistGui {
	//主面板
	private JFrame frame = new JFrame("患者注册");
	private JPanel panelNorth = new JPanel();
	private JPanel panelCenter = new JPanel();
	
	private JLabel label = new JLabel("患者注册");
	//输入患者信息
	private JLabel pNameLabel = new JLabel("姓名：");
	private JTextField pName = new JTextField(8);
	private JLabel pSexLabel = new JLabel("性别：");
	private JComboBox<String> pSex = new JComboBox<String>();
	private JLabel pAgeLabel = new JLabel("年龄：");
	private JTextField pAge = new JTextField(2);
	private JLabel pPhoneLabel = new JLabel("联系电话：");
	private JTextField pPhone = new JTextField(11);
	private JLabel pAddressLabel = new JLabel("住址：");
	private JTextField pAddress = new JTextField(300);
	private JLabel pEmpLabel = new JLabel("职业：");
	private JTextField pEmp = new JTextField(60);
	private JLabel pIDnoLabel = new JLabel("身份证号：");
	private JTextField pIDno = new JTextField(18);
	private JLabel pPwdLabel = new JLabel("密码：");
	private JPasswordField pPwd = new JPasswordField(12);
	private JLabel pYesPwdLabel = new JLabel("确认密码：");
	private JPasswordField pYesPwd = new JPasswordField(12);
	
	private JButton yesBtn = new JButton("确定注册");
	//字体定义
	private Font fontMid = new Font("华文楷体",Font.PLAIN,24);
	
	public PatientRegistGui() {
		//布局
		frame.setLayout(new BorderLayout());
		panelCenter.setLayout(new GridLayout(9,2));
		//设置字体、颜色
		label.setFont(new Font("华文琥珀",Font.PLAIN,36));
		label.setForeground(new Color(220, 118, 51));
		yesBtn.setFont(fontMid);
		pNameLabel.setFont(fontMid);
		pName.setFont(fontMid);
		pSexLabel.setFont(fontMid);
		pSex.setFont(fontMid);
		pAgeLabel.setFont(fontMid);
		pAge.setFont(fontMid);
		pPhoneLabel.setFont(fontMid);
		pPhone.setFont(fontMid);
		pAddressLabel.setFont(fontMid);
		pAddress.setFont(fontMid);
		pEmpLabel.setFont(fontMid);
		pEmp.setFont(fontMid);
		pIDnoLabel.setFont(fontMid);
		pIDno.setFont(fontMid);
		pPwdLabel.setFont(fontMid);
		pPwd.setFont(fontMid);
		pYesPwdLabel.setFont(fontMid);
		pYesPwd.setFont(fontMid);
		//添加模块
		frame.add(panelNorth,BorderLayout.NORTH);
		frame.add(panelCenter,BorderLayout.CENTER);
		frame.add(yesBtn,BorderLayout.SOUTH);
		panelNorth.add(label);
		panelCenter.add(pNameLabel);
		panelCenter.add(pName);
		panelCenter.add(pSexLabel);
		panelCenter.add(pSex);
		panelCenter.add(pAgeLabel);
		panelCenter.add(pAge);
		panelCenter.add(pPhoneLabel);
		panelCenter.add(pPhone);
		panelCenter.add(pAddressLabel);
		panelCenter.add(pAddress);
		panelCenter.add(pEmpLabel);
		panelCenter.add(pEmp);
		panelCenter.add(pIDnoLabel);
		panelCenter.add(pIDno);
		panelCenter.add(pPwdLabel);
		panelCenter.add(pPwd);
		panelCenter.add(pYesPwdLabel);
		panelCenter.add(pYesPwd);
		
		pSex.addItem(null);
		pSex.addItem("男");
		pSex.addItem("女");
		//确定注册按钮监听器
		class YesBtn implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Patient patient = new Patient();
				patient.setPname(pName.getText());
				patient.setPsex((String)pSex.getSelectedItem());
				patient.setPage(pAge.getText());
				patient.setPphone(pPhone.getText());
				patient.setPaddress(pAddress.getText());
				patient.setPemployer(pEmp.getText());
				patient.setPIDno(pIDno.getText());
				String patientPwd = String.valueOf(pPwd.getPassword());
				String yesPwd = String.valueOf(pYesPwd.getPassword());
				if(patient != null && patientPwd.length() != 0 && yesPwd.length() != 0) {
					if(patientPwd.equals(yesPwd)) {
						patient.setPpwd(yesPwd);
						PatientRegist pr = new PatientRegist();
						String selPno = pr.selPatient(patient.getPIDno());
						if(selPno==null) {
							if(pr.addPatient(patient)) {
								JOptionPane.showMessageDialog(frame,patient.getPname() + "，欢迎您！\n您已注册成功！您的病历号为：" + pr.selPatient(patient.getPIDno()) + "！\n请登录 ","注册成功提示",JOptionPane.PLAIN_MESSAGE);
								LoginGui.frame.setVisible(true);
								frame.setVisible(false);
							}else {
								JOptionPane.showMessageDialog(frame, "注册失败！信息可能有误！请重试！","注册失败提示",JOptionPane.ERROR_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(frame, "您的身份证号已注册！\n您的身份证号为：" + patient.getPIDno() + "\n您的病历号为：" + selPno,"已注册提示",JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(frame, "您两次输入的密码不一致！请重新输入！","密码不一致提示",JOptionPane.ERROR_MESSAGE);
						pPwd.setText(null);
						pYesPwd.setText(null);
					}
				}else {
					JOptionPane.showMessageDialog(frame, "请输入您的注册信息！","输入错误提示",JOptionPane.ERROR_MESSAGE);
				}
			}			
		}
		
		YesBtn yes = new YesBtn();
		yesBtn.addActionListener(yes);
		
		frame.setSize(400, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
