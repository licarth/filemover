package com.licarth.filemover;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by thomas on 05/05/14.
 *
 * Service that uploads, downloads files.
 *
 *
 *
 */
@Service
@Log
public class UploadService {

    @Autowired
    JdbcService service;

    public UploadService() {
        log.info("File Service created.");
        log.info("line after FS :"+ (System.currentTimeMillis() - App.start));
    }

    @Override
    public String toString() {
        return "This is a file service";
    }
}
