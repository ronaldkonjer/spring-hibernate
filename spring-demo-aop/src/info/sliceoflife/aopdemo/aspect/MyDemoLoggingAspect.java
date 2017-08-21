package info.sliceoflife.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// pointcut expression match addAccount anywhere
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("=====>>> Executing @Before advice on addAccount()");
	}
	
	// pointcut expression match addAccount in specific class
	@Before("execution(public void info.sliceoflife.aopdemo.dao.MembershipDao.addAccount())")
	public void beforeAddMembershipAccountAdvice() {
		System.out.println("=====>>> Executing @Before advice on addMembershipAccount()");
	}
	
	// pointcut expression match starts with add
	@Before("execution(public void add*())")
	public void beforeStartsWithAddAdvice() {
		System.out.println("=====>>> Executing @Before advice on all methods starting witn add()");
	}
	
	// pointcut expression match on return type and starts with add
	@Before("execution( void add*())")
	public void beforeReturnTypeVoidAndStartsWithAddAdvice() {
		System.out.println("=====>>> Executing @Before advice on all methods starting with add and having return type void()");
	}
	
	// pointcut expression match on any return type and starts with add
	@Before("execution( * add*())")
	public void beforeAnyReturnTypeAndStartsWithAddAdvice() {
		System.out.println("=====>>> Executing @Before advice on all methods starting with add and having any return type");
	}
	
	// pointcut expression match on any return type and starts with add that has parameter ...Account
	@Before("execution( * add*(info.sliceoflife.aopdemo.Account))")
	public void beforeAnyReturnTypeAndStartsWithAddAndHasParameterTypeAccountAdvice() {
		System.out.println("=====>>> Executing @Before advice on all methods starting with add and having any return type and have parameters of type Account");
	}
	
	// pointcut expression match on any return type and starts with add that has parameter of type Account and some more
	@Before("execution( * add*(info.sliceoflife.aopdemo.Account, ..))")
	public void beforeAnyReturnTypeAndStartsWithAddAndHasParameterTypeAccountAndSomeMoreAdvice() {
		System.out.println("=====>>> Executing @Before advice on all methods starting with add and having any return type and have parameters of type Account and some more");
	}
	
	// pointcut expression match on any return type and starts with add that has any type of parameters
	@Before("execution( * add*(..))")
	public void beforeAnyReturnTypeAndStartsWithAddAndHasAnyTypeOfParametersAdvice() {
		System.out.println("=====>>> Executing @Before advice on all methods starting with add and having any return type and has any type of parameters");
	}
	
	// pointcut expression match on any return type and any method in a package that has any type of parameters
	@Before("execution( * info.sliceoflife.aopdemo.dao.*.*(..))")
	public void beforeAnyReturnTypeAndAnyClassWithinGivenPackageAndHasAnyTypeOfParametersAdvice() {
		System.out.println("=====>>> Executing @Before advice on all methods within Dao package and having any return type and has any type of parameters");
	}
		
	
	
	

}
