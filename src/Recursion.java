/*
 * There is no requirement for a file header comment for this
 * assignment. Spend your time writing good testcases instead!
 */
import java.util.Queue;
import java.util.Stack;

public class Recursion {

    /**
     * Write a recursive function that finds the index of s2 in s1. Do not use any
     * string functions except for .length(), .equals(), and .substring(). Do not use
     * any loops, or any data structures.
     * @param s1
     * @param s2
     * @return Returns the index of the first time that
     * 			s2 appears in s1 or -1 if s2 is not contained
     * 			in s1.
     */

    public static int indexOf(String s1, String s2)
    {
        /**
         * Make sure neither string has run out of characters to check
         * exit function if the "internal string" is longer than the "external string"
         */
        if(s1.length()==0 || s2.length()==0)
            return 0;
        else if (s2.length()>s1.length())
            return -1;
        else if(s1.substring(0,1).equals(s2.substring(0,1)))
        {
            /**
             * If we are inside this block it means the first letters of the two strings are the same
             * The recursive call here stored in index is essentially an implementation of .startsWith()
             * As long as each call continues to show matching characters the method will be recursively
             * called until the word is found
             */
            int index = indexOf(s1.substring(1),s2.substring(1));
            if (index==-1)
                return -1;
            else
                return indexOf(s1.substring(1),s2.substring(1));
        }
        else
        {
            /**
             * If we are inside this block it means the first letters of the two strings are NOT the same
             * The recursive call here stored in index continues to search for s2 in s1, moving through s1
             * a single character at a time
             * The method will exit if it determines s2 is not in s1, otherwise it will continue adding 1
             * to the current index as it searches
             */
            int index = indexOf(s1.substring(1),s2);
            if(index==-1)
                return -1;
            else
                return 1+indexOf(s1.substring(1),s2);
        }
    }

    /**
     * Write a recursive function that removes the first k even numbers
     * from the stack. If there are less than k even elements in the stack,
     * just remove all even elements. Do not use any loops or data structures
     * other than the stack passed in as a parameter.
     * @param stack
     * @param k
     * @return Returns the number of elements removed from the stack.
     */
    public static int removeEvenNumbers(Stack<Integer> stack, int k)
    {
         if(!stack.isEmpty())
         {
             //Check if stack is empty then run
             int firstElement = stack.pop();
             int counter = 0;
             boolean deleteFlag = false;
             //Check if element stored in firstElement is even
             if(k>0 && firstElement!=0 && firstElement%2==0)
             {
                 k--;
                 counter++;
                 deleteFlag = true;
             }
             //Make the recursive call here, passing stack with first item removed, and incremented k
             counter+=removeEvenNumbers(stack,k);
             //Re-add the non-deleted elements after recursive call to avoid rescanning integers
             if(!deleteFlag)
                 stack.push(firstElement);
             //Return counter at the end of each run through
             return counter;
         }
         //Return 0 when the stack is empty, meaning we are finished
         return 0;
    }

    /**
     * Write a recursive function that accepts an integer and
     * returns a new number containing only the even digits, in the same
     * order. If there are no even digits, return 0. Your function should
     * work for positive or negative numbers. You are NOT allowed
     * to use any data structures. You are not allowed to use Strings to
     * solve this problem either.
     * @param n
     * @return The input with only the even digits remaining in the same
     * order.
     */
    public static int evenDigits(int n)
    {
        if(n<0) //Takes care of negative cases
            return -evenDigits(-n);
        else if(n==0) //Zero is neither even nor odd so instantly return 0
            return 0;
        else if(n%2==0) //If number is even then remove it by integer division by 10 passed recursively
            return evenDigits(n/10);
        else //Math tricks to add the odd numbers back on to the end of the recursive call
            return 10*evenDigits(n/10)+(n%10);
    }

    /**
     * Write a recursive function that evaluates a Queue<Character> as a mathematical
     * expression. This queue can have any of the following characters:
     * { '(', ')', '+', '*'} or any single digit number. Evaluate this expression and
     * return the result. For example, for the expression:
     * "(((1+2)*(3+1))+(1*(2+2)))", each of these characters would be in the
     * q. As you recursively evaluate characters from the expression, you will
     * remove the characters from the q. After evaluating the above expression,
     * you should return 16. You are guaranteed that there are NO two digit numbers,
     * and that the expression is well formed (parenthesis match, etc...). Do not use any
     * loops. Do not use any data structures besides the q passed in as a parameter.
     * @param q
     * @return The result of the mathematical expression.
     */
    public static int evaluate(Queue<Character> q)
    {
        //((3*4)+5)
        int total = 0;
        char temp = q.remove();
        if(Character.isDigit(temp))
        {
            total+=Character.getNumericValue(temp);
            char nextChar = q.remove();
            if(nextChar=='(')
            if(nextChar=='+')
            {
                char nextNextChar = q.remove();
                total+=nextNextChar;
            }
            else if(nextChar=='*')
            {
                char nextNextChar = q.remove();
                total*=nextNextChar;
            }
        }
        return 0;
    }

    /**
     * Write a recursive function that accepts a stack of integers and
     * replaces each int with two copies of that integer. For example,
     * calling repeatStack and passing in a stack of { 1, 2, 3} would change
     * the stack to hold { 1, 1, 2, 2, 3, 3}. Do not use any loops. Do not use
     * any data structures other than the stack passed in as a parameter.
     * @param stack
     */
    public static void repeatStack(Stack<Integer> stack)
    {
        //Continue until we reach the last element of the stack
        if(!stack.isEmpty())
        {
            //Store first element here so we can pass stack without first element
            int firstElement = stack.pop();
            //Recursive call with updated stack
            repeatStack(stack);
            //Push original element twice on the returned stack
            stack.push(firstElement);
            stack.push(firstElement);
        }
    }

    /**
     * Write a recursive function that accepts a Queue<Integer>. It
     * should change every int in this queue to be double its original
     * value. You may NOT use loops or any other data structures besides
     * the queue passed in as a parameter. You may use a helper function.
     * @param q
     */
    public static void doubleElements(Queue<Integer> q)
    {
        //Make recursive call through helper function to get around length parameter issue
        doubleElementsHelper(q,q.size());
    }

    public static void doubleElementsHelper(Queue<Integer> q, int length)
    {
        //Exit when queue is empty
        if(length>0)
        {
            int temp = 2*q.remove();
            q.add(temp);
            //Recursive function call, pass queue with doubled value added to back, length-1
            doubleElementsHelper(q,length-1);
        }
    }



}
