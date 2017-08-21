package info.sliceoflife.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	

	// creating a pointcut declaration to honor DRY principle
	@Pointcut("execution(* info.sliceoflife.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* info.sliceoflife.aopdemo.dao.*.get*(..))")
	private void getterMethods() {}
	
	@Pointcut("execution(* info.sliceoflife.aopdemo.dao.*.set*(..))")
	private void setterMethods() {}
	
	// combining multiple pointcuts into one decoration
	@Pointcut("forDaoPackage() && !(getterMethods() || setterMethods())")
	private void forDaoPackageNoGetterSetter() {}
	
	// pointcut expression match addAccount anywhere
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("=====>>> Executing @Before advice on addAccount()");
	}
	
	// pointcut expression match addAccount anywhere
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("=====>>> Performing API analytics");
	}
	

	
	
	

}
