package com.example.springproxy.cglib;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceImpl implements ServiceInterface{

    @Override
    public void save() {
      log.info("save invoke");
    }

    @Override
    public void find() {
        log.info("find invoke");
    }

}
