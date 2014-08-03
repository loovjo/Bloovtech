package com.loovjo.bloovtech.item;

import com.loovjo.bloovtech.BloovMain;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemElectricBag extends Item {

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World world,
			EntityPlayer player) {
		player.openGui(BloovMain.instance, 0, world, player.serverPosX, player.serverPosY, player.serverPosZ);
		return super.onItemRightClick(par1ItemStack, world, player);
	}


	
	
}
