package hello;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RuntimeDevice {

	@Before("execution(* hello..*doSomething())")
	public void logServiceAccess(JoinPoint joinPoint) {
		Logger LOGGER = LoggerFactory.getLogger(joinPoint.getSignature().getName());
		LOGGER.info("Accessing {}", joinPoint.getSignature().getName());

	}

	@Around("execution(* hello.BO.do*())")
	public Object runtimeHandling(ProceedingJoinPoint jp)  {
		System.out.println("Before method: " + jp.getSignature().getName() + ". Class: "
				+ jp.getTarget().getClass().getSimpleName());

		try {
			// Proceed with method invocation
			Object result = jp.proceed();

			System.out.println("Returning: " + result);
			return result;
		} catch (Throwable e) {
			// Log error
			System.out.println("Error: " + e.getMessage());
			
		}
		return "0";

	}
}
