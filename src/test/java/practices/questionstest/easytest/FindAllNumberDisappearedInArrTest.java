package practices.questionstest.easytest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static practices.HelperFunctionKt.intArrayToString;
import static practices.HelperFunctionKt.intListToString;

import practices.di.DaggerDataStructureComponent;
import practices.di.DaggerTestAppComponent;
import practices.questions.easy.FindAllNumberDisappearedInArr;

public class FindAllNumberDisappearedInArrTest {

    private FindAllNumberDisappearedInArr findAllNumberDisappearedInArr = null;

    @Before
    public void setUp() {
        findAllNumberDisappearedInArr = DaggerTestAppComponent
                .builder()
                .dataStructureComponent(DaggerDataStructureComponent.create())
                .build()
                .provideFindAllNumberDisappearedInArr();
    }

    @After
    public void tearDown() { /* no -op */}

    @Test
    public void getNameTest() {
        assertEquals("FindAllNumberDisappearedInArr", findAllNumberDisappearedInArr.getName());
    }

    // FindAllNumberDisappearedInArr solve() implementation is firstAttempt(), so ```fun firstAttemptTest()``` is not needed
    @Test
    public void solveTest1() {
        int[] test = {1,1};
        int[] ans = {2};
        assertEquals(intArrayToString(ans), intListToString(findAllNumberDisappearedInArr.solve(test)));
    }

    @Test
    public void solveTest2() {
        int[] test = {1};
        int[] ans = {};
        assertEquals(intArrayToString(ans), intListToString(findAllNumberDisappearedInArr.solve(test)));
    }

}
