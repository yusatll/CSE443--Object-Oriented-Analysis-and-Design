package hw2;

public class Singleton_1 extends Object {
    private volatile static Singleton_1 unique;

    private Singleton_1 () { }

    /**
     * This class extends from Object class.
     * @return unique object.
     */
    public static Singleton_1 getInstance()
    {
        if (unique == null)
        {
            synchronized (Singleton_1.class)
            {
                if (unique == null){
                    unique = new Singleton_1();
                }
            }
        }
        return unique;
    }

    /**
     * we can create a new object.
     * @return clone object.
     */
    public Object clone(){
        return new Singleton_1();
    }
}
