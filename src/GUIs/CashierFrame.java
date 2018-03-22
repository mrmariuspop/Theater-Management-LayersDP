package GUIs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import service.TicketService;
import tables.TicketTable;
import bussinessModel.*;

		
public class CashierFrame extends JFrame implements ActionListener {

	JButton sellTicketBtn=new JButton(new ImageIcon("images\\ttk.png"));
	JButton seeAllTicketsBtn=new JButton(new ImageIcon("images\\aalltkt.png"));
	JButton cancelResBtn=new JButton(new ImageIcon("images\\cancel.png"));
	JButton editBtn=new JButton(new ImageIcon("images\\edit.png"));
	JButton logOut=new JButton("Logout");
	JFrame frame = new JFrame("Cashier Window");
	JLabel cancelLbl = new JLabel("Cancel Reservation");
	JLabel editLbl = new JLabel("Edit Reservation");

	TicketService ticketService = new TicketService();
	
	public CashierFrame()
	{
		
		frame.setSize(650, 650);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	
	
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		panel.add(logOut);
		panel.add(cancelResBtn);
		panel.add(editBtn);
		editBtn.setBounds(360,450,50,50);
		panel.add(editLbl);
		editLbl.setBounds(345,485,150,50);
		
		cancelResBtn.setBounds(200,450,50,50);
		logOut.setBounds(500,550,80,25);
		JLabel background=new JLabel(new ImageIcon("images\\ttklogo.png"));
		panel.add(background);
		background.setBounds(130,-0,350,350);
		panel.add(cancelLbl);
		
		cancelLbl.setBounds(175,485,150,50);
		panel.add(sellTicketBtn);
		sellTicketBtn.setBounds(80,450,50,50);
		
		JLabel sellTicket = new JLabel("Sell ticket");
		panel.add(sellTicket);
		sellTicket.setBounds(78, 485,100,50);

		
		
		panel.add(seeAllTicketsBtn);
		seeAllTicketsBtn.setBounds(80+400,450,50,50);
		
		JLabel seeAllTickets = new JLabel("See all tickets");
		panel.add(seeAllTickets);
		seeAllTickets.setBounds(465, 485,150,50);
		
		
	
		
		
		
		sellTicketBtn.addActionListener(this);
		seeAllTicketsBtn.addActionListener(this);
		logOut.addActionListener(this);
		cancelResBtn.addActionListener(this);
		editBtn.addActionListener(this);

	}

	@Override
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sellTicketBtn) {
			System.out.println("Sell ticket frame opened"); // quit application and close frame when QUIT is
							// pressed
			
			SellTicketFrame sellTicketFrame = new SellTicketFrame();
		}
		if (e.getSource() == seeAllTicketsBtn) {
			System.out.println("See all tickets frame opened"); // quit application and close frame when QUIT is
							// pressed
			
			
			try {
				List<Ticket> displayAllTickets = ticketService.displayAllTickets();
				TicketTable pt = new TicketTable(displayAllTickets);
				pt.displayAllTickets();
			} catch (Exception e1) {
				System.out.println(e1);
				JOptionPane.showMessageDialog(null, "Internal Error", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (e.getSource() == logOut) {

			LoginFrame login2 = new LoginFrame();
			frame.dispose();
							// pressed
		}
		if (e.getSource() == cancelResBtn) {

			CancelReservationFrame cancelReservationFrame = new CancelReservationFrame();
							// pressed
		}
		if (e.getSource() == editBtn) {

			System.out.println("Edit Button pressed");
			EditReservationFrame editReservationFrame = new EditReservationFrame();
		}
//		showsBtn
//		if (e.getSource() == registerButton) {
//			RegisterFrame frame2 = new RegisterFrame();
//							// pressed
//		}
//
	}



}