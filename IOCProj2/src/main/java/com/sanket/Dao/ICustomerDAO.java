//DAO Interface
package com.sanket.Dao;

import com.sanket.model.CustomerInfo;

public interface ICustomerDAO {

    public int insert(CustomerInfo cust)throws Exception;
}
