package aop.aspect;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspectJoinPoint {

    @Before("execution(public * aop.model.*.*(*))")
    public void loggingAdvice(JoinPoint joinPoint) {
        System.out.println("Before running loggingAdvice on method=" +
                joinPoint.toString());

        System.out.println("Arguments Passed=" + Arrays.toString(joinPoint.getArgs()));
    }

    @Before("args(name)")
    public void logStringArguments(String name) {
        System.out.println("String argument passed=" + name);
    }
}
