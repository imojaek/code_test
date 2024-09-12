class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        int[] discount = new int[7];
        for (int i = 0; i < emoticons.length - 1; i++) {
            discount[i] = 10;
        }
        
        while (nextDiscount(discount, emoticons.length)) {
            int numOfPlus = 0;
            int sumOfPrice = 0;
            
            for (int[] user : users) {
                int targetDiscount = user[0];
                int targetPrice = user[1];
                int currentPrice = 0;

                for (int i = 0; i < emoticons.length; i++) {
                    if (targetDiscount <= discount[i]) {
                        currentPrice += emoticons[i] * (100 - discount[i]) / 100;
                    }
                }
                if (currentPrice >= targetPrice) {
                    numOfPlus++;
                }
                else 
                    sumOfPrice += currentPrice;
            }
            if (numOfPlus > answer[0]) {
                answer[0] = numOfPlus;
                answer[1] = sumOfPrice;
            }
            else if (numOfPlus == answer[0] && sumOfPrice > answer[1]) {
                answer[1] = sumOfPrice;
            }
        }
        return answer;
    }
    
    public boolean nextDiscount(int[] discount, int emoticonSize) {
        int maxIndex = emoticonSize - 1;
        discount[maxIndex] += 10;
        for (int i = maxIndex; i >= 0; i--) {
            if (discount[i] == 50) {
                if (i == 0)
                    return false;
                discount[i - 1] += 10;
                discount[i] = 10;
            }
        }
        return true;
    }
}
