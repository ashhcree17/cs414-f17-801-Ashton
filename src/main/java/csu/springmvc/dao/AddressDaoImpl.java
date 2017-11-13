package csu.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import csu.springmvc.dao.AddressDao;
import csu.springmvc.model.Address;

public class AddressDaoImpl implements AddressDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public void register(Address address) {

    String sql = "insert into address values(?,?,?,?,?,?)";

    jdbcTemplate.update(sql, new Object[] { address.getAddressid(), 
        address.getStreet1(), address.getStreet2(), address.getCity(),
        address.getState(), address.getZipcode() });
  }

  public Address getAddress(int addressid) {

    String sql = "select * from address where addressid=" + addressid;

    List<Address> addresss = jdbcTemplate.query(sql, new AddressMapper());

    return addresss.size() > 0 ? addresss.get(0) : null;
  }
}

class AddressMapper implements RowMapper<Address> {

  public Address mapRow(ResultSet rs, int arg1) throws SQLException {
    Address address = new Address();

    address.setAddressid(rs.getInt("addressid"));
    address.setStreet1(rs.getString("street1"));
    address.setStreet2(rs.getString("street2"));
    address.setCity(rs.getString("city"));
    address.setState(rs.getString("state"));
    address.setZipcode(rs.getInt("zipcode"));

    return address;
  }
}