package kr.soft.study.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class StudyAspect {

    @Before("execution(* kr.soft.study.api.StudyController.*(..))")
    public void beforeAPI(JoinPoint joinPoint) {
        log.info("=======================before======================");
        log.info("type-name: {}",joinPoint.getSignature().getDeclaringType());
        log.info("getName: {}",joinPoint.getSignature().getName());
    }

    @After("execution(* kr.soft.study.api.StudyController.*(..))")
    public void afterAPI(JoinPoint joinPoint) {
        log.info("=======================after======================");
        log.info("type-name: {}",joinPoint.getSignature().getDeclaringType());
        log.info("getName: {}",joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* kr.soft.study.api.StudyController.*(..))")
    public void afterReturningAPI(JoinPoint joinPoint) {
        log.info("=======================afterReturning======================");
        log.info("type-name: {}",joinPoint.getSignature().getDeclaringType());
        log.info("getName: {}",joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "execution(* kr.soft.study.api.StudyController.*(..))", throwing = "e")
    public void afterThrowingAPI(JoinPoint joinPoint, Exception e) {
        log.info("=======================afterThrowing======================");
        log.info("type-name: {}",joinPoint.getSignature().getDeclaringType());
        log.info("getName: {}",joinPoint.getSignature().getName());
    }

    @Around("execution(* kr.soft.study.api.StudyController.*(..))")
    public Object afterAroundAPI(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("=======================Around Start======================");
        log.info("type-name: {}",joinPoint.getSignature().getDeclaringType());
        log.info("getName: {}",joinPoint.getSignature().getName());

        long start = System.currentTimeMillis();
        //년, 월, 일, 시, 분, 초 이 모든 것을 모두 초로 환산하기 때문에 21억 이상이다. 그래서 long으로 받아야한다.
        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        log.info("=======================Around End======================");
        log.info("class: {}",joinPoint.getSignature().getDeclaringTypeName());
        log.info("method: {}",joinPoint.getSignature().getName());
        log.info("time: {}",(end-start));

        return result;
    }

}
