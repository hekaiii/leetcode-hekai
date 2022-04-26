/**
 * @Date: 2022/4/25 9:31
 */
public class BigCar extends Car {
    public int count;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BigCar bigCar = (BigCar) o;

        return count == bigCar.count;
    }

    @Override
    public int hashCode() {
        return count;
    }
}
