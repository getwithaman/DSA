class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        while (j < nums1.length && k < nums2.length) {
            if (nums1[j] < nums2[k]) {
                arr[i++] = nums1[j++];
            } else {
                arr[i++] = nums2[k++];
            }
        }

        while (j < nums1.length) {
            arr[i++] = nums1[j++];
        }

        while (k < nums2.length) {
            arr[i++] = nums2[k++];
        }

        int n = arr.length;
        if (n % 2 == 0) {
            return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
        } else {
            return arr[n / 2];
        }
    }
}
