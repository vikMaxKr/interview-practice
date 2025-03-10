
package com.vikash.springmvc1;

public class EmployeeServiceImpl  implements EmployeeService{
    
    @Override
    public void insert(EmployeeDTO emp)
    {
       System.out.println(emp.getEmpName());
    }
    
    public void delete(int empid)
    {
        System.out.println("Deleted");
    }
    
    
    
    
}
