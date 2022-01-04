package com.kaliada.sandbox;

/*
   /3/
  \7\ 4
 2 \4\ 6
8 5 \9\ 3

Let's say that the 'slide down' is the maximum sum of consecutive numbers from the top to the bottom of the pyramid.
As you can see, the longest 'slide down' is 3 + 7 + 4 + 9 = 23
 */

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class PyramidSlideDown {
    public static void main(String[] args) {
        int[][] pyramid = {{3}, {7, 4}, {2, 4, 6}, {8, 5, 9, 3}};
        System.out.println(longestSlideDown(pyramid));
    }
    public static int longestSlideDown(int[][] pyramid) {
        for (int i = pyramid.length - 1; i >= 1; i--)
            for (int j = 0; j < i; j++)
                pyramid[i - 1][j] += Math.max(pyramid[i][j], pyramid[i][j + 1]);
        return pyramid[0][0];
    }

    public static int getSum(int x, int y, int[][] pyramid, int sum) {
        sum += pyramid[x][y];
        if (pyramid.length - 1 == x) {
            return sum;
        }
        return Math.max(getSum(x + 1, y, pyramid, sum), getSum(x + 1, y + 1, pyramid, sum));
    }

    private static class SumCounter extends RecursiveTask<Integer> {
        private final int x;
        private final int y;
        private final int[][] pyramid;
        private int sum;

        public SumCounter(int x, int y, int[][] pyramid, int sum) {
            this.x = x;
            this.y = y;
            this.pyramid = pyramid;
            this.sum = sum;
        }

        @Override
        protected Integer compute() {
            sum += pyramid[x][y];
            if (pyramid.length - 1 == x) {
                return sum;
            }
            SumCounter one = new SumCounter(x + 1, y, pyramid, sum);
            one.fork();
            SumCounter two = new SumCounter(x + 1, y + 1, pyramid, sum);
            two.fork();
            return Math.max(one.join(), two.join());
        }
    }
}