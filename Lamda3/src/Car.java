import java.util.*;

public class Car {
    private String model;
    private boolean gasoline;
    private int age;
    private int mileage;

    public Car(String model, boolean gasoline, int age, int mileage) {
        this.model = model;
        this.gasoline = gasoline;
        this.age = age;
        this.mileage = mileage;
    }

    public String getModel() {
        return model;
    }

    public boolean isGasoline() {
        return gasoline;
    }

    public int getAge() {
        return age;
    }

    public int getMileage() {
        return mileage;
    }

    public String toString() {
        return String.format("Car(%s, %s, %d, %d)", model, gasoline, age, mileage);
    }

    public static final List<Car> cars = Arrays.asList(
            new Car("소나타", true, 18, 210000),
            new Car("코란도", false, 15, 200000),
            new Car("그랜저", true, 12, 150000),
            new Car("싼타페", false, 10, 220000),
            new Car("아반테", true, 10, 70000),
            new Car("에쿠스", true, 6, 100000),
            new Car("그랜저", true, 5, 80000),
            new Car("소나타", true, 2, 35000),
            new Car("쏘렌토", false, 1, 10000),
            new Car("아반테", true, 1, 7000));

    // CarPredicate 인터페이스 정의
    interface CarPredicate {
        boolean test(Car car);
    }

    // CarConsumer 인터페이스 정의
    interface CarConsumer {
        void apply(Car car);
    }

    // findCars 메서드 정의
    public static List<Car> findCars(List<Car> all, CarPredicate cp) {
        List<Car> result = new ArrayList<>();

        for (Car car : all) {
            if (cp.test(car))
                result.add(car);
        }
        return result;
    }

    // printCars 메서드 정의
    public static void printCars(List<Car> all, CarConsumer cc) {
        for (Car car : all) {
            cc.apply(car);
        }
    }

    public static void main(String[] args) {
        //람다식 부분
        List<Car> dieselCars = findCars(cars, car -> !car.isGasoline());
        System.out.print("디젤 자동차 = ");
        printCars(dieselCars, c -> System.out.printf("%s(%d) ", c.getModel(), c.getAge()));
    }
}



