package csu.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import csu.springmvc.model.Login;
import csu.springmvc.model.Trainer;

public class TrainerDaoImpl implements TrainerDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public void register(Trainer trainer) {

    String sql = "insert into trainer values(?,?,?,?,?,?,?,?)";

    jdbcTemplate.update(sql, new Object[] { trainer.getTrainerid(), 
        trainer.getUsername(), trainer.getPassword(), trainer.getFirstname(),
        trainer.getLastname(), trainer.getPhonenumber(), trainer.getEmail(), 
        trainer.getInsurance() });
  }

  public Trainer validateTrainer(Login login) {

    String sql = "select * from trainer where username='" + login.getUsername() 
                + "' and password='" + login.getPassword() + "'";

    List<Trainer> trainers = jdbcTemplate.query(sql, new TrainerMapper());

    return trainers.size() > 0 ? trainers.get(0) : null;
  }
}

class TrainerMapper implements RowMapper<Trainer> {

  public Trainer mapRow(ResultSet rs, int arg1) throws SQLException {
    Trainer trainer = new Trainer();

    trainer.setTrainerid(rs.getInt("trainerid"));
    trainer.setUsername(rs.getString("username"));
    trainer.setPassword(rs.getString("password"));
    trainer.setFirstname(rs.getString("firstname"));
    trainer.setLastname(rs.getString("lastname"));
    trainer.setEmail(rs.getString("email"));
    trainer.setPhonenumber(rs.getInt("phonenumber"));

    return trainer;
  }
}