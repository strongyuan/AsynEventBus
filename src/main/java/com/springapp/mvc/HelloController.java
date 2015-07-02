package com.springapp.mvc;

import com.springapp.mvc.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class HelloController {

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/", method = GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    @RequestMapping(value = "/event", method = GET)
    @ResponseBody
    public String doEvent() {
        return "ok:" + eventService.doEvent();
    }

}
