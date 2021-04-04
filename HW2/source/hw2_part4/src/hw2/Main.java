package hw2;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Part A");
        part_A();
        System.out.println();
        System.out.println();
        System.out.println("Part B");
        part_B();
    }

    public static void part_A(){
        int threadsize = 10;
        ThreadITable threadITable = new ThreadITable(10,10);
        Thread thread[] = new Thread[threadsize];

        for (int i = 0; i < threadsize/2; i++) {
            int finalI = i+15;
            thread[i] = new Thread(() -> {
                threadITable.setElementAt(0, 0, finalI);
            });
//            thread[i].start();
        }
//        System.out.println();

        for (int i = threadsize/2; i < threadsize; i++) {
            int finalI = i+6;
            thread[i] = new Thread(()-> {
                System.out.println("Row: " + 0 + " Column: " + 0 + " GET: " + threadITable.getElementAt(0,0));
            });
//            thread[i].start();
        }

        for (int i = 0; i < threadsize; i++) {
            thread[i].start();
        }

        for (int i = 0; i < threadsize; i++) {
            try {
                thread[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void part_B()
    {
        int threadSize = 10;
        Thread thread_2[] = new Thread[threadSize];
        ProrityITable p = new ProrityITable(10,10,5);

        for (int i = 0; i < threadSize/2; i++) {
            thread_2[i] = new Thread(()-> {
                System.out.println("Row: " + 0 + " Column: " + 0 +
                        " GET: " + p.getElementAt(0,0));
            });
//            thread[i].start();
        }

        for (int i = threadSize/2; i < threadSize; i++) {
            int finalI = i+25;
            thread_2[i] = new Thread(() -> {
                p.setElementAt(0, 0, finalI);
            });
//            thread[i].start();
        }

        for (int i = 0; i < threadSize; i++) {
            thread_2[i].start();
        }

        for (int i = 0; i < threadSize; i++) {
            try {
                thread_2[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
