package Array;

import sun.java2d.pipe.AAShapePipe;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: HeKai
 * @Date: 2022/2/23 18:45
 */
public class test {
    public static void main(String[] args) {
        Thread aa = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {
            }
        }, "aa");
        //将aa线程设置为守护线程
//        aa.setDaemon(true);
        aa.start();
        System.out.println(Thread.currentThread().getName() + " is over");
    }
}
