class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        answer = getLcm(arr);
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b =  a % b;
            a = temp;
        }
        return a;
    }
    
    public int lcm(int a, int b) {
        return a * ( b / gcd(a, b));
    }
    
    public int getLcm(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }
        
        int result = arr[0];
        for(int i=1; i<arr.length; i++) {
            result = lcm(result, arr[i]);
        }
        
        return result;
    }
}