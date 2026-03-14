package com.sanket.client;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.sanket.sbeans.WishMessageGenerator;

public class DependencyInjectionTest {
    public static void main(String[] args)
    {
        //create the IOC Container
        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/com/sanket/cfgs/applicationContext.xml");
        //get target spring bean class obj from the ioc container
       // Object obj = ctx.getBean("wmg");
        WishMessageGenerator generator = (WishMessageGenerator)ctx.getBean("wmg");
        String result = generator.generateWishMessage("Sanket");
        System.out.println("Result : "+result);
        ctx.close();
    }
}
