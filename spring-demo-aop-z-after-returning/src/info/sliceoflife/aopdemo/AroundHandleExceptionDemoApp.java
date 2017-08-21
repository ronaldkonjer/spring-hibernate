package info.sliceoflife.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import info.sliceoflife.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
  
  private static Logger LOGGER = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

  public static void main(String[] args) {
    
    // read spring config java class
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

    // get the bean from spring container
    TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
    
    LOGGER.info("\nMain Program: AroundDemoApp");
    
    LOGGER.info("Calling getFortune");
    
    boolean tripWire = true;
    String data = fortuneService.getFortune(tripWire);
    
    LOGGER.info("\nMy fortune is: " + data);
    
    LOGGER.info("Finished");

    // close the context
    context.close();
  }

}
