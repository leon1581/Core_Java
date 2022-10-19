package ObjectAndClass;

public class ParamTest {

    public static void main(String[] args) {
        /**
         * 方法不能修改基本类型的参数
         */
        System.out.println("Testing tripleValue");
        double percent = 10;
        System.out.println("Before: percent=" + percent);
        tripleValue(percent);
        System.out.println("After: percent=" + percent);

        /**
         * 方法可以改变对象参数的状态
         */
        System.out.println("\nTesting tripleSalary:");
        Employeee harry = new Employeee("Harry", 50000);
        System.out.println("Before: salary=" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary=" + harry.getSalary());

        /**
         * 方法不能让一个对象参数引用一个新的对象
         */
        System.out.println("\nTesting swap:");
        Employeee a = new Employeee("Alice", 6000);
        Employeee b = new Employeee("Bob", 5000);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());

    }

    public static void tripleValue(double x) {
        x = 3 * x;
        System.out.println("End of method:x=" + x);
    }

    public static void tripleSalary(Employeee x) {
        x.raiseSalary(200);
        System.out.println("End of method:salary=" + x.getSalary());
    }

    public static void swap(Employeee x, Employeee y) {
        Employeee temp = x;
        x = y;
        y = temp;
        System.out.println("End of method:x=" + x.getName());
        System.out.println("End of method:y=" + y.getName());
    }
}

class Employeee{
    private String name;
    private double salary;

    public Employeee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
