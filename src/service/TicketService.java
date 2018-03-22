package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dbmodel.TicketDto;
import bussinessModel.Ticket;
import repository.TicketRepositorySql;

public class TicketService implements ITicketService {

	TicketRepositorySql ticketSql = new TicketRepositorySql();
	
	@Override
	public int getNoOfTicketByTitle(String title) throws SQLException, Exception {
		ticketSql.getNoOfTicketByTitle(title);
		return 0;
	}

	@Override
	public int updateNoTickets(String title) throws Exception {
		ticketSql.updateNoTickets(title);
	return 0;
	}


	@Override
	public boolean checkIfSeatTaken(String title, int row, int col) throws SQLException, Exception {
		ticketSql.checkIfSeatTaken(title,row,row);
		return false;
	}

	@Override
	public List<Ticket> displayAllTickets() throws Exception {
		List<TicketDto> listDto = ticketSql.displayAllTickets();
		List<Ticket> finalList = new ArrayList<Ticket>();
		
		for (TicketDto ticketDto : listDto) {
			Ticket ticket = new Ticket();
			
			ticket.setShowTitle(ticketDto.getShowTitle());
			ticket.setRow(ticketDto.getRow());
			ticket.setCol(ticketDto.getCol());
			
			finalList.add(ticket);
		}
		return finalList;
	}

	@Override
	public int removeTicketByShowNameAndSeatAndCol(String showtitle, int row, int col) throws SQLException, Exception {
		ticketSql.removeTicketByShowNameAndSeatAndCol(showtitle,row,col);
		return 0;
	}

	@Override
	public int updateSeatRow(String showtitle, int newRow, int oldRow, int col) throws Exception {
		ticketSql.updateSeatRow(showtitle,newRow,oldRow,col);
		return 0;
	}

	@Override
	public int updateSeatCol(String showtitle, int row, int newCol, int oldCol) throws Exception {
		ticketSql.updateSeatCol(showtitle,row,newCol,oldCol);
		return 0;
	}

	@Override
	public int noOfTicketSoldForAShow(String showTitle) throws SQLException, Exception {
		ticketSql.noOfTicketSoldForAShow(showTitle);
		return 0;
	}

	@Override
	public int insertTicket(Ticket ticket1) throws Exception {

		TicketDto ticketDto = new TicketDto();
		
		ticketDto.setShowTitle(ticket1.getShowTitle());
		ticketDto.setRow(ticket1.getRow());
		ticketDto.setCol(ticket1.getCol());
		
		ticketSql.insertTicket(ticketDto);
		
		return 0;
	}

}
