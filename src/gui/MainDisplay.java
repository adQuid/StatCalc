package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import info.clearthought.layout.TableLayout;
import math.MathButtonFactory;

public class MainDisplay {

	private static JFrame GUI = new JFrame("Stat Calc");
	public static JTextArea inputArea = new JTextArea();
	public static JLabel answer = new JLabel("");
			
	public static void display() {
		//TODO: make this less absurd
		List<Double> layoutSizes = new ArrayList<Double>();
		layoutSizes.add(TableLayout.FILL);
		for(MathButtonFactory.MathType current: MathButtonFactory.MathType.values()) {
			layoutSizes.add(30.0);
		}
		layoutSizes.add(50.0);		
		double[][] size = {{TableLayout.FILL},new double[layoutSizes.size()]};
		for(int i=0; i<layoutSizes.size(); i++) {
			size[1][i] = layoutSizes.get(i);
		}
						
		GUI.setLayout(new TableLayout(size));
		
		GUI.add(inputArea,"0,0");
		List<JButton> buttons = MathButtonFactory.buttons();
		for(int i=0; i<buttons.size(); i++) {
			GUI.add(buttons.get(i),"0,"+(i+1));
		}
		GUI.add(answer,"0,"+(buttons.size()+1));
		
		GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		GUI.pack();
		GUI.setSize(400,600);
		GUI.setVisible(true);
	}
	
}
