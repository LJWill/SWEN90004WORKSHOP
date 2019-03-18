// import java.util.concurrent.atomic.AtomicInteger;

class ConCounter {

    // private static AtomicInteger count = new AtomicInteger();

    private static int count = 0;

    // if missing 'synchronized' here, it could cause the problem of interleaving,
    // since count++ is not atomic.
    // the reads and writes from different threads would interleave, so the value of count
    // is not strictlly increment each time.
    private static synchronized void increment(){
        count++;
    }

    public static void main(String[] args){

        Thread t1 = new Thread(() -> {
            for (int i=0; i<10000; i++) {
                increment();
            }
        });


        Thread t2 = new Thread(() -> {
            for (int i=0; i<10000; i++) {
                increment();
            }
        });


        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch(Exception e){}

        System.out.print("value: " + count);

    }

}