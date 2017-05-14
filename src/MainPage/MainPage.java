package MainPage;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MainPage  extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox comboBox_subject;
	private JButton button_update;
	private JTextField text_subject;
	private JTable table_score;
	private JLabel label_subject;
	private Object subject[];
	
	private File file;
	
	
	public MainPage(Object subject[]){
		GUIInit();
		addComponet(subject);
	}
	
	private void GUIInit(){
		setSize(800,600);
		setTitle("ѧ���ɼ�����ϵͳ");
		//getContentPane().setLayout(new GridLayout(3,1));;
		setLocationRelativeTo(null);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	private void addComponet(Object subject[]){
		//comboBox_subject = new JComboBox(subject);
        String[] columnNames = { "Name", "SchoolID", "Grade","","" };
        Object[][] data = {
        		{ "Kathy", "Smith", "Snowboarding", new Integer(5),new Boolean(false) },
        		{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
        		{ "Sue", "Black", "Knitting", new Integer(2),new Boolean(false) },
        		{ "Jane", "White", "Speed reading", new Integer(20),new Boolean(true) },
        		{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) }};
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints s  = new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;
		
		
		JPanel panel_blank1 = new JPanel(null);
		JPanel panel_blank2 = new JPanel(null);
		
		//panel_blank.setBackground(Color.BLACK);
		
		text_subject = new JTextField("��Ŀ");
		label_subject = new JLabel("��Ŀ");
		button_update = new JButton("����");
		comboBox_subject = new JComboBox<Object>(subject);
		table_score = new JTable(data,columnNames);
		
		table_score.setRowMargin(0);
		
		this.setLayout(layout);
		this.add(panel_blank1);
		this.add(label_subject);
		this.add(comboBox_subject);
		this.add(table_score);
		this.add(panel_blank2);
		this.add(button_update);
		
		s.gridwidth = 1;
		s.weightx = 0.5;
		s.weighty = 0;
		layout.setConstraints(panel_blank1, s);
		s.gridwidth = 1;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(label_subject, s);
		s.gridwidth = 0;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(comboBox_subject, s);
		s.gridwidth = 0;
		s.weightx = 0;
		s.weighty = 0.8;
		layout.setConstraints(table_score, s);
		s.gridwidth = 1;
		s.weightx = 0.8;
		s.weighty = 0;
		layout.setConstraints(panel_blank2, s);
		s.gridwidth = 0;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(button_update, s);
	}
	
	private String readFile(){
		char contents[] = null;
		file = new File("C:/Users/zhz/Desktop/text.txt");
		try{
			FileReader fin = new FileReader(file);
			contents = new char[(int)file.length()];
			fin.read(contents);
			fin.close();
		}catch(FileNotFoundException fe){
			System.out.println("File not found");
		}catch(IOException ioex){
			System.out.println("IO not found");
		}
		System.out.println(new String(contents));
		return new String(contents);
	}
	
	public static void main(String args[]){
		Object subject[] = {"�ߵ���ѧ","���Դ���"};
		MainPage mainpage = new MainPage(subject);
		mainpage.readFile();
		mainpage.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
