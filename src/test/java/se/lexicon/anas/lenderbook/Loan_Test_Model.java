package se.lexicon.anas.lenderbook;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import se.lexicon.anas.lenderbook.model.LibraryUser;
import se.lexicon.anas.lenderbook.model.Loan;

class Loan_Test_Model {

	@Test
	void Load_Overdue_ShouldBe_True() {
		Loan loan = new Loan();
		loan.setLoanDate(LocalDate.of(2015, 12, 31));
		
		assertTrue(loan.isOverdue());
	}
	
	@Test
	void Load_Overdue_ShouldBe_False() {
		Loan loan = new Loan();
		loan.setLoanDate(LocalDate.of(2022, 12, 31));
		
		assertFalse(loan.isOverdue());
	}
}
