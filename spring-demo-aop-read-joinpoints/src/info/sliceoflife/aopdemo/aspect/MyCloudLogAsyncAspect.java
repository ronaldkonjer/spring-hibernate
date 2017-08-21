package info.sliceoflife.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(10)
public class MyCloudLogAsyncAspect {

	@Before("info.sliceoflife.aopdemo.aspect.SolAopDeclarations.forDaoPackageNoGetterSetter()")
	public void loggingToCloudAsync() {
		System.out.println("=====>>> Logging to Cloud in async fashion");
	}

}
