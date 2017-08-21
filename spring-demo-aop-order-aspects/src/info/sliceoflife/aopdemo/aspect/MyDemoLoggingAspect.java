package info.sliceoflife.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(20)
public class MyDemoLoggingAspect {

	// pointcut expression match addAccount anywhere
	@Before("info.sliceoflife.aopdemo.aspect.SolAopDeclarations.forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("=====>>> Executing @Before advice on addAccount()");
	}

}
