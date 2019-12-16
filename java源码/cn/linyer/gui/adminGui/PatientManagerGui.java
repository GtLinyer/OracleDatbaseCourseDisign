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

import cn.linyer.dao.impl.PatientDaoImpl;
import cn.linyer.entity.Patient;

/**
 * @author Linyer
 * 管理员管理患者信息界面
 * 
 */
public class PatientManagerGui {
	//主体部分定义
	private JFrame frame = new JFrame("管理患者信息");

	private JLabel patientLabel = new JLabel("患者信息管理",JLabel.CENTER);
	private JPanel patientPanel = new JPanel();
	//查询/删除 部分组件定义
	private JPanel patientSDPanel = new JPanel();
	private JPanel patientSDCenPanel = new JPanel();
	private JPanel patientSDCenTablePanel = new JPanel();
	
	private JLabel patientSDLabel = new JLabel("查询/删除 患者信息",JLabel.CENTER);
	private JLabel patientSDTypeLabel = new JLabel("操作类型：");
	
	private JComboBox<String> patientSDType = new JComboBox<String>();
	
	private JLabel patientSDNoLabel = new JLabel("患者编号：");
	
	private JTextField patientSDNo = new JTextField(8);
	private JTextArea patientSDArea = new JTextArea(12,30);
	
	private JButton patientSDBtn = new JButton("确定 查询/删除");
	
	//增加/修改 部分组件定义
	private JPanel patientAEPanel = new JPanel();
	private JPanel patientAECenPanel = new JPanel();
	
	private JLabel patientAELabel = new JLabel("增加/修改 患者信息",JLabel.CENTER);
	private JLabel patientAETypeLabel = new JLabel("操作类型：");
	private JLabel patientAENoLabel = new JLabel("病历号：");
	private JLabel patientAENameLabel = new JLabel("患者姓名：");
	private JLabel patientAESexLabel = new JLabel("患者性别：");
	private JLabel patientAEAgeLabel = new JLabel("患者年龄：");
	private JLabel patientAEPhoneLabel = new JLabel("患者联系电话：");
	private JLabel patientAEAddressLabel = new JLabel("患者住址：");
	private JLabel patientAEDnoLabel = new JLabel("主治医师工号：");
	private JLabel patientAEEnDateLabel = new JLabel("患者入院日期：");
	private JLabel patientAEEmpLabel = new JLabel("患者职业：");
	private JLabel patientAEPwdLabel = new JLabel("患者登录密码：");
	private JLabel patientAEIDnoLabel = new JLabel("患者身份证号：");
	
	
	private JComboBox<String> patientAEType = new JComboBox<String>();
	private JTextField patientAENo = new JTextField(8);
	private JTextField patientAEName = new JTextField(21);
	private JComboBox<String> patientAESex = new JComboBox<String>();
	private JTextField patientAEAge = new JTextField(3);
	private JTextField patientAEPhone = new JTextField(11);
	private JTextField patientAEAddress = new JTextField(300);
	private JTextField patientAEDno = new JTextField(8);
	private JTextField patientAEEnDate = new JTextField(12);
	private JTextField patientAEEmp = new JTextField(60);
	private JTextField patientAEPwd = new JTextField(12);
	private JTextField patientAEIDno = new JTextField(18);
	
	private JButton patientAEBtn = new JButton("确定 增加/修改");
	//返回按钮
	private JButton backBtn = new JButton("返回上一界面");
	//颜色字体定义
	private Color myBlue = new Color(52, 152, 219);
	private Color myGreen = new Color(19, 141, 117);
	private Color myPink = new Color(171, 40, 199);
	
	private Font fontMid = new Font("华文楷体",Font.PLAIN,24);
	
