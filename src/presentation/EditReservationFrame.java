package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
import service.TicketService;

		
public class EditReservationFrame extends JFrame implements ActionListener {
		boolean flag = false;
		boolean flagx = false;
	
	 JLabel titleLbl = new JLabel("Title");
	 JLabel rowLbl = new JLabel("Row");
	 JLabel colLbl = new JLabel("Col");
	 
	 JLabel newRowLbl = new JLabel("New Row");
	 JLabel newColLbl = new JLabel("New Col");
	 
	 JLabel oldRowLbl = new JLabel("Old Row");
	 JLabel oldColLbl = new JLabel("Old Col");
	 
	 JTextField oldRowTxt = new JTextField(20);
	 JTextField oldColTxt = new JTextField(20);
	 
	 JTextField titleTxt = new JTextField(20);
	 JTextField rowTxt = new JTextField(20);
	 JTextField colTxt = new JTextField(20);


	 JButton editBtn = new JButton("Edit");
	 JButton editRowBtn = new JButton("Edit Row");
	 JButton editColBtn = new JButton("Edit Col");
	 
	 TicketService ticketService = new TicketService();
	 	ShowService showService = new ShowService();

 JComboBox genreList = new JComboBox();
	 
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
	 
	public EditReservationFrame()
	{
		JFrame frame = new JFrame("Edit Reservation");
		frame.setSize(550, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);

		frame.setVisible(true);
		panel.setLayout(null);

		panel.add(editRowBtn);
		panel.add(editColBtn);
		
		
		panel.add(newRowLbl);
		panel.add(newColLbl);
		panel.add(oldRowTxt);
		panel.add(oldRowLbl);
		panel.add(oldColTxt);
		panel.add(oldColLbl);
		
		oldRowLbl.setBounds(275,40,80,25);
		oldColLbl.setBounds(275,70,80,25);
		oldRowTxt.setBounds(350,40,150,25);
		oldColTxt.setBounds(350,70,150,25);
		
		oldRowLbl.setVisible(false);
		oldColLbl.setVisible(false);
		oldRowTxt.setVisible(false);
		oldColTxt.setVisible(false);

		
		
		
		newRowLbl.setBounds(10,40,80,25);
		newRowLbl.setVisible(false);
		
		newColLbl.setBounds(10,70,80,25);
		newColLbl.setVisible(false);
		
		
		
		editRowBtn.setBounds(100,220,100,25);
		editColBtn.setBounds(220,220,100,25);
		editBtn.setVisible(false);

		
		titleLbl.setBounds(10, 10, 80, 25);
		panel.add(titleLbl);
		
		rowLbl.setBounds(10, 40, 80, 25);
		panel.add(rowLbl);
		panel.add(colLbl);
		panel.add(colTxt);
		
		colLbl.setBounds(10,70,80,25);
		colTxt.setBounds(100,70,160,25);
		
		panel.add(genreList);
		genreList.setBounds(100, 10, 160, 25);
		panel.add(titleTxt);
		panel.add(rowTxt);
		rowTxt.setBounds(100, 40, 160, 25);
		

		
		
		editBtn.setBounds(100, 120, 80, 25);
		panel.add(editBtn);
		editBtn.addActionListener(this);
		editRowBtn.addActionListener(this);
		editColBtn.addActionListener(this);

	}
	

	
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == editBtn && flag == true && flagx == false)
		{
			System.out.println(flag);
			System.out.println(flagx);
			
			try {
				int aux = Integer.parseInt(rowTxt.getText());
				int aux1 = Integer.parseInt(colTxt.getText());
			} catch (NumberFormatException e2) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Invalid seat format!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			try {
				
				boolean checkIfSeatTaken = ticketService.checkIfSeatTaken(String.valueOf(genreList.getSelectedItem()), Integer.parseInt(rowTxt.getText()), Integer.parseInt(colTxt.getText()));
				boolean checkIfSeatPayed = ticketService.checkIfSeatTaken(String.valueOf(genreList.getSelectedItem()), Integer.parseInt(oldRowTxt.getText()), Integer.parseInt(colTxt.getText()));
				
				if (checkIfSeatTaken)
				{
					JOptionPane.showMessageDialog(null, "Seat already booked, please pick another one!", "Error", JOptionPane.ERROR_MESSAGE);

				}
				else 
				{
					if (Integer.parseInt(rowTxt.getText()) < 0 || Integer.parseInt(rowTxt.getText()) > 65 || Integer.parseInt(colTxt.getText()) < 0 || Integer.parseInt(colTxt.getText()) > 65) 
					{
						JOptionPane.showMessageDialog(null, "Invalid seat!", "Error", JOptionPane.ERROR_MESSAGE);

					}
					else
					{
						if (checkIfSeatPayed) 
						{
							ticketService.updateSeatRow(String.valueOf(genreList.getSelectedItem()), Integer.parseInt(rowTxt.getText()), Integer.parseInt(oldRowTxt.getText()), Integer.parseInt(colTxt.getText()));
							JOptionPane.showMessageDialog(null, "Seat row succesfully updated!", "Check", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "You have to buy the ticket first in order to edit it!", "Error", JOptionPane.ERROR_MESSAGE);

						}
						
					}
					
				}
				

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
		if (e.getSource() == editBtn && flag == false && flagx == true)
		{
			System.out.println(flag);
			System.out.println(flagx);
			
			try {
				
				boolean checkIfSeatTaken = ticketService.checkIfSeatTaken(String.valueOf(genreList.getSelectedItem()), Integer.parseInt(rowTxt.getText()), Integer.parseInt(colTxt.getText()));
				boolean checkIfSeatPayed = ticketService.checkIfSeatTaken(String.valueOf(genreList.getSelectedItem()), Integer.parseInt(rowTxt.getText()), Integer.parseInt(oldColTxt.getText()));
				
				if (checkIfSeatTaken)
				{
					JOptionPane.showMessageDialog(null, "Seat already booked, please pick another one!", "Error", JOptionPane.ERROR_MESSAGE);

				}
				else 
				{
					if(Integer.parseInt(rowTxt.getText()) < 0 ||  Integer.parseInt(colTxt.getText()) > 65 ||Integer.parseInt(oldColTxt.getText()) < 0 || Integer.parseInt(oldColTxt.getText()) > 65 )
					{
						JOptionPane.showMessageDialog(null, "Invalid seat!", "Error", JOptionPane.ERROR_MESSAGE);

					}
					else
					{
						if (checkIfSeatPayed == false)
						{
							JOptionPane.showMessageDialog(null, "You have to buy the ticket first in order to edit it!", "Error", JOptionPane.ERROR_MESSAGE);

						}
						else
						{
							ticketService.updateSeatCol(String.valueOf(genreList.getSelectedItem()), Integer.parseInt(rowTxt.getText()), Integer.parseInt(colTxt.getText()), Integer.parseInt(oldColTxt.getText()));
							JOptionPane.showMessageDialog(null, "Seat column succesfully updated!", "Check", JOptionPane.INFORMATION_MESSAGE);
						}
						
					}
					
					
				}
				

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		
		if (e.getSource() == editRowBtn)
		{
			flag = true;
			flagx = false;
			rowLbl.setVisible(false);
			newRowLbl.setVisible(true);
			newColLbl.setVisible(false);
			colLbl.setVisible(true);
			editColBtn.setVisible(false);
			
			oldRowLbl.setVisible(true);
			oldColLbl.setVisible(false);
			oldRowTxt.setVisible(true);
			oldColTxt.setVisible(false);
			editBtn.setVisible(true);
			editRowBtn.setVisible(false);
			
		}
		if (e.getSource() == editColBtn)
		{
			flag= false;
			flagx = true;
			
			colLbl.setVisible(false);
			newColLbl.setVisible(true);
			newRowLbl.setVisible(false);
			rowLbl.setVisible(true);
			editRowBtn.setVisible(false);
			oldRowLbl.setVisible(false);
			oldColLbl.setVisible(true);
			oldRowTxt.setVisible(false);
			oldColTxt.setVisible(true);
			editBtn.setVisible(true);
			editColBtn.setVisible(false);


		}

	}



}