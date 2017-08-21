package info.sliceoflife.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import info.sliceoflife.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
  
  private static Logger LOGGER = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

  public static void main(String[] args) {
    
    // read spring config java class
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

    // get the bean from spring container
    TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
    
    LOGGER.info("\nMain Program: AroundDemoApp");
    
    LOGGER.info("Calling getFortune");
    
    String data = fortuneService.getFortune();
    
    LOGGER.info("\nMy fortune is: " + data);
    
    LOGGER.info("Finished");

    // close the context
    context.close();
  }

}
