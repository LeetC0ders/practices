package practices.questions.medium;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import practices.questions.Solution;

import javax.inject.Inject;
import java.util.PriorityQueue;

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
        if (solutionIn != null) {

            int[] arr = solutionIn.nums;
            int k = solutionIn.k;
            int numberOfInterest = arr.length - k;
            int answer = -1;

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i : arr) pq.add(i);
            for (int i = 0; i <= numberOfInterest; i++) answer = pq.poll();

            return answer;
        }
        return -1;
    }

// TODO: Use main for unit test

//    public static void main(String[] args) {
//        // test
//        int[] arr = {2,3,4,5,6};
//        System.out.println(new KthLargestNumber().solve(new Pair(arr, 2)));
//    }
}
