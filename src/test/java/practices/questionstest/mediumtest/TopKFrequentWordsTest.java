package practices.questionstest.mediumtest;

import org.junit.Before;
import org.junit.Test;
import practices.HelperFunctionKt;
import practices.di.DaggerDataStructureComponent;
import practices.di.DaggerTestAppComponent;
import practices.questions.medium.TopKFrequentWords;

import static org.junit.Assert.*;

public class TopKFrequentWordsTest {

    private TopKFrequentWords topKFrequentWords = null;

    @Before
    public void setUp() {
            topKFrequentWords = DaggerTestAppComponent
                .builder()
                .dataStructureComponent(DaggerDataStructureComponent.create())
                .build()
                .provideTopKFrequentWords();
    }

    @Test
    public void getNameTest() {
        assertEquals("TopKFrequentWords", topKFrequentWords.getName());
    }

    @Test
    public void solveTest1() {
        String [] testArr = {"i", "love", "leetcode", "i", "love", "coding"};
        int testK = 2;
        TopKFrequentWords.SolutionIn testSolutionIn = new TopKFrequentWords.SolutionIn(testArr, testK);
        assertEquals("[i,love,]", HelperFunctionKt.stringListToString(topKFrequentWords.solve(testSolutionIn)));
    }

    @Test
    public void solveTest2() {
        String [] testArr = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int testK = 4;
        TopKFrequentWords.SolutionIn testSolutionIn = new TopKFrequentWords.SolutionIn(testArr, testK);
        assertEquals("[the,is,sunny,day,]", HelperFunctionKt.stringListToString(topKFrequentWords.solve(testSolutionIn)));
    }

    @Test
    public void solveTest3() {
        String [] testArr = {"a","aa","aaa"};
        int testK = 3;
        TopKFrequentWords.SolutionIn testSolutionIn = new TopKFrequentWords.SolutionIn(testArr, testK);
        assertEquals("[a,aa,aaa,]", HelperFunctionKt.stringListToString(topKFrequentWords.solve(testSolutionIn)));
    }
}
