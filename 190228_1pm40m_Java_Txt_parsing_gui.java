import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.*;

public class Java_Txt_parsing_gui extends JFrame implements ActionListener {

	private JLabel enterName;
	private JTextField name;
	private JButton click;
    private String DirectoryPath = "dd";

	
//	private String DirectoryPath = "C:\\Users\\byeonghooh\\eclipse-workspace\\Java_Reading_Txtfile_Text_01\\combine\\More1";


	public Java_Txt_parsing_gui() { // Constructor
		
		
		setLayout(null);
		setSize(300, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		enterName = new JLabel("Enter the directory Path");
		click = new JButton("Click");
		name = new JTextField();
		enterName.setBounds(60, 30, 120, 30);
		name.setBounds(80, 60, 130, 30);
		click.setBounds(100, 190, 60, 30);
		click.addActionListener(this); // point to ActionListener

		add(click);
		add(name);
		add(enterName);

	}
		
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == click) {
		
			DirectoryPath = name.getText();
			
			JOptionPane.showMessageDialog(null, "DP :" + DirectoryPath );
//			System.exit(0);
		}
		
		}
	public String getDirectoryPath () {
		System.out.println("GUI class 내 getDirectoryPath() 함수 값 " + DirectoryPath);
		return DirectoryPath;
	}

}





