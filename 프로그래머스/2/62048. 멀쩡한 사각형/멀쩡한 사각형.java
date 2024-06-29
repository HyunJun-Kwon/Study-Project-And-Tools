class Solution {
    public long solution(int w, int h) {
        // 전체 정사각형의 개수
        long answer = (long) w * h;
        
        // 대각선이 지나가면서 잘리는 정사각형의 개수
        long cut = w + h - gcd(w, h);
        
        // 사용할 수 있는 정사각형의 개수
        return answer - cut;
    }

    // 유클리드 호제법을 사용한 최대공약수 계산
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
