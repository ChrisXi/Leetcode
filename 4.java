public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    
        int n1 = nums1.length;
        int n2 = nums2.length;
        int l = n1+n2;

        if(l%2 == 0) {
            return findMedian(nums1, 0, n1, nums2, 0, n2, l/2+1);
        } else {
            return (findMedian(nums1, 0, n1, nums2, 0, n2, l/2)+
                    findMedian(nums1, 0, n1, nums2, 0, n2, l/2+1))/2;
        }

    }

    public int findMedian(int[] nums1, int s1, int n1, int[] nums2, int s2, int n2, int l) {

        if(n1 > n2) {
            return findMedian(nums2, s2, n2, nums1, s1, n1, l);
        }

        if(n1 == 0) {
            return nums2[s2+l-1];
        }

        if(l == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }

        int part1 = Math.min(l/2, n1);
        int part2 = l-part1;

        if(nums1[s1+part1-1]==nums2[s2+part2-1]) {
            return nums1[s1+part1-1];
        } else if(nums1[s1+part1-1]<nums2[s2+part2-1]) {
            return findMedian(nums1, s1+part1, n1-part1, nums2, s2, n2, l-part1);
        } else {
            return findMedian(nums1, s1, n1, nums2, s2+part2, n2-part2, l-part2);
        }

    }
}