package tables;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import bussinessModel.Ticket;

public class TicketTable {
	private List<Ticket> listTickets;
	public TicketTable(List<Ticket> listTickets) 
	{
		this.listTickets = listTickets;
	}
	public void displayAllTickets(){
		
		JFrame frame = new JFrame("Tickets Table");
		JPanel panel = new JPanel();
		String h1[] = {"showTitle","row", "col"};
		String[][] data = fromListToArray(listTickets);
		 JTable table = new JTable(data,h1);
		  JTableHeader header = table.getTableHeader();
		  header.setBackground(Color.yellow);
		  JScrollPane pane = new JScrollPane(table);
//		  table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		  panel.add(pane);
		  frame.add(panel);
		  frame.setSize(500,150);
		  frame.setVisible(true);
		  frame.pack();
	}
	
	private String[][] fromListToArray(List<Ticket> list)
	{
		String[][] res = new String[list.size()][3];
		for (int i=0; i<list.size(); i++)
		{
			res[i][0] = ""+list.get(i).getShowTitle();
			res[i][1] = String.valueOf(list.get(i).getRow());
			res[i][2] = String.valueOf(list.get(i).getCol());
		}
		return res;
	}
}
