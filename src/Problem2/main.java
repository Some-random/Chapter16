package Problem2;

/**
 * Created by Bob_JIANG on 8/16/2015.
 */
public class main {

    //The code below claims to be able to calculate context switch time. A context switch is the computing process of
    // storing and restoring the state (context) of a CPU such that multiple processes can share a single CPU resource.

    public static long starttime;
    public static long endtime;
    public static void main(String[] args) {
        Object theLock = new Object();
        synchronized( theLock ){
            Thread task = new TheTask( theLock );
            task.start();
            try {
                theLock.wait();
                endtime = System.currentTimeMillis();
            }
            catch( InterruptedException e ){
                // do something if interrupted
            }
        }
        System.out.println("Context Switch Time elapsed: " + (endtime - starttime));
    }

    static class TheTask extends Thread {
        private Object theLock;
        public TheTask( Object theLock ){
            this.theLock = theLock;
        }
        public void run(){
            synchronized( theLock ){
                starttime = System.currentTimeMillis();
                theLock.notify();
            }
        }
    }
}