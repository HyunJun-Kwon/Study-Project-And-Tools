import java.util.*;

class Solution {
    
    static int temp;
    static int t1, t2;
    static int a,b;
    static int[] onboard;
        
    static HashMap<Integer,Integer> map;
    
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        
        this.temp = temperature;
        this.t1 = t1;
        this.t2 = t2;
        this.a = a;
        this.b = b;
        this.onboard = onboard;
        
        map = new HashMap<>();
        map.put(temperature, 0);
        
        for(int i=1; i<onboard.length; i++) {
            getCost(i);
        }
        
        // 가장 적은 에너지 사용량
        int answer = Integer.MAX_VALUE;
        int c;
        for(int k : map.keySet()) {
            c = map.get(k);
            answer = Math.min(answer, c);
        }
        return answer;
        
    }
    
    public void getCost(int n) {
        HashMap<Integer,Integer> now = new HashMap<>();
        int c;
        for(int i : map.keySet()) {
            c = map.get(i);
            
            //에어컨을 끄는 경우
            if(i < temp) putMap(n, now, i+1, c);
            else if(i == temp) putMap(n, now, i, c);
            else putMap(n, now, i-1, c);
            
            //희망온도를 변경하는 경우
            putMap(n, now, i-1, c+a);
            putMap(n, now, i+1, c+a);
            
            //희망온도를 유지하는 경우
            putMap(n, now, i, c+b);
        }
        
        map = now;
    }
    
    public void putMap(int n, HashMap<Integer,Integer> map, int i, int v) {
        int tmp;
        
        // n분에 승객이 탑승 중이지 않거나, 탑승 중 쾌적한 실내온도를 유지 중인 경우
        if(onboard[n] == 0 || (i>= t1 && i <= t2)) {
            //아직 i도의 경우의 수가 없는 경우
            if(map.get(i) == null) map.put(i,v);
            else {
                tmp = map.get(i);
                if(v < tmp) map.put(i,v);
            }
        }
    }
}