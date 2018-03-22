package service;

import java.sql.SQLException;
import java.util.List;

import bussinessModel.Cashier;
import bussinessModel.Ticket;

public interface ICashierService {
	
	public int checkIfUsernameExistsAlreadyInTheDatabase(String username) throws SQLException, Exception;

	public int insertCashier(Cashier cash1) throws Exception;

	public int removeCashierbyUsername(String username) throws SQLException, Exception;

	public  List<Cashier> displayAllCashiers() throws Exception;
	
	public int updateCashierLastname(String username, String newLastName) throws Exception;
	
	public boolean checkUserInAdmin(String username) throws SQLException, Exception;
	
	public String givePasswordByUsernameAdmin (String username) throws SQLException, Exception;

	public boolean checkUserInCashier(String username) throws SQLException, Exception;
	
	public String givePasswordbyUsernameCashier (String username) throws SQLException, Exception;


}
