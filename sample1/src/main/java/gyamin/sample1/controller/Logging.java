package gyamin.sample1.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.apache.log4j.Logger;

@Controller
public class Logging {
    static Logger log = Logger.getLogger(Logging.class.getName());

    @RequestMapping(value = "/logging1", method = GET)
    public String logging1(Model model) {
        log.debug("This is DEBUG LEVEL log.");
        log.info("This is INFO LEVEL log.");
        log.warn("This is WARN LEVEL log.");
        log.error("This is ERROR LEVEL log.");
        log.fatal("This is FATAL LEVEL log.");
        return "logging1";
    }
}
