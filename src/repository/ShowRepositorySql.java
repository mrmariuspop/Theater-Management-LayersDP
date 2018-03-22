package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Dbmodel.ShowDto;
import dataAccess.DbConnection;

public class ShowRepositorySql implements IShowRepository {


	@Override
	public List<ShowDto> displayAllShows() throws Exception {
		List<ShowDto> result = new ArrayList<ShowDto>();
		ResultSet rs=null;
		try {
			String sql = "select * from teatru.show";
			Statement stmt = DbConnection.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				String title = rs.getString("title");
				String genre = rs.getString("genre");
				String distribution = rs.getString("distribution");
				LocalDate date = LocalDate.parse(rs.getString("date"));
				int notickets = rs.getInt("noTickets");
				
				ShowDto c = new ShowDto();
				c.setTitle(title);
				c.setGenre(genre);
				c.setDistribution(distribution);
				c.setDate(date);
				c.setNoTickets(notickets);
				
				result.add(c);
			}
			
		} 
		finally 
		{
		if (rs!=null) {
			rs.close(); //will be executed always
		}
		if (DbConnection.conn!=null)
			DbConnection.conn.close();
		}
		return result;
	}

	@Override
	public int removeShowByTitle(String title) throws SQLException, Exception {
		String sql = "delete From teatru.show where title = ?";
		PreparedStatement pstmt=null;
		try {
			pstmt = DbConnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, title);		
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
	public int updateShowDate(String title, String newDate) throws Exception {
		String sql = "update teatru.show set date = '"+ newDate +"' where title = " +"'"+ title+"'";
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
	public int insertShow(ShowDto show1) throws Exception {
		String sql = "insert Into teatru.show Values(?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt = DbConnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, show1.getTitle());
			pstmt.setString(2, show1.getGenre());
			pstmt.setString(3, show1.getDistribution());
			pstmt.setString(4, String.valueOf(show1.getDate()));
			pstmt.setInt(5, show1.getNoTickets());

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

	@Override
	public  int noOfTicketSoldForAShow(String showTitle) throws SQLException, Exception
	{
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
}
