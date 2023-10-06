class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        #10 len sliding window - O(n) TC and SC
        # if len(s)<10: return []
        # s_set=set()
        # res_set=set()

        # for i in range(len(s)-9):
        #     sub=s[i:i+10]
        #     if sub in s_set:
        #         res_set.add(sub)
        #     else:
        #         s_set.add(sub)
        # return list(res_set)
        
        #Improved sliding moving - it is same as above but we use rolling hash to improve the hashing.
        #Below we use rolling hash, so we store only the hash val and not the entire string of every 10 len window (essentially at every new char we were storing 10 character in above)

        if len(s)<10: return []
        val_map={'A':1,'C':2,'G':3,'T':4}
        s_set=set()
        res_set=set()
        rolling_hash=0
        for i in range(len(s)):
            if i>=10: #when i>=10 we need to calculate the ougoing hash and subtract it from rolling_hash
                outgoing_hash=val_map[s[i-10]]
                rolling_hash=rolling_hash-outgoing_hash*(4**9)
            incoming_hash=val_map[s[i]] #calculate the rolling hash for every incoming character 
            rolling_hash=rolling_hash*4+incoming_hash
            if rolling_hash not in s_set:
                s_set.add(rolling_hash)
            else:
                res_set.add(s[i-9:i+1])
        return list(res_set)

        # #example:
        # ACACG
        # window_size=4
        # different chars=5
        # for A ->1
        # for AC -> 1x5+2
        # for ACA -> 1x25+2x5+1
        # for ACAC -> 1x125+2x25+1x5+2 = 182

        #Now, the window will move -> CACG -> rolling_hash-outgoing+incoming
        #rolling_hash-outgoing -> rolling_hash-val_map[s[i-4]]*(5*(4-1)) -> 182 - 1x5^(4-1) = 57
        #rolling_hash-outgoing+incoming -> 57x5+3 =288

        #proof
        # C->2
        # CA->2x5+1
        # CAC->2x25+1x5+2
        # CACG->2x125+1x25+2x5+3 = 288
