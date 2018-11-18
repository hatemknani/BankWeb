package un.bank.ws;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import un.bank.BankLocal;
import un.bank.entities.Account;

@WebService
public class BankService {

	@EJB
	private BankLocal business;

	@WebMethod
	public Account addAccount(@WebParam(name="balance") double balance) {
		Account acc = new Account();
		acc.setBalance(balance);
		acc.setDateCreation(new Date());
		return business.addAccount(acc);
	}

	@WebMethod
	public Account getAccount(@WebParam(name="code") Long code) {
		return business.getAccount(code);
	}

	@WebMethod
	public List<Account> listAccounts() {
		return business.listAccounts();
	}

	@WebMethod
	public void credit(
			@WebParam(name="code") Long code, 
			@WebParam(name="amount") double amt) {
		
		business.credit(code, amt);
	}

	@WebMethod
	public void withdraw(
			@WebParam(name="code") Long code, 
			@WebParam(name="amount") double amt) {
		
		business.withdraw(code, amt);
	}

	@WebMethod
	public void transfer(
			@WebParam(name="acc1") Long code1,
			@WebParam(name="acc2") Long code2,
			@WebParam(name="amount") double amt) {
		
		business.transfer(code1, code2, amt);
	}


}
