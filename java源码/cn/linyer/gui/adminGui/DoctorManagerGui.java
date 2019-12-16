package cn.linyer.gui.adminGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.linyer.dao.impl.DoctorDaoImpl;
import cn.linyer.entity.Doctor;

/**
 * @author Linyer
 * 管理员管理医师基本信息界面
 * 
 */
public class DoctorManagerGui {
	//主体部分定义
	private JFrame frame = new JFrame("管理医师基本信息");

	private JLabel doctorLabel = new JLabel("医师基本信息管理",JLabel.CENTER);
	private JPanel doctorPanel = new JPanel();
	//查询/删除 部分组件定义
	private JPanel doctorSDPanel = new JPanel();
	private JPanel doctorSDCenPanel = new JPanel();
	private JPanel doctorSDCenTablePanel = new JPanel();
	
	private JLabel doctorSDLabel = new JLabel("查询/删除 医师基本信息",JLabel.CENTER);
	private JLabel doctorSDTypeLabel = new JLabel("操作类型：");
	
	private JComboBox<String> doctorSDType = new JComboBox<String>();
	
	private JLabel doctorSDNoLabel = new JLabel("医师工号：");
	
	private JTextField doctorSDNo = new JTextField(8);
	private JTextArea doctorSDArea = new JTextArea(12,30);
	
	private JButton doctorSDBtn = new JButton("确定 查询/删除");
	
	//增加/修改 部分组件定义
	private JPanel doctorAEPanel = new JPanel();
	private JPanel doctorAECenPanel = new JPanel();
	
	private JLabel doctorAELabel = new JLabel("增加/修改 医师基本信息",JLabel.CENTER);
	private JLabel doctorAETypeLabel = new JLabel("操作类型：");
	private JLabel doctorAENoLabel = new JLabel("医师工号：");
	private JLabel doctorAENameLabel = new JLabel("医师姓名：");
	private JLabel doctorAESexLabel = new JLabel("医师性别：");
	private JLabel doctorAEBirthLabel = new JLabel("医师出生日期：");
	private JLabel doctorAEPhoneLabel = new JLabel("医师联系电话：");
	private JLabel doctorAEEmailLabel = new JLabel("医师电子邮箱：");
	private JLabel doctorAEBriefLabel = new JLabel("医师简介：");
	private JLabel doctorAEPwdLabel = new JLabel("医师账号密码：");
	
	private JComboBox<String> doctorAEType = new JComboBox<String>();
	private JTextField doctorAENo = new JTextField(8);
	private JTextField doctorAEName = new JTextField(18);
	private JComboBox<String> doctorAESex = new JComboBox<String>();
	private JTextField doctorAEBirth = new JTextField(10);
	private JTextField doctorAEPhone = new JTextField(11);
	private JTextField doctorAEEmail = new JTextField(40);
	private JTextField doctorAEBrief = new JTextField(3000);
	private JTextField doctorAEPwd = new JTextField(12);
	
	private JButton doctorAEBtn = new JButton("确定 增加/修改");
	//返回按钮
	private JButton backBtn = new JButton("返回上一界面");
	//颜色字体定义
	private Color myBlue = new Color(52, 152, 219);
	private Color myGreen = new Color(19, 141, 117);
	private Color myPink = new Color(171, 40, 199);
	
	private Font fontMid = new Font("华文楷体",Font.PLAIN,24);
	
