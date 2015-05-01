package io.github.jisaacs1207.FiveKingdomsRPG;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
//String string = FiveKingdomsRPG.plugin.getConfig().getString("p");
import org.bukkit.inventory.ItemStack;

// Axe Sword Shovel Stick Fists Hoe Pick
//
//     /--------------------------------------------------------------\ Attack
//     |        |  Axe | Sword | Shovel | Stick | Fists | Hoe | Pick  | Rating
//     |--------+------+-------+--------+-------+-------+-----+-------|
//     | Axe    | 150  |  160  |  160   |  100  |  160  | 160 |  160  | 150%
//     |--------+------+-------+--------+-------+-------+-----+-------|  
//     | Sword  | 160  |  100  |  110   |  100  |  140  | 100 |  130  | 120%
//     |--------+------+-------+--------+-------+-------+-----+-------|
//     | Shovel | 160  |  100  |   80   |   50  |  50   | 90  |  100  | 90%
//     |--------+------+-------+--------+-------+-------+-----+-------|
//     | Stick  | 100  |  120  |   60   |  100  |  100  | 100 |  120  | 100%
//     |--------+------+-------+--------+-------+-------+-----+-------|
//     | Fists  | 160  |  100  |   80   |  100  |  25   | 30  |  30   | 75%
//     |--------+------+-------+--------+-------+-------+-----+-------|
//     | Hoe    | 160  |  110  |   80   |  100  |  25   | 100 |  125  | 100%
//     |--------+------+-------+--------+-------+-------+-----+-------|
//     | Pick   | 160  |  150  |   60   |  150  |  25   | 120 |  105  | 110%
//     \==============================================================/
// Defence        50%     80%      110%    100%   125%   100%    90%
// Rating      
//
// Material Modifiers
// Wood       -25 AR  -25 DR
// Stone      -10 AR  -0 DR
// Iron       20 AR   5 DR 
// Gold       5 AR    20 DR
// Diamond    30 AR  10 DR
//
// Fist Modifiers
// 8 AR 4 DR Per piece of armor missing
//
// Stick Modifiers
//
// Stick     0 AR 0 DR
// Torch     -10 AR 20 DR
// RsTorch   -20 AR 40 DR
// Lever     -5 AR 10 DR
// Bone      20 AR -10 DR
// BRod      40 AR -20 DR

// Weapon Specialties (when over 100 learned)
//
// Axe - Weapon Cleave: 1% chance of breaking others weapons and nulling damage
// Sword - Ripose: 5% chance of dealing damage in response to receiving damage
// Shovel - Concuss: 2% chance to inflict nausia on target
// Stick - Disarm: 2% chance of having other player drop their weapon  
// Fist - Reverse: 2% chance of reversing damage to the attacker
// Hoe - Pierce: 5% chance of dealing true damage through armor
// Pick - Yoink : 2% chance of swapping weapons with the victim

public class Weapons implements Listener{
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent event) { 
		// If both attacker and attackee are players
		if(event.getEntity() instanceof Player || event.getDamager() instanceof Player) {
			Player attacker = (Player) event.getDamager();
			Player victim = (Player) event.getEntity();
			// Calls a function to check held item.
			// Writes weapon type to a string
			String heldWeapons[]=weaponCheck(attacker, victim);
			String aWep=heldWeapons[0];
			String vWep=heldWeapons[1];
			// Debug breakpoint
			//FiveKingdomsRPG.plugin.getServer().broadcastMessage(heldWeapons[0]+" "+heldWeapons[1]);			
			
			// Factors weapon type of attacker vs victim
			if(aWep.equalsIgnoreCase("axe")){
				// Modifier
			}
			else if(aWep.equalsIgnoreCase("sword")){
				// Modifier
			}
			else if(aWep.equalsIgnoreCase("shovel")){
				// Modifier
			}
			else if(aWep.equalsIgnoreCase("stick")){
				// Modifier
			}
			else if(aWep.equalsIgnoreCase("fists")){
				// Modifier
			}
			else if(aWep.equalsIgnoreCase("hoe")){
				// Modifier
			}
			else if(aWep.equalsIgnoreCase("pickaxe")){
				// Modifier
			}
		}
	}
	
	// Returns weapon type in an array. [0] = attacker [1] = victim
	// Types are "sword,shovel,axe,hoe,pickaxe,stick,fists,none"
	// If held item is not a weapon or victim/attacker is a mob, type is "none"
	public String[] weaponCheck(Entity attacker, Entity victim){
		String aWeaponType = "none";
		String vWeaponType = "none";
		String vWeaponName;
		String aWeaponName;
		if(attacker instanceof Player){
			Player pAttacker = (Player) attacker;
			aWeaponName = pAttacker.getItemInHand().getType().name();
			if(aWeaponName.contains("SWORD")) aWeaponType = "sword";
			else if(aWeaponName.contains("SHOVEL")) aWeaponType = "shovel";
			else if(aWeaponName.contains("_AXE")) aWeaponType = "axe";
			else if(aWeaponName.contains("HOE")) aWeaponType = "hoe";
			else if(aWeaponName.contains("PICKAXE")) aWeaponType = "pickaxe";
			else if(aWeaponName.contains("BONE")) aWeaponType = "stick";
			else if(aWeaponName.contains("STICK")) aWeaponType = "stick";
			else if(aWeaponName.contains("BLAZE_ROD")) aWeaponType = "stick";
			else if(aWeaponName.contains("TORCH")) aWeaponType = "stick";
			else if(aWeaponName.contains("LEVER")) aWeaponType = "stick";
			else if(aWeaponName.contains("BONE")) aWeaponType = "stick";
			else if(aWeaponName.contains("AIR")) aWeaponType = "fists";
			else aWeaponType="none";
		}
		if(victim instanceof Player){
			Player pVictim = (Player) victim;
			vWeaponName = pVictim.getItemInHand().getType().name();
			if(vWeaponName.contains("SWORD")) vWeaponType = "sword";
			else if(vWeaponName.contains("SHOVEL")) vWeaponType = "shovel";
			else if(vWeaponName.contains("_AXE")) vWeaponType = "axe";
			else if(vWeaponName.contains("HOE")) vWeaponType = "hoe";
			else if(vWeaponName.contains("PICKAXE")) vWeaponType = "pickaxe";
			else if(vWeaponName.contains("BONE")) vWeaponType = "stick";
			else if(vWeaponName.contains("STICK")) vWeaponType = "stick";
			else if(vWeaponName.contains("BLAZE_ROD")) vWeaponType = "stick";
			else if(vWeaponName.contains("TORCH")) vWeaponType = "stick";
			else if(vWeaponName.contains("LEVER")) vWeaponType = "stick";
			else if(vWeaponName.contains("BONE")) vWeaponType = "stick";
			else if(vWeaponName.contains("AIR")) vWeaponType = "fists";
			else vWeaponType="none";
		}
		return new String[] {aWeaponType, vWeaponType};
	}
	
}
