
package com.vikash.springmvc1;


public class EmployeeDTO {
    
    private int empId;
    private String empName;
    private String department;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }
    
    

    public EmployeeDTO(int empId, String empName, String department) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
    }
    

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    
    
}
