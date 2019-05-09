package com.zamacloud.commons.clientapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Fact S Musingarimi
 * 12/10/18
 * 5:03 AM
 */
@Controller
public class LogoutController {
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String loginPage() {
        return "logout";
    }

}
