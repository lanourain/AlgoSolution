class Solution(object):

    def lengthOfLongestSubstring_1(self, s):
        """
        :type s: str
        :rtype: int
        """
        l = r = longest = 0
        char_dict = {}
        while r < len(s):
            if s[r] not in char_dict:
                char_dict[s[r]] = 0

            char_dict[s[r]] += 1
            if char_dict[s[r]] > 1:
                while l < r:
                    char_dict[s[l]] -= 1
                    if s[l] == s[r]:
                        l += 1
                        break
                    l += 1

            longest = max(longest, r - l + 1)
            r += 1
        return longest

    # 通过记录char对应的位置在找到重复char的时候快速跳跃
    def lengthOfLongestSubstring_2(self, s):
        """
        :type s: str
        :rtype: int
        """
        char_dict = {}
        l = longest = 0
        for r in range(0, len(s)):
            if s[r] in char_dict:
                l = max(char_dict[s[r]] + 1, l)
            char_dict[s[r]] = r
            longest = max(longest, r - l + 1)

        return longest

if __name__ == '__main__':
    print Solution().lengthOfLongestSubstring_2("abcabcbb")