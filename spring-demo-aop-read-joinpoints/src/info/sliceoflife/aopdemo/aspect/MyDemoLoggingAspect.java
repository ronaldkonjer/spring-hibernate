package info.sliceoflife.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
