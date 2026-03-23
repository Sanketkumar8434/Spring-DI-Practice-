//DAO Interface Implementation Class
package com.sanket.Dao;

import com.sanket.model.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository("custDAO")
public class CustomerDAOImpl implements ICustomerDAO{
    private static final String CUSTOMER_INFO_INSERT_QUERY = "insert into customer_info(cname, cAddress, BillAmount, Discount, FinalAmount) values(?,?,?,?,?)";
    @Autowired
    private DataSource ds;  //HAS-A Property
    @Override
    public int insert(CustomerInfo cust) throws Exception {
        int count = 0;
        try {
        Connection con = ds.getConnection();
        PreparedStatement ps = con.prepareStatement(CUSTOMER_INFO_INSERT_QUERY);

        //Set the query paramaters
            ps.setString(1, cust.getCName());
            ps.setString(2, cust.getCAddress());
            ps.setDouble(3, cust.getBillAmount());
            ps.setDouble(4, cust.getDiscount());
            ps.setDouble(5, cust.getFinalAmount());
        //execute the sql query
        count = ps.executeUpdate();
    }

    catch (SQLException se) {
        se.printStackTrace(); //Exception Rethrowing for Exception propagation
        throw se;
    }

    catch (Exception e) {
        e.printStackTrace();  //Exception Rethrowing for Exception propagation
        throw e;
    }
        return count;
    }
}
