#Time:O(mn)
#Space:O(mn)
from collections import defaultdict
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        if len(s)<10 or not s:
            return []
        
        ans = []
        max_hash_map = defaultdict(int)
        set_visited = set()
        
        max_count=0
        
        for i in range(len(s)-9):
            if s[i:i+10] in set_visited:
                max_hash_map[s[i:i+10]]+=1
                max_count = max(max_count,max_hash_map[s[i:i+10]])
            set_visited.add(s[i:i+10])
        for string_val,count in max_hash_map.items():
            if count==max_count:
                ans.append(string_val)
        return ans