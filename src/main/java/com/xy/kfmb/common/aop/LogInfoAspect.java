package com.xy.kfmb.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @Author: Lyh
 * @Date: 2020-03-20
 * @Description : AOP日志拦截
 */

@Slf4j
@Aspect
@Order(1)
@Configuration
public class LogInfoAspect {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void webLog() {
    }

    /**
     * 前置(在目标方法执执行之前执行)
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("AOP------>前置方法执行");
    }

    /**
     * 环绕(在目标方法执行之前执行一次,目标方法之执行结束后执行一次)
     *
     *  proceedingJoinPoint.proceed() 作用是让目标方法执行(意思就是继续执行下面的步骤)
     * @return
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("AOP------>环绕通知执行开始");
        // 环绕通知=前置+目标方法执行+后置通知，proceed方法就是用于启动目标方法执行的.
        // 上面这句话是在(方法不出异常的情况下)宏观上看好像是这样,如果细看的话你会发现一旦程序执行出错
        // 就不再走环绕的结束步骤,但是后置方法不管是否出异常都会执行
        Object result = proceedingJoinPoint.proceed();
        System.out.println("AOP------>环绕通知执行结束");
        return result;
    }

    /**
     * 后置(目标方法执行后执行)
     *
     * @param joinPoint
     * @throws Throwable
     */
    @After("webLog()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("AOP------>后置通知执行");
    }

    /**
     * 异常(目标方法出异常执行)
     *
     * @param joinPoint
     */
    @AfterThrowing(pointcut = "webLog()")
    public void doAfterThrowing(JoinPoint joinPoint) {
        System.out.println("AOP------>异常通知执行");
    }

    /**
     * 返回通知(目标方法成功返回执行)
     * @param joinPoint
     * @throws RuntimeException
     */
    @AfterReturning("webLog()")
    public void after(JoinPoint joinPoint) throws RuntimeException {
        System.out.println("AOP------>返回通知执行");
    }
}
