import java.util.*;

public class World {
	private int size, difficulty;
	private Random num = new Random();
	public Room [] [] worldMap = new Room [12][12];
	public World(int d){
		difficulty = d;
	}
	
	public void genWorld(){
		size = num.nextInt(difficulty+1)+15;
		Room holder = new Room();
		for(int i =0; i < 11; i++)
			for(int k = 0; k <11;k++)
				worldMap[i][k] = holder;

		Room start = new Room();
		start.connectedToStart = true;
		start.isStart = true;
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
		
		int xCoord = num.nextInt(10)+1;
		int yCoord = num.nextInt(10)+1;
		worldMap[xCoord][yCoord] = start;
		for(int i = 1; i < roomHolder.size();i++){
			do{
				xCoord = num.nextInt(10)+1;
				yCoord = num.nextInt(10)+1;
				if(!worldMap[xCoord][yCoord].connectedToStart && checkConnected(xCoord,yCoord)){
					roomHolder.get(i).connectedToStart = true;
					worldMap[xCoord][yCoord] = roomHolder.get(i);
				}
			}while(!roomHolder.get(i).connectedToStart);
		}
	}
	
	boolean checkConnected(int x, int y){
		if((worldMap[x+1][y] != null && worldMap[x+1][y].connectedToStart) ||(worldMap[x][y+1] != null &&  worldMap[x][y+1].connectedToStart) || (worldMap[x-1][y] != null && worldMap[x-1][y].connectedToStart) || (worldMap[x][y-1] != null && worldMap[x][y-1].connectedToStart))
			return true;
		else
			return false;
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
	
	public int getDifficulty(){
		return difficulty;
	}
}




class Room{
	public Monster resident;
	public boolean hasStairs= false, connectedToStart= false, isStart = false, beenVisited =false;
	public Item loot;
	public Room(){
		
	}
	
}