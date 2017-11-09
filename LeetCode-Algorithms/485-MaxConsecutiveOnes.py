class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = current = 0

        for num in nums:
            if num:
                current += 1
            else:
                ans = max(ans, current)
                current = 0

        return max(ans, current)