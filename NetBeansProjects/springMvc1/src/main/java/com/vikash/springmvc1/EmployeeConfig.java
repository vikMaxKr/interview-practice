
package com.vikash.springmvc1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration 
public class EmployeeConfig {
    
    
    @Bean(name="EmployeeService")
    public EmployeeServiceImpl empservice()
    {
        return new EmployeeServiceImpl();
    }
    
}