	public DoctorManagerGui() {
		//布局
		frame.setLayout(new BorderLayout());
		doctorPanel.setLayout(new BorderLayout());
		doctorSDPanel.setLayout(new BorderLayout());
		doctorSDCenPanel.setLayout(new BorderLayout());
		doctorSDCenTablePanel.setLayout(new GridLayout(2,2));
		doctorAEPanel.setLayout(new BorderLayout());
		doctorAECenPanel.setLayout(new GridLayout(9,2));
		//设置各个组件的属性
		doctorLabel.setFont(new Font("华文琥珀",Font.BOLD,36));
		doctorLabel.setForeground(myBlue);
		//查询组件属性
		doctorSDLabel.setFont(new Font("黑体",Font.BOLD,28));
		doctorSDLabel.setForeground(myGreen);
		doctorSDTypeLabel.setFont(fontMid);
		doctorSDTypeLabel.setForeground(Color.red);
		doctorSDType.setFont(fontMid);
		doctorSDType.setForeground(Color.red);
		doctorSDNoLabel.setFont(fontMid);
		doctorSDNoLabel.setForeground(myPink);
		doctorSDNo.setFont(fontMid);
		doctorSDArea.setFont(fontMid);
		doctorSDBtn.setFont(fontMid);
		//增加/修改组件属性
		doctorAELabel.setFont(new Font("黑体",Font.BOLD,28));
		doctorAELabel.setForeground(myGreen);
		doctorAETypeLabel.setFont(fontMid);
		doctorAETypeLabel.setForeground(Color.red);
		doctorAENoLabel.setFont(fontMid);
		doctorAENoLabel.setForeground(myPink);
		doctorAENameLabel.setFont(fontMid);
		doctorAESexLabel.setFont(fontMid);
		doctorAEBirthLabel.setFont(fontMid);
		doctorAEPhoneLabel.setFont(fontMid);
		doctorAEEmailLabel.setFont(fontMid);
		doctorAEBriefLabel.setFont(fontMid);
		doctorAEPwdLabel.setFont(fontMid);
		doctorAEType.setFont(fontMid);
		doctorAEType.setForeground(Color.red);
		doctorAENo.setFont(fontMid);
		doctorAEName.setFont(fontMid);
		doctorAESex.setFont(fontMid);
		doctorAEBirth.setFont(fontMid);
		doctorAEPhone.setFont(fontMid);
		doctorAEEmail.setFont(fontMid);
		doctorAEBrief.setFont(fontMid);
		doctorAEPwd.setFont(fontMid);
		doctorAEBtn.setFont(fontMid);
		
		backBtn.setFont(fontMid);
		//设置查询中的文本域不可编辑
		doctorSDArea.setEditable(false);
		
		//添加组件
		frame.add(doctorLabel,BorderLayout.NORTH);
		frame.add(doctorPanel,BorderLayout.CENTER);
		frame.add(backBtn,BorderLayout.SOUTH);
		
		doctorPanel.add(doctorSDPanel,BorderLayout.WEST);
		doctorPanel.add(doctorAEPanel,BorderLayout.CENTER);

		doctorSDPanel.add(doctorSDLabel,BorderLayout.NORTH);
		doctorSDPanel.add(doctorSDCenPanel,BorderLayout.CENTER);
		doctorSDPanel.add(doctorSDBtn,BorderLayout.SOUTH);

		doctorSDCenPanel.add(doctorSDCenTablePanel,BorderLayout.NORTH);
		doctorSDCenPanel.add(doctorSDArea,BorderLayout.SOUTH);
		
		doctorSDCenTablePanel.add(doctorSDTypeLabel);
		doctorSDCenTablePanel.add(doctorSDType);
		doctorSDCenTablePanel.add(doctorSDNoLabel);
		doctorSDCenTablePanel.add(doctorSDNo);
		
		doctorAEPanel.add(doctorAELabel,BorderLayout.NORTH);
		doctorAEPanel.add(doctorAECenPanel,BorderLayout.CENTER);
		doctorAEPanel.add(doctorAEBtn,BorderLayout.SOUTH);
		
		doctorAECenPanel.add(doctorAETypeLabel);
		doctorAECenPanel.add(doctorAEType);
		doctorAECenPanel.add(doctorAENoLabel);
		doctorAECenPanel.add(doctorAENo);
		doctorAECenPanel.add(doctorAENameLabel);
		doctorAECenPanel.add(doctorAEName);
		doctorAECenPanel.add(doctorAESexLabel);
		doctorAECenPanel.add(doctorAESex);
		doctorAECenPanel.add(doctorAEBirthLabel);
		doctorAECenPanel.add(doctorAEBirth);
		doctorAECenPanel.add(doctorAEPhoneLabel);
		doctorAECenPanel.add(doctorAEPhone);
		doctorAECenPanel.add(doctorAEEmailLabel);
		doctorAECenPanel.add(doctorAEEmail);
		doctorAECenPanel.add(doctorAEBriefLabel);
		doctorAECenPanel.add(doctorAEBrief);
		doctorAECenPanel.add(doctorAEPwdLabel);
		doctorAECenPanel.add(doctorAEPwd);
		
		doctorSDType.addItem("查询");
		doctorSDType.addItem("删除");
		
		doctorAEType.addItem("增加");
		doctorAEType.addItem("修改");
		
		doctorAESex.addItem(null);
		doctorAESex.addItem("男");
		doctorAESex.addItem("女");
		//窗口一打开就判断一下是增加还是修改
		class DoctorWindowOpenIsAE implements WindowListener {
			public void windowActivated(WindowEvent e) {
				String doctorAETp = (String) doctorAEType.getSelectedItem();
				if(doctorAETp.equals("增加")) {
					doctorAENo.setEditable(false);
					doctorAENo.setText("自动生成工号");
				}else if(doctorAETp.equals("修改")) {
					doctorAENo.setEditable(true);
					doctorAENo.setText(null);
				}
			}

			public void windowOpened(WindowEvent e) {}
			public void windowClosing(WindowEvent e) {}
			public void windowClosed(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
		}
		
		DoctorDaoImpl doctorSDAE = new DoctorDaoImpl();
		
		//查询/删除医师基本信息，按钮事件处理
		class DoctorSDBtn implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				doctorSDArea.setText(null);
				String doctorSDTp = (String) doctorSDType.getSelectedItem();
				String dNo = doctorSDNo.getText();
				if(dNo.length()>0 || dNo.length()<=8) {
					if(doctorSDTp.equals("查询")) {
						Doctor doctor = new Doctor();
						doctor = doctorSDAE.selDoctor(dNo);
						if(doctor != null) {
							String doctorInfo = "医师工号：" + doctor.getDno()
											+ "\n医师姓名："+ doctor.getDname()
											+ "\n医师性别：" + doctor.getDsex()
											+ "\n医师出生日期：" + doctor.getDbirth()
											+ "\n医师联系电话：" + doctor.getDphone()
											+ "\n医师电子邮箱：" + doctor.getDemail()
											+ "\n医师简介：" + doctor.getDbrief()
											+ "\n医师账号密码：" + doctor.getDpwd();
							doctorSDArea.setText(doctorInfo);
						}else {
							doctorSDArea.setText("此医师基本信息不存在");
						}
					}else if(doctorSDTp.equals("删除")) {
						Boolean isOK = doctorSDAE.deleObj(dNo);
						if(isOK) {
							JOptionPane.showMessageDialog(frame,doctorSDNo.getText() + "医师基本信息 已被删除！","医师基本信息删除提示",JOptionPane.PLAIN_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(frame, "删除医师基本信息 失败！","医师基本信息删除提示",JOptionPane.ERROR_MESSAGE);
						}
					}
				}else {
					JOptionPane.showMessageDialog(frame, "请输入1-8位工号！","输入错误提示",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		//判断选择的是增加还是修改，设置医师工号是否可以输入
		class DoctorAETp implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String doctorAETp = (String) doctorAEType.getSelectedItem();
				if(doctorAETp.equals("增加")) {
					doctorAENo.setEditable(false);
					doctorAENo.setText("自动生成工号");
				}else if(doctorAETp.equals("修改")) {
					doctorAENo.setEditable(true);
					doctorAENo.setText(null);
				}
			}
			
		}
		//判断是增加还是修改，执行相应的事件
		class DoctorAEBtn implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String doctorAETp = (String) doctorAEType.getSelectedItem();
				Doctor doctor = new Doctor();
				doctor.setDname(doctorAEName.getText());
				doctor.setDsex((String)doctorAESex.getSelectedItem());
				doctor.setDbirth(doctorAEBirth.getText());
				doctor.setDphone(doctorAEPhone.getText());
				doctor.setDemail(doctorAEEmail.getText());
				doctor.setDbrief(doctorAEBrief.getText());
				doctor.setDpwd(doctorAEPwd.getText());
				if(doctorAETp.equals("增加")) {
					Boolean isOK = doctorSDAE.addObj(doctor);
					if(isOK) {
						JOptionPane.showMessageDialog(frame,doctorAEName.getText() + "医师的基本信息 已成功添加！","医师基本信息添加提示",JOptionPane.PLAIN_MESSAGE);
						String dnum = doctorSDAE.selDoctorNo(doctor.getDname());
						JOptionPane.showMessageDialog(frame,"生成的工号为："+ dnum +"！","医师基本信息添加提示",JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(frame, "添加医师基本信息 失败！","医师基本信息添加提示",JOptionPane.ERROR_MESSAGE);
					}
				}else if(doctorAETp.equals("修改")) {
					if(doctorAENo.getText()!=null) {
						Boolean isOK = doctorSDAE.exeObj(doctor);
						if(isOK) {
							JOptionPane.showMessageDialog(frame, "工号为："+ doctorAENo.getText() + " 的医师的基本信息 已成功修改！","医师基本信息修改提示",JOptionPane.PLAIN_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(frame, "修改医师基本信息 失败！","医师基本信息修改提示",JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(frame, "必须输入工号！","医师基本信息修改提示",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		//返回上一界面的按钮事件
		class BackBtn implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				AdminGui.frame.setVisible(true);
			}
		}
		
		DoctorWindowOpenIsAE dWOIAE = new DoctorWindowOpenIsAE();
		frame.addWindowListener(dWOIAE);
		
		DoctorSDBtn dSDBtn = new DoctorSDBtn();
		doctorSDBtn.addActionListener(dSDBtn);
		
		DoctorAETp dAETp = new DoctorAETp();
		doctorAEType.addActionListener(dAETp);
		
		DoctorAEBtn dAEBtn = new DoctorAEBtn();
		doctorAEBtn.addActionListener(dAEBtn);
		
		BackBtn bkBtn = new BackBtn();
		backBtn.addActionListener(bkBtn);
		
		frame.setResizable(false);
		frame.setSize(1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
