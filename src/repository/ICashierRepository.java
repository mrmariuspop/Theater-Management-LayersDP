package repository;

import java.sql.SQLException;
import java.util.List;

import Dbmodel.CashierDto;

public interface ICashierRepository {
	
		//login
	
		public boolean checkUserInAdmin(String username) throws SQLException, Exception;
		
		public String givePasswordByUsernameAdmin (String username) throws SQLException, Exception;

		public boolean checkUserInCashier(String username) throws SQLException;
		
		public String givePasswordbyUsernameCashier (String username) throws Exception;

		//create cashier
		public int checkIfUsernameExistsAlreadyInTheDatabase(String username) throws SQLException, Exception;
		

		public void insertCashier(CashierDto cash1dto) throws Exception;
		
		public int updateCashierLastname(String username, String newLastName) throws Exception;
		
		public List<CashierDto> displayAllCashiers() throws Exception;

}
