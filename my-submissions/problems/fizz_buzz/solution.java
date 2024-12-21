class Solution {
    public List<String> fizzBuzz(int n) {
        int i = 1; 
        List<String> answer = new ArrayList<String>();
        while(i <= n)
        {
            if(i % 3 == 0 && i % 5 == 0)
                answer.add("FizzBuzz");
            else if(i % 3 == 0)
                answer.add("Fizz");
            else if(i % 5 == 0)
                answer.add("Buzz");
            else
                answer.add(Integer.toString(i));
            i++;
        }
        return answer;
    }
}