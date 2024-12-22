"""
In real world number of tax brackets is constant. Thus, TC: O(1)
Todo: Recursion 
"""


class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:

        income_left = income
        tax = 0
        prev_upper_limit = 0
        for curr_upper_limit, tax_percentage in brackets:
            taxable_amt = curr_upper_limit - prev_upper_limit
            if income_left > taxable_amt:
                tax += (tax_percentage / 100 * taxable_amt)
                income_left -= taxable_amt
            else:
                tax += (tax_percentage / 100 * income_left)
                income_left = 0

            prev_upper_limit = curr_upper_limit

        return tax