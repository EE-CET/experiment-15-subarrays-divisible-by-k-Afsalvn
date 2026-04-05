
import java.util.Scanner;

public class SubarraysDivByK {

    // Method to calculate the count of subarrays whose sum is divisible by k
    public int countSubarrays(int[] nums, int n, int k) {
        // Array to store the frequency of each remainder
        // Remainders modulo k will always be from 0 to k-1
        int[] remCount = new int[k];
        
        // Base case: A remainder of 0 occurs 1 time initially (an empty prefix)
        remCount[0] = 1; 

        int count = 0;
        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            
            // Calculate the remainder of the current prefix sum.
            // We use (sum % k + k) % k to correctly handle negative numbers in Java.
            int remainder = (prefixSum % k + k) % k;
            
            // If we've seen this remainder before, it forms valid subarrays.
            // Add the number of times we've seen it to our total count.
            count += remCount[remainder];
            
            // Update the frequency of this remainder for future iterations
            remCount[remainder]++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read size of array (n) and the divisor (k)
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int[] nums = new int[n];
            
            // Read the array elements
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            
            // Create object and solve
            SubarrayDivisible solver = new SubarrayDivisible();
            int result = solver.countSubarrays(nums, n, k);
            
            // Output the count
            System.out.println(result);
        }
        
        sc.close();
    }
}
