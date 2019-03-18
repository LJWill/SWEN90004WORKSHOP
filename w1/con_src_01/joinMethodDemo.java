class joinMethodDemo {

    public static void main(String[] args){

        Thread t1 = new Thread(() -> {
            for (int i=0; i<5; i++) {
                System.out.println("Hi");
                try {Thread.sleep(1000); } catch(Exception e){}
            }
        });


        Thread t2 = new Thread(() -> {
            for (int i=0; i<5; i++) {
                System.out.println("Hello");
                try {Thread.sleep(1000); } catch(Exception e){}
            }
        });

        t1.start();
        t2.start();

        // wait t1, t2 finished.
        try{t1.join();t2.join();}catch(Exception e){}

        System.out.println("Bye!");

    }

}