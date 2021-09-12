import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Stack;

public class RecursionTestClass
{
    /**
     * indexOf() test cases
     */

    @Test
    public void testIndexOf_test1()
    {
        int result1 = Recursion.indexOf("Hello", "World");
        System.out.println("Hello, World: " + result1);
        assertEquals(-1, result1);
    }

    @Test
    public void testIndexOf_test2()
    {
        int result2 = Recursion.indexOf("boring", "ing");
        System.out.println("boring, ing: " + result2);
        assertEquals(3, result2);
    }

    @Test
    public void testIndexOf_test3()
    {
        int result3 = Recursion.indexOf("","");
        System.out.println("\"\",\"\": " + result3);
        assertEquals(0,result3);
    }

    @Test
    public void testIndexOf_test4()
    {
        int result4 = Recursion.indexOf("United States of America", "INGSOC");
        System.out.println("United States of America, INGSOC: "+result4);
        assertEquals(-1,result4);
    }

    @Test
    public void testIndexOf_test5()
    {
        int result5 = Recursion.indexOf("Kafkaesque", "Kafka");
        System.out.println("Kafkaesque, Kafka: "+result5);
        assertEquals(0,result5);
    }

    /**
     * removeEvenNumbers() test cases
     */

    @Test
    public void testRemoveEvenNumbers1()
    {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i =0;i<11;i++)
            stack.push(i);
        System.out.println();
        int result = Recursion.removeEvenNumbers(stack,7);
        System.out.println("Elements removed test 1: "+result);
        assertEquals(5,result);
    }

    @Test
    public void testRemoveEvenNumbers2()
    {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i =0;i>-11;i--)
            stack.push(i);
        System.out.println();
        int result = Recursion.removeEvenNumbers(stack,2);
        System.out.println("Elements removed test 2: "+result);
        assertEquals(2,result);
    }

    @Test
    public void testRemoveEvenNumbers3()
    {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i =-1000;i<1001;i++)
            stack.push(i);
        System.out.println();
        int result = Recursion.removeEvenNumbers(stack,230);
        System.out.println("Elements removed test 3: "+result);
        assertEquals(230,result);
    }

    @Test
    public void testRemoveEvenNumbers4()
    {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i =-1000;i<1001;i++)
            stack.push(i);
        System.out.println();
        int result = Recursion.removeEvenNumbers(stack,2500);
        System.out.println("Elements removed test 4: "+result);
        assertEquals(1000,result);
    }

    /**
     * evenDigits() test cases
     */

    //@Test

}
