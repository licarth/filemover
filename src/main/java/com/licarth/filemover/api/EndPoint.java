package com.licarth.filemover.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by thomas on 07/05/14.
 */
@Controller
@RequestMapping("/rest")
public class EndPoint {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld(){
        return "Hello";
    }
}
