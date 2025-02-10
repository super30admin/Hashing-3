// Approach : Brute Force with a for loop of taking 10 characters into account (substring) - Using Extra Space (HashSet) for identifying the repeated DNA sequence
// Time : O(10n)
// Space :
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> allSeq = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        int n = s.length();
        System.out.println(n);
        for(int i=0;i<n-9;i++){
            String seq = s.substring(i,i+10);
            System.out.println(seq +","+ i);
            if(allSeq.contains(seq)){
                result.add(seq);
            } else{
                allSeq.add(seq);
            }
            
        }
        return new ArrayList<>(result);
    }
}

// Approach : Robincops rolling Hashing technique to reduce the time complexity to O(n).
// claculate hash value for every incoming character and once you reach the sequence length then
// remove the hashvalue of incoming character and add hash value of new incoming character. 
// Time : O(n)
// Space : 
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<Long> allSeq = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        int n = s.length();
        HashMap<Character , Integer> map = new HashMap<>();
        // Based on given constraints only A,C,G,T
        map.put('A',1);
        map.put('C',2);
        map.put('G',3);
        map.put('T',4);

        long hash = 0;
        long posFac = (long)Math.pow(4,10); // only using 4 characters and length of window is 10
        for(int i=0;i<n;i++){
            char in = s.charAt(i);
            hash = hash * 4 + map.get(in); 
            // for first 9 characters there wont be any outgoing characters
            if(i>=10){
                char out = s.charAt(i-10);
                hash = hash - (posFac*map.get(out));
            }

            if(allSeq.contains(hash)){
                result.add(s.substring(i-9,i+1));
            }else{
                allSeq.add(hash);
            }
            
        }
        return new ArrayList<>(result);
    }
}

// Approach : Robincops rolling Hashing technique to reduce the time complexity to O(n).
// claculate hash value for every incoming character and once you reach the sequence length then
// remove the hashvalue of incoming character and add hash value of new incoming character. 
// Time : O(n)
// Space : 
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<Long> allSeq = new HashSet<>();
        HashSet<String> result = new HashSet<>();
        int n = s.length();
        // HashMap<Character , Integer> map = new HashMap<>();
        // Based on given constraints only A,C,G,T
        // map.put('A',1);
        // map.put('C',2);
        // map.put('G',3);
        // map.put('T',4);

        long hash = 0;
        long posFac = (long)Math.pow(20,10); 
        // instead of 4 characters the range can up to 20 for these 4 charcters
        // after we calculate in - 'A' + 1 ===> 1 to 20 (range up to) for charcters A , C , G , T
        for(int i=0;i<n;i++){
            char in = s.charAt(i);
            hash = hash * 20 + (in - 'A' +1); // contribution of this character
            // for first 9 characters there wont be any outgoing characters
            if(i>=10){
                char out = s.charAt(i-10);
                hash = hash - (posFac*(out - 'A' + 1));
            }

            if(allSeq.contains(hash)){
                result.add(s.substring(i-9,i+1));
            }else{
                allSeq.add(hash);
            }
            
        }
        return new ArrayList<>(result);
    }
}