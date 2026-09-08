class Solution {

    public void moveZeroes(int[] nums) {

        int j = 0;

        // Put all non-zero elements at the beginning
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        // Put zeros at the end
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }
}