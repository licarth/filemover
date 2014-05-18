package com.licarth.filemover;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

/**
 * Created by thomas on 07/05/14.
 */
@Service
@Log4j
public class JdbcService {

    public JdbcService() {
        log.debug("Jdbc Service created.");
        log.debug("line after JS :" + (System.currentTimeMillis() - App.start));
    }
}
