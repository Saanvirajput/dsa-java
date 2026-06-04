package dsa.dp.medium;

import java.util.Arrays;

/**
 * 📝 Problem Name: 3751. Total Waviness of Numbers in Range I
 * 🌐 Platform: LeetCode
 * ⚡ Approach: Digit DP to construct numbers dynamically and count waviness based on adjacent placed digits.
 * ⏱ Time Complexity: O(L * 10^2) where L is the number of digits in num2
 * 📦 Space Complexity: O(L * 10^2) for memoization table
 */
public class TotalWavinessOfNumbers {

    // memo[idx][prev1][prev2][isLimit][isLead]
    // Stores: {count_of_valid_numbers, sum_of_waviness}
    private long[][][][][][] memo;
    private String s;

    public int totalWaviness(int num1, int num2) {
        // We can solve this with Digit DP to easily handle constraints up to 10^18
        return (int) (solve(num2) - solve(num1 - 1));
    }

    private long solve(long num) {
        if (num < 100) return 0; // Numbers < 100 have 0 waviness

        s = String.valueOf(num);
        memo = new long[s.length()][11][11][2][2][2];
        for (long[][][][][] a : memo)
            for (long[][][][] b : a)
                for (long[][][] c : b)
                    for (long[][] d : c)
                        for (long[] e : d)
                            Arrays.fill(e, -1);

        // prev1 = 10, prev2 = 10 denotes "no digit placed yet"
        return dfs(0, 10, 10, 1, 1)[1];
    }

    private long[] dfs(int idx, int prev1, int prev2, int isLimit, int isLead) {
        if (idx == s.length()) {
            return new long[]{1, 0}; // 1 valid number suffix, 0 additional waviness
        }

        if (memo[idx][prev1][prev2][isLimit][isLead][0] != -1) {
            return memo[idx][prev1][prev2][isLimit][isLead];
        }

        int limit = isLimit == 1 ? s.charAt(idx) - '0' : 9;
        long count = 0;
        long waviness = 0;

        for (int d = 0; d <= limit; d++) {
            int nextIsLimit = (isLimit == 1 && d == limit) ? 1 : 0;
            int nextIsLead = (isLead == 1 && d == 0) ? 1 : 0;

            int nextPrev1 = (nextIsLead == 1) ? 10 : d;
            int nextPrev2 = (nextIsLead == 1) ? 10 : prev1;

            long[] sub = dfs(idx + 1, nextPrev1, nextPrev2, nextIsLimit, nextIsLead);
            long subCount = sub[0];
            long subWaviness = sub[1];

            long currentWaviness = 0;
            // A peak or valley is formed only if we have at least 3 valid digits (prev2, prev1, d)
            if (isLead == 0 && prev2 != 10 && prev1 != 10) {
                if ((prev1 > prev2 && prev1 > d) || (prev1 < prev2 && prev1 < d)) {
                    currentWaviness = 1;
                }
            }

            count += subCount;
            // The total waviness is the sum of waviness from suffixes,
            // plus the contribution of the current peak/valley applied to all valid suffixes.
            waviness += subWaviness + currentWaviness * subCount;
        }

        memo[idx][prev1][prev2][isLimit][isLead][0] = count;
        memo[idx][prev1][prev2][isLimit][isLead][1] = waviness;
        return new long[]{count, waviness};
    }

    // Original O(N * L) solution provided by the problem
    public int totalWavinessBruteForce(int num1, int num2) {
        int ans = 0;
        for (int x = num1; x <= num2; x++) {
            ans += waviness(x);
        }
        return ans;
    }

    private int waviness(int x) {
        String str = Integer.toString(x);
        int cnt = 0;
        for (int i = 1; i < str.length() - 1; i++) {
            char cur = str.charAt(i);
            if ((cur > str.charAt(i - 1) && cur > str.charAt(i + 1)) ||
                (cur < str.charAt(i - 1) && cur < str.charAt(i + 1))) {
                cnt++;
            }
        }
        return cnt;
    }
}
