package org.example;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnit4.class)
public class MainTest {

    String result;

    @Test
    public void mainTest(){
        Main.main(new String[] {});
    }

    @Test
    public void replaceStringTest(){
        String myString = "I am Happy";
        String oldString = "Happy";
        String newString = "Glad";
        String expected = "I am Glad";

        //replace success
        result = Main.replaceString(myString, oldString, newString);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void reverseStringTest(){
        String myString = "I am Happy";
        String expected = "yppaH ma I";

        //replace success
        result = Main.reverseString(myString);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getAvgTest(){
        int arr[] = {7,4,2,8,9};
        Main.getAvg(arr,5);
        Assert.assertTrue(true);
    }

}