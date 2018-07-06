package com.yys.lottery.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("")
public class ApiController {

    @RequestMapping(value = "docs",method = RequestMethod.GET)
    public void Api(HttpServletResponse response) throws IOException {
        response.sendRedirect("swagger-ui.html");
    }

}
