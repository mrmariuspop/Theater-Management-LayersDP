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

import bussinessModel.Ticket;
import service.TicketService;
import service.ToCSV;

		
public class AdminFrame extends JFrame implements ActionListener {

	JButton cashiersBtn=new JButton(new ImageIcon("images\\addCashier.png"));
	JButton showsBtn=new JButton(new ImageIcon("images\\show.png"));
	JButton export=new 	JButton(new ImageIcon("images\\exp.png"));
	JButton backBtn=new 	JButton("Log Out");
	
	JFrame frame = new JFrame("Admin Window");
	
	TicketService ticketService = new TicketService();
	
	public AdminFrame()
	{
		
		frame.setSize(650, 650);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		panel.add(backBtn);
		
		backBtn.setBounds(500, 550, 80, 25);
		
		JLabel background=new JLabel(new ImageIcon("images\\adminlogo.png"));
		panel.add(background);
		background.setBounds(130,-70,350,350);
		
		panel.add(cashiersBtn);
		cashiersBtn.setBounds(80,250,50,50);
		
		JLabel cashiers = new JLabel("Cashiers");
		panel.add(cashiers);
		cashiers.setBounds(78, 285,100,50);

		JLabel welcome = new JLabel("Welcome Marius Pop!");
		panel.add(welcome);
		welcome.setBounds(250,100,200,200);
		
		
		panel.add(showsBtn);
		showsBtn.setBounds(80+400,250,50,50);
		
		JLabel showsLbl = new JLabel("Shows");
		panel.add(showsLbl);
		showsLbl.setBounds(485, 283,100,50);
		
		
	
		panel.add(export);
		export.setBounds(80,450,50,50);
		
		JLabel persInfo = new JLabel("Export to csv");
		panel.add(persInfo);
		persInfo.setBounds(70, 485 ,150,50);

		
		
		cashiersBtn.addActionListener(this);
		showsBtn.addActionListener(this);
		backBtn.addActionListener(this);
		export.addActionListener(this);
	}

	@Override
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cashiersBtn) {
			CashierEditFrame cash1 = new CashierEditFrame();
			frame.dispose();

			System.out.println("Cashier Window opened!"); // quit application and close frame when QUIT is
							// pressed
		}
		if (e.getSource() == showsBtn) {
			ShowsFrame cash1 = new ShowsFrame();
			frame.dispose();
			System.out.println("Shows Window opened!"); // quit application and close frame when QUIT is
							// pressed
		}
		
		if (e.getSource() == backBtn) {

			LoginFrame login2 = new LoginFrame();
			frame.dispose();
			System.out.println("Shows Window opened!"); // quit application and close frame when QUIT is
							// pressed
		}
		if (e.getSource() == export) {

			System.out.println("Exported!"); // quit application and close frame when QUIT is
							// pressed
			
			JOptionPane.showMessageDialog(null, "Data succesfully exported to csv file!", "Check", JOptionPane.INFORMATION_MESSAGE);

			
			try {
				List<Ticket> displayAllTickets = ticketService.displayAllTickets();
				
				for (Ticket ticket : displayAllTickets) {
					System.out.println(ticket.getShowTitle());
				}
				
				ToCSV.fromListToArrayCSV(displayAllTickets);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("am intrat aici ");
			}
		}
		
		
		
		
//		showsBtn
//		if (e.getSource() == registerButton) {
//			RegisterFrame frame2 = new RegisterFrame();
//							// pressed
//		}
//
	}



}