	public PatientManagerGui() {
		//布局
		frame.setLayout(new BorderLayout());
		patientPanel.setLayout(new BorderLayout());
		patientSDPanel.setLayout(new BorderLayout());
		patientSDCenPanel.setLayout(new BorderLayout());
		patientSDCenTablePanel.setLayout(new GridLayout(2,2));
		patientAEPanel.setLayout(new BorderLayout());
		patientAECenPanel.setLayout(new GridLayout(12,2));
		//设置各个组件的属性
		patientLabel.setFont(new Font("华文琥珀",Font.BOLD,36));
		patientLabel.setForeground(myBlue);
		//查询 组件属性
		patientSDLabel.setFont(new Font("黑体",Font.BOLD,28));
		patientSDLabel.setForeground(myGreen);
		patientSDTypeLabel.setFont(fontMid);
		patientSDTypeLabel.setForeground(Color.red);
		patientSDType.setFont(fontMid);
		patientSDType.setForeground(Color.red);
		patientSDNoLabel.setFont(fontMid);
		patientSDNoLabel.setForeground(myPink);
		patientSDNo.setFont(fontMid);
		patientSDArea.setFont(fontMid);
		patientSDBtn.setFont(fontMid);
		//增加/修改 组件属性
		patientAELabel.setFont(new Font("黑体",Font.BOLD,28));
		patientAELabel.setForeground(myGreen);
		patientAETypeLabel.setFont(fontMid);
		patientAETypeLabel.setForeground(Color.red);
		patientAENoLabel.setFont(fontMid);
		patientAENoLabel.setForeground(myPink);
		patientAENameLabel.setFont(fontMid);
		patientAESexLabel.setFont(fontMid);
		patientAEAgeLabel.setFont(fontMid);
		patientAEPhoneLabel.setFont(fontMid);
		patientAEAddressLabel.setFont(fontMid);
		patientAEDnoLabel.setFont(fontMid);
		patientAEEnDateLabel.setFont(fontMid);
		patientAEEmpLabel.setFont(fontMid);
		patientAEPwdLabel.setFont(fontMid);
		patientAEIDnoLabel.setFont(fontMid);
		patientAEType.setFont(fontMid);
		patientAEType.setForeground(Color.red);
		patientAENo.setFont(fontMid);
		patientAEName.setFont(fontMid);
		patientAESex.setFont(fontMid);
		patientAEAge.setFont(fontMid);
		patientAEPhone.setFont(fontMid);
		patientAEAddress.setFont(fontMid);
		patientAEDno.setFont(fontMid);
		patientAEEnDate.setFont(fontMid);
		patientAEEmp.setFont(fontMid);
		patientAEPwd.setFont(fontMid);
		patientAEIDno.setFont(fontMid);
		patientAEBtn.setFont(fontMid);
		
		backBtn.setFont(fontMid);
		//设置查询中的文本域不可编辑
		patientSDArea.setEditable(false);
		
		//添加组件
		frame.add(patientLabel,BorderLayout.NORTH);
		frame.add(patientPanel,BorderLayout.CENTER);
		frame.add(backBtn,BorderLayout.SOUTH);
		
		patientPanel.add(patientSDPanel,BorderLayout.WEST);
		patientPanel.add(patientAEPanel,BorderLayout.CENTER);

		patientSDPanel.add(patientSDLabel,BorderLayout.NORTH);
		patientSDPanel.add(patientSDCenPanel,BorderLayout.CENTER);
		patientSDPanel.add(patientSDBtn,BorderLayout.SOUTH);

		patientSDCenPanel.add(patientSDCenTablePanel,BorderLayout.NORTH);
		patientSDCenPanel.add(patientSDArea,BorderLayout.SOUTH);
		
		patientSDCenTablePanel.add(patientSDTypeLabel);
		patientSDCenTablePanel.add(patientSDType);
		patientSDCenTablePanel.add(patientSDNoLabel);
		patientSDCenTablePanel.add(patientSDNo);
		
		patientAEPanel.add(patientAELabel,BorderLayout.NORTH);
		patientAEPanel.add(patientAECenPanel,BorderLayout.CENTER);
		patientAEPanel.add(patientAEBtn,BorderLayout.SOUTH);
		
		patientAECenPanel.add(patientAETypeLabel);
		patientAECenPanel.add(patientAEType);
		patientAECenPanel.add(patientAENoLabel);
		patientAECenPanel.add(patientAENo);
		patientAECenPanel.add(patientAENameLabel);
		patientAECenPanel.add(patientAEName);
		patientAECenPanel.add(patientAESexLabel);
		patientAECenPanel.add(patientAESex);
		patientAECenPanel.add(patientAEAgeLabel);
		patientAECenPanel.add(patientAEAge);
		patientAECenPanel.add(patientAEPhoneLabel);
		patientAECenPanel.add(patientAEPhone);
		patientAECenPanel.add(patientAEAddressLabel);
		patientAECenPanel.add(patientAEAddress);
		patientAECenPanel.add(patientAEDnoLabel);
		patientAECenPanel.add(patientAEDno);
		patientAECenPanel.add(patientAEEnDateLabel);
		patientAECenPanel.add(patientAEEnDate);
		patientAECenPanel.add(patientAEEmpLabel);
		patientAECenPanel.add(patientAEEmp);
		patientAECenPanel.add(patientAEPwdLabel);
		patientAECenPanel.add(patientAEPwd);
		patientAECenPanel.add(patientAEIDnoLabel);
		patientAECenPanel.add(patientAEIDno);
		
		patientSDType.addItem("查询");
		patientSDType.addItem("删除");
		
		patientAEType.addItem("增加");
		patientAEType.addItem("修改");
		
		patientAESex.addItem(null);
		patientAESex.addItem("男");
		patientAESex.addItem("女");
		
		//窗口一打开就判断一下是增加还是修改
		class DoctorWindowOpenIsAE implements WindowListener {
			public void windowActivated(WindowEvent e) {
				String doctorAETp = (String) patientAEType.getSelectedItem();
				if(doctorAETp.equals("增加")) {
					patientAENo.setEditable(false);
					patientAENo.setText("自动生成病历号");
				}else if(doctorAETp.equals("修改")) {
					patientAENo.setEditable(true);
					patientAENo.setText(null);
				}
			}

			public void windowOpened(WindowEvent e) {}
			public void windowClosing(WindowEvent e) {}
			public void windowClosed(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
		}
		
		PatientDaoImpl patientSDAE = new PatientDaoImpl();
		
		//查询/删除 患者信息，按钮事件处理
		class patientSDBtn implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				patientSDArea.setText(null);
				String patientSDTp = (String) patientSDType.getSelectedItem();
				String patientNo = patientSDNo.getText();
				if(patientNo.length()>0 || patientNo.length()<=8) {
					if(patientSDTp.equals("查询")) {
						Patient patient = new Patient();
						patient = patientSDAE.selPatient(patientNo);
						if(patient != null) {
							String patientInfo = "病历号：" + patient.getPno()
											+ "\n患者姓名："+ patient.getPname()
											+ "\n患者性别：" + patient.getPsex()
											+ "\n患者年龄：" + patient.getPage()
											+ "\n患者联系电话：" + patient.getPphone()
											+ "\n患者住址：" + patient.getPaddress()
											+ "\n主治医师工号：" + patient.getDno()
											+ "\n入院日期：" + patient.getPEnDate()
											+ "\n患者职业：" + patient.getPemployer()
											+ "\n患者登录密码：" + patient.getPpwd()
											+ "\n患者身份证号：" + patient.getPIDno();
							patientSDArea.setText(patientInfo);
						}else {
							patientSDArea.setText("此患者信息不存在");
						}
					}else if(patientSDTp.equals("删除")) {
						Boolean isOK = patientSDAE.deleObj(patientNo);
						if(isOK) {
							JOptionPane.showMessageDialog(frame,patientSDNo.getText() + "患者信息 已被删除！","患者信息删除提示",JOptionPane.PLAIN_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(frame, "删除患者信息 失败！","患者信息删除提示",JOptionPane.ERROR_MESSAGE);
						}
					}
				}else {
					JOptionPane.showMessageDialog(frame, "请输入1-8位编号！","输入错误提示",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		//判断选择的是增加还是修改，设置患者编号是否可以输入
		class patientAETp implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String patientAETp = (String) patientAEType.getSelectedItem();
				if(patientAETp.equals("增加")) {
					patientAENo.setEditable(false);
					patientAENo.setText("自动生成病历号");
				}else if(patientAETp.equals("修改")) {
					patientAENo.setEditable(true);
					patientAENo.setText(null);
				}
			}
			
		}		
		//判断是增加还是修改，执行相应的事件
		class patientAEBtn implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String patientAETp = (String) patientAEType.getSelectedItem();
				if(patientAETp.equals("增加")) {
					Patient patient = new Patient();
					patient.setPname(patientAEName.getText());
					patient.setPsex((String)patientAESex.getSelectedItem());
					patient.setPage(patientAEAge.getText());
					patient.setPphone(patientAEPhone.getText());
					patient.setPaddress(patientAEAddress.getText());
					patient.setDno(patientAEDno.getText());
					patient.setPEnDate(patientAEEnDate.getText());
					patient.setPemployer(patientAEEmp.getText());
					patient.setPpwd(patientAEPwd.getText());
					patient.setPIDno(patientAEIDno.getText());
					Boolean isOK = patientSDAE.addObj(patient);
					if(isOK) {
						JOptionPane.showMessageDialog(frame,"患者："+ patientAEName.getText() + " 的信息 已成功添加！","患者信息添加提示",JOptionPane.PLAIN_MESSAGE);
						String dnum = patientSDAE.selPatientNo(patient.getPname());
						JOptionPane.showMessageDialog(frame,"生成的编号为："+ dnum +"！","患者信息添加提示",JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(frame, "添加患者信息 失败！","患者信息添加提示",JOptionPane.ERROR_MESSAGE);
					}
				}else if(patientAETp.equals("修改")) {
					if(patientAENo.getText()!=null) {
						Patient patient = new Patient();
						patient.setPno(patientAENo.getText());
						patient.setPname(patientAEName.getText());
						patient.setPsex((String)patientAESex.getSelectedItem());
						patient.setPage(patientAEAge.getText());
						patient.setPphone(patientAEPhone.getText());
						patient.setPaddress(patientAEAddress.getText());
						patient.setDno(patientAEDno.getText());
						patient.setPEnDate(patientAEEnDate.getText());
						patient.setPemployer(patientAEEmp.getText());
						patient.setPpwd(patientAEPwd.getText());
						patient.setPIDno(patientAEIDno.getText());
						Boolean isOK = patientSDAE.exeObj(patient);
						if(isOK) {
							JOptionPane.showMessageDialog(frame, "编号为："+ patientAENo.getText() + " 的患者信息 已成功修改！","患者信息修改提示",JOptionPane.PLAIN_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(frame, "修改患者信息 失败！","患者信息修改提示",JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(frame, "必须输入编号！","患者信息修改提示",JOptionPane.ERROR_MESSAGE);
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
		
		patientSDBtn dESDBtn = new patientSDBtn();
		patientSDBtn.addActionListener(dESDBtn);
		
		patientAETp patientAETp = new patientAETp();
		patientAEType.addActionListener(patientAETp);
		
		patientAEBtn dEAEBtn = new patientAEBtn();
		patientAEBtn.addActionListener(dEAEBtn);
		
		BackBtn bkBtn = new BackBtn();
		backBtn.addActionListener(bkBtn);
		
		frame.setResizable(false);
		frame.setSize(1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
