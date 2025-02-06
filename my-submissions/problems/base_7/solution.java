class Solution {
    public String convertToBase7(int num) {
        if(num == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        boolean negative = false;
        if(num < 0)
        {
            negative  = true;
            num *= -1;
        }
        while(num > 0)
        {
            sb.insert(0, String.valueOf(num % 7));
            num = num / 7;
        }
        if(negative)
            sb.insert(0, '-');
        return sb.toString();
    }
}