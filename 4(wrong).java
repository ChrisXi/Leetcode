public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        
        double nums[] = new double[len1+len2];
        while (index1<len1 && index2<len2) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];

            if (num1 >= num2) {
                nums[index] = num2;
                index2 ++;
            } else {
                nums[index] = num1;
                index1 ++;
            }
            index ++;
            
        }
        
        while (index1<len1) {
            int num1 = nums1[index1];
            nums[index] = num1;
            index1 ++;
            index++;
        }
        while (index2<len2) {
            int num2 = nums2[index2];
            nums[index] = num2;
            index2 ++;
            index++;
        }
        
        int medianIndex = (len1+len2)/2;
        
        double num =  0;
        if ((len1+len2)%2 == 1) {
            num = nums[medianIndex];
        } else {
            num = (nums[medianIndex-1]+nums[medianIndex])/2;
        }
        
        return num;
    }
}