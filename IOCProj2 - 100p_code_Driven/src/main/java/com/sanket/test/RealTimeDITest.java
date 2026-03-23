package com.sanket.test;

import com.sanket.config.AppConfig;
import com.sanket.controller.CustomerOperationsController;
import com.sanket.model.CustomerInfo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class RealTimeDITest {

    public static void main(String[] args) {

//        read input value from end user
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter Customer no : ");
//        int cno = sc.nextInt();
        System.out.println("Enter Customer Name : ");
        String name = sc.nextLine();
        System.out.println("Enter Customer Address ::");
        String Address = sc.nextLine();
        System.out.println("Enter Customer bill amount ::");
        double BillAmount = sc.nextDouble();
        System.out.println("Enter Discount Percentage ::");
        double discount = sc.nextDouble();

//        create customer class object
        CustomerInfo cust = new CustomerInfo();
//        cust.setCno(cno);
        cust.setCName(name);
        cust.setCAddress(Address);
        cust.setBillAmount(BillAmount);
        cust.setDiscount(discount);

//        create IOC Container
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

//        get controller class object from the IOC container(dependency lookup)
        CustomerOperationsController controller = ctx.getBean("custController",CustomerOperationsController.class);

//        invoke the business method
        try {
            String resultMsg = controller.processCustomer(cust);
            System.out.println(resultMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ctx.close();
    }
}
