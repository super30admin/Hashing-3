# Time: O((n-9)*10)
# Space: O(n)
class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        uni_seq = set()
        if len(s) < 10:
            return []
        ans = set()
        for i in range(len(s)-9):
            #print(i)
            if s[i:i+10] not in uni_seq:
                uni_seq.add(s[i:i+10])
            else:
                #print('djbvwd')
                ans.add(s[i:i+10])
        #print(uni_seq)
        return ans
                
        
