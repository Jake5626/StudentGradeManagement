package MainPage;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Data.Subject;

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
	
	private List<Subject> score;
	
	
	public MainPage(){
		GUIInit();
	}
	
	private void GUIInit(){
		setSize(800,600);
		setTitle("学生成绩管理系统");
		//getContentPane().setLayout(new GridLayout(3,1));;
		setLocationRelativeTo(null);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	
	private void addComponet(Object subject[],Object[][] data){
		//comboBox_subject = new JComboBox(subject);
        String[] columnNames = { "Name", "SchoolID", "Subject","Score" };
//        Object[][] data = {
//        		{ "Kathy", "Smith", "Snowboarding", new Integer(5),new Boolean(false) },
//        		{ "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
//        		{ "Sue", "Black", "Knitting", new Integer(2),new Boolean(false) },
//        		{ "Jane", "White", "Speed reading", new Integer(20),new Boolean(true) },
//        		{ "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) }};
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints s  = new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;
		
		
		JPanel panel_blank1 = new JPanel(null);
		JPanel panel_blank2 = new JPanel(null);
		
		//panel_blank.setBackground(Color.BLACK);
		
		text_subject = new JTextField("科目");
		label_subject = new JLabel("科目");
		button_update = new JButton("更改");
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
	
	private List<Subject> readFile(){
		score = new ArrayList<Subject>();
		file = new File("C:/Users/zhz/Desktop/text.txt");
		try{
//			FileReader fin = new FileReader(file);
			BufferedReader fin = new BufferedReader(new FileReader(file));
//			contents = new char[(int)file.length()];
			String line ;
			while((line=fin.readLine())!=null){
				String[] splitLine = line.split(" ");
				Subject sub = new Subject();
				sub.setId(splitLine[0]);
				sub.setName(splitLine[1]);
				sub.setSubject(splitLine[2]);
				sub.setScore(splitLine[3]);
				score.add(sub);
			}
//			fin.read(contents);

			fin.close();
		}catch(FileNotFoundException fe){
			System.out.println("File not found");
		}catch(IOException ioex){
			System.out.println("IO not found");
		}
//		System.out.println(new String(contents));
		System.out.println(score);
		return score;
	}
	
	private Object[][] listToObject(List<Subject> score){
		int size = score.size();
		Object[][] target = new Object[size][4];
		for(int i = 0;i<score.size();i++){
			Subject sco = score.get(i);
			target[i][0] = sco.getId();
			target[i][1] = sco.getName();
			target[i][2] = sco.getSubject();
			target[i][3] = sco.getScore();
		}
		return target;
	}
	
	public static void main(String args[]){
		Object subject[] = {"高等数学","线性代数"};
		MainPage mainpage = new MainPage();
		mainpage.addComponet(subject, mainpage.listToObject(mainpage.readFile()));
		mainpage.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
