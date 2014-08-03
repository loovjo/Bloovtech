package com.loovjo.bloovtech.container;

import com.loovjo.bloovtech.tileentity.TileEntitySteamGenerator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;

public class ContainerSteamGenerator extends Container {

	public ContainerSteamGenerator(InventoryPlayer invplayer,
			TileEntitySteamGenerator tileEntity) {
		for (int i = 0; i < 9; i++)
			addSlotToContainer(new Slot(invplayer, i, 8 + i * 18, 142));
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 3; j++)
				addSlotToContainer(new Slot(invplayer, i + j * 9 + 9,
						8 + i * 18, 84 + j * 18));

		addSlotToContainer(new Slot(tileEntity, 0, 44, 53));

		for (int i = 0; i < 3; i++) {
			addSlotToContainer(new Slot(tileEntity, i + 1, 152, 17 + i * 18));
		}

	}

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}

}
