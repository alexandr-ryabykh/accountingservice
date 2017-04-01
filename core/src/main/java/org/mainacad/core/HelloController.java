package org.mainacad.core;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = "/")
    public ModelAndView getIndex() {
        return new ModelAndView("hello");
    }

}
