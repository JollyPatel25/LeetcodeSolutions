class Solution {
    public char findTheDifference(String s, String t) {
        if(s == null || s.length() == 0)
        {
            return t.charAt(0);
        }
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        for(int i = 0; i < s.length(); i++)
        {
            arr1[s.charAt(i) - 97]++;
            arr2[t.charAt(i) - 97]++;
        }
        arr2[t.charAt(t.length() - 1) - 97]++;
        for(int i = 0; i < 26; i++){
            if(arr1[i] != arr2[i] && arr2[i] != 0)
            {
                return (char)(i + 97);
            }
        }
        return '\0';
    }
}