package com.huafanfan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author alex
 */
public class ValidParentheses0020 {
	private HashMap<Character,Character> mappings;
	
	public ValidParentheses0020(){
		this.mappings = new HashMap<>();
		this.mappings.put(')','(');
		this.mappings.put(']','[');
		this.mappings.put('}','{');
		
	}
	/*
	 * 时间复杂度：O(n)，因为我们一次只遍历给定的字符串中的一个字符并在栈上进行 O(1)的推入和弹出操作。
	 * 空间复杂度：O(n)，当我们将所有的开括号都推到栈上时以及在最糟糕的情况下，我们最终要把所有括号推到栈上。
	 */
	
	public boolean isValid(String s) {
		Stack<Character> st = new Stack<Character>();
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			
			if(this.mappings.containsKey(c)){
				char top = st.empty() ? '#' : st.pop();
				if(top!= this.mappings.get(c)) {
					return false;
				}
			}
			else {
				st.push(c);
			}
		}

		return st.isEmpty();
	}
	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<>();
		String test = "((((((((((";
		ValidParentheses0020 a = new ValidParentheses0020();
		System.out.println(a.isValid(test));

	}

}
