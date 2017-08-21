package info.sliceoflife.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SolAopDeclarations {

	// creating a pointcut declaration to honor DRY principle
	@Pointcut("execution(* info.sliceoflife.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("execution(* info.sliceoflife.aopdemo.dao.*.get*(..))")
	public void getterMethods() {
	}

	@Pointcut("execution(* info.sliceoflife.aopdemo.dao.*.set*(..))")
	public void setterMethods() {
	}

	// combining multiple pointcuts into one decoration
	@Pointcut("forDaoPackage() && !(getterMethods() || setterMethods())")
	public void forDaoPackageNoGetterSetter() {
	}
}
