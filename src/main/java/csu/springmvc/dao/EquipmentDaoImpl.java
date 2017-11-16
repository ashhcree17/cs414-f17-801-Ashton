package csu.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import csu.springmvc.dao.EquipmentDao;
import csu.springmvc.model.Equipment;

public class EquipmentDaoImpl implements EquipmentDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public void addEquipment(Equipment equipment) {

    String sql = "insert into equipment values(?,?,?)";

    jdbcTemplate.update(sql, new Object[] { equipment.getEquipmentid(), 
        equipment.getName(), /*equipment.getPicture(),*/ equipment.getQuantity() });
  }

  public Equipment getEquipment(int equipmentid) {

    String sql = "select * from equipment where equipmentid=" + equipmentid;

    List<Equipment> equipments = jdbcTemplate.query(sql, new EquipmentMapper());

    return equipments.size() > 0 ? equipments.get(0) : null;
  }

  public List<Equipment> listEquipment() {

    String sql = "select * from equipment";

    List<Equipment> equipment = jdbcTemplate.query(sql, new EquipmentMapper());

    return equipment;
  }
}

class EquipmentMapper implements RowMapper<Equipment> {

  public Equipment mapRow(ResultSet rs, int arg1) throws SQLException {
    Equipment equipment = new Equipment();

    equipment.setEquipmentid(rs.getInt("equipmentid"));
    equipment.setName(rs.getString("name"));
//    equipment.setPicture(rs.getBlob("picture"));
    equipment.setQuantity(rs.getInt("quantity"));

    return equipment;
  }
}