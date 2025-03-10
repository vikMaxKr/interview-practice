/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interviewprep.comparator;

/**
 *
 * @author vikashkumar
 */
public class Address  implements Comparable<Address>{
    
    private String streetName;
    private int pinCode;

    public Address(String streetName, int pinCode) {
        this.streetName = streetName;
        this.pinCode = pinCode;
    }

    
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public int compareTo(Address o) {
     return this.pinCode-o.pinCode;
    }

    @Override
    public String toString() {
        return "Address{" + "streetName=" + streetName + ", pinCode=" + pinCode + '}';
    }
    
    
}
