package csu.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import csu.springmvc.dao.WorkScheduleDao;
import csu.springmvc.model.WorkSchedule;

public class WorkScheduleDaoImpl implements WorkScheduleDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public void createWorkSchedule(WorkSchedule workSchedule) {

    String sql = "insert into workSchedule values(?,?,?,?)";

    jdbcTemplate.update(sql, new Object[] { workSchedule.getWorkScheduleid(), 
        workSchedule.getDay(), workSchedule.getStartTime(), workSchedule.getEndTime() });
  }

  public WorkSchedule getWorkSchedule(int workScheduleid) {

    String sql = "select * from workSchedule where workScheduleid=" + workScheduleid;

    List<WorkSchedule> workSchedules = jdbcTemplate.query(sql, new WorkScheduleMapper());

    return workSchedules.size() > 0 ? workSchedules.get(0) : null;
  }
}

class WorkScheduleMapper implements RowMapper<WorkSchedule> {

  public WorkSchedule mapRow(ResultSet rs, int arg1) throws SQLException {
    WorkSchedule workSchedule = new WorkSchedule();

    workSchedule.setWorkScheduleid(rs.getInt("workScheduleid"));
    workSchedule.setDay(rs.getDate("day"));
    workSchedule.setStartTime(rs.getString("startTime"));
    workSchedule.setEndTime(rs.getString("endTime"));

    return workSchedule;
  }
}