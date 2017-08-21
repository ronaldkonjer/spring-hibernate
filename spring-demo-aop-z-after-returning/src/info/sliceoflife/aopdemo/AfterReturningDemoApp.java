package info.sliceoflife.aopdemo;


import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import info.sliceoflife.aopdemo.dao.AccountDao;

public class AfterReturningDemoApp {

	public static void main(String[] args) throws Exception {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		
		List<Account> accounts = accountDao.findAccounts(false);
		
		System.out.println("\n\n Main program: AfterReturningDemoApp");
		System.out.println("----");
		
		System.out.println(accounts);
		
		System.out.println("\n");
		
		
		// close the context
		context.close();
	}

}
