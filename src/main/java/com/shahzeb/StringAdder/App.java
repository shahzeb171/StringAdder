package com.shahzeb.StringAdder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
	int Add(String numbers) throws Exception {
		int idx = numbers.indexOf("//");
		HashSet<String> delimiter = new HashSet<>();
		if(idx!=-1)
			numbers=getDelimiter(numbers,delimiter);
		else
			delimiter.add(",");
		delimiter.add("\n");
		List<String> str = mysplit(numbers,delimiter);
		int sum=0;
		String neg="";
		for(String x : str) {
			int val = trimZ(x).length()>4?0:Integer.parseInt(x);
			if(val<0)
				neg+=String.valueOf(x)+" ";
			if(val>1000)
				val=0;
			sum+=val;
		}
		if(neg.length()!=0)
			throw new Exception("negatives not allowed "+neg);
		return sum;
	}
	String trimZ(String s) {
		int i=0;
		for(char c : s.toCharArray()) {
			if(c=='0') {
				i++;
				continue;
			}
			break;
		}
			
		return s.substring(i).length()==0?"0":s.substring(i);
	}
	
	List<String> mysplit(String s,HashSet<String> delim) {
		List<String> list = new ArrayList<>();
		String num="",delimit="";
		char wordA[] = s.toCharArray();
		for(int i=0;i<wordA.length;i++) {
			if(wordA[i]>='0' && wordA[i]<='9' || wordA[i]=='-' ) {
				if(delimit.length()!=0) {
					if(delim.contains(delimit)) {
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
	String getDelimiter(String s,HashSet<String> set) {
		char wordA[] = s.toCharArray();
		int n = wordA.length,i=2;
		String del="";
		for(;i<n;i++) {
			if(wordA[i]=='\n')
					break;
			if(wordA[i]=='[' ) {
				continue;
			}
			else if(wordA[i]==']') {
				set.add(del);
				del="";
				continue;
			}
			del+=wordA[i];
		}
		if(!del.equals(""))
			set.add(del);
		return s.substring(i+1, s.length());
	}
}
