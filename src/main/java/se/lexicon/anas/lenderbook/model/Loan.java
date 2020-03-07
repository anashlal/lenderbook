package se.lexicon.anas.lenderbook.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Loan")
public class Loan implements Serializable{

	private static final long serialVersionUID = 3L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long loanId;

	@ManyToOne(fetch = FetchType.EAGER)
	private LibraryUser loanTaker;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE,

	})
	private Book Book;
	@ManyToOne(fetch = FetchType.EAGER)
	private LibraryUser libraryUser;
	private LocalDate LoanDate;
	private boolean terminated;

	public Loan(LibraryUser loanTaker, Book book, LibraryUser libraryUser, LocalDate loanDate,
			boolean terminated) {
		super();
		this.loanTaker = loanTaker;
		Book = book;
		this.libraryUser = libraryUser;
		LoanDate = loanDate;
		this.terminated = terminated;
	}

	public Loan() {

	}

	public long getLoanId() {
		return loanId;
	}

	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	public LibraryUser getLoanTaker() {
		return loanTaker;
	}

	public void setLoanTaker(LibraryUser loanTaker) {
		this.loanTaker = loanTaker;
	}

	public Book getBook() {
		return Book;
	}

	public void setBook(Book book) {
		Book = book;
	}

	public LocalDate getLoanDate() {
		return LoanDate;
	}

	public void setLoanDate(LocalDate loanDate) {
		LoanDate = loanDate;
	}

	public boolean isTerminated() {
		return terminated;
	}

	public void setTerminated(boolean terminated) {
		this.terminated = terminated;
	}

	public boolean isOverdue() {
		return LocalDate.now().isAfter(LoanDate);
	}

	public BigDecimal getFine() {
		int daysFine = 0;
		if (isOverdue()) {
			daysFine = LocalDate.now().getDayOfYear() - LoanDate.getDayOfYear();
		}
		return Book.getFinePerDay().multiply(new BigDecimal(daysFine));
	}

	public boolean extendLoan(int days) {
		if (!isOverdue() && !Book.isReserved()) {
			LoanDate.plusDays(days);
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Book == null) ? 0 : Book.hashCode());
		result = prime * result + ((LoanDate == null) ? 0 : LoanDate.hashCode());
		result = prime * result + ((libraryUser == null) ? 0 : libraryUser.hashCode());
		result = prime * result + (int) (loanId ^ (loanId >>> 32));
		result = prime * result + ((loanTaker == null) ? 0 : loanTaker.hashCode());
		result = prime * result + (terminated ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		if (Book == null) {
			if (other.Book != null)
				return false;
		} else if (!Book.equals(other.Book))
			return false;
		if (LoanDate == null) {
			if (other.LoanDate != null)
				return false;
		} else if (!LoanDate.equals(other.LoanDate))
			return false;
		if (libraryUser == null) {
			if (other.libraryUser != null)
				return false;
		} else if (!libraryUser.equals(other.libraryUser))
			return false;
		if (loanId != other.loanId)
			return false;
		if (loanTaker == null) {
			if (other.loanTaker != null)
				return false;
		} else if (!loanTaker.equals(other.loanTaker))
			return false;
		if (terminated != other.terminated)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanTaker=" + loanTaker + ", Book=" + Book + ", libraryUser=" + libraryUser
				+ ", LoanDate=" + LoanDate + ", terminated=" + terminated + "]";
	}

}
