# make the key of length 10 and the add into another map if repetaed
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:

        if s is None or len(s) == 0: return []
        myresult = set()
        myrepectedstring = set()

        for ids in range(len(s) - 9):
            if s[ids: ids + 10] in myrepectedstring:
                myresult.add(s[ids: ids + 10])
            myrepectedstring.add(s[ids: ids + 10])

        return myresult


