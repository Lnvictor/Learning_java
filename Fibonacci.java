/*
 * Fibonacci Sequence Implementation using recursion concept
 * @author: Victor Pereira
 * version: 21/12/2019
 */

public class Fibonacci {

    public int return_Fibo(int position) {
        if (position <= 2) {
            return 1;
        }

        return return_Fibo(position - 1) + return_Fibo(position - 2);
    }

    public void test_returnFIbo() {
        System.out.println(return_Fibo(5));
        System.out.println(return_Fibo(2));
        System.out.println(return_Fibo(1));
        System.out.println(return_Fibo(6));
    }

    public static void main(String[] args) {
        Fibonacci Fibo = new Fibonacci();
        Fibo.test_returnFIbo();
    }
}