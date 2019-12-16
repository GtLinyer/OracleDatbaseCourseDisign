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

import cn.linyer.dao.impl.DepartmentDaoImpl;
import cn.linyer.entity.Department;


/**
 * @author Linyer
 * 管理员管理科室信息界面
 * 
 */
public class DepartmentManagerGui {
	//主体部分定义
	private JFrame frame = new JFrame("管理科室信息");

	private JLabel dpLabel = new JLabel("科室信息管理",JLabel.CENTER);
	private JPanel dpPanel = new JPanel();
	//查询/删除 部分组件定义
	private JPanel dpSDPanel = new JPanel();
	private JPanel dpSDCenPanel = new JPanel();
	private JPanel dpSDCenTablePanel = new JPanel();
	
	private JLabel dpSDLabel = new JLabel("查询/删除 科室信息",JLabel.CENTER);
	private JLabel dpSDTypeLabel = new JLabel("操作类型：");
	
	private JComboBox<String> dpSDType = new JComboBox<String>();
	
	private JLabel dpSDNoLabel = new JLabel("科室编号：");
	
	private JTextField dpSDNo = new JTextField(8);
	private JTextArea dpSDArea = new JTextArea(8,25);
	
	private JButton dpSDBtn = new JButton("确定 查询/删除");
	
	//增加/修改 部分组件定义
	private JPanel dpAEPanel = new JPanel();
	private JPanel dpAECenPanel = new JPanel();
	
	private JLabel dpAELabel = new JLabel("增加/修改 科室信息",JLabel.CENTER);
	private JLabel dpAETypeLabel = new JLabel("操作类型：");
	private JLabel dpAENoLabel = new JLabel("科室编号：");
	private JLabel dpAENameLabel = new JLabel("科室名称：");
	private JLabel dpAELocaLabel = new JLabel("科室位置：");
	private JLabel dpAEBriefLabel = new JLabel("科室简介：");
	private JLabel dpAEIsClicLabel = new JLabel("是否临床科室：");
	
	private JComboBox<String> dpAEType = new JComboBox<String>();
	private JTextField dpAENo = new JTextField(8);
	private JTextField dpAEName = new JTextField(40);
	private JTextField dpAELoca = new JTextField(100);
	private JTextField dpAEBrief = new JTextField(1000);
	private JComboBox<String> dpAEIsClic = new JComboBox<String>();
	
	private JButton dpAEBtn = new JButton("确定 增加/修改");
	//返回按钮
	private JButton backBtn = new JButton("返回上一界面");
	//颜色字体定义
	private Color myBlue = new Color(52, 152, 219);
	private Color myGreen = new Color(19, 141, 117);
	private Color myPink = new Color(171, 40, 199);
	
	private Font fontMid = new Font("华文楷体",Font.PLAIN,24);
	
