import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) throws ParseException {
        List<Integer> answer = new ArrayList<>();
        
        String[][] privaciesArray = splitPrivacies(privacies);
        List<String> countDate = countDate(terms, privaciesArray);

        for(int i=0; i<countDate.size(); i++) {
            if(date(today,countDate.get(i))) {
                answer.add(i+1);
                System.out.println(countDate.get(i));
            } 
        }

        return answer;
    }

    public boolean date(String a, String b) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        Date Adate = format.parse(a);
        Date Bdate = format.parse(b);

        int result = Adate.compareTo(Bdate);

        if(result > 0) {
            return true; //폐기
        } else {
            return false; //보존
        }
    }

    public List<String> countDate(String[] terms, String[][] privacies) throws ParseException {
        List<String> countDate = new ArrayList<>();

        for(String[] a : privacies) {
            String date1 = a[0];
            SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
            Date date = format.parse(date1);
            String type = a[1];

            for(String term : terms) {
                String[] splitTerm = term.split(" ");
                String termType = splitTerm[0];
                String termMonth = splitTerm[1];

                int month = Integer.parseInt(termMonth);

                if(type.equals(termType)) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    calendar.add(Calendar.MONTH, month);
                    calendar.add(Calendar.DAY_OF_MONTH, -1);
                    Date monthLaterDate = calendar.getTime();
                    String monthLaterDateString = format.format(monthLaterDate);
                    countDate.add(monthLaterDateString);
                }
            }
        }
        return countDate;
    }
    
    public String[][] splitPrivacies(String[] privacies) {
        List<String[]> privaciesSplit = new ArrayList<>();

        for(String privacie : privacies) {
            String[] privaciesArray = privacie.split(" ");
            privaciesSplit.add(privaciesArray);
        }

        String[][] privaciesArray = new String[privaciesSplit.size()][];
        for(int i=0; i<privaciesSplit.size(); i++) {
            privaciesArray[i] = privaciesSplit.get(i);
        }
        
        return privaciesArray;
    }
}
