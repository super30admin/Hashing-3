class Solution:
    def __init__(self):
        self.levels = [[10000,0.3],[20000, 0.2],[30000,0.1],[None, 0.1]]

    def calcTax(self, index, salary):
        prev = 0
        tax = 0
        while(salary!= 0):
            if self.levels[index][0] == None:
                tax += salary * self.levels[index][1]
                return tax

            taxableIncome = min((self.levels[index][0] - prev), salary)
            
            tax += taxableIncome * self.levels[index][1]

            salary -= taxableIncome
            prev = self.levels[index][0]
            index+=1
        return tax
        

sol = Solution()

print(sol.calcTax(0, 45000))