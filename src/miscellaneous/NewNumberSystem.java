/*

Find n’th number in a number system with only 3 and 4
Given a number system with only 3 and 4. Find the nth number in the number system. First few numbers in the number system are: 
3, 4, 33, 34, 43, 44, 333, 334, 343, 344, 433, 434, 443, 444, 3333, 3334, 3343, 3344, 3433, 3434, 3443, 3444, …

 */

package miscellaneous;

/**
 * Created by poorvank on 1/16/16.
 */
public class NewNumberSystem {

    public static void main(String[] args) {

        int n = 8;

        String[] arr = new String[n + 1];

        arr[0] = "";

        //Total number pf elements till now
        int size = 1;

        //Elements in last iteration
        int lastIterationCount = 1;

        while (size <= n) {

            for (int i = 0; i < lastIterationCount && (size + i) <= n; i++) {
                arr[size + i] = '3' + arr[size - lastIterationCount + i];
            }

            for (int i = 0; i < lastIterationCount && (size + lastIterationCount + i) <= n; i++) {
                arr[size + lastIterationCount + i] = '4' + arr[size - lastIterationCount + i];
            }

            lastIterationCount = lastIterationCount << 1;

            size = size + lastIterationCount;

        }

        System.out.println(arr[n]);
    }

}

/*

We can generate all numbers with i digits using the numbers with (i-1) digits. 
The idea is to first add a ‘3’ as prefix in all numbers with (i-1) digit, then add a ‘4’. 
For example, the numbers with 2 digits are 33, 34, 43 and 44. The numbers with 3 digits are 
333, 334, 343, 344, 433, 434, 443 and 444 which can be generated by first adding a 3 as prefix, then 4.

Following are detailed steps.

1) Create an array 'arr[]' of strings size n+1. 
2) Initialize arr[0] as empty string. (Number with 0 digits)
3) Do following while array size is smaller than or equal to n
.....a) Generate numbers by adding a 3 as prefix to the numbers generated 
        in previous iteration.  Add these numbers to arr[]
.....a) Generate numbers by adding a 4 as prefix to the numbers generated 
        in previous iteration. Add these numbers to arr[]


 */