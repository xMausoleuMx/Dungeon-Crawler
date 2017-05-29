
public class Player {
	private int currentHP = 50;
	private int MAX_HP = 50;
	private int score = 0;
	public boolean hasLeveledFlag = false;
	private int xPos, yPos;
	private int speed, strength, currentLevel =0,xp = 0;
	public int enemiesKilled =0;
    private String name;
    private Item inventory [];
    public Player(String n){
        name = n;
        inventory = new Item[10];
        
        buildCharacter(2);
    }
    public void buildCharacter(int difficulty){
    	inventory[0] = new IronSword();
    	inventory[2] = new HealthPotion();
    	switch(difficulty){
    	case 1://easy difficulty
    		strength = 5;
    		speed = 10;
    		inventory[1] = new IronArmor();
    		inventory[3] = new HealthPotion();
    		inventory[4] = new ManaPotion();
    		break;
    	case 2://medium difficulty
    		strength = 5;
    		speed = 5;
    		inventory[1] = new IronArmor();
    		inventory[4] = new ManaPotion();
    		break;
    	case 3://hard difficulty
    		speed = 5;
    		strength = 3;
    		inventory[0] = new SteelSword();
    		break;
    	}
    }
    
    //add or remove HP from the player
    public void editHP(int z){
    	currentHP += z;
        if(currentHP > MAX_HP)
        	currentHP = MAX_HP;
    }
    
    
    //these methods show the current stats of the player,
    public int getStrength(){
    	return strength;
    }
    public int getSpeed(){
    	return speed;
    }
    public int getHP(){
        return currentHP;
    }
    public String getName(){
    	return name;
    }
    public int getScore(){
    	return score;
    }
    public int getLvl(){
    	return currentLevel;
    }
    
    
    //Add exp to the player when an enemy is killed or a floor is completed.
    public void addXp(int exp){
    	xp += exp;
    	if(currentLevel < 2*Math.sqrt(xp))
    		levelUp();
    }
    
    public void levelUp(){
    	currentLevel++;
    	if(currentLevel%5==0){
    		strength++;
        	speed++;
    	}
    	strength++;
    	speed++;
    }
    
    public void editScore(int x){
    	score+=x;
    }
    public int getXPos(){
    	return xPos;
    }
    public int getYPos(){
    	return yPos;
    }
    public void setYPos(int y){
    	yPos = y;
    }
    public void setXPos(int x){
    	xPos = x;
    }
}
