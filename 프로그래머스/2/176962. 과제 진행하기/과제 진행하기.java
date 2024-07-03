import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Solution {
    
    static class MyWork {
        private String subject;
        private int time;
        private int minute;
    
        public MyWork(String subject, int time, int minute) {
            this.subject = subject;
            this.time = time;
            this.minute = minute;
        }
    
        public MyWork(String subject, int minute) {
            this.subject = subject;
            this.minute = minute;
        }
    
        public String getSubject() {
            return subject;
        }
    
        public int getTime() {
            return time;    
        }
    
        public int getMinute() {
            return minute;
        }
    }
    
    public List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        PriorityQueue<MyWork> workQ = new PriorityQueue<>(Comparator.comparingInt(MyWork::getTime));
        
        for(String[] plan : plans) {
            String subject = plan[0];
            String[] splitT = plan[1].split(":");
            
            int h = Integer.parseInt(splitT[0]);
            int m = Integer.parseInt(splitT[1]);
            int time = (h * 60) + m;
            int minute = Integer.parseInt(plan[2]);
            
            workQ.add(new MyWork(subject,time,minute));
        }
        
        Stack<MyWork> remainWork = new Stack<>();
        
        
        while(!workQ.isEmpty()) {
            MyWork current = workQ.poll();
            
            String curSubject = current.subject;
            int curStart = current.time;
            int minute = current.minute;
            
            // 현재 시간
            int curTime = curStart;
            
            //새로운 과제가 남아있는 경우
            if(!workQ.isEmpty()) {
                MyWork next = workQ.peek();
                
                if(curTime + minute < next.time) {
                    answer.add(curSubject);
                    curTime += minute;
                    
                    while(!remainWork.isEmpty()) {
                        MyWork remain = remainWork.pop();
                        
                        if(curTime + remain.minute <= next.time) {
                            curTime += remain.minute;
                            answer.add(remain.subject);
                            continue;
                        } else {
                            int t = remain.minute - (next.time - curTime);
                            remainWork.push(new MyWork(remain.subject, t));
                            break;
                        }
                    }
                } else if(curStart + minute == next.time) {
                    answer.add(curSubject);
                    continue;
                } else {
                    int t = (next.time - curTime);
                    remainWork.push(new MyWork(curSubject, minute - t));
                }
            } else {
                if(remainWork.isEmpty()) {
                    curTime += minute;
                    answer.add(curSubject);
                } else {
                    answer.add(curSubject);
                    while(!remainWork.isEmpty()) {
                        MyWork rem = remainWork.pop();
                        answer.add(rem.subject);
                    }
                }
            }
        }
        return answer;
    }     
}

