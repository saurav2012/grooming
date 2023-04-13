package com.sapient.grooming.Questions;

import java.util.LinkedList;
import java.util.Stack;

public class Palindorme {
    public static void main(String[] args) {
        LinkedList<Character> ll = new LinkedList<>();
        Stack<Character> st = new Stack<>();
        String input = "saas";
        for(int i=0; i<input.length(); i++){
            ll.add(input.charAt(i));
        }

        st.addAll(ll);

        for (Character character : ll) {
            if (!character.equals(st.peek())) {
                System.out.println("Not a palindrome");
                return;
            }
            st.pop();
        }
        System.out.println("It is a palindrome");

    }

}
