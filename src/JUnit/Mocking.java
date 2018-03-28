package JUnit;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import repository.CashierRepositorySql;
import service.CashierService;
import service.Encode;

import org.mockito.Mockito;

public class Mocking {

	@Test
	public void test() throws SQLException, Exception {
		
		String username = "marius";
		String pass = "parolatest";
		String encrypted = "d38739ae66fe0aa0c873ba93eed7b6df";
		
		CashierRepositorySql mocked = Mockito.mock(CashierRepositorySql.class);
		Encode mockedEncode = Mockito.mock(Encode.class);
		
		Mockito.when(mocked.checkUserInAdmin(username)).thenReturn(true);
		Mockito.when(mocked.givePasswordByUsernameAdmin(username)).thenReturn(encrypted);
		Mockito.when(mockedEncode.encode(pass)).thenReturn(encrypted);
		
		CashierService cashS = new CashierService();
		
		cashS.setCashSql(mocked);
		
		assertEquals(cashS.givePasswordByUsernameAdmin(username),encrypted);
		
	}

}
