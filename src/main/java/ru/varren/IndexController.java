package ru.varren;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by varren on 01.09.17.
 */
@Controller
public class IndexController {

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
