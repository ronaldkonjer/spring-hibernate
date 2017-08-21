package info.sliceoflife.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import info.sliceoflife.aopdemo.dao.AccountDao;
import info.sliceoflife.aopdemo.dao.MembershipDao;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);
		
		Account account = new Account();
		// call the business method
		accountDao.addAccount(account, true);
		accountDao.doWork();
		
		// call the membership business method
		membershipDao.addAccount();
		membershipDao.addSilly();
		membershipDao.goToSleep();
		
		// close the context
		context.close();
		
	}

}
