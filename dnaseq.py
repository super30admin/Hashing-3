'''
time complexity: O(n)
space complexity(n)
n - len of s 
'''
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        
        st = set()
        res = set()
        n = len(s)
        for i in range(n-10+1):
            if(s[i:i+10] in st):
                res.add(s[i:i+10])
            else:
                st.add(s[i:i+10])
        return res