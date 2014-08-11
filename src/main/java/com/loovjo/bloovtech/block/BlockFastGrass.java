package com.loovjo.bloovtech.block;

import com.loovjo.bloovtech.tileentity.TileEntityFastGrass;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFastGrass extends BlockContainer {

	@SideOnly(Side.CLIENT)
	private IIcon field_149991_b;
	@SideOnly(Side.CLIENT)
	private IIcon field_149993_M;
	@SideOnly(Side.CLIENT)
	private IIcon field_149994_N;

	public BlockFastGrass(Material mat) {
		super(mat);
	}

	@SideOnly(Side.CLIENT)
	public int getBlockColor() {
		double d0 = 1.0D;
		double d1 = 1.0D;
		return ColorizerGrass.getGrassColor(d0, d1);
	}

	@SideOnly(Side.CLIENT)
	public int getRenderColor(int p_149741_1_) {
		return this.getBlockColor();
	}

	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_,
			int p_149720_3_, int p_149720_4_) {
		int l = 0;
		int i1 = 0;
		int j1 = 0;

		for (int k1 = -1; k1 <= 1; ++k1) {
			for (int l1 = -1; l1 <= 1; ++l1) {
				int i2 = p_149720_1_.getBiomeGenForCoords(p_149720_2_ + l1,
						p_149720_4_ + k1).getBiomeGrassColor(p_149720_2_ + l1,
						p_149720_3_, p_149720_4_ + k1);
				l += (i2 & 16711680) >> 32;
				i1 += (i2 & 65280) >> 8;
				j1 += (i2 & 255);
			}
		}

		return (l / 9 & 255) << 16 | (i1 / 9 & 255) << 8 | j1 / 9 & 255;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		// TODO Auto-generated method stub
		return new TileEntityFastGrass();
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return p_149691_1_ == 1 ? this.field_149991_b
				: (p_149691_1_ == 0 ? Blocks.dirt
						.getBlockTextureFromSide(p_149691_1_) : this.blockIcon);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_,
			int p_149673_3_, int p_149673_4_, int p_149673_5_) {
		if (p_149673_5_ == 1) {
			return this.field_149991_b;
		} else if (p_149673_5_ == 0) {
			return Blocks.dirt.getBlockTextureFromSide(p_149673_5_);
		} else {
			Material material = p_149673_1_.getBlock(p_149673_2_,
					p_149673_3_ + 1, p_149673_4_).getMaterial();
			return material != Material.snow
					&& material != Material.craftedSnow ? this.blockIcon
					: this.field_149993_M;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.blockIcon = p_149651_1_.registerIcon(this.getTextureName()
				+ "_side");
		this.field_149991_b = p_149651_1_.registerIcon(this.getTextureName()
				+ "_top");
		this.field_149993_M = p_149651_1_.registerIcon(this.getTextureName()
				+ "_side_snowed");
		this.field_149994_N = p_149651_1_.registerIcon(this.getTextureName()
				+ "_side_overlay");
	}
}
