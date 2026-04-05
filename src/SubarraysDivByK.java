import java.util.Scanner;

// FIX 1: Class name must exactly match the filename SubarraysDivByK.java
public class SubarraysDivByK {

    public int countSubarrays(int[] nums, int n, int k) {
        int[] remCount = new int[k];
        remCount[0] = 1; 

        int count = 0;
        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            
            // Handle negative remainders correctly in Java
            int remainder = (prefixSum % k + k) % k;
            
            count += remCount[remainder];
            remCount[remainder]++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int[] nums = new int[n];
            
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            
            // FIX 2: Instantiate the correct class
            SubarraysDivByK solver = new SubarraysDivByK();
            int result = solver.countSubarrays(nums, n, k);
            
            System.out.println(result);
        }
        
        sc.close();
    }
}
