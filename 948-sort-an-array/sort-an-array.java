class Solution {

    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length - 1);
        return nums;
    }

    public void divide(int[] a, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;

            divide(a, start, mid);
            divide(a, mid + 1, end);

            merge(a, start, mid, end);
        }
    }

    public void merge(int[] a, int start, int mid, int end) {
        int[] merged = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                merged[k++] = a[i++];
            } else {
                merged[k++] = a[j++];
            }
        }

        while (i <= mid) merged[k++] = a[i++];
        while (j <= end) merged[k++] = a[j++];

        for (int x = 0; x < merged.length; x++) {
            a[start + x] = merged[x];
        }
    }
}