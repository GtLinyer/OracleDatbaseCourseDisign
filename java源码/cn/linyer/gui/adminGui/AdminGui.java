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
import javax.swing.JPanel;

/**
 * @author Linyer
 * 管理员管理主界面
 * 
 */
public class AdminGui {
	static JFrame frame = new JFrame("管理员管理");
	private JPanel panelNorth = new JPanel();
	private JPanel panelCenter = new JPanel();
	
	private JLabel label;
	private JLabel typeLabel = new JLabel("管理对象：");
	private JComboBox<String> type = new JComboBox<String>();
	private JButton yes = new JButton("确定");
	
	private Font fontMid = new Font("华文楷体",Font.PLAIN,24);
	
	public AdminGui(String adName) {
		//欢迎管理员
		label = new JLabel("管理员：" + adName + "，欢迎您！");
		//布局
		frame.setLayout(new BorderLayout());
		panelCenter.setLayout(new GridLayout(1,2));
		//设置各个组件的属性
		label.setFont(new Font("华文琥珀",Font.BOLD,36));
		label.setForeground(new Color(220, 118, 51));
		typeLabel.setFont(fontMid);
		type.setFont(fontMid);
		yes.setFont(fontMid);
		//添加组件
		panelCenter.add(typeLabel);
		panelCenter.add(type);
		//为下拉框添加选项
		type.addItem("医师基本信息");
		type.addItem("医师职业信息");
		type.addItem("科室信息");
		type.addItem("患者信息");
		
		frame.add(panelNorth,BorderLayout.NORTH);
		frame.add(panelCenter,BorderLayout.CENTER);
		frame.add(yes,BorderLayout.SOUTH);
		
		panelNorth.add(label);
		
		class YesButton implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String manageTp = (String) type.getSelectedItem();
				if(manageTp.equals("医师基本信息")) {
					new DoctorManagerGui();
					frame.setVisible(false);
				}else if(manageTp.equals("医师职业信息")) {
					new DoctorEmpManagerGui();
					frame.setVisible(false);
				}else if(manageTp.equals("科室信息")) {
					new DepartmentManagerGui();
					frame.setVisible(false);
				}else if(manageTp.equals("患者信息")) {
					new PatientManagerGui();
					frame.setVisible(false);
				}
			}
		}
		
		YesButton yesButton = new YesButton();
		yes.addActionListener(yesButton);
		
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
