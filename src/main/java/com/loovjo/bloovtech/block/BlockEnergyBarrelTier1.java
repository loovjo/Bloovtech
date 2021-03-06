package com.loovjo.bloovtech.block;

import com.loovjo.bloovtech.BloovMain;
import com.loovjo.bloovtech.item.ItemPowerStone;
import com.loovjo.bloovtech.tileentity.TileEntityEnergyBarrel;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable;

public class BlockEnergyBarrelTier1 extends BlockContainer {
	
	private IIcon iconTop, iconBottom;
	
	public BlockEnergyBarrelTier1(Material p_i45386_1_) {
		super(p_i45386_1_);

	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		// TODO Auto-generated method stub
		return new TileEntityEnergyBarrel();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int p_149727_6_, float p_149727_7_,
			float p_149727_8_, float p_149727_9_) {
		if (world.isRemote && !(player.getItemInUse() == null) && !(player.getItemInUse().getItem() instanceof ItemPowerStone))
			player.addChatComponentMessage(new ChatComponentTranslation(
					"message.eb.energy",
					((TileEntityEnergyBarrel) world.getTileEntity(x, y, z)).energyStored,
					((TileEntityEnergyBarrel) world.getTileEntity(x, y, z)).energyMax, ((TileEntityEnergyBarrel)world.getTileEntity(x, y, z)).getEnergyScaled(100)+"%"));
		return true;
	}
	@Override
	public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_,
			int p_149673_3_, int p_149673_4_, int side) {
		IIcon icon = blockIcon;
		if (side == 0) 
			icon = iconBottom;
		if (side == 1) {
			icon = iconTop;
		}
		return icon;
	}

	@Override
	public void registerBlockIcons(IIconRegister iconreg) {
		
		iconTop = iconreg.registerIcon(BloovMain.MODID + ":barrel_top");
		iconBottom = iconreg.registerIcon(BloovMain.MODID + ":barrel_bottom");
		blockIcon = iconreg.registerIcon(BloovMain.MODID + ":barrel_side");
	}

}
