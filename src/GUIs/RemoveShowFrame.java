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

		
public class RemoveShowFrame extends JFrame implements ActionListener {

	 JLabel titleLbl = new JLabel("Title");
	 JTextField titleTxt = new JTextField(20);
	 JButton deleteShowBtn = new JButton("Delete");
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
	
	public RemoveShowFrame()
	{
		JFrame frame = new JFrame("Remove Show Window");
		frame.setSize(300, 150);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		panel.add(genreList);
		frame.setVisible(true);
		panel.setLayout(null);

		
		titleLbl.setBounds(10, 10, 80, 25);
		panel.add(titleLbl);
		
		
		
		genreList.setBounds(100, 10, 160, 25);

		

		
		
		deleteShowBtn.setBounds(100, 70, 80, 25);
		panel.add(deleteShowBtn);
		deleteShowBtn.addActionListener(this);
		
	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == deleteShowBtn)
		{
			try {
				int noTick = showService.noOfTicketSoldForAShow(String.valueOf(genreList.getSelectedItem()));
				
				if (noTick ==0) 
				{
					showService.removeShowByTitle(String.valueOf(genreList.getSelectedItem()));
					JOptionPane.showMessageDialog(null, "Show succesfuly deleted!", "Check", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Ticket already sold, gotta keep goin with the show bro!", "Error", JOptionPane.ERROR_MESSAGE);

				}
				
				

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Title does not exist in the database!", "Error", JOptionPane.ERROR_MESSAGE);

			}
			
			
							// pressed
		}

	}



}