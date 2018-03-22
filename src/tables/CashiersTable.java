package tables;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import bussinessModel.Cashier;

public class CashiersTable {
	private List<Cashier> listCashier;
	public CashiersTable(List<Cashier> listCashier) 
	{
		this.listCashier = listCashier;
	}
	public void displayTableCust(){
		
		JFrame frame = new JFrame("Cashiers Table");
		JPanel panel = new JPanel();
		String h1[] = {"username","lastname", "firstname"};
		String[][] data = fromListToArray(listCashier);
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
	
	private String[][] fromListToArray(List<Cashier> list)
	{
		String[][] res = new String[list.size()][3];
		for (int i=0; i<list.size(); i++)
		{
			res[i][0] = ""+list.get(i).getUsername();
			res[i][1] = list.get(i).getLastname();
			res[i][2] = list.get(i).getFirstname();
		}
		return res;
	}
}
