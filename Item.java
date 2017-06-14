
public abstract class Item {
	protected int itemId,type,dropRate;
	String name;
	//itemId is a unique identifier for all possible items
	//Type is category that defines if an item is consumed, wielded, or worn.
	//dropRate is the drop rate of an item out of 1000;
	
	public int getItemID(){
		return itemId;
	}
	public int getItemType(){
		return type;
	}
	public String getItemName(){
		return name;
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
		name = "Iron Sword";
		itemId = 1;
		damageValue = 5;
		dropRate = 125;
	}
}

class SteelSword extends Sword{
	public SteelSword(){
		name = "Steel Sword";
		itemId = 2;
		damageValue = 10;
		dropRate = 100;
	}
}

class AdamantiumSword extends Sword{
	public AdamantiumSword(){
		name = "Adamantium Sword";
		itemId = 3;
		damageValue = 15;
		dropRate = 25;
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
		name = "Health Potion";
		itemId = 4;
		modifierValue = 15;
		dropRate = 250;
	}
}

class ManaPotion extends Potion{
	public ManaPotion(){
		name = "Mana Potion";
		itemId = 5;
		modifierValue = 15;
		dropRate = 250;
	}
}


//Armor and wearable items, reduces incoming damage and some may grant bonuses.
class Armor extends Item{
	public int armorValue;
	public Armor(){
		type = 2;
	}
}

class IronArmor extends Armor{
	public IronArmor(){
		name = "Iron Armor";
		itemId = 6;
		armorValue = 5;
		dropRate = 125;
	}
}

class SteelArmor extends Armor{
	public SteelArmor(){
		name = "Steel Armor";
		itemId = 7;
		armorValue = 10;
		dropRate = 100;
	}
}

class AdamantiumArmor extends Armor{
	public AdamantiumArmor(){
		name = "Adamantium Armor";
		itemId = 8;
		armorValue = 15;
		dropRate = 25;
	}
}

