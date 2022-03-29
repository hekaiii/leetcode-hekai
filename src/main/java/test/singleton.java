package test;

/**
 * @Date: 2022/3/29 17:45
 */
public class singleton {
    private final static singleton SINGLETON = new singleton();

    public singleton() {
    }

    public static singleton getInstance() {
        return SINGLETON;
    }
}
