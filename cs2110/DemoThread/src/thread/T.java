package thread;

public class T extends Thread {
    public static void main(String args[]) {
        new T().start();
        for (int i= 0; i < 20; i++ ) {
            System.out.println("main thread, i = " + i);
        }
    }

    public @Override void run() {
        for (int k= 0; k < 20; k++ ) {
            System.out.println("new thread, k = " + k);
        }
    }

}