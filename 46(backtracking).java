public class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        backtrack(nums,new ArrayList<Integer>(),0);
        return result;
    }

    private void backtrack(int nums[],ArrayList<Integer> list,int start){
        if(list.size()==nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i=0;i<=list.size();i++){
            list.add(i,nums[start]);
            backtrack(nums,list,start+1);
            list.remove(i);
        }
    }     
}