// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
we used rabin karp algorithm in here as in we do the following:
1)first we take window with the given length word needed from the question and calculate the hash code value.
2)then we start doing it for the other windows and calculate the hash code,but instead of calculating the hashcode again and again.we just calculate it once and then subtract the first character occured in the given window and add the immediate next character after the window.i.e we do as (hashcode for the given window)-(hashcode value for the first character in the given window)+(hash code value for the immediate next character of the window).
3)if we find the hash code value repeating it means that the given string is repeating.

# Rabin-karp algorithm
# Time complexity --> o(n)
# space complexity --> o(n)
class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        if s==None or len(s)==0 or len(s)<10:
            return []
        b=set(s)
        n=len(b)
        d=dict()
        l=10
        count=1
        #assigning each unique character in the input string a certain value
        for i in b:
            d[i]=count
            count=count+1
        sum1=0
        sum2=set()
        words=set()
        #for the given range in the question we have to calculate the hashcode value and store it in the hashset.so that when the same value comes again it means the pattern repeated again and then add it to the result.
        for i in range(10):
            #eg: for input ccacdbadba in this n=4 as 4 unique characters are there.for instance we want 3 letter repeating words in the input.so l=3.we calculate hash code of cca as val=(3*(4**2))+(3*(4**1))+(1*(4**0)).
            val=d[s[i]]*(n**(l-1))
            # print(d[s[i]],l-1)
            sum1=sum1+val
            l=l-1
        sum2.add(sum1)
        print(sum2)
        for i in range(1,len(s)-9):
            #for the first time we calculate the hashcode value using above so for the remaining we do as below 
            #for the above ((val-(3*(4**2)))*4)+dictionary value at the current instance.
            sum1=sum1-(d[s[i-1]]*(n**9))
            j=i+10
            sum1=(sum1*n)+d[s[j-1]]
            #if the value is new it is the first time it is occuring else we add it to the result indicating it repeated.
            if sum1 not in sum2:
                sum2.add(sum1)
            else:
                words.add(s[i:j])
        return list(words)
            
            
        
            