package practices.questions.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import practices.questions.Solution;
import practices.questions.medium.TopKFrequentWords.SolutionIn;

/*
* problem-692: Top K words
*
* Given a non-empty list of words, return the k most frequent elements.
* Your answer should be sorted by frequency from highest to lowest.
* If two words have the same frequency, then the word with the lower alphabetical order comes first.
*
* Example 1:
*
* Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
* Output: ["i", "love"]
* Explanation: "i" and "love" are the two most frequent words.
* Note that "i" comes before "love" due to a lower alphabetical order.
*
* Example 2:
*
* Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
* Output: ["the", "is", "sunny", "day"]
* Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
* with the number of occurrence being 4, 3, 2 and 1 respectively.
*
* Note: You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
*
* Input words contain only lowercase letters.
* Follow up:
* Try to solve it in O(n log k) time and O(n) extra space.
* */
@Singleton
public class TopKFrequentWords implements Solution<SolutionIn, List<String>> {

    @Inject
    public TopKFrequentWords() {
    }

    public static class SolutionIn {

        private String[] words;
        private int k;

        public SolutionIn(String[] words, int k) {
            this.words = words;
            this.k = k;
        }

        int getK() { return k; }
        String[] getWords() { return words; }
    }

    @NotNull
    @Override
    public String getName() {
        return "TopKFrequentWords";
    }

    @Override
    public List<String> solve(@Nullable SolutionIn solutionIn) {
        if (solutionIn != null) {
            return firstAttempt(solutionIn.getWords(), solutionIn.getK());
        }
        return null;
    }

    /*
    * Runtime: 7 ms, faster than 54.64% of Java online submissions for Top K Frequent Words.
    * Memory Usage: 37.3 MB, less than 91.07% of Java online submissions for Top K Frequent Words.
    * */
    public List<String> firstAttempt(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        Comparator<WordWithCounter> wordWithCounterComparator = new Comparator<WordWithCounter>() {
            @Override
            public int compare(WordWithCounter o1, WordWithCounter o2) {
                if (o1.counter > o2.counter) {
                    return -1;
                }
                if (o1.counter == o2.counter) {
                    // handle order based on characters
                        return o1.word.compareTo(o2.word);
                } else {
                    return 1;
                }

            }
        };
        PriorityQueue<WordWithCounter> pq = new PriorityQueue<>(wordWithCounterComparator);

        if (k > words.length) return list;

        for (String word : words) {
            if (map.containsKey(word)) {
                Integer count = map.get(word);
                map.remove(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }

        for (String wordKey: map.keySet()) {
            WordWithCounter wwc = new WordWithCounter(map.get(wordKey), wordKey);
            pq.add(wwc);
        }

        for (int i = 0; i < k; i++) {
            list.add(pq.poll().word);
        }

        return list;
    }

    // required by firstAttempt()
    static class WordWithCounter {
        int counter;
        String word;
        WordWithCounter(int counter, String word) {
            this.counter = counter;
            this.word = word;
        }
    }

}
