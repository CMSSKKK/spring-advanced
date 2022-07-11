package com.example.springproxy.cglib;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
@RequiredArgsConstructor
public class TimeMethodInterceptor implements MethodInterceptor {

    private final Object target;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("Time proxy begin");
        long startTime = System.currentTimeMillis();

        Object result = methodProxy.invoke(target, objects);

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("Time proxy end, resultTime = {}", resultTime);

        return result;
    }
}
