class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        start=0
        end=start+10-1
        hashmap=dict()
        output=[]
        while end<len(s):
            hashmap[s[start:end+1]]=hashmap.get(s[start:end+1],0)+1
            start+=1
            end+=1
            
        for item in hashmap:
            if hashmap[item]>1:
                output.append(item)
                
        return output
                
            
        
            