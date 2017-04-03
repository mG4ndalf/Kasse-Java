import java.util.*;

public class KassenMain {
	public static void MainMenue(ArrayList <Posten> PreisListe, ArrayList <String> Kassenzettel){
		
		
		System.out.println("[1]: Preisliste ausgeben.");
		System.out.println("[2]: Artikel einlesen.");
		System.out.println("[3]: Kassenzettel ausgeben.");
		
		Scanner Eingabe = new Scanner(System.in);
		int Input = Eingabe.nextInt(); 
		if(Input == 1){
			preisListeAusgeben(PreisListe, Kassenzettel);
		}
		else if(Input == 2){
			artikelEinlesen(PreisListe, Kassenzettel);
		}
		else if(Input == 3){
			kassenzettelAusgeben(PreisListe, Kassenzettel);
		}
		else{
			System.out.printf("\n[Fehler]: Auswahl existiert nicht. Bitte erneut versuchen!\n");
			MainMenue(PreisListe, Kassenzettel);
		}
	}
	public static void kassenzettelAusgeben(ArrayList<Posten> PreisListe, ArrayList<String> Kassenzettel){
		
		Kassenzettel.trimToSize();
		for(int i = 0; i < Kassenzettel.size(); i++){
			System.out.println(Kassenzettel.get(i).toString());
		}
		ArrayList <String> KassenzettelNew = new ArrayList<String>(100);
		MainMenue(PreisListe, KassenzettelNew);
		
	}
	
	public static void artikelEinlesen(ArrayList<Posten> PreisListe, ArrayList<String> Kassenzettel){
		System.out.println("Artikel einlesen[A]:");
		System.out.println("Mit [X] beenden:");
		Scanner keyboardInput = new Scanner(System.in);
		char choice = keyboardInput.next().charAt(0);
		if(choice == 'A'){
			System.out.println("Artikel aus Liste waehlen: ");
			Scanner Eingabe = new Scanner(System.in);
			int input = Eingabe.nextInt();
			for(int i = 1; i <= 10; i++){
				if(input == i){
					Kassenzettel.add((PreisListe.get(i-1)).allToString());
				}
			}
			artikelEinlesen(PreisListe, Kassenzettel);
		}
		else if (choice == 'X'){
			MainMenue(PreisListe, Kassenzettel);
		}
		else{
			System.out.println("[Fehler]: Ungueltige Eingabe, Sie kehren ins Menue zurueck!");
			MainMenue(PreisListe, Kassenzettel);
		}
		
	}
	
	public static void preisListeAusgeben(ArrayList <Posten> PreisListe, ArrayList <String> Kassenzettel){
		for(int i = 0; i <=9; i++){
			System.out.println((i+1)+". "+ PreisListe.get(i).nameAusgeben() + PreisListe.get(i).preisAusgeben());
		}
		MainMenue(PreisListe, Kassenzettel);
	}
	
	public static void main (String[] args){
		ArrayList <Posten> a = new ArrayList <Posten> (20);
		
		Posten Orangensaft = new Posten ("Orangensaft", 1.99, true);
		a.add(Orangensaft);
		Posten Brot = new Posten("Brot", 3.49, false);
		a.add(Brot);
		Posten Salami = new Posten("Salami", 0.99, false);
		a.add(Salami);
		Posten Vodka = new Posten("Vodka", 12.99, true);
		a.add(Vodka);
		Posten Käse = new Posten("Käse", 4.49, false);
		a.add(Käse);
		Posten Wasser = new Posten("Wasser", 0.29, true);
		a.add(Wasser);
		Posten Bier = new Posten("Bier", 0.79, true);
		a.add(Bier);
		Posten Kaugummi = new Posten("Kaugummi", 0.89, false);
		a.add(Kaugummi);
		Posten Bananen = new Posten("Bananen", 2.99, false);
		a.add(Bananen);
		Posten Spezi = new Posten("Spezi", 1.29, true);
		a.add(Spezi);
		ArrayList <String> Kassenzettel = new ArrayList<String>(100);
		
		MainMenue(a, Kassenzettel);
		
	}
}