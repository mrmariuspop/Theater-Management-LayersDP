package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dbmodel.CashierDto;
import bussinessModel.Cashier;
import dataAccess.DbConnection;
import repository.CashierRepositorySql;

	
public class CashierService implements ICashierService{

	CashierRepositorySql cashSql = new CashierRepositorySql();

	
	@Override
	public int checkIfUsernameExistsAlreadyInTheDatabase(String username) throws SQLException, Exception {
		return cashSql.checkIfUsernameExistsAlreadyInTheDatabase(username);
		 
	}
	
	

	@Override
	public int insertCashier(Cashier cash1) throws Exception{
		
		CashierDto cash1dto = new CashierDto();
		
		cash1dto.setUsername(cash1.getUsername());
		cash1dto.setPassword(cash1.getPassword());
		cash1dto.setFirstname(cash1.getFirstname());
		cash1dto.setLastname(cash1.getLastname());
		
		cashSql.insertCashier(cash1dto);
		
		
		return 0;
	}

	@Override
	public int removeCashierbyUsername(String username) throws SQLException, Exception {
		cashSql.removeCashierbyUsername(username);
		return 0;
	}
	@Override
	public List<Cashier> displayAllCashiers() throws Exception {
		
		List<CashierDto> listaCashierDto = cashSql.displayAllCashiers();
		List<Cashier> listaCashier = new ArrayList<Cashier>();
		
		for (CashierDto cashierDto : listaCashierDto) {
			
			Cashier obj1 = new Cashier();

			obj1.setUsername(cashierDto.getUsername());
			obj1.setPassword(cashierDto.getPassword());
			obj1.setFirstname(cashierDto.getFirstname());
			obj1.setLastname(cashierDto.getLastname());
		
			listaCashier.add(obj1);
		}
		return listaCashier;
	}

	@Override
	public int updateCashierLastname(String username, String newLastName) throws Exception {
		cashSql.updateCashierLastname(username,newLastName);
		return 0;
	}

	@Override
	public boolean checkUserInAdmin(String username) throws SQLException, Exception {
		cashSql.checkUserInAdmin(username);
	return false;
	}

	@Override
	public String givePasswordByUsernameAdmin(String username) throws SQLException, Exception {
		
	return cashSql.givePasswordByUsernameAdmin(username);
	}

	@Override
	public boolean checkUserInCashier(String username) throws SQLException, Exception {
		cashSql.checkUserInCashier(username);
		return false;
	}

	@Override
	public String givePasswordbyUsernameCashier(String username) throws SQLException, Exception {
		return cashSql.givePasswordbyUsernameCashier(username);
		 
	}

	

}
