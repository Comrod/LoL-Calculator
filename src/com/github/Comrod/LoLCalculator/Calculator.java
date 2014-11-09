package com.github.Comrod.LoLCalculator;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {

	
	//Main Frame
	JFrame frame = new JFrame();

	//Main Panel
	final JPanel panel = new JPanel(new BorderLayout());
	
	//AD Label
	JLabel adLbl = new JLabel("Enter AD");
	JLabel armorLbl = new JLabel("Enter Armor");
	JLabel farLbl = new JLabel("Enter Flat Armor Reduction");
	JLabel parLbl = new JLabel("Enter Percentage Armor Reduction");
	JLabel papLbl = new JLabel("Enter Percentage Armor Penetration");
	JLabel fapLbl = new JLabel("Enter Flat Armor Penetration");
	
	//AD Input
	JTextField adTxtF = new JTextField(20);
	JTextField armorTxtF = new JTextField(20);
	JTextField farTxtF = new JTextField(20);
	JTextField parTxtF = new JTextField(20);
	JTextField papTxtF = new JTextField(20);
	JTextField fapTxtF = new JTextField(20);
	
	//Calculate Button
	JButton calculateBut = new JButton("Calculate");
	
	private Float adInput, armorInput, farInput, parInput, papInput, fapInput, damageReduc, damageDeliv;
	
	public Calculator()
	{
		Calculator.ActionHandler handler = new Calculator.ActionHandler();
		
		this.panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		this.panel.add(adLbl);
		this.panel.add(armorLbl);
		this.panel.add(farLbl);
		this.panel.add(parLbl);
		this.panel.add(papLbl);
		this.panel.add(fapLbl);
		
		this.panel.add(adTxtF);
		this.panel.add(armorTxtF);
		this.panel.add(farTxtF);
		this.panel.add(parTxtF);
		this.panel.add(papTxtF);
		this.panel.add(fapTxtF);
		
		this.panel.add(calculateBut);
		
		this.calculateBut.addActionListener(handler);
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setTitle("LoL Calculator");
		this.frame.setSize(500, 450);
		this.frame.setLocationRelativeTo(null);
		this.frame.add(panel, BorderLayout.NORTH);
		this.frame.setVisible(true);
		this.frame.setResizable(false);
		
	}

	private class ActionHandler implements ActionListener
	{
		private ActionHandler(){
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == Calculator.this.calculateBut)
			{
				
				Calculator.this.adInput = Float.parseFloat(Calculator.this.adTxtF.getText());
				Calculator.this.armorInput = Float.parseFloat(Calculator.this.armorTxtF.getText());
				Calculator.this.farInput = Float.parseFloat(Calculator.this.farTxtF.getText());
				Calculator.this.parInput = Float.parseFloat(Calculator.this.parTxtF.getText());
				Calculator.this.papInput = Float.parseFloat(Calculator.this.papTxtF.getText());
				Calculator.this.fapInput = Float.parseFloat(Calculator.this.fapTxtF.getText());
				
				try
				{
					Float currentArmor = armorInput;
					System.out.println("Initial Armor: " + currentArmor);
					
					//Flat Armor Reduction
					currentArmor-= farInput;
					System.out.println("Armor after FAR: " + currentArmor);
					
					//Percentage Armor Reduction
					Float par;
					par = 1 - parInput;
					currentArmor = currentArmor*par;
					System.out.println("Armor after PAR: "+ currentArmor);
					
				}
				catch (Error error)
				{
					error.printStackTrace();
				}
			}
			
		}
	}
	
}
