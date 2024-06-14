import java.util.*;

class Solution {

    static class User {
        int discount_d;
        int standard;

        public User(int discount_d, int standard) {
            this.discount_d = discount_d;
            this.standard = standard;
        }

        public int getDiscount_d() {
            return discount_d;
        }

        public int getStandard() {
            return standard;
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        List<User> userList = new ArrayList<>();

        // 유저 정보를 User 클래스 타입으로 ArrayList에 저장
        for (int[] user : users) {
            userList.add(new User(user[0], user[1]));
        }

        // 이모티콘마다 할인율이 다르며 10, 20, 30, 40
        List<Integer> discount = checkDiscount(userList);
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(emoticons.length, discount, new ArrayList<>(), combinations);
        
        int maxJoin = 0;
        int maxSales = 0;
        List<Integer> maxDiscountArray = new ArrayList<>(); // 최대 플러스 가입 및 판매액을 달성하는 할인율 배열

        // 각 할인율 조합에 대해 평가
        for (List<Integer> combi : combinations) {
            int join = 0;
            int sales = 0;
            
            for (User user : userList) {
                int totalCost = 0;
                
                // 각 사용자에 대해 이모티콘 구매 비용 계산
                for (int i = 0; i < emoticons.length; i++) {
                    int discountRate = combi.get(i);
                    if(discountRate >= user.getDiscount_d()) {
                        int discountedPrice = emoticons[i] * (100 - discountRate) / 100;
                        totalCost += discountedPrice;
                    }
                }

                // 예산을 초과할 경우 이모티콘 플러스 가입
                if(totalCost >= user.getStandard()) {
                    join++;
                } else {
                    sales += totalCost;
                }
            }

            // 이모티콘 플러스 가입자 수와 판매액 갱신
            if (join > maxJoin || (join == maxJoin && sales > maxSales)) {
                maxJoin = join;
                maxSales = sales;
                maxDiscountArray = new ArrayList<>(combi); 
            }
        }

        // maxJoin을 달성하는 경우의 할인율 배열 출력
        System.out.println("Max Join Discount Array: " + maxDiscountArray);

        return new int[] {maxJoin, maxSales};
    }

    private void generateCombinations(int length, List<Integer> discount, List<Integer> current, List<List<Integer>> combinations) {
        if (current.size() == length) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < discount.size(); i++) {
            current.add(discount.get(i));
            generateCombinations(length, discount, current, combinations);
            current.remove(current.size() - 1);
        }
    }
    
    public List<Integer> checkDiscount(List<User> user) {
        List<Integer> discountArray = new ArrayList<>();
        int[] discount = {10, 20, 30, 40};
        int minDiscount = 40;

        // 고객의 할인 요구치 중 최대값 계산
        for (User userInfo : user) {
            int demandDiscount = userInfo.discount_d;
            if (minDiscount > demandDiscount) {
                minDiscount = demandDiscount;
            }
        }

        // 최대 요구치보다 크거나 같은 할인율을 discountArray에 추가
        for (int i : discount) {
            if (i >= minDiscount) {
                discountArray.add(i);
            }
        }
        return discountArray;
    }
}
