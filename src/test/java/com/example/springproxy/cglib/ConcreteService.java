package com.example.springproxy.cglib;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor // 클래스 기반 프록시는 기본 생성자가 필요하다.

public class ConcreteService {

    public final void call(){
        log.info("ConcreteService call invoke");
    }
}
