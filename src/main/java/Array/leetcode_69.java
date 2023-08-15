package Array;

public class leetcode_69 {
    public static void main(String[] args) {
//        System.out.println(mySqrt(2147395599));
        System.out.println(mySqrt01(5));
    }

    public static int mySqrt(int x) {
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

    //左闭右闭
    public static int mySqrt01(int x){
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1;
        int right = x / 2;
        while (left <= right) {
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
