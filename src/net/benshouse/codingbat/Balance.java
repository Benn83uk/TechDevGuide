package net.benshouse.codingbat;

public class Balance {
    public static boolean canBalance(int[] nums){
        if (nums.length == 0) return true;

        int sumLeft = 0;
        int sumRight = 0;
        int left = 0;
        int right = nums.length;
        while (left < right){
            if (sumLeft > sumRight){
                sumRight += nums[--right];
            } else {
                sumLeft += nums[left];
                left++;
            }
        }
        return sumLeft == sumRight;
    }
}
