package cn.linyer.gui.adminGui;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.linyer.dao.impl.DoctorEmpDaoIpml;
import cn.linyer.entity.DoctorEmp;

/**
 * @author Linyer
 * 管理员管理医师职业信息界面
 * 
 */
public class DoctorEmpManagerGui {
	//主体部分定义
	private JFrame frame = new JFrame("管理医师职业信息");

	private JLabel doctorEmpLabel = new JLabel("医师职业信息管理",JLabel.CENTER);
	private JPanel doctorEmpPanel = new JPanel();
	//查询/删除 部分组件定义
	private JPanel doctorEmpSDPanel = new JPanel();
	private JPanel doctorEmpSDCenPanel = new JPanel();
	private JPanel doctorEmpSDCenTablePanel = new JPanel();
	
	private JLabel doctorEmpSDLabel = new JLabel("查询/删除 医师职业信息",JLabel.CENTER);
	private JLabel doctorEmpSDTypeLabel = new JLabel("操作类型：");
	
	private JComboBox<String> doctorEmpSDType = new JComboBox<String>();
	
	private JLabel doctorEmpSDNoLabel = new JLabel("医师工号：");
	
	private JTextField doctorEmpSDNo = new JTextField(8);
	private JTextArea doctorEmpSDArea = new JTextArea(12,30);
	
	private JButton doctorEmpSDBtn = new JButton("确定 查询/删除");
	
	//增加/修改 部分组件定义
	private JPanel doctorEmpAEPanel = new JPanel();
	private JPanel doctorEmpAECenPanel = new JPanel();
	
	private JLabel doctorEmpAELabel = new JLabel("增加/修改 医师职业信息",JLabel.CENTER);
	private JLabel doctorEmpAETypeLabel = new JLabel("操作类型：");
	private JLabel doctorEmpAENoLabel = new JLabel("医师工号：");
	private JLabel doctorEmpAEDPnoLabel = new JLabel("医师所在科室编号：");
	private JLabel doctorEmpAEWorkLabel = new JLabel("医师职务：");
	private JLabel doctorEmpAELnoLabel = new JLabel("医师职称编号：");
	private JLabel doctorEmpAEXlLabel = new JLabel("医师学历：");
	private JLabel doctorEmpAEYearLabel = new JLabel("医师年资：");
	private JLabel doctorEmpAESalaryLabel = new JLabel("医师薪资：");
	private JLabel doctorEmpAESuperNoLabel = new JLabel("上级医师工号：");
	
	private JComboBox<String> doctorEmpAEType = new JComboBox<String>();
	private JTextField doctorEmpAENo = new JTextField(8);
	private JTextField doctorEmpAEDPno = new JTextField(8);
	private JTextField doctorEmpAEWork = new JTextField(60);
	private JTextField doctorEmpAELno = new JTextField(8);
	private JTextField doctorEmpAEXl = new JTextField(60);
	private JTextField doctorEmpAEYear = new JTextField(40);
	private JTextField doctorEmpAESalary = new JTextField(8);
	private JTextField doctorEmpAESuperNo = new JTextField(8);
	
	private JButton doctorEmpAEBtn = new JButton("确定 增加/修改");
	//返回按钮
	private JButton backBtn = new JButton("返回上一界面");
	//颜色字体定义
	private Color myBlue = new Color(52, 152, 219);
	private Color myGreen = new Color(19, 141, 117);
	private Color myPink = new Color(171, 40, 199);
	
	private Font fontMid = new Font("华文楷体",Font.PLAIN,24);
	
