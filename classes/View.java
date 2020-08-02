package classes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;

public class View extends JFrame {
	private static final long serialVersionUID = 1L;
	public JLabel lbl_verb;
	public JTextField txt_past;
	public JTextField txt_pp;
	public JTextField txt_spanish;
	public JButton btn_check;
	public JButton btn_answer;
	public JLabel lbl_count1;
	public JLabel lbl_count2;

	public View() {
		initComponents();
	}
	
	private void initComponents() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e) {
			System.out.println(e);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl_verb = new JLabel("Verb", SwingConstants.CENTER);
		lbl_verb.setBorder(new EmptyBorder(5, 5, 5, 5));
		lbl_verb.setOpaque(true);
		lbl_verb.setForeground(Color.BLACK);
		lbl_verb.setBackground(Color.WHITE);
		lbl_verb.setBounds(27, 12, 387, 58);
		contentPane.add(lbl_verb);
		
		JLabel lbl_past = new JLabel("Past:");
		lbl_past.setForeground(SystemColor.text);
		lbl_past.setBounds(75, 109, 70, 15);
		contentPane.add(lbl_past);
		
		txt_past = new JTextField();
		txt_past.setBounds(135, 107, 114, 25);
		contentPane.add(txt_past);
		txt_past.setColumns(10);
		
		JLabel lbl_pp = new JLabel("P. Participle:");
		lbl_pp.setForeground(Color.WHITE);
		lbl_pp.setBounds(27, 147, 90, 15);
		contentPane.add(lbl_pp);
		
		txt_pp = new JTextField();
		txt_pp.setColumns(10);
		txt_pp.setBounds(135, 143, 114, 25);
		contentPane.add(txt_pp);
		
		JLabel lbl_spanish = new JLabel("Spanish:");
		lbl_spanish.setForeground(Color.WHITE);
		lbl_spanish.setBounds(58, 187, 70, 15);
		contentPane.add(lbl_spanish);
		
		txt_spanish = new JTextField();
		txt_spanish.setColumns(10);
		txt_spanish.setBounds(135, 185, 114, 25);
		contentPane.add(txt_spanish);
		
		btn_check = new JButton("Check");
		btn_check.setBounds(297, 127, 117, 25);
		contentPane.add(btn_check);
		
		btn_answer = new JButton("Answer");
		btn_answer.setBounds(297, 164, 117, 25);
		contentPane.add(btn_answer);
		
		JLabel lbl_answered = new JLabel("Answered:");
		lbl_answered.setForeground(Color.WHITE);
		lbl_answered.setBounds(27, 242, 76, 15);
		contentPane.add(lbl_answered);
		
		JLabel lbl_remaining = new JLabel("Ramaining:");
		lbl_remaining.setForeground(Color.WHITE);
		lbl_remaining.setBounds(318, 242, 80, 15);
		contentPane.add(lbl_remaining);
		
		lbl_count1 = new JLabel("", SwingConstants.CENTER);
		lbl_count1.setForeground(Color.WHITE);
		lbl_count1.setBounds(109, 242, 25, 15);
		contentPane.add(lbl_count1);
		
		lbl_count2 = new JLabel("", SwingConstants.CENTER);
		lbl_count2.setForeground(Color.WHITE);
		lbl_count2.setBounds(401, 242, 25, 15);
		contentPane.add(lbl_count2);
	}
}
