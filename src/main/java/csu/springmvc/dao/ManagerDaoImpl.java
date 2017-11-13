package csu.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import csu.springmvc.model.Login;
import csu.springmvc.model.Manager;

public class ManagerDaoImpl implements ManagerDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public void register(Manager manager) {

    String sql = "insert into manager values(?,?,?,?,?,?,?,?)";

    jdbcTemplate.update(sql, new Object[] { manager.getManagerid(), 
        manager.getUsername(), manager.getPassword(), manager.getName(),
        manager.getLastname(), manager.getPhonenumber(), manager.getEmail(), 
        manager.getInsurance() });
  }

  public Manager validateManager(Login login) {

    String sql = "select * from manager where username='" + login.getUsername() 
                + "' and password='" + login.getPassword() + "'";

    List<Manager> managers = jdbcTemplate.query(sql, new ManagerMapper());

    return managers.size() > 0 ? managers.get(0) : null;
  }
}

class ManagerMapper implements RowMapper<Manager> {

  public Manager mapRow(ResultSet rs, int arg1) throws SQLException {
    Manager manager = new Manager();

    manager.setManagerid(rs.getInt("managerid"));
    manager.setUsername(rs.getString("username"));
    manager.setPassword(rs.getString("password"));
    manager.setName(rs.getString("name"));
    manager.setLastname(rs.getString("lastname"));
    manager.setPhonenumber(rs.getInt("phonenumber"));
    manager.setEmail(rs.getString("email"));
    manager.setInsurance(rs.getString("insurance"));

    return manager;
  }
}