package gyamin.sample1.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.SQLException;

import gyamin.sample1.dao.UsersDaoImpl;
import gyamin.sample1.dao.UserBean;
import java.util.List;

@Controller
public class Jdbc {
    @RequestMapping(value = "/jdbc1", method = GET)
    public String jdbc1(Model model) {

        // データベース設定を取得
        ApplicationContext ctx = new ClassPathXmlApplicationContext("db-postgre.xml");
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("db-oracle.xml");
        // bean設定を取得しインスタンス作成
        UsersDaoImpl usersDaoImpl = ctx.getBean(UsersDaoImpl.class);

        // usersDaoImplを利用してDBアクセス、usersテーブルを全て取得
        List<UserBean> users = usersDaoImpl.selectAll();
        model.addAttribute("modelUsers", users);
        return "jdbc1";
    }

    @RequestMapping(value = "/jdbc_json1", method = GET)
    @ResponseBody
    public ResponseEntity<List<UserBean>> jdbcJson1(Model model) {

        // データベース設定を取得
        ApplicationContext ctx = new ClassPathXmlApplicationContext("db-postgre.xml");
        // bean設定を取得しインスタンス作成
        UsersDaoImpl usersDaoImpl = ctx.getBean(UsersDaoImpl.class);
        // usersDaoImplを利用してDBアクセス、usersテーブルを全て取得
        List<UserBean> users = usersDaoImpl.selectAll();
        return new ResponseEntity<List<UserBean>>(users, HttpStatus.OK);
    }

    // レスポンスのContent-Typeを"application/json"に設定するには、produces = "application/json"を設定
    @RequestMapping(value = "/jdbc_json2", method = GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<UserBean>> jdbcJson2(Model model) {

        // データベース設定を取得
        ApplicationContext ctx = new ClassPathXmlApplicationContext("db-postgre.xml");
        // bean設定を取得しインスタンス作成
        UsersDaoImpl usersDaoImpl = ctx.getBean(UsersDaoImpl.class);
        try {
            // usersDaoImplを利用してDBアクセス、usersテーブルを全て取得
            List<UserBean> users = usersDaoImpl.selectAll();
            return new ResponseEntity<List<UserBean>>(users, HttpStatus.OK);
        }catch(Exception e) {
            // Exceptionが発生した場合は、Http Status Code 500でレスポンス
            return new ResponseEntity("Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
