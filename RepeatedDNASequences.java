class RepeatedDNASequences {
    
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        
        if(s == null || s.length() < 10 )
            return new ArrayList<>(result);
        
        int n = s.length();
        for(int i = 0; i <= n - 10; i++){
            String subSeq = s.substring(i, i+10);
            if(set.contains(subSeq))
                result.add(subSeq);
            set.add(subSeq);
        }
        return new ArrayList<>(result);
    }
}