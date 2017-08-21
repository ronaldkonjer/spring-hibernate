package info.sliceoflife.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

	public void addAccount() {

		System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT\n");

	}
	
	public boolean addSilly() {

		System.out.println(getClass() + ": DOING MY DB WORK: ADDING A SILLY ACCOUNT\n");
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + ": I'M GOING TO SLEEP NOW HOMBRE!\n");
	}


}
