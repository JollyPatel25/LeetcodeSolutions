class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26)
            return false;
        int data[] = new int[26]; 
        for(int i = 0; i < sentence.length(); i++)
            data[sentence.charAt(i) - 97]++;
        for(int i = 0; i < 26; i++)
            if(data[i] < 1)
                return false;
        return true;
    }
}