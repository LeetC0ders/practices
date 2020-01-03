package practices.questions.medium;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import practices.questions.Solution;

/*
 * problem - Summary Ranges - 228
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 *
 * Example 1:
 *
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 *
 * Example 2:
 *
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 **/
@Singleton
public class SummaryRanges implements Solution<int[], List<String>> {

    @Inject
    public SummaryRanges() {}

    @NotNull
    @Override
    public String getName() {
        return "SummaryRanges";
    }

    @Override
    public List<String> solve(@Nullable int[] solutionIn) {
        if (solutionIn != null) return firstAttempt(solutionIn);
        return null;
    }

    /*
    * Runtime: 0 ms, faster than 100.00% of Java online submissions for Summary Ranges.
    * Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Summary Ranges.
    * */
    public List<String> firstAttempt(int[] nums) {
        List<String> ans = new ArrayList<>();
        int start = 0;
        for (int end = 0; end < nums.length; ++end) {
            // case of continue range
            if (end + 1 < nums.length && nums[end + 1] == nums[end] + 1) continue;
            // - cases of a non-continue range -
            // case of 1 digit sub range: start - end == 0
            if (start == end) ans.add(Integer.toString(nums[start]));
            // case of more than 1 digit sub range: start - end > 0
            else ans.add(nums[start] + "->" + nums[end]);
            // update start after a non-continue case
            start = end + 1;
        }
        return ans;
    }
}
