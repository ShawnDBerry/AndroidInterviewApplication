package com.example.androidinterviewapplication

import com.example.androidinterviewapplication.composable.bracketValidator
import org.junit.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun validateBracketsTest1() {
        assertTrue(bracketValidator(""))
    }

    @Test
    fun validateBracketsTest3() {
        assertFalse(bracketValidator("{"))
    }

    @Test
    fun validateBracketsTest2() {
        assertFalse(bracketValidator("("))
    }

    @Test
    fun validateBracketsTest4() {
        assertFalse(bracketValidator("["))
    }

    @Test
    fun validateBracketsTest6() {
        assertFalse(bracketValidator("}"))
    }

    @Test
    fun validateBracketsTest7() {
        assertFalse(bracketValidator("]"))
    }

    @Test
    fun validateBracketsTest5() {
        assertFalse(bracketValidator(")"))
    }


    @Test
    fun validateBracketsTest8() {
        assertTrue(bracketValidator("{([])}"))
    }

    @Test
    fun validateBracketsTest9() {
        assertTrue(bracketValidator("{()[]}"))
    }

    @Test
    fun validateBracketsTest10() {
        assertTrue(bracketValidator("{}()[]"))
    }

    @Test
    fun validateBracketsTest11() {
        assertFalse(bracketValidator("{([})}"))
    }

    @Test
    fun validateBracketsTest12() {
        assertTrue(bracketValidator("{([{}()[]])}"))
    }
}