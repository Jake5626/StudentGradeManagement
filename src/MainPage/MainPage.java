package MainPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Event;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Data.Subject;
import Data.Others;

public class MainPage  extends JFrame implements ActionListener{
	/**
	 * 
	 */
	DefaultTableModel dm = new DefaultTableModel();
	
	private static final long serialVersionUID = 1L;
	private JComboBox comboBox_subject;
	private JButton button_update;
	private JTextField text_subject;
	private JTable table_score = new JTable(dm);
	private JLabel label_subject;
	private JScrollPane scrollPane;
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
	
	private void addComponet(Object subject[]){
		MainPage mp = new MainPage();
		Others o = new Others();

        String[] columnNames = { "学号", "姓名", "成绩","排名","等级" };
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints s  = new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;
		
		
		JPanel panel_blank1 = new JPanel(null);
		JPanel panel_blank2 = new JPanel(null);
		
		
		text_subject = new JTextField("科目");
		label_subject = new JLabel("科目");
		button_update = new JButton("OK");
		comboBox_subject = new JComboBox<Object>(subject);
		scrollPane = new JScrollPane();
		
		table_score.setRowMargin(0);
		table_score.getTableHeader().setVisible(true);
		scrollPane.setViewportView(table_score);
		
		this.setLayout(layout);
		this.add(panel_blank1);
		this.add(label_subject);
		this.add(comboBox_subject);
		
		comboBox_subject.addActionListener(Event->{
			System.out.println(comboBox_subject.getSelectedIndex());
			switch(comboBox_subject.getSelectedIndex()){
				case 0:		
								o.setIndex_number(comboBox_subject.getSelectedIndex());
								table_score.removeAll();
								table_score.setModel(new DefaultTableModel(mp.listToObject(mp.readFile("text.txt")),columnNames));
								table_score.updateUI();
				break;
				case 1:		
								o.setIndex_number(comboBox_subject.getSelectedIndex());
								table_score.removeAll();
								table_score.setModel(new DefaultTableModel(mp.listToObject(mp.readFile("text2.txt")),columnNames));
								table_score.updateUI();
				break;
				}
		});
	
		button_update.addActionListener(Event->{
			AddPage addPage = new AddPage();
			addPage.setVisible(true);
		});
		
		this.add(scrollPane);
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
		layout.setConstraints(scrollPane, s);
		s.gridwidth = 1;
		s.weightx = 0.8;
		s.weighty = 0;
		layout.setConstraints(panel_blank2, s);
		s.gridwidth = 0;
		s.weightx = 0;
		s.weighty = 0;
		layout.setConstraints(button_update, s);
	}
	
	private List<Subject> readFile(String fileRoute){
		score = new ArrayList<Subject>();
		file = new File(fileRoute);
		try{
			BufferedReader fin = new BufferedReader(new FileReader(file));
			String line ;
			while((line=fin.readLine())!=null){
				String[] splitLine = line.split(" ");
				Subject sub = new Subject();
				sub.setId(splitLine[0]);
				sub.setName(splitLine[1]);
				sub.setScore(splitLine[2]);
				sub.setRank(splitLine[3]);
				sub.setLevel(splitLine[4]);
				score.add(sub);
			}

			fin.close();
		}catch(FileNotFoundException fe){
			System.out.println("File not found");
		}catch(IOException ioex){
			System.out.println("IO not found");
		}
		System.out.println(score);
		return score;
	}
	
	private Object[][] listToObject(List<Subject> score){
		int size = score.size();
		Object[][] target = new Object[size][5];
		for(int i = 0;i<score.size();i++){
			Subject sco = score.get(i);
			target[i][0] = sco.getId();
			target[i][1] = sco.getName();
			target[i][2] = sco.getScore();
			target[i][3] = sco.getRank();
			target[i][4] = sco.getLevel();
		}
		return target;
	}
	
	public static void main(String args[]){
		Object subject[] = {"高等数学","线性代数"};
		MainPage mainpage = new MainPage();
		mainpage.addComponet(subject);
		mainpage.setVisible(true);
	}
                                                                                                                                                                                                                                                                        
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
