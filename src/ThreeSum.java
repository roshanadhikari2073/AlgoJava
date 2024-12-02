import java.util.HashMap;

class ThreeSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> occurences = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            if(occurences.containsKey(target-nums[i])) {
                result = new int[]{occurences.get(target-nums[i]), i};
            } else {
                occurences.put(nums[i], i);
            }
        }
        return result;
    }
}