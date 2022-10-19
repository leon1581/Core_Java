package ObjectAndClass;

import java.util.Objects;
import java.util.Random;

public class ConstructorTest {
    public static void main(String[] args) {
        // 通过3种方式得到Employee3对象加入数组
        Employee3[] staff = new Employee3[3];

        staff[0] = new Employee3("Harry", 40000);
        staff[1] = new Employee3(60000);
        staff[2] = new Employee3();

        for (Employee3 employee3 : staff) {
            System.out.println("name=" + employee3.getName() + ",id=" + employee3.getId() + ",salary=" + employee3.getSalary());

        }

    }
}

class Employee3 {
    private static int nextId;

    private int id;
    private String name = ""; // 字段声明中初始化
    private double salary;

    // 静态代码块
    static {
        Random generator = new Random();
        nextId = generator.nextInt(10000);
    }

    // 初始化代码块
    {
        id = nextId;
        nextId++;
    }

    // 三个重载的构造器
    public Employee3(String n, double s) {
        name = n;
        salary = s;
    }

    public Employee3(double s) {
        this("Employee #" + nextId, s);
    }

    public Employee3(){
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
