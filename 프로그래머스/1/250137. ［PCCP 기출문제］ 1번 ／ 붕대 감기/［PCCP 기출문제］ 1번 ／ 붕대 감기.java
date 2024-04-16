class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
		int hp = health;
		int count = 0;
		int attackTime = attacks.length;
		int finalSecond = attacks[attackTime - 1][0];

		for (int i = 0; i <= finalSecond; i++) {
			boolean isAttack = false;
			for (int j = 0; j < attackTime; j++) {

				if (i == attacks[j][0]) {
					hp -= attacks[j][1];
					count = 0;
					isAttack = true;
					if (hp <= 0) {
						return -1;
					}
				}
			}

			if (!isAttack) {
				hp += bandage[1];
				count++;
				if (count == bandage[0]) {
					hp += bandage[2];
                    count = 0;
				}

				if (hp > health) {
					hp = health;
				}
			}
		}

		return hp;    
    }  
}