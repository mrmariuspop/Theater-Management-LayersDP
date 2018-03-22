package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dbmodel.CashierDto;
import dataAccess.DbConnection;

public class CashierRepositorySql implements ICashierRepository {


	@Override
	public String givePasswordbyUsernameCashier(String username) throws SQLException {
		String sql = "Select password from cashier where username = ?";
		PreparedStatement pstmt = null;
		String password= null;
		
		try 
		{
			pstmt = DbConnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);	
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				  password = rs.getString("Password");
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
		return password;
	}


	@Override
	public int checkIfUsernameExistsAlreadyInTheDatabase(String username) throws SQLException, Exception {
		String sql = "Select COUNT(username) From cashier where username = ?";
		PreparedStatement pstmt=null;
		List<String> sids = new ArrayList<String>();
		boolean usernameExists = false;
		try {
			pstmt = DbConnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);	
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
	public void insertCashier(CashierDto cash1dto) throws Exception {
		
		String sql = "insert Into Cashier Values(?,?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt = DbConnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, cash1dto.getUsername());
			pstmt.setString(2, cash1dto.getPassword());
			pstmt.setString(3, cash1dto.getFirstname());
			pstmt.setString(4, cash1dto.getLastname());

			int executeUpdate = pstmt.executeUpdate();
		} finally 
		{
			if (pstmt!=null){
				pstmt.close();
			}
			if (DbConnection.conn!=null)
				DbConnection.conn.close();
		}

		 
	}

	public List<CashierDto> displayAllCashiers() throws Exception
	{
		List<CashierDto> result = new ArrayList<CashierDto>();
		ResultSet rs=null;
		try {
			String sql = "select * from cashier";
			Statement stmt = DbConnection.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				String username = rs.getString("username");
				String lastname = rs.getString("lastname");
				String firstname = rs.getString("firstname");
				
				CashierDto c = new CashierDto();
				c.setUsername(username);
				c.setLastname(lastname);
				c.setFirstname(firstname);
				
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

	public int removeCashierbyUsername(String username) throws SQLException, Exception {
		String sql = "delete From cashier where username = ?";
		PreparedStatement pstmt=null;
		try {
			pstmt = DbConnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);		
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
	public int updateCashierLastname(String username, String newLastName) throws Exception {
		{
			String sql = "update Cashier set lastname = '"+ newLastName +"' where username = " +"'"+ username+"'";
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
	}

	@Override
	public boolean checkUserInAdmin(String username) throws SQLException, Exception {
		String sql = "Select * From Admin where username = ?";
		PreparedStatement pstmt=null;
		boolean usernameExists = false;
		try {
			pstmt = DbConnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);	
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
	public String givePasswordByUsernameAdmin(String username) throws SQLException, Exception {
		String sql = "Select password from admin where username = ?";
		PreparedStatement pstmt = null;
		String password= null;
		
		try 
		{
			pstmt = DbConnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);	
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				  password = rs.getString("Password");
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
		return password;

	}


	@Override
	public boolean checkUserInCashier(String username) throws SQLException {
		String sql = "Select * From Cashier where username = ?";
		PreparedStatement pstmt=null;
		boolean usernameExists = false;
		try {
			pstmt = DbConnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, username);	
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

	
}
