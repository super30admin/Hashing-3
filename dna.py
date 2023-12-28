# Time: O(n)
# Space: O(n)
# Did it run on Leetcode: yes

class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        # O(n)
        # if(len(s)<10):
        #     return []
        # allsubs=set()
        # res=set()
        # for i in range(len(s)-9):
        #     sub=s[i:i+10]
        #     if(sub in allsubs):
        #         res.add(sub)
        #     else:
        #         allsubs.add(sub)
        # return list(res)

        # optimized O(n)
        hmap={'A':1, 'C':2, 'G':3, 'T':4}
        if(len(s)<10):
            return []
        allsubs=set()
        res=set()
        kl=pow(4,9)
        hashval=0l
        for i in range(len(s)):
            # outgoing i-10
            if(i>=10):
                out=s[i-10]
                hashval=hashval - kl*hmap[out]
            # incoming i
            ic=s[i]
            hashval=hashval*4 + hmap[ic]
            if(hashval in allsubs):
                res.add(s[i-9:i+1])
            else:
                allsubs.add(hashval)
        return list(res)