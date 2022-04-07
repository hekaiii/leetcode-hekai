package StackAndQueue;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

/**
 * @Date: 2022/3/28 15:46
 */

public class leetcode_42 {

    public int trap(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (i == 0 || i == height.length - 1) {
                continue;
            }
            int lheight = 0;
            int rheight = 0;
            for (int r = i - 1; r >= 0; r--) {
                if (height[r] > rheight) {
                    rheight = height[r];
                }
            }
            for (int j = i + 1; j <= height.length - 1; j++) {
                if (height[j] > lheight) {
                    lheight = height[j];
                }
            }
            int h = Math.min(lheight, rheight) - height[i];
            if (h > 0) {
                sum += h;
            }
        }
        return sum;
    }
}
