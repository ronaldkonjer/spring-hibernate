package info.sliceoflife.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	@After("execution(* info.sliceoflife.aopdemo.dao.AccountDao.findAccounts(..))")
	public void afterAccountsAdvice(JoinPoint joinPoint) {

		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=======>>> Executing @After (finally) on method: " + method);

	}

	@AfterThrowing(pointcut = "execution(* info.sliceoflife.aopdemo.dao.AccountDao.findAccounts(..))", throwing = "exception")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {

		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=======>>> Executing @AfterThrowing on method: " + method);

		System.out.println("\n=======>>> The exception is: " + exception);
	}

	@AfterReturning(pointcut = "execution(* info.sliceoflife.aopdemo.dao.AccountDao.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=======>>> Executing @AfterReturning on method: " + method);

		System.out.println("\n=======>>> Result is: " + result);

		convertAccountNamesToUppercase(result);

		System.out.println("\n=======>>> Modified result is: " + result);

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
		System.out.println("=====>>> Executing @Before advice on addAccount()");

		// display the method signature
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();

		System.out.println("Method: " + methodSig);

		// display the method arguments

		// get the args
		Object[] args = joinPoint.getArgs();

		// loop through the args
		for (Object tempArg : args) {
			System.out.println(tempArg);

			if (tempArg instanceof Account) {
				// downcast and print account specific stuff

				Account account = (Account) tempArg;

				System.out.println("account name: " + account.getName());
				System.out.println("account level: " + account.getLevel());

			}
		}
	}

}
