/*
 * Given a string S containing only digits, Your task is to complete the function genIp() which returns a vector containing all
 * possible combinations of valid IPv4 IP addresses and takes only a string S as its only argument.
Note: Order doesn't matter. A valid IP address must be in the form of A.B.C.D, where A, B, C, and D are numbers from 0-255. 
The numbers cannot be 0 prefixed unless they are 0.
For string 11211 the IP address possible are 
1.1.2.11
1.1.21.1
1.12.1.1
11.2.1.1
 */

package com.vikash.vikash.practice.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class IPGenerator {
    public static List<String> genIp(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        generateIpAddresses(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateIpAddresses(String s, int start, List<String> segments, List<String> result) {
        // Base case: if we have 4 segments and we've reached the end of the string, it's a valid IP
        if (segments.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", segments));
            }
            return;
        }

        // Try placing a dot after each of the next 1 to 3 characters, if valid
        for (int i = 1; i <= 3; i++) {
            if (start + i <= s.length()) {
                String segment = s.substring(start, start + i);
                //System.out.println("i--"+i+"--start-"+start+"--"+"--segment-"+segment);
                if (isValidSegment(segment)) {
                    segments.add(segment);
                    System.out.println("segments-"+segments);
                    generateIpAddresses(s, start + i, segments, result);
                    segments.remove(segments.size() - 1);
                }
            }
        }
    }

    // Helper function to check if a segment is a valid part of an IP address
    private static boolean isValidSegment(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) {
            return false; // No leading zero unless the segment is exactly "0"
        }
        int value = Integer.parseInt(segment);
        return value >= 0 && value <= 255;
    }

    public static void main(String[] args) {
        String input = "12345678";
        List<String> ipAddresses = genIp(input);
//        for (String ip : ipAddresses) {
//            System.out.println(ip);
//        }
    }
}

