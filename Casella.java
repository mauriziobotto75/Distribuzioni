
public class Casella {//creazione della classe casella
	public int x;//attributi di casella che identificano la posizione 
	public int y;
	public Pezzo pezzo; //attributo di casella che si chiama pezzo che indica il tipo di pezzo presente sulla casella
	
	public Casella(int x,int y,Pezzo p){//costruttore di casella 
		this.x=x;//coordinata x
		this.y=y;//coordinata y
		this.pezzo=p;//pezzo inteso come pezzo generico
	}
	
	
	
    
}
