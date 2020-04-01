package Q_187_Repeated_DNA_Sequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
//
//Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
//
//Example:
//
//Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//
//Output: ["AAAAACCCCC", "CCCCCAAAAA"]

//Time Complexity  : O(n)
//Space Complexity : O(n)

public class Solution {

	public List<String> findRepeatedDnaSequences(String s) {
		
		HashSet<String> dnaSeq  = new HashSet<>();
		List<String> res = new ArrayList<>();
		
		for(int i=0; i <=  s.length() - 10;i++) {
			String str = s.substring(i,i+10);
			if(dnaSeq.contains(str) && !res.contains(str)) {
				res.add(str);
			}
			dnaSeq.add(str);
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
//		String str = "AAAAAAAAAAAA";
//		String str = "AAAAAAAAAAA";
		System.out.println(s.findRepeatedDnaSequences(str));

	}

}
//AAAAAAAAAA
//AAAAAAAAAA