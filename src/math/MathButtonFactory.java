package math;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import gui.MainDisplay;

public class MathButtonFactory {

	private static math.Math math = new math.Math();
	private static parse.Parser parser = new parse.Parser(); 
	
	public static List<JButton> buttons(){
		ArrayList<JButton> retval = new ArrayList<JButton>();
		
		for(MathType type: MathType.values()) {
			JButton button = genericButton(type);
			retval.add(button);
		}
				
		return retval;
	}
	
	public enum MathType{
		Mean,Variance,Standard_Deviation,Standard_Error;
	}
	
	private static class MathListener implements ActionListener {

		private MathType type;
		
		public MathListener(MathType type) {
			this.type = type;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			BigDecimal[] parsedResult = parser.findNumbers(MainDisplay.inputArea.getText());
			String result = "ERROR";
			switch(type) {
			case Mean:
				result = math.mean(parsedResult).toString();
				break;
			case Variance:
				result = math.variance(parsedResult).toString();
				break;
			case Standard_Deviation:
				result = math.standardDeviation(parsedResult).toString();
				break;
			case Standard_Error:
				result = math.standardError(parsedResult).toString();
				break;
			}
			MainDisplay.answer.setText(result);
		}		
	}
	
	private static JButton genericButton(MathType type) {
		JButton retval = new JButton("Calculate "+type);
		retval.addActionListener(new MathListener(type));
		return retval;
	}
	
}
