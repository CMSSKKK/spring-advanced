package com.example.springproxy.jdk;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
class JdkDynamicProxyTest {

    @Test
    void dynamicATest() {
        AInterface target = new AImpl();

        InvocationHandler timeInvocationHandler = new TimeInvocationHandler(target);

        AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(),
                new Class[]{AInterface.class}, timeInvocationHandler);
        String result = proxy.call();

        assertThat(result).isEqualTo("A");

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }

    @Test
    void dynamicBTest() {
        BInterface target = new BImpl();

        InvocationHandler timeInvocationHandler = new TimeInvocationHandler(target);

        BInterface proxy = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(),
                new Class[]{BInterface.class}, timeInvocationHandler);
        String result = proxy.call();

        assertThat(result).isEqualTo("B");

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
    }
}