	public DoctorEmpManagerGui() {
		//布局
		frame.setLayout(new BorderLayout());
		doctorEmpPanel.setLayout(new BorderLayout());
		doctorEmpSDPanel.setLayout(new BorderLayout());
		doctorEmpSDCenPanel.setLayout(new BorderLayout());
		doctorEmpSDCenTablePanel.setLayout(new GridLayout(2,2));
		doctorEmpAEPanel.setLayout(new BorderLayout());
		doctorEmpAECenPanel.setLayout(new GridLayout(9,2));
		//设置各个组件的属性
		doctorEmpLabel.setFont(new Font("华文琥珀",Font.BOLD,36));
		doctorEmpLabel.setForeground(myBlue);
		//查询组件属性
		doctorEmpSDLabel.setFont(new Font("黑体",Font.BOLD,28));
		doctorEmpSDLabel.setForeground(myGreen);
		doctorEmpSDTypeLabel.setFont(fontMid);
		doctorEmpSDTypeLabel.setForeground(Color.red);
		doctorEmpSDType.setFont(fontMid);
		doctorEmpSDType.setForeground(Color.red);
		doctorEmpSDNoLabel.setFont(fontMid);
		doctorEmpSDNoLabel.setForeground(myPink);
		doctorEmpSDNo.setFont(fontMid);
		doctorEmpSDArea.setFont(fontMid);
		doctorEmpSDBtn.setFont(fontMid);
		//增加/修改组件属性
		doctorEmpAELabel.setFont(new Font("黑体",Font.BOLD,28));
		doctorEmpAELabel.setForeground(myGreen);
		doctorEmpAETypeLabel.setFont(fontMid);
		doctorEmpAETypeLabel.setForeground(Color.red);
		doctorEmpAENoLabel.setFont(fontMid);
		doctorEmpAENoLabel.setForeground(myPink);
		doctorEmpAEDPnoLabel.setFont(fontMid);
		doctorEmpAEWorkLabel.setFont(fontMid);
		doctorEmpAELnoLabel.setFont(fontMid);
		doctorEmpAEXlLabel.setFont(fontMid);
		doctorEmpAEYearLabel.setFont(fontMid);
		doctorEmpAESalaryLabel.setFont(fontMid);
		doctorEmpAESuperNoLabel.setFont(fontMid);
		doctorEmpAEType.setFont(fontMid);
		doctorEmpAEType.setForeground(Color.red);
		doctorEmpAENo.setFont(fontMid);
		doctorEmpAEDPno.setFont(fontMid);
		doctorEmpAEWork.setFont(fontMid);
		doctorEmpAELno.setFont(fontMid);
		doctorEmpAEXl.setFont(fontMid);
		doctorEmpAEYear.setFont(fontMid);
		doctorEmpAESalary.setFont(fontMid);
		doctorEmpAESuperNo.setFont(fontMid);
		doctorEmpAEBtn.setFont(fontMid);
		
		backBtn.setFont(fontMid);
		//设置查询中的文本域不可编辑
		doctorEmpSDArea.setEditable(false);
		
		//添加组件
		frame.add(doctorEmpLabel,BorderLayout.NORTH);
		frame.add(doctorEmpPanel,BorderLayout.CENTER);
		frame.add(backBtn,BorderLayout.SOUTH);
		
		doctorEmpPanel.add(doctorEmpSDPanel,BorderLayout.WEST);
		doctorEmpPanel.add(doctorEmpAEPanel,BorderLayout.CENTER);

		doctorEmpSDPanel.add(doctorEmpSDLabel,BorderLayout.NORTH);
		doctorEmpSDPanel.add(doctorEmpSDCenPanel,BorderLayout.CENTER);
		doctorEmpSDPanel.add(doctorEmpSDBtn,BorderLayout.SOUTH);

		doctorEmpSDCenPanel.add(doctorEmpSDCenTablePanel,BorderLayout.NORTH);
		doctorEmpSDCenPanel.add(doctorEmpSDArea,BorderLayout.SOUTH);
		
		doctorEmpSDCenTablePanel.add(doctorEmpSDTypeLabel);
		doctorEmpSDCenTablePanel.add(doctorEmpSDType);
		doctorEmpSDCenTablePanel.add(doctorEmpSDNoLabel);
		doctorEmpSDCenTablePanel.add(doctorEmpSDNo);
		
		doctorEmpAEPanel.add(doctorEmpAELabel,BorderLayout.NORTH);
		doctorEmpAEPanel.add(doctorEmpAECenPanel,BorderLayout.CENTER);
		doctorEmpAEPanel.add(doctorEmpAEBtn,BorderLayout.SOUTH);
		
		doctorEmpAECenPanel.add(doctorEmpAETypeLabel);
		doctorEmpAECenPanel.add(doctorEmpAEType);
		doctorEmpAECenPanel.add(doctorEmpAENoLabel);
		doctorEmpAECenPanel.add(doctorEmpAENo);
		doctorEmpAECenPanel.add(doctorEmpAEDPnoLabel);
		doctorEmpAECenPanel.add(doctorEmpAEDPno);
		doctorEmpAECenPanel.add(doctorEmpAEWorkLabel);
		doctorEmpAECenPanel.add(doctorEmpAEWork);
		doctorEmpAECenPanel.add(doctorEmpAELnoLabel);
		doctorEmpAECenPanel.add(doctorEmpAELno);
		doctorEmpAECenPanel.add(doctorEmpAEXlLabel);
		doctorEmpAECenPanel.add(doctorEmpAEXl);
		doctorEmpAECenPanel.add(doctorEmpAEYearLabel);
		doctorEmpAECenPanel.add(doctorEmpAEYear);
		doctorEmpAECenPanel.add(doctorEmpAESalaryLabel);
		doctorEmpAECenPanel.add(doctorEmpAESalary);
		doctorEmpAECenPanel.add(doctorEmpAESuperNoLabel);
		doctorEmpAECenPanel.add(doctorEmpAESuperNo);
		
		doctorEmpSDType.addItem("查询");
		doctorEmpSDType.addItem("删除");
		
		doctorEmpAEType.addItem("增加");
		doctorEmpAEType.addItem("修改");

		DoctorEmpDaoIpml doctorEmpSDAE = new DoctorEmpDaoIpml();
		
		//查询/删除医师职业信息，按钮事件处理
		class DoctorEmpSDBtn implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				doctorEmpSDArea.setText(null);
				String doctorEmpSDTp = (String) doctorEmpSDType.getSelectedItem();
				String dNo = doctorEmpSDNo.getText();
				if(dNo.length()>0 || dNo.length()<=8) {
					if(doctorEmpSDTp.equals("查询")) {
						DoctorEmp doctorEmp = new DoctorEmp();
						doctorEmp = doctorEmpSDAE.selDoctorEmp(dNo);
						if(doctorEmp != null) {
							String doctorEmpInfo = "医师工号：" + doctorEmp.getDno()
											+ "\n医师所在科室编号："+ doctorEmp.getDPno()
											+ "\n医师职务：" + doctorEmp.getDwork()
											+ "\n医师职称编号：" + doctorEmp.getLno()
											+ "\n医师学历：" + doctorEmp.getDxl()
											+ "\n医师年资：" + doctorEmp.getDyear()
											+ "\n医师薪资：" + doctorEmp.getDsalary()
											+ "\n上级医师工号：" + doctorEmp.getDsuperNo();
							doctorEmpSDArea.setText(doctorEmpInfo);
						}else {
							doctorEmpSDArea.setText("此医师职业信息不存在");
						}
					}else if(doctorEmpSDTp.equals("删除")) {
						Boolean isOK = doctorEmpSDAE.deleObj(dNo);
						if(isOK) {
							JOptionPane.showMessageDialog(frame,doctorEmpSDNo.getText() + "医师职业信息 已被删除！",
															"医师职业信息删除提示",JOptionPane.PLAIN_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(frame, "删除医师职业信息 失败！",
															"医师职业信息删除提示",JOptionPane.ERROR_MESSAGE);
						}
					}
				}else {
					JOptionPane.showMessageDialog(frame, "请输入1-8位工号！",
													"输入错误提示",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		//判断是增加还是修改，执行相应的事件
		class DoctorEmpAEBtn implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String doctorEmpAETp = (String) doctorEmpAEType.getSelectedItem();
				DoctorEmp doctorEmp = new DoctorEmp();
				doctorEmp.setDno(doctorEmpAENo.getText());
				doctorEmp.setDPno(doctorEmpAEDPno.getText());
				doctorEmp.setDwork(doctorEmpAEWork.getText());
				doctorEmp.setLno(doctorEmpAELno.getText());
				doctorEmp.setDxl(doctorEmpAEXl.getText());
				doctorEmp.setDyear(doctorEmpAEYear.getText());
				doctorEmp.setDsalary(doctorEmpAESalary.getText());
				doctorEmp.setDsuperNo(doctorEmpAESuperNo.getText());
				if(doctorEmpAETp.equals("增加")) {
					if(doctorEmpSDAE.addObj(doctorEmp)) {
						JOptionPane.showMessageDialog(frame,"工号为：" + doctorEmpAENo.getText() + " 医师的职业信息 已成功添加！",
														"医师职业信息添加提示",JOptionPane.PLAIN_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(frame, "添加医师职业信息 失败！",
														"医师职业信息添加提示",JOptionPane.ERROR_MESSAGE);
					}
				}else if(doctorEmpAETp.equals("修改")) {
					if(doctorEmpAENo.getText()!=null) {
						if(doctorEmpSDAE.exeObj(doctorEmp)) {
							JOptionPane.showMessageDialog(frame, "工号为："+ doctorEmpAENo.getText() + " 的医师的职业信息 已成功修改！",
															"医师职业信息修改提示",JOptionPane.PLAIN_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(frame, "修改医师职业信息 失败！",
															"医师职业信息修改提示",JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(frame, "必须输入工号！","医师职业信息修改提示",JOptionPane.ERROR_MESSAGE);
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
		
		DoctorEmpSDBtn dESDBtn = new DoctorEmpSDBtn();
		doctorEmpSDBtn.addActionListener(dESDBtn);
		
		DoctorEmpAEBtn dEAEBtn = new DoctorEmpAEBtn();
		doctorEmpAEBtn.addActionListener(dEAEBtn);
		
		BackBtn bkBtn = new BackBtn();
		backBtn.addActionListener(bkBtn);
		
		frame.setResizable(false);
		frame.setSize(1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
