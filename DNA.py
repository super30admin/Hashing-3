#T: O(N)
#Space = O(N)
#Worked on leet code
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        Input= set()
        Output= set()
        
        for i in range(len(s)-9):
            
            if(s[i:i+10] in Input):
                # adding the substriang into the output set
                Output.add(s[i:i+10])
            #adding each substring to the input set 
            Input.add(s[i:i+10])

        return Output
                
        