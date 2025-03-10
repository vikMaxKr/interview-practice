package com.vikash.vikash.practice.javaconcepts;

/*
Method Overloading:

Java selects the most specific method that can handle the argument type, based on the rules of type conversion (widening or boxing/unboxing).
Type of a:

a is declared as long a = 1L;, so its type is long.
Available Methods:

test(float a): Accepts a float (32-bit floating-point).
test(double a): Accepts a double (64-bit floating-point).
Type Widening Order:

A long can be widened to either:
float (as long → float is a valid widening conversion).
double (as long → double is also a valid widening conversion).
However, Java prefers the "narrower" widening if both are possible when considering overloading. This means:
From long, the conversion to float is narrower than the conversion to double.
 */
public class Overloading {

    private void test(double a)
    {
        System.out.println("double test "+a);
    }

    private void test(float a)
    {
        System.out.println("float test "+a);
    }

    public static void main(String[] args) {

        long a=1L;
        Overloading test1=new Overloading();
        test1.test(a);
    }
}

