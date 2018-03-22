package service;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import bussinessModel.Ticket;

public class ToCSV {
	
	public static void fromListToArrayCSV(List<Ticket> list) throws IOException
	{
		String csvFile = "abc.csv";
	    FileWriter writer = new FileWriter(csvFile);
	    
		String[][] res = new String[list.size()][3];
		for (int i=0; i<list.size(); i++)
		{
			res[i][0] = ""+list.get(i).getShowTitle();
			
			
			res[i][1] = String.valueOf(list.get(i).getRow());
			
			
			res[i][2] = String.valueOf(list.get(i).getCol());
			
			CSVUtils.writeLine(writer, Arrays.asList(res[i][0], res[i][1], res[i][2]));
			
		}

		writer.flush();
	    writer.close();
		 
	}
	

	
	

}
