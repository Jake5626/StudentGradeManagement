package MainPage;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Data.Subject;
import Data.Others;

public class AddPage extends JFrame{
	
	private JButton button1;
	
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JTextField text4;
	private JTextField text5;
	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	
	public Subject subject;
	
	AddPage(){
		GUIInit();
	}
	
	private void GUIInit(){
		setSize(400,300);
		addComponet();
	}
	
	private String readFile(String textName){
		char contents[] = null;
		File file1 = new File(textName);
		try{
			FileReader fin = new FileReader(file1);
			contents = new char[(int)file1.length()];
			fin.read(contents);
			fin.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new String(contents);
	}
	
	private void addComponet(){
		MainPage mp = new MainPage();
		Others o = new Others();
		char contents[] = null;
		File file1 = new File("text1.txt");
		File file2 = new File("text2.txt");
		subject = new Subject();
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints s = new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;
		
		label1 = new JLabel("学号");
		label2 = new JLabel("姓名");
		label3 = new JLabel("成绩");
		label4 = new JLabel("排名");
		label5 = new JLabel("等级");
		text1 = new JTextField();
		text2 = new JTextField();
		text3 = new JTextField();
		text4 = new JTextField();
		text5 = new JTextField();
		
		button1 = new JButton("确认");
		this.setLayout(layout);
		this.add(label1);
		this.add(text1);
		this.add(label2);
		this.add(text2);
		this.add(label3);
		this.add(text3);
		this.add(label4);
		this.add(text4);
		this.add(label5);
		this.add(text5);
		this.add(button1);
		
		s.gridwidth = 1;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(label1, s);
		s.gridwidth = 0;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(text1,s);
		s.gridwidth = 1;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(label2, s);
		s.gridwidth = 0;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(text2,s);
		s.gridwidth = 1;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(label3, s);
		s.gridwidth = 0;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(text3,s);
		s.gridwidth = 1;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(label4, s);
		s.gridwidth = 0;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(text4,s);
		s.gridwidth = 1;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(label5, s);
		s.gridwidth = 0;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(text5,s);
		s.gridwidth = 0;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(button1,s);
		
		button1.addActionListener(Event->{
			try {
				if(o.getIndex_number() == 0){
					String buff = readFile("text.txt");
					FileWriter fileW = new FileWriter("text.txt");
					System.out.println(buff);
					fileW.write(buff+"\r\n"+text1.getText()+" "+text2.getText()+" "+text3.getText()+" "+text4.getText()+" "+text5.getText());
					fileW.close();
					JOptionPane.showMessageDialog(null, "修改成功！","提示信息",JOptionPane.PLAIN_MESSAGE);
				}
				if(o.getIndex_number() == 1){
					FileWriter fileW = new FileWriter("text2.txt");
					fileW.write(text1.getText()+" "+text2.getText()+" "+text3.getText()+""+text4.getText()+" "+text5.getText()+"\n");
					fileW.close();
					JOptionPane.showMessageDialog(null, "修改成功！","提示信息",JOptionPane.PLAIN_MESSAGE);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}
