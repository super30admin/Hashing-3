/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
    n -  no of 10 char long sequence.
* 
* Space Complexity: O(n)
* 
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> hmap = new HashMap<>();

        int start = 0, end = 0;

        while (start <= s.length() - 10) {
            if (end - start + 1 == 10) {
                String sequence = s.substring(start, end + 1);

                hmap.put(sequence, hmap.getOrDefault(sequence, 0) + 1);

                start++;
            }

            end++;
        }

        List<String> result = new ArrayList<>();

        for (String str : hmap.keySet()) {
            if (hmap.get(str) > 1) {
                result.add(str);
            }
        }

        return result;
    }
}
