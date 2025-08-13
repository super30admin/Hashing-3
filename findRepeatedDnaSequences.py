# TimeComplexity:O(n)
# SpaceCompleity:O(1)
# Approach :Bf would be regualr hashmap/set optimal would be rolling hash


class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        """
        similar to group anagrams problem maintain a window and have incomming and out going element adn chec if     it is present in map/set


        but in hashmap /set if we are try to find strings avg tc is O(m) where m is m avg length even in set
        this is because you need to compute hash value for string wehre m in size of string 

        so lets use rolling hash with incoming and outgoing 
        remove outgoing contribution and addin coming contribution

        """
        # 'A', 'C', 'G', and 'T'
        vals= {"A":1,"G":2,"C":3,"T":4}
        hashval=0
        n=len(s)
        ans=set()
        hset=set()
        if len(s)<10:return []
        for i in range(10):
            hashval= hashval*10 + vals[s[i]]
        hset.add(hashval)
        for i in range(10,n):
            #outgoing
            comp= vals[s[i-10]]*(10**9)
            hashval-=comp

            #incoming "AAAAAAAAAAA"

            hashval= vals[s[i]]+hashval*10
            if hashval in hset:
                ans.add(s[i-9:i+1])
            else:
                hset.add(hashval)
        return list(ans)

#-----------------------
# Regular hashmap, remeber get opertaion for strings in set would be O(m) where is m is size of string , time takes finding hashvalue
#-----------------------
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        """
        similar to group anagrams problem maintain a window and have incomming and out going element adn chec if it is present in map/set 
        """
        hmap=defaultdict(int)
        #fixed size 10
        n=len(s)
        ans=[]
        for i in range(0,n-9):
            hmap[s[i:i+10]]+=1
        for j in hmap:
            if hmap[j]>1:
                ans.append(j)
        print(n)
        return ans
