package com.sanket.service;

import com.sanket.Dao.ICustomerDAO;
import com.sanket.model.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService{
    @Autowired
    private ICustomerDAO custDAO;
    @Override
    public String registerCustomer(CustomerInfo cust) throws Exception {

//    calculate Discount and final bill amount
        Double discountAmount = (cust.getBillAmount()* (cust.getDiscount()/100.0));
        Double finalAmount = cust.getBillAmount() - discountAmount;
        cust.setFinalAmount(finalAmount);

//     use DAO
        int count = custDAO.insert(cust);
//        here using ternary operator
        return count==0?"Customer Registration Failed":"Customer is registered having bill amount :: " +cust.getBillAmount()+" Discount Amount :: "+cust.getDiscount()+"% "+"Final Amount :: "+finalAmount;
    }
}
