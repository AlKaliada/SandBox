package com.kaliada.sandbox;

/*
   /3/
  \7\ 4
 2 \4\ 6
8 5 \9\ 3

Let's say that the 'slide down' is the maximum sum of consecutive numbers from the top to the bottom of the pyramid.
As you can see, the longest 'slide down' is 3 + 7 + 4 + 9 = 23
 */

public class PyramidSlideDown {
    public static void main(String[] args) {
        int[][] pyramid = {{3}, {7, 4}, {2, 4, 6}, {8, 5, 9, 3}};
        System.out.println(longestSlideDown(pyramid));
    }
    public static int longestSlideDown(int[][] pyramid) {
        return getSum(0, 0, pyramid, 0);
    }

    static class Sum extends Thread {
        @Override
        public void run() {
            super.run();
        }
    }
    public static int getSum(int x, int y, int[][] pyramid, int sum) {
        sum += pyramid[x][y];
        if (pyramid.length - 1 == x) {
            return sum;
        }
        return Math.max(getSum(x + 1, y, pyramid, sum), getSum(x + 1, y + 1, pyramid, sum));
    }
}