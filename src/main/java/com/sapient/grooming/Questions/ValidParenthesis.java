package com.sapient.grooming.Questions;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args){
        String input = "(())";
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<input.length(); i++){
            char ch = input.charAt(i);
            if(ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
                if(st.peek().equals('(')){
                    st.pop();
                }
                else {
                    System.out.println("Not a valid String");
                    break;
                }
            }
        }
        if(st.size()>0) System.out.println("Not a valid Parenthesis");
        else System.out.println("Valid Parenthesis");
    }
}
