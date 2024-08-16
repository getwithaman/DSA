class Solution {
    public int search(int[] nums, int k) {
        int n = nums.length;
        int si = 0;
        int ei = n - 1;
        while (si <= ei) {
            int mid = si + (ei - si) / 2;
            if (nums[mid] == k) {
                return mid;
            }
            if (nums[si] <= nums[mid]) {
                if (nums[si] <= k && k <= nums[mid]) {
                    ei = mid-1;
                    // mid = si + (ei - si) / 2;
                }
                else{
                    si = mid + 1;
                }
            } else {
                if(nums[mid]<=k && k <=nums[ei]){
                    si = mid+1;
                }
                else{
                    ei = mid-1;
                }
            }
        }
        return -1;
    }
}
