import java.util.HashSet;

public class DoubleOfN {

    class Solution {
        public boolean checkIfExist(int[] arr) {
            HashSet<Integer> occurences = new HashSet<>();

            for (int i=0; i<arr.length; i++) {
                int val = arr[i];
                if(occurences.contains(val * 2) || occurences.contains(val / 2)) return true;
                occurences.add(val);
            }
            return false;
        }
    }

    // Optimized solution

    class Solution2 {
        public boolean checkIfExist(int[] arr) {
            for (int i = 0; i < arr.length; i++) { // Fixed initialization and condition for outer loop
                float t = (float) arr[i] / 2;
                int x = Search(arr, t);
                if (x != i && x != -1) {
                    return true;
                }
            }
            return false;
        }

        static int Search(int[] arr, float target) {
            for (int i = 0; i < arr.length; i++) { // Fixed initialization and condition for inner loop
                if ((float) arr[i] == target) { // Fixed comparison with float target
                    return i;
                }
            }
            return -1;
        }
    }
}
