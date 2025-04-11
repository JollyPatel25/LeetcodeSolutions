class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        HashSet<Character> set = new HashSet<Character>();
        int length = s.length();
        for(int i = 0; i < length; i++)
        {
            Character c1 = s.charAt(i);
            Character value = map.get(c1);
            Character c2 = t.charAt(i);
            if(value != null)
            {
                if(!value.equals(t.charAt(i)))
                    return false;
            }
            else
            {
                if(!set.contains(c2))
                {
                    map.put(c1, c2);
                    set.add(c2);
                }
                else
                {
                    return false;
                }
            }
                
        }
        return true;
    }
}