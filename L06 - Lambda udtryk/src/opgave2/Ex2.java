package opgave2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Ex2 {

	public static void main(String[] args) {
		List<Runner> runners = new ArrayList<>();
		runners.addAll(List.of(
				new Runner("Ib", 30),
				new Runner("Per", 50),
				new Runner("Ole", 27),
				new Runner("Ulla", 40),
				new Runner("Jens", 35),
				new Runner("Hans", 28)));
//		System.out.println(runners);
//		System.out.println();



		//opgave 2.a
		Consumer<List<Runner>> c1 = runnerslist -> runnerslist.forEach(r -> System.out.println(r));
		c1.accept(runners);

//		runners.forEach();
		//opg2.b
		Consumer<List<Runner>> c2 = runnerslist -> runnerslist.forEach(r->{
			if (r.getLapTime() <30){
				System.out.println(r);
			}
		});
		c2.accept(runners);


		//opgave 2.c
		//istedet for at oprette en comparator klasse og benytte et objekt af den comparator klasse, kan man her med lambda gøre det ved hjælp af en genvej
		Comparator<Runner> rc = (r1, r2) -> r1.getLapTime() - r2.getLapTime();
		runners.sort(rc);
		System.out.println(runners);


		Consumer<List<Runner>> print = (runner) -> System.out.println(runner);
		print.accept(runners);

	}
}