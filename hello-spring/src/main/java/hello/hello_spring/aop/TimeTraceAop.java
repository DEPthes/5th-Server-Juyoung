package hello.hello_spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class TimeTraceAop {

    // SpringConfig를 제외하지 않으면 스프링이 빈을 만들다가 순환 참조에 빠져서 AOP를 포기합니다.
    @Around("execution(* hello.hello_spring..*(..)) && !target(hello.hello_spring.service.SpringConfig)")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString()+ " " + timeMs + "ms");
        }
    }
}
