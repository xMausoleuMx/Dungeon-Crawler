import java.util.*;

public class World {
	private int size, difficulty;
	
	public World(int d){
		difficulty = d;
	}
	
	public void genWorld(){
		Random num = new Random();
		size = num.nextInt(3+difficulty);
		Room start = new Room(false);
		ArrayList<Room> roomHolder = new ArrayList<Room>();
		roomHolder.add(start);
		
		//this generates rooms with monsters and items.
		for(int i =0; i < size; i++){
			boolean isExit;
			int z = num.nextInt(2);
			if(z == 1)
				isExit = true;
			else
				isExit = false;
				
			Room temp = new Room(isExit);
			roomHolder.add(temp);
		}
	}
}


class Room{
	private Room north, south, east, west;
	public Monster resident;
	private boolean hasStairs;
	public Item loot;
	public Room(boolean flag){
		hasStairs = flag;
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