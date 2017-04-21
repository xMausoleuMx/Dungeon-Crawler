
public abstract class Monster {
	protected int attack, currentHP, armor, magic, attackVariance, expWorth, speed;
	protected double spawnRate,dropRate;
    
    public void editHP(int damage){
    	currentHP += damage;
    }
    public void editArmor(int value){
    	armor += value;
    }
    public int getHP(){
    	return currentHP;
    }
}

//outlines the base stats for the goblin creature type. Basic low tier monster with balacned attack and defense.
class Goblin extends Monster{
	public Goblin(){
		currentHP = 20;
		speed = 5;
		attack = 5;
		attackVariance = 3;
		armor = 5;
		dropRate = .5;
		spawnRate = .8;
		expWorth = 1;
	}
}

//outlines the base stats for the HobGoblin creature type. Meant to be a glass cannon, high damage low HP
class HobGoblin extends Monster{
	public HobGoblin(){
		speed = 7;
		currentHP = 15;
		attack = 10;
		attackVariance = 5;
		armor = 2;
		dropRate = .8;
		spawnRate = .65;
		expWorth = 1;
	}
}

//outlines the base stats for the Mountain Troll creature type. No armor and high HP makes him weak to physical damage.
class MountainTroll extends Monster{
	public MountainTroll(){
		currentHP = 50;
		speed = 3;
		attack = 15;
		attackVariance = 3;
		armor = 0;
		dropRate = 1.4;
		spawnRate = .4;
		expWorth = 5;
	}
}

//outlines the base stats for the Cave Troll creature type. High armor and high damage, weak to magic.
class CaveTroll extends Monster{
	public CaveTroll(){
		currentHP = 30;
		speed = 3;
		attack = 20;
		attackVariance = 5;
		armor = 10;
		dropRate = 1.6;
		spawnRate = .35;
		expWorth = 6;
	}
}