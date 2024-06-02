class Solution {
    public String solution(int[] food) {
        int totalAmount = 0;
        int[] evenNumFood = new int[food.length];

       
        evenNumFood[0] = food[0];

        for (int i = 1; i < food.length; i++) {
            if (food[i] % 2 != 0) {
                evenNumFood[i] = (food[i] - 1) / 2;
            } else {
                evenNumFood[i] = food[i] / 2;
            }
         
            totalAmount += evenNumFood[i];
        }
        
        StringBuilder answerBuild = new StringBuilder(totalAmount * 2 + 1);

        for (int i = 1; i < evenNumFood.length; i++) {
            for (int j = 0; j < evenNumFood[i]; j++) {
                answerBuild.append(i);
            }
        }
        
        answerBuild.append(0);
        
        for (int i = evenNumFood.length - 1; i > 0; i--) {
            for (int j = 0; j < evenNumFood[i]; j++) {
                answerBuild.append(i);
            }
        }
        
        return answerBuild.toString();
    }
}
