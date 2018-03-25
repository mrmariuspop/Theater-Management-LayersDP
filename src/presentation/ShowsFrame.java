package presentation;

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

import bussinessModel.Show;
import service.ShowService;
import tables.ShowTable;

		
public class ShowsFrame extends JFrame implements ActionListener {

	JLabel displayAll=new JLabel(new ImageIcon("images\\trt.png"));

	
	JButton addShow=new JButton("Add");
	JButton updateShow=new JButton("Update");
	JButton deleteShow=new JButton("Delete");
	JButton displayAllShows=new JButton("Display");
	JButton backBtn = new JButton("Back");
	JFrame frame = new JFrame("Shows Window");

	ShowService showService = new ShowService();
	
	public ShowsFrame()
	{
		frame.setSize(650, 650);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	
		
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		
		panel.add(backBtn);
		backBtn.setBounds(500,550,80,25);
		
		panel.add(displayAll);
		displayAll.setBounds(130,-70,350,350);
		
		panel.add(addShow);
		addShow.setBounds(80,250,100,25);
		
		JLabel cashiers = new JLabel("Create Show");
		panel.add(cashiers);
		cashiers.setBounds(85, 260,100,50);

		
		panel.add(updateShow);
		updateShow.setBounds(80+400,250,100,25);
		
		JLabel payTaxes = new JLabel("Update Show");
		panel.add(payTaxes);
		payTaxes.setBounds(485, 260,100,50);
		
		
		panel.add(deleteShow);
		deleteShow.setBounds(80,430,100,25);
		
		JLabel persInfo = new JLabel("Delete Show");
		panel.add(persInfo);
		persInfo.setBounds(85, 440 ,150,50);

		panel.add(displayAllShows);
		displayAllShows.setBounds(80+400,430,100,25);
		
		JLabel displayLbl = new JLabel("Display All");
		
		panel.add(displayLbl);
		displayLbl.setBounds(500, 440 ,150,50);
		
		addShow.addActionListener(this);
		updateShow.addActionListener(this);
		deleteShow.addActionListener(this);
		displayAllShows.addActionListener(this);
		backBtn.addActionListener(this);

	}

	@Override
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addShow) {
			AddShowFrame addShowFrame = new AddShowFrame();
			System.out.println("Add new show window!"); // quit application and close frame when QUIT is
							// pressed
		}
		if (e.getSource() == updateShow) {
			System.out.println("Update a show!"); // quit application and close frame when QUIT is
							// pressed
			UpdateShowFrame updateShowDate = new UpdateShowFrame();
		}
		if (e.getSource() == deleteShow) {
			System.out.println("Pick a show to delete!"); // quit application and close frame when QUIT is
							// pressed
			RemoveShowFrame removeShowFrame = new RemoveShowFrame();
		}
		if (e.getSource() == displayAllShows) {
			System.out.println("Display all shows window!"); // quit application and close frame when QUIT is
							// pressed
			
			try {
				List<Show> displayAllShows = showService.displayAllShows();
				
				for (Show show : displayAllShows) {
					System.out.println("din foreach "  + show.getNoTickets());
				}
				
				ShowTable pt = new ShowTable(displayAllShows);
				pt.displayTableShows();
			} catch (Exception e1) {
				e1.printStackTrace();
//				JOptionPane.showMessageDialog(null, "Internal Error", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
//		
		if (e.getSource() == backBtn) {

			AdminFrame af3 = new AdminFrame();
			frame.dispose();
			System.out.println("Shows Window opened!"); // quit application and close frame when QUIT is
							// pressed
		}
		
		
//		if (e.getSource() == registerButton) {
//			RegisterFrame frame2 = new RegisterFrame();
//							// pressed
//		}
//
	}



}