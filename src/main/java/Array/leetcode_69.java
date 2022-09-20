package Array;

public class leetcode_69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        int result = 0;
        int left = 1;
        int right = x;
        if (x == 1 || x == 0) {
            return x;
        }
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (mid < x / mid) {
                left = mid + 1;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else if (mid == x / mid) {
                return mid;
            }
        }
        return left;
    }
}
