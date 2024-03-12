package algorithms;

public class RainTrap {
    //Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

    public int trap(int[] height) {
        int len = height.length;

        //Left Side max check and store max number in maxL Array
        int[] maxL = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, height[i]);
            maxL[i] = max;
        }

        //Right Side max check and store max number in maxL Array
        int[] maxR = new int[len];
        max = 0;
        for (int i = len - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            maxR[i] = max;
        }

        // Here Calculate Water Level
        int waterLevelStore = 0;
        for (int i = 0; i < len; i++) {
            int min = Math.min(maxL[i], maxR[i]);
            waterLevelStore += min - height[i];
        }
        return waterLevelStore;
    }
}
