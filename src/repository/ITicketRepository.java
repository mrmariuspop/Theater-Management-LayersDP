package repository;

import java.sql.SQLException;
import java.util.List;

import Dbmodel.TicketDto;

public interface ITicketRepository {
	
	public int getNoOfTicketByTitle (String title) throws SQLException, Exception;
	
	public int updateNoTickets(String title) throws Exception;
	
	public int insertTicket(TicketDto ticketDto) throws Exception;
	
	public boolean checkIfSeatTaken(String title, int row, int col) throws SQLException, Exception;
	
	public  List<TicketDto> displayAllTickets() throws Exception;
	
	public int removeTicketByShowNameAndSeatAndCol(String showtitle, int row, int col) throws SQLException, Exception;

	public int updateSeatRow(String showtitle, int newRow, int oldRow, int col) throws Exception;

	public int updateSeatCol(String showtitle, int row, int newCol, int oldCol) throws Exception;

	public int noOfTicketSoldForAShow(String showTitle) throws SQLException, Exception;

}
