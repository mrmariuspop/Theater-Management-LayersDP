package Dbmodel;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ShowDto {
	public String title;
	public String genre;
	public String distribution;
	public LocalDate date;
	public int noTickets;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDistribution() {
		return distribution;
	}
	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getNoTickets() {
		return noTickets;
	}
	public void setNoTickets(int noTickets) {
		this.noTickets = noTickets;
	}
}
