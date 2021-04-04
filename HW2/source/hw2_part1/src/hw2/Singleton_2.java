package hw2;

public class Singleton_2 extends CloneableParent {
    private volatile static Singleton_2 unique;

    /**
     * This class extends from cloneable parent.
     */
    private Singleton_2() { }

    /**
     * The second class. It returns one instance.
     * @return unique instance.
     */
    public static Singleton_2 getInstance()
    {
        if (unique == null)
        {
            synchronized (Singleton_2.class)
            {
                if (unique == null){
                    unique = new Singleton_2();
                }
            }
        }
        return unique;
    }

    /**
     * We have to return unique object or throw exception.
     * @return unique object
     * @throws CloneNotSupportedException do not let create new instance
     */
    @Override
    protected Object clone() throws CloneNotSupportedException  {
        //throw new CloneNotSupportedException();
        return unique;
    }

}
