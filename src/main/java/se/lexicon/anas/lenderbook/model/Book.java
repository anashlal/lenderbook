package se.lexicon.anas.lenderbook.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "available")
	private boolean available;
	
	@Column(name = "reserved")
	private boolean reserved;
	
	@Column(name = "maxLoanDays")
	private int maxLoanDays;
	
	@Column(name = "finePerDay")
	private BigDecimal finePerDay;
	
	@Column(name = "description")
	private String description;

	public Book(String title, int maxLoanDays, BigDecimal finePerDay, String description) {
		super();
		this.title = title;
		this.maxLoanDays = maxLoanDays;
		this.finePerDay = finePerDay;
		this.description = description;
	}

	public Book() {

	}

	public int getBookId() {
		return id;
	}

	public void setBookId(int bookId) {
		this.id = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public int getMaxLoanDays() {
		return maxLoanDays;
	}

	public void setMaxLoanDays(int maxLoanDays) {
		this.maxLoanDays = maxLoanDays;
	}

	public BigDecimal getFinePerDay() {
		return finePerDay;
	}

	public void setFinePerDay(BigDecimal finePerDay) {
		this.finePerDay = finePerDay;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [bookId=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", available=");
		builder.append(available);
		builder.append(", reserved=");
		builder.append(reserved);
		builder.append(", maxLoanDays=");
		builder.append(maxLoanDays);
		builder.append(", finePerDay=");
		builder.append(finePerDay);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}

}
