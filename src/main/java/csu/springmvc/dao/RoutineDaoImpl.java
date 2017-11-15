package csu.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import csu.springmvc.dao.RoutineDao;
import csu.springmvc.model.Routine;

public class RoutineDaoImpl implements RoutineDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public void addRoutine(Routine routine) {

    String sql = "insert into routine values(?,?)";

    jdbcTemplate.update(sql, new Object[] { routine.getRoutineid(), 
        routine.getName() });
  }

  public Routine getRoutine(int routineid) {

    String sql = "select * from routine where routineid=" + routineid;

    List<Routine> routines = jdbcTemplate.query(sql, new RoutineMapper());

    return routines.size() > 0 ? routines.get(0) : null;
  }
}

class RoutineMapper implements RowMapper<Routine> {

  public Routine mapRow(ResultSet rs, int arg1) throws SQLException {
    Routine routine = new Routine();

    routine.setRoutineid(rs.getInt("routineid"));
    routine.setName(rs.getString("name"));

    return routine;
  }
}