package com.loovjo.bloovtech.item;

import com.google.common.collect.Sets;
import com.loovjo.bloovtech.interfaces.IEnergyConnectable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemPowerStone extends ItemTool {
	public ItemPowerStone() {
		super(0.0f, ToolMaterial.IRON, Sets.newHashSet());
		// TODO Auto-generated constructor stub
	}

	public static int powerMax;

	@Override
	public boolean onItemUse(ItemStack is,
			EntityPlayer player, World world, int x, int y,
			int z, int par7, float par8, float par9, float par10) {
		System.out.println(x + " " + y + " " + z);
		TileEntity te = world.getTileEntity(x, y, z);
		if (te == null || !(te instanceof IEnergyConnectable)) {
			return false;
		}
		IEnergyConnectable te2 = (IEnergyConnectable) te;
		if (te2.canDraw(ForgeDirection.UP, 100)) {
			this.setDamage(player.getItemInUse(), getDamage(player.getItemInUse()) + 100);
		}
		return true;
	}
	
}
