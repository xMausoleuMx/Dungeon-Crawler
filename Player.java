
public class Player {
	private int HP = 50;
	private final int MAX_HP = 50;
    private String name;
    private Item inventory [];
    public Player(String n){
        name = n;
    }
    
    //add or remove HP from the player
    public void editHP(int z){
        HP += z;
        if(HP > MAX_HP)
        	HP = MAX_HP;
    }
    
    public int getHP(){
        return HP;
    }
    
    public String getName(){
    	return name;
    }
    
}
