package ph.com.nikkinicholas.aspect.monitor.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by nikkiromero on 30/01/2017.
 */
@Aspect
@Component
public class StudentControllerMonitor {
    @Before("execution(* ph.com.nikkinicholas..*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before (Signature) : " + joinPoint.getSignature());
        Object[] args = joinPoint.getArgs();
        for(int i = 0; i < args.length; i++) {
            System.out.println("Before (Param) : " + args[i].toString());
        }
    }

    @AfterReturning(value = "execution(* ph.com.nikkinicholas..*.*(..))", returning = "returnValue")
    public void logAfterReturning(JoinPoint joinPoint, Object returnValue) {
        System.out.println("After Returning (Signature) : " + joinPoint.getSignature());
        System.out.println("After Returning (Return Value) : " + (returnValue != null ? returnValue.toString() : null));
    }

    @AfterThrowing(value = "execution(* ph.com.nikkinicholas..*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
        System.out.println("After Throwing (Signature) : " + joinPoint.getSignature());
        System.out.println("After Throwing (Exception Class) : " + exception.getClass());
        System.out.println("After Throwing (Exception Message) : " + exception.getMessage());
    }
}