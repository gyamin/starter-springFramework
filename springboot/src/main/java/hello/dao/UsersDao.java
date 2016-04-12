package hello.dao;

import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuffer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import hello.dao.User;

@Component
public class UsersDao {

    @Autowired
    private JdbcTemplate jdbc;

//    public UsersDao(JdbcTemplate jdbcTemplate) {
//        this.jdbc = jdbcTemplate;
//    }

    public void findAll() {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT id, name FROM USERS");
        List list = this.jdbc.queryForList(sql.toString());
        list.size();
        return;
    }
}