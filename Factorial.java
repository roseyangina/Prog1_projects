public class Factorial {

        public static long pureRecursive(int n) {
            if (n <= 0) {
                throw new IllegalArgumentException(); //non-positive number
            }
            if(n==1){return 1;}
            return n * pureRecursive(n - 1);

        }
        //Tail Recursion with calling to tail
        public static long tailRecursive(int n) {
            if(n<=0){
                throw new IllegalArgumentException(); //non-positive number
            }
            return tail(n, 1, 1);
        }

        //method for tail recursion
        private static long tail(int n, int i, long m) {
            if (i <= n) {
                return tail(n, i + 1, m * i);
            } else {
                return m;
            }
        }

        // a  non-recursive method of tail recursion to find factorial
    public static long iterative(int n) {
        if(n<=0){
            throw new IllegalArgumentException();
        }

            long m = 1;
            // for loop to get factorial of n
            for (int i = 1; i <= n; i++) {
                m = m * i;

            }
            return m;
        }
    }

