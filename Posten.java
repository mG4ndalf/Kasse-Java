public class Posten{
	private String Name;
	private double preis;
	private boolean getränk;
	
	public Posten(String aName, double aPreis, boolean aGetränk){
		Name = aName;
		preis = aPreis;
		getränk = aGetränk;
	}
	public double preisAusgeben(){
		return preis; 
	}
	public String nameAusgeben(){
		return Name;
	}
	public String allToString(){
		return Name+"			"+ preis;
	}
}