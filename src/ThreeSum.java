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



class SolutionTwo {
    public String reverseWords(String s) {
        char t[] = s.toCharArray();
        char r[] = new char[s.length()];

        int reversedSize = reversedSize(t, r, 0);
        return new String(r, 0, reversedSize);
    }

    private int reversedSize(char t[], char r[], int index) {
        if (index == t.length) return 0;
        while (index < t.length && t[index] == ' ') index++;
        int endIndex = index;

        while (endIndex < t.length && t[endIndex] != ' ') endIndex++;

        int reversedSize = reversedSize(t, r, endIndex);

        if (reversedSize > 0) {
            r[reversedSize] = ' ';
            reversedSize++;
        }
        for (int i = index; i < endIndex; i++) {
            r[reversedSize++] = t[i];
        }
        return reversedSize;
    }
}