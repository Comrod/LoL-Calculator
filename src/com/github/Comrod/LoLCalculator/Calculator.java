package com.github.Comrod.LoLCalculator;

import java.awt.BorderLayout;
import java.awt.Component;
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
	final JPanel panelTxtF = new JPanel(new BorderLayout());
	final JPanel panelLbl = new JPanel (new BorderLayout());
	final JPanel panelBot = new JPanel (new BorderLayout());
	
	//AD Label
	JLabel adLbl = new JLabel("Enter Damage");
	JLabel armorLbl = new JLabel("Enter Armor");
	JLabel farLbl = new JLabel("Enter Flat Armor Reduction");
	JLabel parLbl = new JLabel("Enter Percentage Armor Reduction");
	JLabel papLbl = new JLabel("Enter Percentage Armor Penetration");
	JLabel fapLbl = new JLabel("Enter Flat Armor Penetration");
	JLabel finalDmg = new JLabel("Damage Delivered:");
	
	
	//AD Input
	JTextField adTxtF = new JTextField(20);
	JTextField armorTxtF = new JTextField(20);
	JTextField farTxtF = new JTextField(20);
	JTextField parTxtF = new JTextField(20);
	JTextField papTxtF = new JTextField(20);
	JTextField fapTxtF = new JTextField(20);
	
	//Calculate Button
	JButton calculateBut = new JButton("Calculate");
	
	private float adInput, armorInput, farInput, parInput, papInput, fapInput, damageReduc, damageDeliv;
	
	public Calculator()
	{
		Calculator.ActionHandler handler = new Calculator.ActionHandler();
		
		this.panelLbl.setLayout(new BoxLayout(panelLbl, BoxLayout.Y_AXIS));
		this.panelLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.panelLbl.setAlignmentY(Component.CENTER_ALIGNMENT);
		this.panelLbl.add(adLbl);
		this.panelLbl.add(armorLbl);
		this.panelLbl.add(farLbl);
		this.panelLbl.add(parLbl);
		this.panelLbl.add(papLbl);
		this.panelLbl.add(fapLbl);
		
		this.panelTxtF.setLayout(new BoxLayout(panelTxtF, BoxLayout.Y_AXIS));
		this.panelTxtF.setAlignmentX(Component.RIGHT_ALIGNMENT);
		this.panelTxtF.add(adTxtF);
		this.panelTxtF.add(armorTxtF);
		this.panelTxtF.add(farTxtF);
		this.panelTxtF.add(parTxtF);
		this.panelTxtF.add(papTxtF);
		this.panelTxtF.add(fapTxtF);
		
		this.panelBot.setLayout(new BoxLayout(panelBot, BoxLayout.Y_AXIS));
		this.panelBot.add(calculateBut);
		this.panelBot.add(finalDmg);
		
		this.calculateBut.addActionListener(handler);
		

		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setTitle("LoL Calculator");
		this.frame.setSize(300, 235);
		this.frame.setLocationRelativeTo(null);
		this.frame.add(panelLbl, BorderLayout.WEST);
		this.frame.add(panelTxtF, BorderLayout.CENTER);
		this.frame.add(panelBot, BorderLayout.SOUTH);
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
				
				if (Calculator.this.adTxtF.getText().isEmpty()){
					Calculator.this.adInput = (float) 0;
					System.out.println("Changed to zero 1");
				}
				else{
					Calculator.this.adInput = Float.parseFloat(Calculator.this.adTxtF.getText());
				}
				
				if (Calculator.this.armorTxtF.getText().isEmpty()){
					Calculator.this.armorInput = (float) 0;
					System.out.println("Changed to zero 2");
				}
				else{
					Calculator.this.armorInput = Float.parseFloat(Calculator.this.armorTxtF.getText());
				}
				
				if (Calculator.this.farTxtF.getText().isEmpty()){
					Calculator.this.farInput = (float) 0;
					System.out.println("Changed to zero 3");
				}
				else{
					Calculator.this.farInput = Float.parseFloat(Calculator.this.farTxtF.getText());
				}
				
				if (Calculator.this.parTxtF.getText().isEmpty()){
					Calculator.this.parInput = (float) 0;
					System.out.println("Changed to zero 4");
				}
				else{
					Calculator.this.parInput = Float.parseFloat(Calculator.this.parTxtF.getText());
				}
				
				if (Calculator.this.papTxtF.getText().isEmpty()){
					Calculator.this.papInput = (float) 0;
					System.out.println("Changed to zero 5");
				}
				else{
					Calculator.this.papInput = Float.parseFloat(Calculator.this.papTxtF.getText());
				}
				if (Calculator.this.fapTxtF.getText().isEmpty()){
					Calculator.this.fapInput = (float) 0;
					System.out.println("Changed to zero 6");
				}
				else{
					Calculator.this.fapInput = Float.parseFloat(Calculator.this.fapTxtF.getText());	
				}
				
				try
				{
					Float currentArmor = armorInput;
					System.out.println("Initial Armor: " + currentArmor);
					
					//Flat Armor Reduction
					currentArmor-= farInput;
					System.out.println("Armor after FAR: " + currentArmor);
					if (currentArmor < 0)
					{
						currentArmor = 0F;
					}
					
					//Percentage Armor Reduction
					float par = 1;
					if (parInput < 1 && parInput > 0)
					{
						par = 1 - parInput;
					}
					else if (parInput < 100 && parInput > 1)
					{
						par = (100 - parInput)/100;
					}
					
					currentArmor = currentArmor*par;
					System.out.println("Armor after PAR: "+ currentArmor);
					
					//Percentage Armor Penetration
					float pap = 1;
					if (papInput < 1 && papInput > 0)
					{
						pap = 1 - papInput;
					}
					else if (papInput < 100 && papInput > 1)
					{
						pap = (100 - papInput)/100;
					}
					
					currentArmor = currentArmor*pap;
					System.out.println("Armor after PAP: " + currentArmor);
					
					//Flat Armor Penetration
					currentArmor -= fapInput;
					System.out.println("Armor after FAP: " + currentArmor);
					if (currentArmor < 0)
					{
						currentArmor = 0F;
					}
					
					//Damage Reduction Calculation
					if (currentArmor >= 0)
					{
						damageReduc = 100/(100+currentArmor);
						damageDeliv = damageReduc*adInput;
					}
					else
					{
						//If armor is less than 0
						damageReduc = 2- (100/(100-currentArmor));
						damageDeliv = damageReduc*adInput;
					}
					System.out.println("Damage Reduction: " + damageReduc);
					System.out.println("Damage Delivered: " + damageDeliv);
					finalDmg.setText("Damage Delivered: " + damageDeliv);
				}
				catch (Error error)
				{
					error.printStackTrace();
				}
			}
			
		}
	}
	
}
