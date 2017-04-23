import java.util.*;

public class World {
	private int size, difficulty;
	private Random num = new Random();
	public World(int d){
		difficulty = d;
	}
	
	public void genWorld(){
		size = num.nextInt(3+difficulty);
		Room start = new Room();
		ArrayList<Room> roomHolder = new ArrayList<Room>();
		roomHolder.add(start);
		
		//this generates rooms and fills them with monsters and items.
		for(int i =0; i < size; i++){
			Room temp = new Room();
			int spawner = num.nextInt(1000);
			if(spawner < 500)
				temp.resident = spawnMonster();
			else if(spawner <750)
				temp.loot = spawnItem();
			roomHolder.add(temp);
		}
		//Makes sure a non starting room has stairs
		int x = num.nextInt(size-1)+1;
		roomHolder.get(x).hasStairs = true;
		
		//connects the rooms to one another
		for(int i = 0; i <size*1.5;i++){
			
		}
	}
	
	//Generates a monster based on spawn rates and returns it.
	public Monster spawnMonster(){
		Monster occupant;
		double spawn = num.nextDouble();
		if(spawn < .4)
			return occupant = new Goblin();
		else if(spawn < .8)
			return occupant = new HobGoblin();
		else if(spawn <.9)
			return occupant = new MountainTroll();
		else
			return occupant = new CaveTroll();
	}
	
	//generates an item based on drop rates and returns it.
	public Item spawnItem(){
		Item roomLoot;
		double spawn = num.nextDouble();
		if(spawn < .2)
			return roomLoot = new HealthPotion();
		else if(spawn < .5)
			return roomLoot = new ManaPotion();
		else if(spawn <.625)
			return roomLoot = new IronArmor();
		else if(spawn < .725)
			return roomLoot = new SteelArmor();
		else if(spawn < .75)
			return roomLoot = new AdamantiumArmor();
		else if(spawn < .875)
			return roomLoot = new IronSword();
		else if(spawn < .975)
			return roomLoot = new SteelSword();			
		else
			return roomLoot = new AdamantiumSword();
	}
}




class Room{
	private Room north, south, east, west;
	public Monster resident;
	public boolean hasStairs;
	public Item loot;
	public Room(){
	}
	
	public void connectRoom(Room temp, int direction){
		switch(direction){
		case 1:
			north = temp;
			break;
		case 2:
			east = temp;
			break;
		case 3:
			south = temp;
			break;
		case 4:
			west = temp;
			break;
		}
	}
}