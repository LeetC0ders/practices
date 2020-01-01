package practices.questions.medium;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import practices.questions.Solution;

import javax.inject.Inject;
import java.util.PriorityQueue;

/*
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * */
public class KthLargestNumber implements Solution<KthLargestNumber.Pair, Integer> {

    static class Pair {

        int[] nums;
        int k;

        Pair(int[] nums, int k) {
            this.nums = nums;
            this.k = k;
        }
    }

    @Inject
    public KthLargestNumber() {}

    @NotNull
    @Override
    public String getName() {
        return "KthLargestNumber";
    }

    @Override
    public Integer solve(@Nullable Pair solutionIn) {
        if (solutionIn != null) return firstAttempt(solutionIn.nums, solutionIn.k);
        return -1;
    }

    /*
     * Runtime: 8 ms, faster than 47.97% of Java online submissions for Kth Largest Element in an Array.
     * Memory Usage: 36.2 MB, less than 90.67% of Java online submissions for Kth Largest Element in an Array.
     * */
    public Integer firstAttempt(int[] nums, int k) {
        int[] arr = nums;
        int numberOfInterest = arr.length - k;
        int answer = -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : arr) {
            pq.add(i);
        }
        for (int i = 0; i <= numberOfInterest; i++) {
            answer = pq.poll();
        }

        return answer;
    }

// TODO: Use main for unit test

//    public static void main(String[] args) {
//        // test
//        int[] arr = {2,3,4,5,6};
//        System.out.println(new KthLargestNumber().solve(new Pair(arr, 2)));
//    }
}
