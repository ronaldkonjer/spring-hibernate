package info.sliceoflife.aopdemo.dao;

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

}
