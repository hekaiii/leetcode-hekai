package test;

/**
 * @Date: 2022/3/29 17:48
 */
public enum Lazy {
    Instance;

    private Lazy() {
        System.out.println(Thread.currentThread().getName());
    }

    public static Lazy getInstance() {
        System.out.println();
        return Instance;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Lazy.getInstance();
                System.out.println();
            }, i + "").start();
        }
    }
}
