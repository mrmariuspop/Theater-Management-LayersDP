package repository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import Dbmodel.ShowDto;

public interface IShowRepository {
	
	public int insertShow(ShowDto show1) throws Exception;
	
	public List<ShowDto> displayAllShows() throws Exception;
	
	public int removeShowByTitle(String title) throws SQLException, Exception;
	
	public int updateShowDate(String title, String newDate) throws Exception;

	public  int noOfTicketSoldForAShow(String showTitle) throws SQLException, Exception;
	
	public int checkIfShowAlreadyInTheDatabase(String title) throws SQLException;

}
