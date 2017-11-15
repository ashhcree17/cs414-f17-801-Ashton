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

  public void addAddress(Address address) {

    String sql = "insert into address values(?,?,?,?,?,?)";

    jdbcTemplate.update(sql, new Object[] { address.getAddressid(), 
        address.getStreet1(), address.getStreet2(), address.getCity(),
        address.getState(), address.getZipcode() });
  }

  public void deleteAddress(int addressid) {
    
    String sql = "delete from address where addressid=" + addressid;

    jdbcTemplate.execute(sql);
  }

  public Address getAddress(int addressid) {

    String sql = "select * from address where addressid=" + addressid;

    List<Address> addresses = jdbcTemplate.query(sql, new AddressMapper());

    return addresses.size() > 0 ? addresses.get(0) : null;
  }

  public List<Address> listAddresses() {

    String sql = "select * from address";

    List<Address> addresses = jdbcTemplate.query(sql, new AddressMapper());

    return addresses;
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