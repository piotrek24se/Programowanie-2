package ex7Password;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    private PasswordValidator passwordValidator;
    private String password = "d229fwA!";

    @BeforeEach
    public void setUp() {
        passwordValidator = new PasswordValidator();
    }

    @Test
    public void shouldReturnTrueIfPasswordLengthIs8() {
        //when
        Boolean isLength8 = passwordValidator.isPasswordValid(password);
        //then
        assertTrue(isLength8 == true);
    }

    @Test
    public void shouldReturnTrueIfPasswordConsistOnlyOfLettersDigitsAndSpecialSigns() {
        //when
        Boolean complexity = passwordValidator.isPasswordValid(password);
        //then
        assertTrue(complexity == true);
    }

    @Test
    public void shouldReturnTrueIfPasswordContainsAtLeast2Digits() {
        //when
        Boolean complexity = passwordValidator.isPasswordValid(password);
        //then
        assertTrue(complexity == true);
    }

    @Test
    public void shouldReturnTrueIfPasswordContainsAtLeast1CapitalLetter() {
        //when
        Boolean complexity = passwordValidator.isPasswordValid(password);
        //then
        assertTrue(complexity == true);
    }

    @Test
    public void shouldReturnTrueIfPasswordContainsAtLeast1SpecialSign() {
        //when
        Boolean complexity = passwordValidator.isPasswordValid(password);
        //then
        assertTrue(complexity == true);
    }


}