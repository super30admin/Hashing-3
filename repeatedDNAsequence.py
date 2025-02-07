# Time: O(n)
# Space: O(n)
# Leetcode: Yes
# Issues: No


class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        allseq = set()
        result = set()
        n = len(s)

        hsh = 0
        # hmap = {"A":1,"C":2,"G":3,"T":4}
        posfac = pow(20,10)
        for i in range(n):
            cin = s[i]
            hsh = (hsh*20)+(ord(cin) -ord("A")+1) 
            if i >= 10:
                cout = s[i-10]
                hsh = hsh - (posfac* (ord(cout) -ord("A")+1))
            
            if hsh in allseq:
                result.add(s[i-9:i+1]) # -9 not -10 remove 9th 
            else:
                allseq.add(hsh)
        return list(result)
    
# hmap with 4 values
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        allseq = set()
        result = set()
        n = len(s)

        hsh = 0
        hmap = {"A":1,"C":2,"G":3,"T":4}
        posfac = pow(4,10)      # 4 values 
        for i in range(n):
            cin = s[i]
            hsh = (hsh*4)+hmap[cin]
            if i >= 10:
                cout = s[i-10]
                hsh = hsh - (posfac* hmap[cout])
            
            if hsh in allseq:
                result.add(s[i-9:i+1])
            else:
                allseq.add(hsh)
        return list(result)


# 2 hashmaps
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        allseq = set()
        result = set()
        n = len(s)

        for i in range(n-9):
            seq = s[i:i+10]
            if seq in allseq:
                result.add(seq)
            else:
                allseq.add(seq)

        return list(result)