	public DepartmentManagerGui() {
		//布局
		frame.setLayout(new BorderLayout());
		dpPanel.setLayout(new BorderLayout());
		dpSDPanel.setLayout(new BorderLayout());
		dpSDCenPanel.setLayout(new BorderLayout());
		dpSDCenTablePanel.setLayout(new GridLayout(2,2));
		dpAEPanel.setLayout(new BorderLayout());
		dpAECenPanel.setLayout(new GridLayout(6,2));
		//设置各个组件的属性
		dpLabel.setFont(new Font("华文琥珀",Font.BOLD,36));
		dpLabel.setForeground(myBlue);
		//查询组件属性
		dpSDLabel.setFont(new Font("黑体",Font.BOLD,28));
		dpSDLabel.setForeground(myGreen);
		dpSDTypeLabel.setFont(fontMid);
		dpSDTypeLabel.setForeground(Color.red);
		dpSDType.setFont(fontMid);
		dpSDType.setForeground(Color.red);
		dpSDNoLabel.setFont(fontMid);
		dpSDNoLabel.setForeground(myPink);
		dpSDNo.setFont(fontMid);
		dpSDArea.setFont(fontMid);
		dpSDBtn.setFont(fontMid);
		//增加/修改组件属性
		dpAELabel.setFont(new Font("黑体",Font.BOLD,28));
		dpAELabel.setForeground(myGreen);
		dpAETypeLabel.setFont(fontMid);
		dpAETypeLabel.setForeground(Color.red);
		dpAENoLabel.setFont(fontMid);
		dpAENoLabel.setForeground(myPink);
		dpAENameLabel.setFont(fontMid);
		dpAELocaLabel.setFont(fontMid);
		dpAEBriefLabel.setFont(fontMid);
		dpAEType.setFont(fontMid);
		dpAEType.setForeground(Color.red);
		dpAENo.setFont(fontMid);
		dpAEName.setFont(fontMid);
		dpAELoca.setFont(fontMid);
		dpAEBrief.setFont(fontMid);
		dpAEBtn.setFont(fontMid);
		dpAEIsClicLabel.setFont(fontMid);
		dpAEIsClic.setFont(fontMid);
		
		backBtn.setFont(fontMid);
		//设置查询中的文本域不可编辑
		dpSDArea.setEditable(false);
		
		//添加组件
		frame.add(dpLabel,BorderLayout.NORTH);
		frame.add(dpPanel,BorderLayout.CENTER);
		frame.add(backBtn,BorderLayout.SOUTH);
		
		dpPanel.add(dpSDPanel,BorderLayout.WEST);
		dpPanel.add(dpAEPanel,BorderLayout.CENTER);

		dpSDPanel.add(dpSDLabel,BorderLayout.NORTH);
		dpSDPanel.add(dpSDCenPanel,BorderLayout.CENTER);
		dpSDPanel.add(dpSDBtn,BorderLayout.SOUTH);

		dpSDCenPanel.add(dpSDCenTablePanel,BorderLayout.NORTH);
		dpSDCenPanel.add(dpSDArea,BorderLayout.SOUTH);
		
		dpSDCenTablePanel.add(dpSDTypeLabel);
		dpSDCenTablePanel.add(dpSDType);
		dpSDCenTablePanel.add(dpSDNoLabel);
		dpSDCenTablePanel.add(dpSDNo);
		
		dpAEPanel.add(dpAELabel,BorderLayout.NORTH);
		dpAEPanel.add(dpAECenPanel,BorderLayout.CENTER);
		dpAEPanel.add(dpAEBtn,BorderLayout.SOUTH);
		
		dpAECenPanel.add(dpAETypeLabel);
		dpAECenPanel.add(dpAEType);
		dpAECenPanel.add(dpAENoLabel);
		dpAECenPanel.add(dpAENo);
		dpAECenPanel.add(dpAENameLabel);
		dpAECenPanel.add(dpAEName);
		dpAECenPanel.add(dpAELocaLabel);
		dpAECenPanel.add(dpAELoca);
		dpAECenPanel.add(dpAELocaLabel);
		dpAECenPanel.add(dpAELoca);
		dpAECenPanel.add(dpAEBriefLabel);
		dpAECenPanel.add(dpAEBrief);
		dpAECenPanel.add(dpAEIsClicLabel);
		dpAECenPanel.add(dpAEIsClic);
		
		dpSDType.addItem("查询");
		dpSDType.addItem("删除");
		
		dpAEType.addItem("增加");
		dpAEType.addItem("修改");
		
		dpAEIsClic.addItem("是");
		dpAEIsClic.addItem("否");
		//启动之时，默认为增加
		dpAENo.setEditable(false);
		dpAENo.setText("自动生成编号");
		
		DepartmentDaoImpl dpSDAE = new DepartmentDaoImpl();
		
		//查询/删除 科室信息，按钮事件处理
		class dpSDBtn implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				dpSDArea.setText(null);
				String dpSDTp = (String) dpSDType.getSelectedItem();
				String dPNo = dpSDNo.getText();
				if(dPNo.length()>0 || dPNo.length()<=8) {
					if(dpSDTp.equals("查询")) {
						Department dp = new Department();
						dp = dpSDAE.selDepartment(dPNo);
						if(dp != null) {
							String dpInfo = "科室编号：" + dp.getDPno()
											+ "\n科室名称："+ dp.getDPname()
											+ "\n科室位置：" + dp.getDPloca()
											+ "\n科室简介：" + dp.getDPbrief()
											+ "\n是否临床科室：" + dp.getIsClinical();
							dpSDArea.setText(dpInfo);
						}else {
							dpSDArea.setText("此科室信息不存在");
						}
					}else if(dpSDTp.equals("删除")) {
						Boolean isOK = dpSDAE.deleObj(dPNo);
						if(isOK) {
							JOptionPane.showMessageDialog(frame,dpSDNo.getText() + "科室信息 已被删除！","科室信息删除提示",JOptionPane.PLAIN_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(frame, "删除科室信息 失败！","科室信息删除提示",JOptionPane.ERROR_MESSAGE);
						}
					}
				}else {
					JOptionPane.showMessageDialog(frame, "请输入1-8位编号！","输入错误提示",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		//判断选择的是增加还是修改，设置科室编号是否可以输入
		class DpAETp implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String dpAETp = (String) dpAEType.getSelectedItem();
				if(dpAETp.equals("增加")) {
					dpAENo.setEditable(false);
					dpAENo.setText("自动生成编号");
				}else if(dpAETp.equals("修改")) {
					dpAENo.setEditable(true);
					dpAENo.setText(null);
					dpAEIsClic.setSelectedItem(null);
				}
			}
			
		}		
		//判断是增加还是修改，执行相应的事件
		class dpAEBtn implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String dpAETp = (String) dpAEType.getSelectedItem();
				if(dpAETp.equals("增加")) {
					Department dp = new Department();
					dp.setDPname(dpAEName.getText());
					dp.setDPloca(dpAELoca.getText());
					dp.setDPbrief(dpAEBrief.getText());
					if(dpAEIsClic.getSelectedItem().equals("是")) {
						dp.setIsClinical("1");
					}else {
						dp.setIsClinical("0");
					}
					Boolean isOK = dpSDAE.addObj(dp);
					if(isOK) {
						JOptionPane.showMessageDialog(frame,dpAEName.getText() + "的信息 已成功添加！","科室信息添加提示",JOptionPane.PLAIN_MESSAGE);
						String dnum = dpSDAE.selDpNo(dp.getDPname());
						JOptionPane.showMessageDialog(frame,"生成的编号为："+ dnum +"！","科室信息添加提示",JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(frame, "添加科室信息 失败！","科室信息添加提示",JOptionPane.ERROR_MESSAGE);
					}
				}else if(dpAETp.equals("修改")) {
					if(dpAENo.getText()!=null) {
						Department dp = new Department();
						dp.setDPno(dpAENo.getText());
						dp.setDPname(dpAEName.getText());
						dp.setDPloca(dpAELoca.getText());
						dp.setDPbrief(dpAEBrief.getText());
						if(dpAEIsClic.getSelectedItem().equals("是")) {
							dp.setIsClinical("1");
						}else {
							dp.setIsClinical("0");
						}
						Boolean isOK = dpSDAE.exeObj(dp);
						if(isOK) {
							JOptionPane.showMessageDialog(frame, "编号为："+ dpAENo.getText() + " 的科室信息 已成功修改！","科室信息修改提示",JOptionPane.PLAIN_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(frame, "修改科室信息 失败！","科室信息修改提示",JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(frame, "必须输入编号！","科室信息修改提示",JOptionPane.ERROR_MESSAGE);
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
		
		dpSDBtn dESDBtn = new dpSDBtn();
		dpSDBtn.addActionListener(dESDBtn);
		
		DpAETp dpAETp = new DpAETp();
		dpAEType.addActionListener(dpAETp);
		
		dpAEBtn dEAEBtn = new dpAEBtn();
		dpAEBtn.addActionListener(dEAEBtn);
		
		BackBtn bkBtn = new BackBtn();
		backBtn.addActionListener(bkBtn);
		
		frame.setResizable(false);
		frame.setSize(880, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
