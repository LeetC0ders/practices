package practices.questionstest.easytest

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import practices.di.DaggerDataStructureComponent
import practices.di.DaggerTestAppComponent
import practices.questions.easy.FizzBuzz
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class FizzBuzzTest {

    private lateinit var fizzBuzz: FizzBuzz

    private val outContent = ByteArrayOutputStream()
    private val errContent = ByteArrayOutputStream()
    private val originalOut = System.out
    private val originalErr = System.err

    @Before
    fun setup() {
        System.setOut(PrintStream(outContent))
        System.setErr(PrintStream(errContent))
        fizzBuzz = DaggerTestAppComponent.builder().dataStructureComponent(DaggerDataStructureComponent.create())
                .build().provideFizzBuzz()
    }

    @Test
    fun getNameTest() {
        assertEquals("FizzBuzz", fizzBuzz.getName())
    }

    @Test
    fun solve1() {
        fizzBuzz.solve(3)
        assertEquals("Fizz", outContent.toString())
    }

    @Test
    fun solve2() {
        fizzBuzz.solve(5)
        assertEquals("Buzz", outContent.toString())
    }

    @Test
    fun solve3() {
        fizzBuzz.solve(15)
        assertEquals("FizzBuzz", outContent.toString())
    }

    @Test
    fun solve4() {
        fizzBuzz.solve(13)
        assertEquals("13", outContent.toString())
    }

    @Test
    fun exceptionTest() {
        try {
            fizzBuzz.solve(0)
        } catch (exception: Exception) {
            assertEquals("Number out of range", exception.message)
        }
    }

    @Test
    fun solve6() {
        try {
            fizzBuzz.solve(101)
        } catch (exception: Exception) {
            assertEquals("Number out of range", exception.message)
        }
    }

    @After
    fun tearDown() {
        System.setOut(originalOut)
        System.setErr(originalErr)
    }
}