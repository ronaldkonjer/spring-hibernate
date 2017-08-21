package info.sliceoflife.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import info.sliceoflife.aopdemo.Account;

@Component
public class AccountDao {
	
	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT\n");
		
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": DOING MY DB WORK: doing the real work\n");
		return false;
	}
	
	public List<Account> findAccounts(boolean tripWire) throws Exception {
		if(tripWire) {
			throw new RuntimeException("Exception just because i feel like it");
		}
		List<Account> accounts = new ArrayList<>();
		
		Account account1 = new Account("John", "Silver");
		Account account2 = new Account("Madhu", "Platinum");
		Account account3 = new Account("Luca", "Gold");
		
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		
		return accounts;
		
	}

}
