package com.sanket.client;

import com.sanket.config.AppConfig;
import com.sanket.sbeans.WishMessageGenerator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependencyInjectionTest {

    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        // IOC CONTAINER CREATED
        WishMessageGenerator generator = ctx.getBean("wmg", WishMessageGenerator.class);
        // CALL B.METHOD
        String wish = generator.GenerateWish("Sanket Chief");
        System.out.println(wish);
    }
}
