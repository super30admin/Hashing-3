class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        # TIme - O(2n)
        #space- O(n)
        substring=set()
        result=set()
        arr=[]
        i=0
        while i<len(s):
            if s[i:i+10] in substring:
                result.add(s[i:i+10])
            substring.add(s[i:i+10])
            i+=1
        for i in result:
            arr.append(i)
        return arr