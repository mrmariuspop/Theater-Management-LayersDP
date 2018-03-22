package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dbmodel.TicketDto;
import bussinessModel.Ticket;
import dataAccess.DbConnection;

public class TicketRepositorySql implements ITicketRepository{

	public int getNoOfTicketByTitle (String title) throws SQLException, Exception
	{
		String sql = "Select noTickets from teatru.show where title = ?";
		PreparedStatement pstmt = null;
		int aux = 0;
		
		try 
		{
			pstmt = DbConnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, title);	
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				aux = rs.getInt("noTickets");
				//  System.out.println(password + "\n");
				}
			
		}
		catch(Exception e)
		{}
		finally
		{
			if (pstmt!=null){
				pstmt.close();
			}
			if (DbConnection.conn!=null)
				DbConnection.conn.close();
		}
		return aux;
	}
	
	@Override
	public int updateNoTickets(String title) throws Exception {
		
		int aux = getNoOfTicketByTitle(title);
		int noTick = aux +1 ;
		String sql = "update teatru.show set noTickets = '"+ noTick +"' where title = " +"'"+ title+"'";
		Statement stmt=null;
		try {
			Connection cnn = DbConnection.getConnection();
			stmt = cnn.createStatement();
			int executeUpdate = stmt.executeUpdate(sql);
			return executeUpdate;
		} finally {
			if (stmt!=null){
		stmt.close();
			}
			if (DbConnection.conn!=null)
				DbConnection.conn.close();
		}
	}


	@Override
	public boolean checkIfSeatTaken(String title, int row, int col) throws SQLException, Exception {
		String sql = "Select * From Ticket where showtitle = ? AND row = ? AND col = ?";
		PreparedStatement pstmt=null;
		boolean usernameExists = false;
		try {
			pstmt = DbConnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, title);	
			pstmt.setInt(2, row);	
			pstmt.setInt(3, col);	
			ResultSet rs = pstmt.executeQuery();
			
			 usernameExists = rs.next();
			
		}catch (Exception e){
			
		}
		finally 
		{
			if (pstmt!=null){
				pstmt.close();
			}
			if (DbConnection.conn!=null)
				DbConnection.conn.close();
		}
		return usernameExists;
	}

	@Override
	public List<TicketDto> displayAllTickets() throws Exception {
		
		List<TicketDto> result = new ArrayList<TicketDto>();
		ResultSet rs=null;
		try {
			String sql = "select * from ticket order by showtitle";
			Statement stmt = DbConnection.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				String showTitle = rs.getString("showTitle");
				int row = rs.getInt("row");
				int col = rs.getInt("col");
				
				TicketDto c = new TicketDto();
				c.setShowTitle(showTitle);;
				c.setRow(row);
				c.setCol(col);
				
				result.add(c);
			}
			return result;
		} 
		finally 
		{
		if (rs!=null) {
			rs.close(); //will be executed always
		}
		if (DbConnection.conn!=null)
			DbConnection.conn.close();
		}
	}

	@Override
	public int removeTicketByShowNameAndSeatAndCol(String showtitle, int row, int col) throws SQLException, Exception {
		String sql = "delete From ticket where showtitle = ? AND row = ? AND col = ?";
		PreparedStatement pstmt=null;
		try {
			pstmt = DbConnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, showtitle);	
			pstmt.setInt(2, row);	
			pstmt.setInt(3, col);	
			int executeUpdate = pstmt.executeUpdate();
			return executeUpdate;
		}catch (Exception e){
			return 0;
		}
		finally 
		{
			if (pstmt!=null){
				pstmt.close();
			}
			if (DbConnection.conn!=null)
				DbConnection.conn.close();
		}

	}

	@Override
	public int updateSeatRow(String showtitle, int newRow, int oldRow, int col) throws Exception {
		
		int aux = getNoOfTicketByTitle(showtitle);
		int noTick = aux +1 ;
		String sql = "update ticket set row = '"+ newRow +"' where showtitle = " +"'"+ showtitle+"' AND col = " + col + " AND row = " + oldRow;
		Statement stmt=null;
		try {
			Connection cnn = DbConnection.getConnection();
			stmt = cnn.createStatement();
			int executeUpdate = stmt.executeUpdate(sql);
			return executeUpdate;
		} finally {
			if (stmt!=null){
		stmt.close();
			}
			if (DbConnection.conn!=null)
				DbConnection.conn.close();
		}
	}

	@Override
	public int updateSeatCol(String showtitle, int row, int newCol, int oldCol) throws Exception {
		int aux = getNoOfTicketByTitle(showtitle);
		int noTick = aux +1 ;
		String sql = "update ticket set col = '"+ newCol +"' where showtitle = " +"'"+ showtitle+"' AND row = " + row + " AND col = " + oldCol;
		Statement stmt=null;
		try {
			Connection cnn = DbConnection.getConnection();
			stmt = cnn.createStatement();
			int executeUpdate = stmt.executeUpdate(sql);
			return executeUpdate;
		} finally {
			if (stmt!=null){
		stmt.close();
			}
			if (DbConnection.conn!=null)
				DbConnection.conn.close();
		}
		
	}

	@Override
	public int noOfTicketSoldForAShow(String showTitle) throws SQLException, Exception {
		String sql = "Select COUNT(showtitle) From ticket where showtitle = ?";
		PreparedStatement pstmt=null;
		List<String> sids = new ArrayList<String>();
		boolean usernameExists = false;
		try {
			pstmt = DbConnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, showTitle);	
			ResultSet rs = pstmt.executeQuery();
			
			
			
			while (rs.next()) {
		        sids.add(rs.getString(1));
		    }
			
		}catch (Exception e){
			
		}
		finally 
		{
			if (pstmt!=null){
				pstmt.close();
			}
			if (DbConnection.conn!=null)
				DbConnection.conn.close();
		}
		return Integer.parseInt(sids.get(0));
	}

	@Override
	public int insertTicket(TicketDto ticketDto) throws Exception {
		String sql = "insert Into ticket Values(?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt = DbConnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, ticketDto.getShowTitle());
			pstmt.setInt(2, ticketDto.getRow());
			pstmt.setInt(3, ticketDto.getCol());

			int executeUpdate = pstmt.executeUpdate();
			return executeUpdate;
		} finally 
		{
			if (pstmt!=null){
				pstmt.close();
			}
			if (DbConnection.conn!=null)
				DbConnection.conn.close();
		}
	}

}
