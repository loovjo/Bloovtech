package com.loovjo.bloovtech.tileentity;

import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;

public class TileEntitySteamGenerator extends TileEntity implements
		ISidedInventory {

	private ItemStack[] slots = new ItemStack[4];
	private int i = 0, tick = 0;
	public int steamStored, steamMax = 20000, waterStored, looseLevel = 5,
			maxWater = 4000, transferSpeed = 100;
	public float fuelLevel = 0, fuelLossPerTick = 0, maxFuel = 200;

	@Override
	public void updateEntity() {
		super.updateEntity();
		
		if (fuelLevel > 0) {
			if (steamStored < steamMax && waterStored > 0) {
				steamStored += 20;
				fuelLevel -= fuelLossPerTick;
				waterStored -= looseLevel;
			}
		} else {
			if (waterStored > 0 && TileEntityFurnace.isItemFuel(slots[0])) {
				fuelLevel = maxFuel;
				fuelLossPerTick = (float) (3000 / TileEntityFurnace
						.getItemBurnTime(slots[0]) * 1.1);
				slots[0].stackSize--;
				if (slots[0].stackSize == 0) {
					slots[0] = null;
				}
				if (steamStored < steamMax) {
					steamStored += 20;
					fuelLevel -= fuelLossPerTick;
				}
			}

		}
		TileEntity te = worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
		if (te != null) {
			if (te instanceof TileEntityTurbine) {
				TileEntityTurbine te2 = (TileEntityTurbine) te;
				if (steamStored > transferSpeed && te2.steamStored < te2.steamMax) {
					te2.steamStored += transferSpeed;
					steamStored -= transferSpeed;
				}
			}
		}

	}

	public int getWaterScaled(int scale) {
		// TODO Auto-generated method stub
		return (int) (waterStored / (float) maxWater * scale);
	}

	public int getSteamScaled(int scale) {
		return (int) (steamStored / (float) steamMax * scale);
	}

	public int getFuelScaled(int scale) {
		return (int) (fuelLevel / (float) maxFuel * scale);
	}

	@Override
	public int getSizeInventory() {
		return slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return slots[slot];
	}

	public ItemStack decrStackSize(int par1, int par2) {
		if (this.slots[par1] != null) {
			ItemStack itemstack;

			if (this.slots[par1].stackSize <= par2) {
				itemstack = this.slots[par1];
				this.slots[par1] = null;
				return itemstack;
			} else {
				itemstack = this.slots[par1].splitStack(par2);

				if (this.slots[par1].stackSize == 0) {
					this.slots[par1] = null;
				}

				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		return slots[var1];
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		slots[var1] = var2;
	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return true;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		return side == 1 ? new int[] { 1, 2, 3 } : new int[] { 0 };
	}

	@Override
	public boolean canInsertItem(int var1, ItemStack var2, int var3) {
		return true;
	}

	@Override
	public boolean canExtractItem(int var1, ItemStack var2, int var3) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		this.slots = new ItemStack[this.getSizeInventory()];
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 255;

			if (j >= 0 && j < this.slots.length) {
				this.slots[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}

		steamStored = nbt.getInteger("powerStored");
		fuelLevel = nbt.getFloat("fuelLevel");
		fuelLossPerTick = nbt.getFloat("flpt");
		System.out.println("lallare3000");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.slots.length; ++i) {
			if (this.slots[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.slots[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbt.setTag("Items", nbttaglist);

		nbt.setInteger("powerStored", steamStored);
		nbt.setFloat("fuelLevel", fuelLevel);
		nbt.setFloat("flpt", fuelLossPerTick);
		System.out.println("lallare2000");
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		super.onDataPacket(net, pkt);

	}

}
