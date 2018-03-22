package GUIs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import service.CashierService;

		
public class LoginFrame extends JFrame implements ActionListener {

	 JLabel userLabel = new JLabel("User");
	 JTextField userText = new JTextField(20);
	 JLabel passwordLabel = new JLabel("Password");
	 JPasswordField passwordText = new JPasswordField(20);
	 JButton loginButton = new JButton("login");
	 JFrame frame = new JFrame("Login Window");
	
	 CashierService cashierService = new CashierService();
	 
	 
	public LoginFrame()
	{
		
		frame.setSize(450, 450);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		
		JLabel background=new JLabel(new ImageIcon("images\\ut.png"));
		panel.add(background);
		
		frame.setVisible(true);
		panel.setLayout(null);

		
		userLabel.setBounds(10+50, 10+250, 80, 25);
		panel.add(userLabel);

		
		userText.setBounds(100+50, 10+250, 160, 25);
		panel.add(userText);

		
		passwordLabel.setBounds(10+50, 40+250, 80, 25);
		panel.add(passwordLabel);

		
		passwordText.setBounds(100+50, 40+250, 160, 25);
		panel.add(passwordText);

		
		loginButton.setBounds(10+150, 80+260, 80, 25);
		panel.add(loginButton);
		
		
		
		loginButton.addActionListener(this);
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
		boolean test = false;
		boolean test1 = false;
		boolean succesfulForAdmin = false;
		boolean succesfulForCashier = false;
		String pass = "";
		String pass1 = "";
		if (e.getSource() == loginButton) {
			try {
				 test  = cashierService.checkUserInAdmin(userText.getText());
				  pass = passwordText.getText();
				
				System.out.println("user " + userText.getText() + "\n");
				System.out.println("parola care ar trebui " + cashierService.givePasswordByUsernameAdmin(userText.getText()) + "\n");
				System.out.println("parola citita din field " + passwordText.getText() + "\n");
				System.out.println("parola citita din field encryptata " + encode(pass)+"\n");
				
				
				 if (cashierService.givePasswordByUsernameAdmin(userText.getText()).equals(encode(pass))) 
				 {
					 succesfulForAdmin = true;
					 System.out.println("Login Succesful for Admin");
				 }
				 else
				 {
					 succesfulForAdmin = false;
					 System.out.println("Login UnSuccesful for Admin");
						JOptionPane.showMessageDialog(null, "Password does not correspond to the given user!", "Error", JOptionPane.ERROR_MESSAGE);

				 }
				;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
//				JOptionPane.showMessageDialog(null, "Username not found!", "Error", JOptionPane.ERROR_MESSAGE);
				
				
				try {
					test1  = cashierService.checkUserInCashier(userText.getText());
					
					System.out.println(cashierService.givePasswordbyUsernameCashier(userText.getText()));
					pass1 = passwordText.getText();
					 if (cashierService.givePasswordbyUsernameCashier(userText.getText()).equals(encode(pass1))) 
					 {
						 succesfulForCashier = true;
						 System.out.println("Login Succesful for Cashier");
					 }
					 else 
					 {
						 succesfulForCashier = false;

						 System.out.println("Login Unsuccesful for Cashier");
							JOptionPane.showMessageDialog(null, "Password does not correspond to the given user!", "Error", JOptionPane.ERROR_MESSAGE);

					 }
					
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Username not found!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		finally 
		{
			
			
		}
			if (succesfulForAdmin) 
			{
				AdminFrame adminFrame = new AdminFrame();
				frame.dispose();
			}
			
			if (succesfulForCashier)
			{
				System.out.println(pass1);
				CashierFrame cashierFrame = new CashierFrame();
				frame.dispose();
			}
			
							// pressed
		}
		
		}
	

	}



