package com.loovjo.bloovtech.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;

public class ContainerElectricBag extends Container {
	
	public ContainerElectricBag(InventoryPlayer invplayer, TileEntity te) {
		for (int i = 0; i < 9; i++)
			addSlotToContainer(new Slot(invplayer, i, 44 + i * 18, 230));
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 3; j++) 
				addSlotToContainer(new Slot(invplayer, i + j*9 + 9, 44 + i * 18, 172 + j * 18));
		
		
		
		
	}
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}

}
