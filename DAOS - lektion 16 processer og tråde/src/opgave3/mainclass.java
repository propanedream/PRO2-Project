package opgave3;
public class mainclass {

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		lottoraek[] spillede = new lottoraek[3000000];
		lottoraek rigtig = new lottoraek();
		for (int j=0; j < spillede.length; j++)
			spillede[j] = new lottoraek();
		int[] antalgev = new int[8];
		long l1,l2;
		l1 = System.nanoTime();
		for (int j=0; j < spillede.length; j++) {
			antalgev[rigtig.antalrigtige(spillede[j])] ++; 
		}
		 l2 = System.nanoTime();
			System.out.println("K�retiden var " +(l2-l1)/1000000 + " millisekunder");
		int total = 0;
		for (int i=0;i<8;i++){
			System.out.println("Der var " + antalgev[i] + " r�kker med " + i + " rigtige" );
			total = total + antalgev[i];
			}
		System.out.println("Der var totalt " + total + " r�kker");
	}
}	
