package opgave1;

public class App {
    public static void main(String[] args) {
        //        Filter filter = (o) -> {
//        };
        Chili c1 = new Chili("Reaper", 10);
        Chili c2 = new Chili("Habanero", 500000);
        Chili c3 = new Chili("Jalapeno", 500001);
        Chili c4 = new Chili("Peberfrugt", 10);
        Measureable[] chililiste = {c1, c2, c3, c4};

        System.out.println(max(chililiste));
        System.out.println(avg(chililiste));


        //filter her skabes ved et lambda udtryk som sortere alle chili'er under 5000 fra
        System.out.println(avg(chililiste, (chili) -> ((Chili) chili).getMeasure() > 5000));
        System.out.println(max(chililiste, chili -> ((Chili) chili).getMeasure() > 5000));
    }

    public static Measureable max(Measureable[] objects) {
        Measureable m = objects[0];
        for (int i = 0; i < objects.length; i++) {
            if (m.getMeasure() <= objects[i].getMeasure()) {
                m = objects[i];
            }
        }
        return m;
    }

    public static double avg(Measureable[] objects) {
        double avg = 0;
        for (int i = 0; i < objects.length; i++) {
            avg += objects[i].getMeasure();
        }
        return avg / objects.length;
    }

    public static double avg(Measureable[] objects, Filter filter) {
        double avg = 0;
        int counter = 0;
        for (int i = 0; i < objects.length; i++) {
            if (filter.accept(objects[i])) {
                avg += objects[i].getMeasure();
                counter++;
            }
        }
        return avg / counter;
    }


    public static Measureable max(Measureable[] objects, Filter filter) {
        Measureable m = objects[0];
        for (int i = 0; i < objects.length; i++) {
            if (m.getMeasure() <= objects[i].getMeasure()) {
                m = objects[i];
            }
        }
        return m;
    }

}
