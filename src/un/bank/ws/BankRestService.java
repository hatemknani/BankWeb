package un.bank.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import un.bank.BankLocal;
import un.bank.entities.Account;

@Stateless
@Path("/")
public class BankRestService {
	@EJB
	private BankLocal business;

	@POST
	@Path("/accounts")
	@Produces(MediaType.APPLICATION_JSON)
	public Account addAccount(Account acc) {
		return business.addAccount(acc);
	}

	@GET
	@Path("/accounts/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Account getAccount(@PathParam (value="code") Long code) {
		return business.getAccount(code);
	}

	@GET
	@Path("/accounts")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> listAccounts() {
		return business.listAccounts();
	}

	@PUT
	@Path("/accounts/credit")
	@Produces(MediaType.APPLICATION_JSON)
	public void credit(@FormParam(value="code") Long code, 
			@FormParam(value="amount") double amt) {
		business.credit(code, amt);
	}

	@PUT
	@Path("/accounts/withdraw")
	@Produces(MediaType.APPLICATION_JSON)
	public void withdraw(@FormParam(value="code") Long code, 
			@FormParam(value="amount") double amt) {
		business.withdraw(code, amt);
	}

	@PUT
	@Path("/accounts/transfer")
	@Produces(MediaType.APPLICATION_JSON)
	public void transfer(@FormParam(value="code1") Long code1, 
			@FormParam(value="code2") Long code2, 
			@FormParam(value="amount") double amt) {
		business.transfer(code1, code2, amt);
	}
	
	
	
}
