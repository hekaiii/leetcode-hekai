package Array;

public class leetcode_69 {

  public static void main(String[] args) {
//        System.out.println(mySqrt(2147395599));
    System.out.println(mySqrt02(12));
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
  public static int mySqrt01(int x) {
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

  //蠢人方法
  public static int mySqrt02(int x) {
    if (x == 0 || x == 1) {
      return x;
    }
    int left = 1;
    int right = x / 2;
    while (right >= left) {
      int mid = left + (right - left) / 2;
      if (mid < x/mid) {
        left = mid + 1;
      } else if (mid > x/mid) {
        right = mid - 1;
      } else {
        return mid;
      }
    }
    //拿不准是否需要减1，再次校验结果
    if (left > x / left && (left + 1) < x / (left + 1)) {
      return left;
    } else {
      return left - 1;
    }
  }


  public static int mySqrt03(int x) {
    if (x == 0) {
      return 0;
    }
    if (x == 1) {
      return 1;
    }
    int left = -1;
    int right = x + 1;
    while (left+1 < right) { // [a,b]
      int mid = left + (right - left) / 2;
      if (mid > x/mid ) {
        right = mid;
      } else {
        // 由于本题特殊性，如果 mid == x / mid 就找到了答案，其它问题不一定可以这样
          left = mid;
      }
    }
    return left;
  }
}
