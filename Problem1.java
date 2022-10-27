import java.util.*;
class Problem1{

    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String>hs1= new HashSet<>();
        HashSet<String>hs2= new HashSet<>();
        
        for( int i=0;i<s.length()-9;i++){
            
            String check=s.substring(i,i+10);
            
            if(hs1.contains(check)){
                
                hs2.add(check);
            
            }else{
                
               hs1.add(check); 
            }
            
            
               }
        
        
    List <String> l= new ArrayList<>();
        for(String x:hs2){
            
            l.add(x);
        }
return l;
               
               
               }
}