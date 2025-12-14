public class Solution {
    public string ReverseWords(string s) {
        StringBuilder sb = new StringBuilder();
        var arr = s.Split(' ');
        int vowelCount = CountVowel(arr[0]);
        Console.WriteLine(vowelCount);
        sb.Append(arr[0]); 
        if(arr.Length == 1) return sb.ToString();
        else sb.Append(" ");
        for(int i = 1 ; i < arr.Length; i++)
        {
            int count = CountVowel(arr[i]);
            if(count == vowelCount)
            {
                char[] charArray = arr[i].ToCharArray();
                Array.Reverse(charArray);
                sb.Append(new string(charArray));
                
                if(i != arr.Length - 1)
                {
                    sb.Append(" ");
                }
            }
            else
            {
                sb.Append(arr[i]);
                if(i != arr.Length - 1)
                {
                    sb.Append(" ");
                }
            }
        }
        return sb.ToString();
    }
    public int CountVowel(string s)
    {
        int count = 0;
        foreach(char i in s)
        {
            switch(i)
            {
                case 'a':
                case 'e': 
                case 'i':
                case 'o':
                case 'u': 
                    count++;
                    break;
            } 
        }
        return count;
    }
}
