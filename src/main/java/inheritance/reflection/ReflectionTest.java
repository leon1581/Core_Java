package inheritance.reflection;

import javax.print.attribute.standard.MediaSize;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest {
    public static void main(String[] args) throws ReflectiveOperationException {
        // 从命令框中读取类名
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date)");
            name = in.next();
        }

        // 打印类名和超类名
        Class<?> cl = Class.forName(name);
        Class<?> supercl = cl.getSuperclass();
        String modifies = Modifier.toString(cl.getModifiers());
        if (modifies.length() > 0) System.out.println(modifies + " ");
        System.out.println("class" + name);
        if (supercl != null && supercl != Object.class) System.out.println(" extends " + supercl.getName());

        System.out.println("\n{\n");
        printConstructors(cl);
        System.out.println();
        printMethods(cl);
        System.out.println();
        printFields(cl);
        System.out.println("}");
    }

    private static void printFields(Class<?> cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            Class<?> type = field.getType();
            String name = field.getName();
            System.out.println("    ");
            String modifies = Modifier.toString(field.getModifiers());
            if (modifies.length() > 0) System.out.println(modifies + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }

    private static void printMethods(Class<?> cl) {
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            Class<?> retType = m.getReturnType();
            String name = m.getName();

            System.out.println("    ");
            // 打印修饰符，返回类型和方法名
            String modifies = Modifier.toString(m.getModifiers());
            if (modifies.length() > 0) System.out.println(modifies + "");
            System.out.println(retType.getName() + "" + name + "(");

            // 打印参数
            Class<?>[] parameterTypes = m.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                if (j > 0) System.out.println(",  ");
                System.out.println(parameterTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    private static void printConstructors(Class<?> cl) {
        Constructor<?>[] constructors = cl.getDeclaredConstructors();
        for (Constructor<?> c : constructors) {
            String name = c.getName();
            System.out.println("     ");
            String modifies = Modifier.toString(c.getModifiers());
            if (modifies.length() > 0) System.out.println(modifies + " ");
            System.out.println(name + "(");

            // 打印参数
            Class<?>[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0) System.out.println(",    ");
                System.out.println(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }
}
