#Time O(n), space O(n)
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        h={}
        res=set()
        for i in range((len(s)-10)+1):
            #Substring with 10 chars
            cur = s[i:i+10]
            
            
            if cur not in h:
                h[cur]=0
         
        #If count is 1 add in res
            if h[cur] == 1:
                res.add(cur)
                
            h[cur]+=1
            
        return res
