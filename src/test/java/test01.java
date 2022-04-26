/**
 * @Date: 2022/4/25 9:35
 */
public class test01 {
    public static void main(String[] args) {
        Car car = new Car();
        BigCar bigCar = new BigCar();
        if (car instanceof BigCar) {
            System.out.println("1");
        }
        if (bigCar instanceof Car) {
            System.out.println("2");
        }
    }
}
