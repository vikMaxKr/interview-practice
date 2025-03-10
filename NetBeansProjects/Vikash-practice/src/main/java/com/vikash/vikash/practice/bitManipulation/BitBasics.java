package com.vikash.vikash.practice.bitManipulation;

/*
 * Bitwise AND (&):

Sets each bit to 1 if both corresponding bits are 1.
java
Copy code
int a = 5;  // 0101 in binary
int b = 3;  // 0011 in binary
int result = a & b;  // 0001 in binary, which is 1
System.out.println(result);



Bitwise OR (|):

Sets each bit to 1 if at least one of the corresponding bits is 1.
java
Copy code
int a = 5;  // 0101 in binary
int b = 3;  // 0011 in binary
int result = a | b;  // 0111 in binary, which is 7
System.out.println(result);



Bitwise XOR (^):

Sets each bit to 1 if only one of the corresponding bits is 1.
java
Copy code
int a = 5;  // 0101 in binary
int b = 3;  // 0011 in binary
int result = a ^ b;  // 0110 in binary, which is 6
System.out.println(result);


Bitwise NOT (~):

Inverts all the bits (flips 0 to 1 and 1 to 0).
java
Copy code
int a = 5;  // 0101 in binary
int result = ~a;  // 1010 in binary (2's complement), which is -6
System.out.println(result);



Left Shift (<<):

Shifts bits to the left, adding 0s from the right.
java
Copy code
int a = 5;  // 0101 in binary
int result = a << 1;  // 1010 in binary, which is 10
System.out.println(result);



Right Shift (>>):

Shifts bits to the right, maintaining the sign bit (sign-extended).
java
Copy code
int a = 5;  // 0101 in binary
int result = a >> 1;  // 0010 in binary, which is 2
System.out.println(result);

int b = -5;  // 11111011 in binary (2's complement)
int resultNegative = b >> 1;  // 11111101 in binary, which is -3
System.out.println(resultNegative);


Unsigned Right Shift (>>>):

Shifts bits to the right, adding 0s from the left regardless of the sign bit.
java
Copy code
int a = 5;  // 0101 in binary
int result = a >>> 1;  // 0010 in binary, which is 2
System.out.println(result);

int b = -5;  // 11111011 in binary (2's complement)
int resultUnsigned = b >>> 1;  // 01111101 in binary, which is 2147483645
System.out.println(resultUnsigned);


n>>=1 --> n=n/2;
n<<=1  --> n=n*2;
 */