package com.vikash.springmvc1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
        EmployeeServiceImpl empservice=null;
        
        AbstractApplicationContext context=new AnnotationConfigApplicationContext(EmployeeConfig.class);
        empservice=(EmployeeServiceImpl)context.getBean("EmployeeService");
        EmployeeDTO dto=new EmployeeDTO(12,"vik","CSE");
        empservice.insert(dto);
       empservice.delete(12);
       context.close();
    }
}
