class Solution {
    public int romanToInt(String s) {
        StringBuilder sb = new StringBuilder(s);
        int result = 0;
        while(sb.length() >= 2)
        {
            switch(sb.substring(sb.length() - 2, sb.length()))
            {
                case "IV":
                    result += 4;
                    sb.delete(sb.length() - 2, sb.length());
                    break;
                case "IX":
                    result += 9;
                    sb.delete(sb.length() - 2, sb.length());
                    break;
                case "XL":
                    result += 40;
                    sb.delete(sb.length() - 2, sb.length());
                    break;
                case "XC":
                    result += 90;
                    sb.delete(sb.length() - 2, sb.length());
                    break;
                case "CD":
                    result += 400;
                    sb.delete(sb.length() - 2, sb.length());
                    break;
                case "CM":
                    result += 900;
                    sb.delete(sb.length() - 2, sb.length());
                    break;
                default:
                    switch(sb.charAt(sb.length() - 1))
                    {
                        case 'I':
                            result += 1;
                            sb.setLength(sb.length() - 1);
                            break;
                        case 'V':
                            result += 5;
                            sb.setLength(sb.length() - 1);
                            break;
                        case 'X':
                            result += 10;
                            sb.setLength(sb.length() - 1);
                            break;
                        case 'L':
                            result += 50;
                            sb.setLength(sb.length() - 1);
                            break;
                        case 'C':
                            result += 100;
                            sb.setLength(sb.length() - 1);
                            break;
                        case 'D':
                            result += 500;
                            sb.setLength(sb.length() - 1);
                            break;
                        case 'M':
                            result += 1000;
                            sb.setLength(sb.length() - 1);
                            break;
                    }
                    break;
            }
        }
        if(sb.length() == 1)
        {
            switch(s.charAt(0))
            {
                case 'I':
                    result += 1;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    result += 10;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    result += 100;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }
        return result;
    }
}