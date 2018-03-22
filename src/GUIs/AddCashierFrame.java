package GUIs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bussinessModel.*;
import service.CashierService;
		
public class AddCashierFrame extends JFrame implements ActionListener {

	 JLabel userLabel = new JLabel("User");
	 JTextField userText = new JTextField(20);
	 JLabel passwordLabel = new JLabel("Password");
	 JLabel passwordLabel2 = new JLabel("Confirm");
	 JPasswordField userText2 = new JPasswordField(20);
	 JPasswordField passwordText = new JPasswordField(20);
	 JButton addCashierBtn = new JButton("Add");
	 JLabel firstnameLbl = new JLabel("Firstname");
	 JLabel lastnameLbl = new JLabel("Lastname");
	 
	 JTextField firstnameTxt = new JTextField(20);
	 JTextField lastnameTxt = new JTextField(20);
	 
	 CashierService cashierService = new CashierService();
	
	public AddCashierFrame()
	{
		JFrame frame = new JFrame("Register Window");
		frame.setSize(300, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);

		frame.setVisible(true);
		panel.setLayout(null);

		
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);
		panel.add(firstnameLbl);
		panel.add(lastnameLbl);
		panel.add(firstnameTxt);
		panel.add(lastnameTxt);
		
		userText2.setBounds(100, 70 ,160, 25);
		panel.add(userText2);
		
		firstnameTxt.setBounds(100, 100 ,160, 25);
		lastnameTxt.setBounds(100, 130 ,160, 25);
		
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		passwordLabel2.setBounds(10,70,80,25);
		panel.add(passwordLabel2);
		
		firstnameLbl.setBounds(10,100,80,25);
		lastnameLbl.setBounds(10,130,80,25);

		
		
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		
		
		addCashierBtn.setBounds(100, 180, 80, 25);
		panel.add(addCashierBtn);
		addCashierBtn.addActionListener(this);
		
	}
	

	public static String encode(String password)
    {
        String passwordToHash = password;
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == addCashierBtn)
		{
			if (userText2.getText().equals(passwordText.getText())) 
			{
				try {
					int allow = cashierService.checkIfUsernameExistsAlreadyInTheDatabase(userText.getText());
					
					if (allow == 1)  
					{
						JOptionPane.showMessageDialog(null, "Username already exists in the database!", "Error", JOptionPane.ERROR_MESSAGE);

					}
					else
					{
						Cashier cashier1 = new Cashier();
						
							cashier1.setUsername(userText.getText());
							cashier1.setPassword(encode(passwordText.getText()));
							cashier1.setFirstname(firstnameTxt.getText());
							cashier1.setLastname(lastnameTxt.getText());
						
						cashierService.insertCashier(cashier1);
						JOptionPane.showMessageDialog(null, "Cashier succesfuly added!", "Check", JOptionPane.INFORMATION_MESSAGE);
					}
					

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);

			}
			
							// pressed
		}

	}



}