package practices.questionstest.easytest;

import org.junit.Before;
import org.junit.Test;
import practices.di.DaggerDataStructureComponent;
import practices.di.DaggerTestAppComponent;
import practices.questions.easy.SplitStringToBalancedString;

import static org.junit.Assert.*;

public class SplitStringToBalancedStringTest {

    private SplitStringToBalancedString splitStringToBalancedString = null;

    @Before
    public void setUp() {
        splitStringToBalancedString = DaggerTestAppComponent
                .builder()
                .dataStructureComponent(DaggerDataStructureComponent.create())
                .build()
                .provideSplitStringToBalancedString();
    }

    @Test
    public void getNameTest() {
        assertEquals("SplitStringToBalancedString", splitStringToBalancedString.getName());
    }

    @Test
    public void solveTest1() {
        String test = "RLRRLLRLRL";
        assertEquals((Integer) 4, splitStringToBalancedString.solve(test));
    }

    @Test
    public void solveTest2() {
        String test = "RLRRRLLRLL";
        assertEquals((Integer) 2, splitStringToBalancedString.solve(test));
    }

    @Test
    public void solveTest3() {
        String test = "L";
        assertEquals((Integer) 0, splitStringToBalancedString.solve(test));
    }

    @Test
    public void solveTest4() {
        String test = "RL";
        assertEquals((Integer) 1, splitStringToBalancedString.solve(test));
    }
}
