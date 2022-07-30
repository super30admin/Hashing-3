#Time complexity: O(10*n)
#Space complexity: O(n)
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        s1=set()
        s2=set()
        for i in range(len(s)-9):
            sub_str=s[i:i+10]
            if sub_str in s1:
                s2.add(sub_str)
            else:
                s1.add(sub_str)
        return list(s2)
        