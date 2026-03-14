package com.sanket.controller;

import com.sanket.model.CustomerInfo;
import com.sanket.service.ICustomerMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("custController")
public class CustomerOperationsController {
    @Autowired
    private ICustomerMgmtService custService;

    public String processCustomer(CustomerInfo cust)throws Exception {

//        use Service class
        String result = custService.registerCustomer(cust);
        return result;

    }
}
