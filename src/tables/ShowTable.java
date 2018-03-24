package tables;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import bussinessModel.Show;

public class ShowTable {
	private List<Show> listShows;
	public ShowTable(List<Show> listShows) 
	{
		this.listShows = listShows;
	}
	public void displayTableShows(){
		
		JFrame frame = new JFrame("Shows Table");
		JPanel panel = new JPanel();
		String h1[] = {"title","genre","distribution","date","noTickets"};
		String[][] data = fromListToArray(listShows);
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
	
	private String[][] fromListToArray(List<Show> list)
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-d");
		String[][] res = new String[list.size()][5];
		for (int i=0; i<list.size(); i++)
		{
			res[i][0] = ""+list.get(i).getTitle();
			res[i][1] = list.get(i).getGenre();
			res[i][2] = list.get(i).getDistribution();
			res[i][3] = String.valueOf(list.get(i).getDate());
			res[i][4] = String.valueOf(list.get(i).getNoTickets());
			
		}
		return res;
	}
}
