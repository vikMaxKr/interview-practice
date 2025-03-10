
package com.mycompany.interviewprep.comparator;

/**
 *
 * @author vikashkumar
 * 
 */
public class Employee {
    
    private int id;
    private int age;
    private String name;
    private Address address;

    public Employee(int id, int age, String name, Address address) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.address = address;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", age=" + age + ", name=" + name + ", address=" + address + '}';
    }
    
}
