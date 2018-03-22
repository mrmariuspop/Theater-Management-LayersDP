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
import service.ShowService;

		
public class UpdateShowFrame extends JFrame implements ActionListener {

	 JLabel titleLbl = new JLabel("Title");
	 JLabel newDateLbl = new JLabel("New Date");
	 
	 JTextField titleTxt = new JTextField(20);
	 JTextField newDateTxt = new JTextField(20);

	 JButton updateNewDateBtn = new JButton("Update");
	 JComboBox genreList = new JComboBox();
	 
	 ShowService showService = new ShowService();
	 
	 {
	 try {
		    String[] titleCmb = new String[10];
		    int i = 0;
		    
			List<Show> lista = showService.displayAllShows();
			
			for (Show iterator : lista) {
				String da = iterator.getTitle();
				
				titleCmb[i] = da;
				i++;

			}
			
			 genreList = new JComboBox(titleCmb);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 }
	
	public UpdateShowFrame()
	{
		JFrame frame = new JFrame("Update Show Date Window");
		frame.setSize(300, 150);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		panel.add(genreList);
		frame.setVisible(true);
		panel.setLayout(null);

		
		titleLbl.setBounds(10, 10, 80, 25);
		panel.add(titleLbl);
		
		newDateLbl.setBounds(10, 40, 80, 25);
		panel.add(newDateLbl);
		
		
		
		genreList.setBounds(100, 10, 160, 25);
		panel.add(titleTxt);
		panel.add(newDateTxt);
		newDateTxt.setBounds(100, 40, 160, 25);
		

		
		
		updateNewDateBtn.setBounds(100, 70, 80, 25);
		panel.add(updateNewDateBtn);
		updateNewDateBtn.addActionListener(this);
		
	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == updateNewDateBtn)
		{
//			System.out.println("username   = " + userText.getText() + "\n");
//			System.out.println("lastname   = " + userText1.getText() + "\n");

			try {
				
				showService.updateShowDate(String.valueOf(genreList.getSelectedItem()), newDateTxt.getText());
				JOptionPane.showMessageDialog(null, "Show`s date succesfully updated!", "Error", JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Invalid Date!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
							// pressed
		}

	}



}