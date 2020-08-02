package classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Controller {
	private Random r = new Random();
	private View view;
	private ArrayList<Verb> verbs;
	private Verb current;
	
	public Controller(View view) {
		this.view = view;
		
		view.btn_check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(view.txt_past.getText().equals("") || view.txt_pp.getText().equals("") || view.txt_spanish.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos");
					return;
				}
				
				boolean next = false;
				if(view.txt_past.getText().equals(current.getPast())  && view.txt_pp.getText().equals(current.getPartiple())
						&& view.txt_spanish.getText().equals(current.getMeaning())) {
					JOptionPane.showMessageDialog(null, "Correcto!");
					next = true;
				}else {
					JOptionPane.showMessageDialog(null, "Incorrecto :(");
				}
				
				view.txt_past.setText("");
				view.txt_pp.setText("");
				view.txt_spanish.setText("");
				
				if(!next) return;
				
				if(!verbs.isEmpty()) {
					current = verbs.remove(r.nextInt(verbs.size()));
					view.lbl_verb.setText(current.getVerb());
					
					int count1 = Integer.parseInt(view.lbl_count1.getText()) + 1;
					view.lbl_count1.setText(String.valueOf(count1));
					view.lbl_count2.setText(String.valueOf(verbs.size()));
				}else {
					JOptionPane.showMessageDialog(null, "Se han terminado los verbos, se volvera a cargar la lista");
					start();
				}
			}
		});
		
		view.btn_answer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.txt_past.setText(current.getPast());
				view.txt_pp.setText(current.getPartiple());
				view.txt_spanish.setText(current.getMeaning());
			}
		});
	}
	
	public void start() {
		view.setVisible(true);
		verbs = getVerbs();
		if(!verbs.isEmpty()) {
			current = verbs.remove(r.nextInt(verbs.size()));
			view.lbl_verb.setText(current.getVerb());
			view.lbl_count1.setText("0");
			view.lbl_count2.setText(String.valueOf(verbs.size()));
		}
		
		
	}
	
	private ArrayList<Verb> getVerbs(){
		ArrayList<Verb> verbs = new ArrayList<Verb>();
		String line = "";
		try {
			
			InputStream in = getClass().getResourceAsStream("verbs.txt");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(in)); 
			while((line = buffer.readLine()) != null) {
				String[] parts = line.split("-");
				Verb verb = new Verb(parts[0], parts[1], parts[2], parts[3]);
				verbs.add(verb);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return verbs;
	}
	
	public static void main(String[] args) {
		View view = new View();
		Controller controller = new Controller(view);
		controller.start();
	}

}
