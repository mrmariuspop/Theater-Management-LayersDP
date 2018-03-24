package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dbmodel.ShowDto;
import bussinessModel.Show;
import repository.ShowRepositorySql;

public class ShowService implements IShowService{

	ShowRepositorySql showSql = new ShowRepositorySql();
	
	@Override
	public int insertShow(Show show1) throws Exception {
		ShowDto showDto = new ShowDto();
		
		showDto.setTitle(show1.getTitle());
		showDto.setGenre(show1.getGenre());
		showDto.setDistribution(show1.getDistribution());
		showDto.setDate(show1.getDate());
		showDto.setNoTickets(show1.getNoTickets());
		
		showSql.insertShow(showDto);
		
		return 0;
	}

	@Override
	public List<Show> displayAllShows() throws Exception {
		
		List<ShowDto> listDto = showSql.displayAllShows();
		List<Show> finalList = new ArrayList<Show>();
		
		for (ShowDto showDto : listDto) {
			
			Show show1 = new Show();
			
			show1.setTitle(showDto.getTitle());
			show1.setGenre(showDto.getGenre());
			show1.setDistribution(showDto.getDistribution());
			show1.setDate(showDto.getDate());
			show1.setNoTickets(showDto.getNoTickets());
			
			
			finalList.add(show1);
		}
		
		return finalList;
	}

	@Override
	public int removeShowByTitle(String title) throws SQLException, Exception {
		showSql.removeShowByTitle(title);
		return 0;
	}

	@Override
	public int updateShowDate(String title, String newDate) throws Exception {
		showSql.updateShowDate(title,newDate);
		return 0;
	}

	@Override
	public int noOfTicketSoldForAShow(String showTitle) throws SQLException, Exception {
		return showSql.noOfTicketSoldForAShow(showTitle);
		
	}

}
