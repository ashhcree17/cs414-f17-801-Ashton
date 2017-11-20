package csu.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import csu.springmvc.dao.ExerciseDao;
import csu.springmvc.model.Exercise;

public class ExerciseDaoImpl implements ExerciseDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public void createExerciseDuration(Exercise exercise) {

    String sql = "insert into exercise values(?,?,?,?,?)";

    jdbcTemplate.update(sql, new Object[] { exercise.getExerciseid(), 
        exercise.getName(), exercise.getDuration(), null, null });
  }
  
  public void createExerciseSets(Exercise exercise) {

    String sql = "insert into exercise values(?,?,?,?,?)";

    jdbcTemplate.update(sql, new Object[] { exercise.getExerciseid(), 
        exercise.getName(), null, exercise.getNumberOfSets(), exercise.getRepsPerSet() });
  }

  public Exercise getExercise(int exerciseid) {

    String sql = "select * from exercise where exerciseid=" + exerciseid;

    List<Exercise> exercises = jdbcTemplate.query(sql, new ExerciseMapper());

    return exercises.size() > 0 ? exercises.get(0) : null;
  }
}

class ExerciseMapper implements RowMapper<Exercise> {

  public Exercise mapRow(ResultSet rs, int arg1) throws SQLException {
    Exercise exercise = new Exercise();

    exercise.setExerciseid(rs.getInt("exerciseid"));
    exercise.setName(rs.getString("name"));
    exercise.setDuration(rs.getInt("duration"));
    exercise.setNumberOfSets(rs.getInt("numberOfSets"));
    exercise.setRepsPerSet(rs.getInt("repsPerSet"));

    return exercise;
  }
}