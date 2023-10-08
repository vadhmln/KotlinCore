  public class JavaMultithreading {
    static boolean isGuessNumber = false;

    public static void main(String[] args) {
        // При создании объект имеет состояние NEW
        Thread myThread = new Thread(new RunnableClass());
        System.out.println(myThread.getState());

        // Нить запускается и переходит в состояние RUNNABLE
        myThread.start();
        System.out.println(myThread.getState());

        // main переходит в состояние WAITING
        try {
            myThread.join(); // main приостановится - ждет, пока myThread завершит свою работу в run(), и код будет выполняться дальше
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Объект завершил свою работу и получил статус TERMINATED
        System.out.println(myThread.getState());

        // После выполнения всех инструкций нить main также становится TERMINATED

        // Главный поток сейчас живой и выполняется, поэтому выведет true
        System.out.println("main thread: " + Thread.currentThread().isAlive()); // main thread: true

        // Новый поток создан, но ещё не запущен (не живой), поэтому вывод будет false
        System.out.println("new thread: " + new Thread().isAlive()); // new thread: false
    }

    /*
    Вывод: NEW
    RUNNABLE
    TERMINATED
    */
}