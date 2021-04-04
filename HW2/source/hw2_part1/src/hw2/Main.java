package hw2;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
	// write your code here
        Singleton_2 s1 = Singleton_2.getInstance();
        System.out.println(s1.hashCode());
        Singleton_2 s2 = (Singleton_2) s1.clone();
        System.out.println(s2.hashCode());

        Singleton_1 s1_1 = Singleton_1.getInstance();
        System.out.println(s1_1.hashCode());
        Singleton_1 s1_2 = (Singleton_1) s1_1.clone();
        System.out.println(s1_2.hashCode());


    }
}
