public class SubSetSum {

    public static void main(String[] args) {

            int[] arr = {3, 34, 4, 12, 5, 2};
            int sum = 3;
            int n = arr.length;
            boolean isSubsetSum = false;

            for (int i = n - 1; i >= 0; i--) {
                isSubsetSum = isSubsetSum(i, arr, sum);
                if (isSubsetSum) {
                    break;
                }
            }

            if (isSubsetSum) {
                System.out.println("Found a subset" + " with given sum");
            } else {
                System.out.println("No subset with" + " given sum");
            }


        }

        private static boolean isSubsetSum(int n, int[] arr, int sum) {

            if (sum == 0) {
                return true;
            }
            if (n < 0) {
                return false;
            }

            if (arr[n] > sum) {
                return isSubsetSum(n - 1, arr, sum);
            }

            return isSubsetSum(n - 1, arr, sum - arr[n]);


        }
}
