package gyamin.sample1.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import gyamin.sample1.dao.UsersDao;
import gyamin.sample1.dao.UserBean;
import java.util.List;

@Controller
public class Jdbc {
    @RequestMapping(value = "/jdbc1", method = GET)
    public String jdbc1() {
        UsersDao usersDao = new UsersDao();
        List<UserBean> users = usersDao.selectAll();
        return "jdbc1";
    }
}
