package info.sliceoflife.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import info.sliceoflife.aopdemo.Account;

@Aspect
@Component
@Order(20)
public class MyDemoLoggingAspect {

  private static Logger LOGGER = Logger.getLogger(MyDemoLoggingAspect.class.getName());

  @Around("execution(* info.sliceoflife.aopdemo.service.*.getFortune(..))")
  public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

    // print out method we are advising on
    String method = proceedingJoinPoint.getSignature().toShortString();
    LOGGER.info("\n=======>>> Executing @Around on method: " + method);

    // get begin timestamp
    long begin = System.currentTimeMillis();

    // now, let's execute the method
    Object result = null;

    try {
      result = proceedingJoinPoint.proceed();
    } catch (Exception e) {
      LOGGER.warning(e.getMessage());

      /*result = "Major accident! But no worries, your private AOP helicopter is on the way!";*/
      
      throw e;
    }

    // get end timestamp
    long end = System.currentTimeMillis();

    // compute the duration
    long duration = end - begin;
    LOGGER.info("\n====>>> Duration: " + duration / 1000.0 + " seconds");

    return result;
  }

  @After("execution(* info.sliceoflife.aopdemo.dao.AccountDao.findAccounts(..))")
  public void afterAccountsAdvice(JoinPoint joinPoint) {

    String method = joinPoint.getSignature().toShortString();
    LOGGER.info("\n=======>>> Executing @After (finally) on method: " + method);

  }

  @AfterThrowing(pointcut = "execution(* info.sliceoflife.aopdemo.dao.AccountDao.findAccounts(..))",
      throwing = "exception")
  public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {

    String method = joinPoint.getSignature().toShortString();
    LOGGER.info("\n=======>>> Executing @AfterThrowing on method: " + method);

    LOGGER.info("\n=======>>> The exception is: " + exception);
  }

  @AfterReturning(pointcut = "execution(* info.sliceoflife.aopdemo.dao.AccountDao.findAccounts(..))",
      returning = "result")
  public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

    String method = joinPoint.getSignature().toShortString();
    LOGGER.info("\n=======>>> Executing @AfterReturning on method: " + method);

    LOGGER.info("\n=======>>> Result is: " + result);

    convertAccountNamesToUppercase(result);

    LOGGER.info("\n=======>>> Modified result is: " + result);

  }

  private void convertAccountNamesToUppercase(List<Account> results) {
    for (Account result : results) {
      String name = result.getName().toUpperCase();
      result.setName(name);
    }

  }

  // pointcut expression match addAccount anywhere
  @Before("info.sliceoflife.aopdemo.aspect.SolAopDeclarations.forDaoPackage()")
  public void beforeAddAccountAdvice(JoinPoint joinPoint) {
    LOGGER.info("=====>>> Executing @Before advice on addAccount()");

    // display the method signature
    MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();

    LOGGER.info("Method: " + methodSig);

    // display the method arguments

    // get the args
    Object[] args = joinPoint.getArgs();

    // loop through the args
    for (Object tempArg : args) {
      LOGGER.info("arg id: " + tempArg);

      if (tempArg instanceof Account) {
        // downcast and print account specific stuff

        Account account = (Account) tempArg;

        LOGGER.info("account name: " + account.getName());
        LOGGER.info("account level: " + account.getLevel());

      }
    }
  }

}
