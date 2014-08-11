package com.loovjo.bloovtech.item;

import com.loovjo.bloovtech.block.BlockCustomCraftingTable;

import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemCCBlock extends ItemBlock {
	private Block type;

	public ItemCCBlock(BlockCustomCraftingTable p_i45328_1_) {
		super(p_i45328_1_);
		type = p_i45328_1_.type;
	}

	public String getItemStackDisplayName(ItemStack par1ItemStack) {
		return I18n.format("crafting.name",
				new Object[] { type.getLocalizedName() });
	}

}
