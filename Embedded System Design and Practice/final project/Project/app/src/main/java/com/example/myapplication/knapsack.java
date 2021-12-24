package com.example.myapplication;

import java.util.*;

class knapsack
{
    private static int Max_sum = 455;
    private static int num; // numbers of all questions
    private static int quiz_amount = 10; // numbers of select questions   
    private static int target; // the weight of correspond difficulty
    private static int[][] dp;
    private static boolean[][][] p;
    private static int difficulty;
    knapsack(int d)
    {
        difficulty = d;
        use();
    }

    // input
    //private static int difficulty = 1; // 1:easy, 2:midium, 3:hard

    // output
    private static List<Integer> result = new ArrayList<Integer>(); // store output(10 questions)

    public static List<Integer> getResult()
    {
        return result;
    }

    public static void use()
    {
        // init
        problem_database mydata = new problem_database();
        num = mydata.getSize();
        dp = new int[Max_sum + 1][quiz_amount + 1];
        p = new boolean[num + 1][Max_sum + 1][quiz_amount + 1];

        if (difficulty == 1) target = (int) (Math.random() * 31) + 70; // 70 ~ 100
        else if (difficulty == 2) target = (int) (Math.random() * 31) + 240; // 240 ~ 270
        else target = (int) (Math.random() * 31) + 420; // 420 ~ 450

        mydata.shuffle();

        dp[0][0] = 1;
        for (int k = 0; k < num; ++k)
        {
            for (int i = Max_sum; i >= mydata.getWeight(k); --i)
            {
                for (int j = quiz_amount; j >= 1 ; --j)
                {
                    int cnt = dp[i - mydata.getWeight(k)][j - 1];
                    if (cnt > 0)
                    {
                        dp[i][j] += cnt;
                        p[k][i][j] = true;
                    }
                }
            }
        }

        for (int i = num - 1, j = target, k = quiz_amount; i >= 0; --i)
        {
            if (p[i][j][k] == true)
            {
                //System.out.println("q:" + myList.get(i).getWeight() + " w:" + j);
                result.add(mydata.getId(i));
                j -= mydata.getWeight(i);
                --k;
            }
        }

       // System.out.println("difficulty: " + difficulty);
       // System.out.println("target weight: " + target);
       // System.out.println("different combination: " + dp[target][10]);
       // for (int i : result) System.out.print(" " + i);
    }
}