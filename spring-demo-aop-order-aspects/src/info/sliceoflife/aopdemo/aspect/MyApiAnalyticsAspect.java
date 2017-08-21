package info.sliceoflife.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(30)
public class MyApiAnalyticsAspect {

	@Before("info.sliceoflife.aopdemo.aspect.SolAopDeclarations.forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("=====>>> Performing API analytics");
	}

}
