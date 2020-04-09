package se.lexicon.anas.lenderbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.lexicon.anas.lenderbook.model.Loan;
import se.lexicon.anas.lenderbook.services.LoanDao;

@RestController
@RequestMapping("/myapp/api")
public class LoanController {
	
	private LoanDao loanServaice;

	@Autowired
	public void LoanControlle(LoanDao loanServaice) {
		
		this.loanServaice = loanServaice;
	}

	@GetMapping("/allloan/{id}")
	public ResponseEntity<Loan> loan_By_Id(@PathVariable int id) {
		try {
			return ResponseEntity.ok(loanServaice.findById_Loan(id));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/allloan")
	public ResponseEntity<List<Loan>> loan_all() {
		List<Loan> loans = loanServaice.findAll();

		if (loans.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(loans);
		}
	}

	@PostMapping("/Creatloan")
	public ResponseEntity<Loan> create_loan(@RequestBody Loan newloan)  {
		if (newloan == null) {
			return ResponseEntity.badRequest().build();
		}

		Loan saved = loanServaice.save_Loan(newloan);

		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@PutMapping("/updateallloan/{id}")
	public ResponseEntity<Loan> update_loan(@PathVariable int id, @RequestBody Loan updated) {
		if (updated == null) {
			return ResponseEntity.badRequest().build();
		}
		try {
			return ResponseEntity.ok(loanServaice.update_Loan(id, updated));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
