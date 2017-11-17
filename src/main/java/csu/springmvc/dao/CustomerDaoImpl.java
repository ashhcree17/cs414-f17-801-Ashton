package csu.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import csu.springmvc.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public void addCustomer(Customer customer) {

    String sql = "insert into customer values(?,?,?,?,?,?,?)";

    jdbcTemplate.update(sql, new Object[] { customer.getCustomerid(), 
        customer.getName(), customer.getLastname(), 
        customer.getPhonenumber(), customer.getEmail(), 
        customer.getInsurance(), customer.getMembership() });
  }

  public Customer getCustomer(int customerid) {

    String sql = "select * from customer where customerid='" + customerid + "'";

    List<Customer> customers = jdbcTemplate.query(sql, new CustomerMapper());

    return customers.size() > 0 ? customers.get(0) : null;
  }

  public List<Customer> listCustomers() {

    String sql = "select * from customer";

    List<Customer> customers = jdbcTemplate.query(sql, new CustomerMapper());

    return customers;
  }
}

class CustomerMapper implements RowMapper<Customer> {

  public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
    Customer customer = new Customer();

    customer.setCustomerid(rs.getInt("customerid"));
    customer.setName(rs.getString("name"));
    customer.setLastname(rs.getString("lastname"));
    customer.setPhonenumber(rs.getInt("phonenumber"));
    customer.setEmail(rs.getString("email"));
    customer.setInsurance(rs.getString("insurance"));
    customer.setMembership(rs.getObject("membership"));

    return customer;
  }
}