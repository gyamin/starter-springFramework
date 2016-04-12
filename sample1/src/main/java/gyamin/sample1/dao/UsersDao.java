package gyamin.sample1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import javax.sql.DataSource;
import gyamin.sample1.dao.UserBean;


@Component
public class UsersDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<UserBean> selectAll() {
        String sql = "SELECT id, name FROM users";
        List<UserBean> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserBean>(UserBean.class));
        return users;
    }
}
