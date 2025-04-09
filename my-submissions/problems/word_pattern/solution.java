class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        HashMap<String, Character> map = new HashMap<>();
        HashSet<Character> used = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            Character c = pattern.charAt(i);
            Character value = map.get(words[i]);
            if (value == null) {
                if (used.contains(c)) return false;
                map.put(words[i], c);
                used.add(c);
            } else {
                if (!value.equals(c)) return false;
            }
        }
        return true;
    }
}
