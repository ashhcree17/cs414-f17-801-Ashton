package csu.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import csu.springmvc.dao.QualificationDao;
import csu.springmvc.model.Qualification;

public class QualificationDaoImpl implements QualificationDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public void createQualification(Qualification qualification) {

    String sql = "insert into qualification values(?,?)";

    jdbcTemplate.update(sql, new Object[] { 
        qualification.getQualificationid(), qualification.getName() });
  }

  public Qualification getQualification(int qualificationid) {

    String sql = "select * from qualification where qualificationid=" + qualificationid;

    List<Qualification> qualifications = jdbcTemplate.query(sql, new QualificationMapper());

    return qualifications.size() > 0 ? qualifications.get(0) : null;
  }
}

class QualificationMapper implements RowMapper<Qualification> {

  public Qualification mapRow(ResultSet rs, int arg1) throws SQLException {
    Qualification qualification = new Qualification();

    qualification.setQualificationid(rs.getInt("qualificationid"));
    qualification.setName(rs.getString("name"));

    return qualification;
  }
}