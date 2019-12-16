package cn.linyer.gui;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.linyer.controller.Login;
import cn.linyer.gui.adminGui.AdminGui;
import cn.linyer.gui.doctorGui.DoctorAuxiliaryGui;
import cn.linyer.gui.doctorGui.DoctorClinicalGui;
import cn.linyer.gui.patientGui.PatientSelDoctorGui;
import cn.linyer.gui.patientGui.PatientRegistGui;

/**
 * @author Linyer
 * 登录界面
 * 
 */
public class LoginGui {
	public static JFrame frame;
	private JPanel panelNorth = new JPanel();
	private JPanel panelWest = new JPanel();
	private JPanel panelCenter = new JPanel();
	private JPanel panelSouth = new JPanel();
	private JLabel label;
	private JLabel noLabel;
	private JTextField no = new JTextField(8);
	private JLabel pwdLabel = new JLabel("密码：");
	private JPasswordField pwd = new JPasswordField(12);
	private JButton login = new JButton("登录");
	private JButton regist = new JButton("注册");
	private Font fontMid = new Font("华文楷体",Font.PLAIN,24);
	Login loginMsg = new Login();
	
	public LoginGui(String type) {
		//不同用户界面
		frame = new JFrame("登录");
		label = new JLabel(type + "登录");
		if(type.equals("患者")) {
			noLabel = new JLabel("患者病历号：");
		}else if(type.equals("医师")) {
			noLabel = new JLabel("医师工号：");
		}else if(type.equals("管理员")) {
			noLabel = new JLabel("管理员编号：");
		}
		//布局
		frame.setLayout(new BorderLayout());
		panelWest.setLayout(new GridLayout(2,1));
		panelCenter.setLayout(new GridLayout(2,1));
		//设置组件的字体、颜色
		label.setFont(new Font("华文楷体",Font.BOLD,36));
		label.setForeground(new Color(220, 118, 51));
		noLabel.setFont(fontMid);
		pwdLabel.setFont(fontMid);
		no.setFont(fontMid);
		pwd.setFont(fontMid);
		login.setFont(fontMid);
		regist.setFont(fontMid);
		//添加各个组件
		frame.add(panelNorth,BorderLayout.NORTH);
		frame.add(panelWest,BorderLayout.WEST);
		frame.add(panelCenter,BorderLayout.CENTER);
		frame.add(panelSouth,BorderLayout.SOUTH);
		panelNorth.add(label);
		panelWest.add(noLabel);
		panelWest.add(pwdLabel);
		panelCenter.add(no);
		panelCenter.add(pwd);
		panelSouth.add(login);
		if(type.equals("患者")) {
			panelSouth.add(regist);
		}
		//登录按钮监听器
		class LoginButton implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				//获取用户编号、密码
				String userNo = no.getText();
				String userPwd = String.valueOf(pwd.getPassword());
				
				if(userNo.equals("") || userNo.length()==0 || userNo.indexOf(" ")!=-1) {
					loginMsg.setUserNo("error");
				} else {
					loginMsg.setUserNo(userNo);
				}
				
				if(userPwd.equals("") || userPwd.length()==0 || userPwd.indexOf(" ")!=-1) {
					loginMsg.setUserPwd("error");
				} else {
					loginMsg.setUserPwd(userPwd);
				}
				//判断是否登录成功
				if(type.equals("患者")) {
					if(loginMsg.selectPatient()) {
						JOptionPane.showMessageDialog(frame, "登录成功！","登陆提示",JOptionPane.PLAIN_MESSAGE);
						new PatientSelDoctorGui(loginMsg.getUserName(),loginMsg.getUserNo());
						frame.setVisible(false);
					}else {
						JOptionPane.showMessageDialog(frame, "登录失败！请重试！","登陆提示",JOptionPane.ERROR_MESSAGE);
					}
				}else if(type.equals("医师")) {
					if(loginMsg.selectDoctor()) {
						JOptionPane.showMessageDialog(frame, "登录成功！","登陆提示",JOptionPane.PLAIN_MESSAGE);
						if(loginMsg.getIsClinical().equals("1")) {
							new DoctorClinicalGui(loginMsg.getUserName(),loginMsg.getUserNo());
						}else {
							new DoctorAuxiliaryGui(loginMsg.getUserName(),loginMsg.getUserNo());
						}
						frame.setVisible(false);
					}else {
						JOptionPane.showMessageDialog(frame, "登录失败！请重试！","登陆提示",JOptionPane.ERROR_MESSAGE);
					}
				}else if(type.equals("管理员")) {
					if(loginMsg.selectAdmin()) {
						JOptionPane.showMessageDialog(frame, "登录成功！","登陆提示",JOptionPane.PLAIN_MESSAGE);
						new AdminGui(loginMsg.getUserName());
						frame.setVisible(false);
					}else {
						JOptionPane.showMessageDialog(frame, "登录失败！请重试！","登陆提示",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		
		//注册按钮监听器
		class RegistButton implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				new PatientRegistGui();
			}
		}
		
		LoginButton loginButton = new LoginButton();
		login.addActionListener(loginButton);
		
		RegistButton registButton = new RegistButton();
		regist.addActionListener(registButton);
		
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
