'''
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
'''
class Solution:
    
    def __init__(self):
        self.allElements = set()
        self.uniqueElements = set()
    
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        
        for i in range(0,len(s)+1-10):
            
            # initialize subString
            subString = s[i:i+10]
            
            if subString in self.allElements:
                self.uniqueElements.add(subString)
                # print('Unique Substring is:\t',subString)
            
            # add to the allElements set
            self.allElements.add(subString)
        
        print('Unique elements are:\t',self.uniqueElements)
                
        return self.uniqueElements