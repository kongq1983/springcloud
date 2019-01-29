package com.kq.springmvc;

/**
 * StrTest
 *
 * @author kq
 * @date 2019-01-21
 */
public class StrTest {

    public static void main(String args[]) {
//        String str = "SAUTHORITY0000000000000001082005";
        String str = "SAUTHORITY0000000000000000012620";
        System.out.println("len="+str.length());

        String input = "8BBBBB";

        if ((input.length() & 1) == 1) {
            System.out.println("--------------------------1");
        }

    }

}
