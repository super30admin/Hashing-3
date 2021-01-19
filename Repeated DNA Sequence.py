# Time:-O(n-10)*10
# Space:- O(n-10)
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        my_set=set()
        res=set()
        for i in range(len(s)-9):
            # take a slice and store it in the set, if we find the slice again this slice is repeating
            string=s[i:i+10]
            if string in my_set:
                res.add(string)
            else:
                my_set.add(string)
        return list(res)