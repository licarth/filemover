package com.licarth.filemover;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

/**
 * Created by thomas on 07/05/14.
 */
@Service
@Log
public class JdbcService {

    public JdbcService() {
        log.info("Jdbc Service created.");
        log.info("line after JS :" + (System.currentTimeMillis() - App.start));
    }
}
