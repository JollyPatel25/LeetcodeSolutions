class Solution:
    def longestPalindrome(self, s: str) -> str:
        def expandFromCenter(left:int, right:int, s:str) -> int:
            while(left >= 0 and right < len(s) and s[left] == s[right]):
                left -= 1
                right += 1
            return s[left + 1: right]
        longestSubstr = ""
        for i in range(len(s)):
            pal1 = expandFromCenter(i, i, s)
            pal2 = expandFromCenter(i, i + 1, s)
            if(len(pal1) > len(longestSubstr)):
                longestSubstr = pal1
            if(len(pal2) > len(longestSubstr)):
                longestSubstr = pal2
        return longestSubstr
        
        