package GUIs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bussinessModel.*;
import service.CashierService;

		
public class UpdateCashierFrame extends JFrame implements ActionListener {

	 JLabel userLabel = new JLabel("Username");
	 JLabel userLabel1 = new JLabel("Lastname");
	 
	 JTextField userText = new JTextField(20);
	 JTextField userText1 = new JTextField(20);

	 JButton updateCashierLastnameBtn = new JButton("Update");

	 CashierService cashierService = new CashierService();

	 
JComboBox genreList = new JComboBox();
	 
	 {
	 try {
		    String[] titleCmb = new String[10];
		    int i = 0;
		    
			List<Cashier> lista = cashierService.displayAllCashiers();
			
			for (Cashier iterator : lista) {
				String da = iterator.getUsername();
				
				titleCmb[i] = da;
				i++;

			}
			
			 genreList = new JComboBox(titleCmb);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 }
	 
	public UpdateCashierFrame()
	{
		JFrame frame = new JFrame("Register Window");
		frame.setSize(300, 150);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);

		frame.setVisible(true);
		panel.setLayout(null);

		
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);
		
		userLabel1.setBounds(10, 40, 80, 25);
		panel.add(userLabel1);
		panel.add(genreList);
		
		
		
		genreList.setBounds(100, 10, 160, 25);
		panel.add(userText);
		panel.add(userText1);
		userText1.setBounds(100, 40, 160, 25);
		

		
		
		updateCashierLastnameBtn.setBounds(100, 70, 80, 25);
		panel.add(updateCashierLastnameBtn);
		updateCashierLastnameBtn.addActionListener(this);
		
	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == updateCashierLastnameBtn)
		{

			try {
				
				
				cashierService.updateCashierLastname(String.valueOf(genreList.getSelectedItem()), userText1.getText());
				JOptionPane.showMessageDialog(null, "Cashier`s lastname succesfully updated!", "Error", JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
							// pressed
		}

	}



}