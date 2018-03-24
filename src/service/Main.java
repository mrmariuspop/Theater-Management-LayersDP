package service;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.Arrays;
import repository.*;
import GUIs.LoginFrame;
import repository.CashierRepositorySql;
import repository.ShowRepositorySql;
import service.CashierService;

public class Main {
public static void main(String[] args) throws SQLException, Exception
{
	LoginFrame main = new LoginFrame();
	
	TicketRepositorySql s = new TicketRepositorySql();
	System.out.println(s.checkIfSeatTaken("Stand-Up-Micutu", 1, 1));
	System.out.println(s.checkIfSeatTaken("Stand-Up-Micutu", 1, 2));

}
}

	