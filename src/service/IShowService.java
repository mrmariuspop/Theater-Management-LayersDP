package service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import bussinessModel.Show;


public interface IShowService {
	
	public int insertShow(Show show1) throws Exception;
	
	public List<Show> displayAllShows() throws Exception;
	
	public int removeShowByTitle(String title) throws SQLException, Exception;
	
	public int updateShowDate(String title, String newDate) throws Exception;
	
	public int noOfTicketSoldForAShow(String showTitle) throws SQLException, Exception;

}
