class Solution {

    //Approach 2
    //Time Complexity: O(n*10)
    //Space Complexity: O(n)

    public List<String> findRepeatedDnaSequences(String s) {

        if(s == null || s.length() == 0 || s.length() < 10) return new ArrayList<>();              //check for null case

        Set<String> allSubString = new HashSet<>();                         //to store all the 10 length sequence
        Set<String> result = new HashSet<>();                               //to store the result, we have used set for result  because sequence might be repeated more than 2 times, and we don't want duplicates in result

        for(int i=0; i<=s.length() - 10; i++){

            String sub = s.substring(i, i+10);      //O(10)                 //take the 10 length substring

            if(!allSubString.add(sub)){                                 //check if that substring is present in the allSubString set, then it will return false, if it return false means that substring is repeating, so we just add that into result set
                result.add(sub);                                            //if so, then add substring into result set as well
            }
        }
        return new ArrayList<>(result);                                     //convert the result set into list and return
    }



    //Approach 1
    //Time Complexity: O(n*10)
    //Space Complexity: O(n)

    // public List<String> findRepeatedDnaSequences(String s) {

    //     if(s == null || s.length() == 0) return new ArrayList<>();              //check for null case

    //     Set<String> allSubString = new HashSet<>();                         //to store all the 10 length sequence
    //     Set<String> result = new HashSet<>();                               //to store the result, we have used set for result  because sequence might be repeated more than 2 times, and we don't want duplicates in result

    //     for(int i=0; i<=s.length() - 10; i++){

    //         String sub = s.substring(i, i+10);      //O(10)                 //take the 10 length substring

    //         if(allSubString.contains(sub)){                                 //check if that substring is present in the allSubString set
    //             result.add(sub);                                            //if so, then add substring into result set as well
    //         }

    //         allSubString.add(sub);                                          //also, add the substring into allSubString set
    //     }
    //     return new ArrayList<>(result);                                     //convert the result set into list and return
    // }
}



public class RepeatedDNASequenceLC187 {
}
