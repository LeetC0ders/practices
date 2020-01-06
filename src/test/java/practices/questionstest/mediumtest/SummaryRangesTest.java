package practices.questionstest.mediumtest;

import org.junit.Before;
import org.junit.Test;
import practices.di.DaggerDataStructureComponent;
import practices.di.DaggerTestAppComponent;
import practices.questions.medium.SummaryRanges;

import static practices.HelperFunctionKt.stringListToString;

import static org.junit.Assert.*;

public class SummaryRangesTest {

    private SummaryRanges summaryRanges = null;

    @Before
    public void setUp() {
        summaryRanges = DaggerTestAppComponent.builder().dataStructureComponent(
            DaggerDataStructureComponent.create()).build().provideSummaryRanges();
    }

    @Test
    public void getNameTest() {
        assertEquals("SummaryRanges", summaryRanges.getName());
    }

    @Test
    public void solveTest1() {
        int[] test = {0,2,3,4,6,8,9};
        assertEquals("[0,2->4,6,8->9,]", stringListToString(summaryRanges.solve(test)));
    }

    @Test
    public void solveTest2() {
        int[] test = {0,2};
        assertEquals("[0,2,]", stringListToString(summaryRanges.solve(test)));
    }

    @Test
    public void solveTest3() {
        int[] test = {0};
        assertEquals("[0,]", stringListToString(summaryRanges.solve(test)));
    }

    @Test
    public void solveTest4() {
        int[] test = {0,1,2,3,4,5,6};
        assertEquals("[0->6,]", stringListToString(summaryRanges.solve(test)));
    }

    @Test
    public void solveTest5() {
        int[] test = {0,2,4,6,8,10,12};
        assertEquals("[0,2,4,6,8,10,12,]", stringListToString(summaryRanges.solve(test)));
    }
}
