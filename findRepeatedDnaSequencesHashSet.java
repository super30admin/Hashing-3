/*
TC - O(n)
SC - O(n)
*/
public class findRepeatedDnaSequencesHashMap {
    
    public List<String> findRepeatedDnaSequences(String s) {
        
        if(s == null || s.length() == 0){ return new ArrayList<>();
                                   }
        Set<String> set = new HashSet<>();
        set<String> list = new HashSet<>();
        for(int i = 0; i <= s.length()-10 ; i++){
            String substring = s.substring( i, i+10) ;
            if(set.contains(substring)){
                list.add(substring) ;
            }
            else{
                set.add(substring) ;
            }
        }
    
        return new ArrayList(list);
    }
}
    
    
