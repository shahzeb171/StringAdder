package com.shahzeb.StringAdder;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
	int Add(String numbers) {
		List<String> str = mysplit(numbers);
		int sum=0;
		for(String x : str) {
			int val = Integer.parseInt(x);
			sum+=val;
		}
		return sum;
	}
	List<String> mysplit(String s) {
		List<String> list = new ArrayList<>();
		String num="",delimit="";
		char wordA[] = s.toCharArray();
		for(int i=0;i<wordA.length;i++) {
			if(wordA[i]>='0' && wordA[i]<='9' || wordA[i]=='-' ) {
				if(delimit.length()!=0) {
					if(delimit.equals(",")||delimit.equals("\n")) {
						list.add(num);
						num="";
						delimit="";
					}
					else
						System.out.println("WRONG DELIMITING");
				}
				num+=wordA[i];
			}
			else {
				delimit+=wordA[i];
			}
		}
		if(num.length()!=0)
			list.add(num);
		return list;
	}
}
