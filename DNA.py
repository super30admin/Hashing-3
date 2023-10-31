#Sliding Window Approach
TC: O((n-k)*k)
SC: (O(n-k)*k)
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        print(len(s))
        sequence_map=set()
        output=[]
        for i in range(0, len(s)-10+1):
            substring=s[i:i+10]
            if substring in sequence_map:
                if substring not in output:
                    output.append(substring)
            else:
                sequence_map.add(substring)
        return output
    

#Rolling Hash(Rabin-Karp Algorithm)
TC: O(n-k)
SC: O(n-k)

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        rolling_hash=0
        rolling_hashmap=set()
        output=set()
        char_map={'A':1,'C':2,'G':3,'T':4}
        valueAtHash=pow(4,9) #4 since it only involves A,C,G,T. 9 since the out going character will be multiplied by 4, 9 times
        for i in range(0, len(s)):
            in_char=s[i]
            if i >9:
                out_char=s[i-10]
                rolling_hash=rolling_hash- (char_map[out_char]*valueAtHash)
            rolling_hash=(rolling_hash*4) + char_map[in_char]
            if rolling_hash in rolling_hashmap:
                output.add(s[i-9:i+1])
            else:
                rolling_hashmap.add(rolling_hash)
        return list(output)