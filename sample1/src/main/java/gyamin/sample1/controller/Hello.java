package gyamin.sample1.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

//＠Controllerアノテーションにより、コントローラとして動作

@Controller
public class Hello {
    // @RequestMappingアノテーションでURLをマッピング
    @RequestMapping(value = "/hello1", method = GET)
    public String hello1() {
        // return "jspファイル名" でjspのテンプレートファイルを指定
        return "hello1";
    }

    // GETパラメータの受け取り
    // http://localhost:8080/sample1?user=Mike&message=Hello
    @RequestMapping(value = "/hello2", method = GET)
    public String hello2(
            // @RequestParamでパラメータを取得
            @RequestParam String user, @RequestParam String message, Model model) {
        // model.addAttributeでkey:valueで値を保持し、jspにデータを渡す
        model.addAttribute("modelUser", user);
        model.addAttribute("modelMessage", message);
        return "hello2";
    }

}