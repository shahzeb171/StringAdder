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
		int idx = numbers.indexOf("//");
		String delimiters = ",";
		if(idx!=-1) {
			String a[] = getDelimiter(numbers);
			numbers=a[0];
			delimiters = new String(a[1]);
		}
			
		
		
		List<String> str = mysplit(numbers,delimiters);
		int sum=0;
		for(String x : str) {
			int val = Integer.parseInt(x);
			sum+=val;
		}
		return sum;
	}
	List<String> mysplit(String s,String delimiter) {
		List<String> list = new ArrayList<>();
		String num="",delimit="";
		char wordA[] = s.toCharArray();
		for(int i=0;i<wordA.length;i++) {
			if(wordA[i]>='0' && wordA[i]<='9' || wordA[i]=='-' ) {
				if(delimit.length()!=0) {
					if(delimit.equals(delimiter)||delimit.equals("\n")) {
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
	String[] getDelimiter(String s) {
		char wordA[] = s.toCharArray();
		int n = wordA.length,i=2;
		String delim="";
		for(;i<n;i++) {
			if(wordA[i]=='\n')
					break;
			delim+=wordA[i];
		}
		String ar[] = new String[2];
		ar[0]=s.substring(i+1, s.length());
		ar[1] = delim;
		return ar;
	}
}
