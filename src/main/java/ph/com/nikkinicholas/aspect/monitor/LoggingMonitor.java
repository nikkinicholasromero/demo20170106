package ph.com.nikkinicholas.aspect.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by nikkiromero on 30/01/2017.
 */
@Aspect
@Component
public class LoggingMonitor {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* ph.com.nikkinicholas..*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Before (Signature) : " + joinPoint.getSignature());
        Object[] args = joinPoint.getArgs();
        for(int i = 0; i < args.length; i++) {
            log.info("Before (Param) : " + args[i].toString());
        }
    }

    @AfterReturning(value = "execution(* ph.com.nikkinicholas..*.*(..))", returning = "returnValue")
    public void logAfterReturning(JoinPoint joinPoint, Object returnValue) {
        log.info("After Returning (Signature) : " + joinPoint.getSignature());
        log.info("After Returning (Return Value) : " + (returnValue != null ? returnValue.toString() : null));
    }

    @AfterThrowing(value = "execution(* ph.com.nikkinicholas..*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
        log.info("After Throwing (Signature) : " + joinPoint.getSignature());
        log.info("After Throwing (Exception Class) : " + exception.getClass());
        log.info("After Throwing (Exception Message) : " + exception.getMessage());
    }
}
