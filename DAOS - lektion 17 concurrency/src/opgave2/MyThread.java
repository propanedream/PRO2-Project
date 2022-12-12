package opgave2;

public class MyThread extends Thread {
    private int id;
    private int concurrentId;
    Faelles faelles;

    public MyThread(int id, Faelles faelles) {
        this.id = id;
        this.faelles = faelles;
    }

    @Override
    public void run() {
        concurrentId = (id + 1) % 2;
        faelles.setFlag(true, id);
        faelles.setTurn(concurrentId);

        for (int i = 0; i < 100; i++) {
            concurrentId = (id + 1) % 2;
            faelles.setFlag(true, id);
            faelles.setTurn(concurrentId);

            while (faelles.getFlag(concurrentId) && faelles.getTurn() == concurrentId) ;

            faelles.kritiskSection();
            faelles.tagerRandomTid(50);
        }
        System.out.println(faelles.getCount());


        faelles.setFlag(false, id);

    }

}
