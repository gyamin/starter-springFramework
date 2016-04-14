package gyamin.sample1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import javax.sql.DataSource;
import gyamin.sample1.dao.UserBean;

@Repository
public class UsersDaoImpl implements UsersDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<UserBean> selectAll() {
        try {
            String sql = "SELECT id, name FROM users";
            List<UserBean> users = this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserBean>(UserBean.class));
            return users;
        }catch(DataAccessException e) {
            throw e;
        }
    }
}
