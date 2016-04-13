package gyamin.sample1.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import gyamin.sample1.dao.UsersDaoImpl;
import gyamin.sample1.dao.UserBean;
import java.util.List;

@Controller
public class Jdbc {
    @RequestMapping(value = "/jdbc1", method = GET)
    public String jdbc1(Model model) {

        // データベース設定を取得
        ApplicationContext ctx = new ClassPathXmlApplicationContext("database.xml");
        // bean設定を取得しインスタンス作成
        UsersDaoImpl usersDaoImpl = ctx.getBean(UsersDaoImpl.class);

        // usersDaoImplを利用してDBアクセス、usersテーブルを全て取得
        List<UserBean> users = usersDaoImpl.selectAll();
        model.addAttribute("modelUsers", users);
        return "jdbc1";
    }
}
