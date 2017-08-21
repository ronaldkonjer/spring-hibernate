package info.sliceoflife.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import info.sliceoflife.aopdemo.dao.AccountDao;

public class AfterFinallyDemoApp {

  public static void main(String[] args) {

    // read spring config java class
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

    // get the bean from spring container
    AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

    List<Account> accounts = null;
    try {
      boolean tripWire = false;
      accounts = accountDao.findAccounts(tripWire);
    } catch (Exception e) {
      System.out.println("\n\nMain Program ... caught exception: " + e);
    }

    System.out.println("\n\n Main program: AfterThrowingDemoApp");
    System.out.println("----");

    System.out.println(accounts);

    System.out.println("\n");

    // close the context
    context.close();
  }

}
