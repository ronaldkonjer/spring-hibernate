package info.sliceoflife.springdemo.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
  
  // setup logger 
  private Logger LOGGER = Logger.getLogger(CRMLoggingAspect.class.getName());
  
  // setup pointcut declarations
  @Pointcut("execution(* info.sliceoflife.springdemo.controller.*.*(..))")
  private void forControllerPackage() {}
  
  @Pointcut("execution(* info.sliceoflife.springdemo.service.*.*(..))")
  private void forServicePackage() {}
  
  @Pointcut("execution(* info.sliceoflife.springdemo.dao.*.*(..))")
  private void forDaoPackage() {}
  
  @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
  private void forAppFlow() {}
  
  // add @Before advice
  
  @Before("forAppFlow()")
  public void before(JoinPoint joinPoint) {
    
    // display the method we are calling
    String method = joinPoint.getSignature().toShortString();
    LOGGER.info("====>>> in @Before: calling method: " + method);
    
    // display the arguments to the method
    
    // get the arguments 
    Object[] args = joinPoint.getArgs();
    
    // loop through and display the arguments
    Arrays.stream(args).forEach(arg -> LOGGER.info("====>>> argument: " + arg));
        
  }
  
  // add @AfterReturning advice
  @AfterReturning(
      pointcut="forAppFlow()",
      returning="result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
    
    // display the method we are returning for
    String method = joinPoint.getSignature().toShortString();
    LOGGER.info("====>>> in @AfterReturning: from method: " + method);
    
    // display data returned
    LOGGER.info("====>>> result: " + result);
  }
  

}
