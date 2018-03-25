package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import service.CashierService;
import bussinessModel.*;
		
public class RemoveCashierFrame extends JFrame implements ActionListener {

	 JLabel userLabel = new JLabel("Username");
	 JTextField userText = new JTextField(20);
	 JButton deleteCashierBtn = new JButton("Delete");
	 JComboBox genreList = new JComboBox();
	 
	 
	 CashierService cashierService = new CashierService();
	 
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
	 
	 
	public RemoveCashierFrame() throws Exception
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
		
		
		panel.add(genreList);
		genreList.setBounds(100, 10, 160, 25);
		panel.add(userText);

		
		
		
		
		deleteCashierBtn.setBounds(100, 70, 80, 25);
		panel.add(deleteCashierBtn);
		deleteCashierBtn.addActionListener(this);
		
	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == deleteCashierBtn)
		{
			try {
				Cashier cashier1 = new Cashier();
				
				cashierService.removeCashierbyUsername(String.valueOf(genreList.getSelectedItem()));
				JOptionPane.showMessageDialog(null, "Cashier succesfuly deleted!", "Check", JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Username does not exist in the database!", "Error", JOptionPane.ERROR_MESSAGE);

			}
			
			
							// pressed
		}

	}



}