
public abstract class Item {
	int itemId,type,dropRate;
	//itemId is a unique identifier for all possible items
	//Type is category that defines if an item is consumed, wielded, or worn.
	//dropRate is the drop rate of an item out of 1000;
	
	public int getItemID(){
		return itemId;
	}
	public int getItemType(){
		return type;
	}
}


//All of the sword items and their default values.
class Sword extends Item{
	int damageValue;
	public Sword(){
		type = 0;
	}
}

class IronSword extends Sword{
	public IronSword(){
		itemId = 1;
		damageValue = 5;
		dropRate = 0;
	}
}

class SteelSword extends Sword{
	public SteelSword(){
		itemId = 2;
		damageValue = 10;
		dropRate = 100;
	}
}

class AdamantiumSword extends Sword{
	public AdamantiumSword(){
		itemId = 3;
		damageValue = 15;
		dropRate = 10;
	}
}


//Consumable Items and their Values
class Potion extends Item{
	int modifierValue;
	public Potion(){
		type = 1;
	}
}

class HealthPotion extends Potion{
	public HealthPotion(){
		itemId = 4;
		modifierValue = 15;
		dropRate = 125;
	}
}

class ManaPotion extends Potion{
	public ManaPotion(){
		itemId = 5;
		modifierValue = 15;
		dropRate = 300;
	}
}


//Armor and wearable items, reduces incoming damage and some may grant bonuses.
class Armor extends Item{
	int armorValue;
	public Armor(){
		type = 2;
	}
}

class IronArmor extends Armor{
	public IronArmor(){
		itemId = 6;
		armorValue = 5;
		dropRate = 25;
	}
}

class SteelArmor extends Armor{
	public SteelArmor(){
		itemId = 7;
		armorValue = 10;
		dropRate = 50;
	}
}

class AdamantiumArmor extends Armor{
	public AdamantiumArmor(){
		itemId = 8;
		armorValue = 15;
		dropRate = 5;
	}
}

