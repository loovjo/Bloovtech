package com.loovjo.bloovtech;

import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import com.loovjo.bloovtech.block.BlockCluster;
import com.loovjo.bloovtech.block.BlockCustomCraftingTable;
import com.loovjo.bloovtech.block.BlockEnergyBarrelTier1;
import com.loovjo.bloovtech.block.BlockEnergyTransferer;
import com.loovjo.bloovtech.block.BlockFireDynamo;
import com.loovjo.bloovtech.block.BlockInfuser;
import com.loovjo.bloovtech.block.BlockMagnetQuarry;
import com.loovjo.bloovtech.block.BlockPowerPipe;
import com.loovjo.bloovtech.block.BlockTurbine;
import com.loovjo.bloovtech.block.BlockWaterPump;
import com.loovjo.bloovtech.event.BloovEventHandler;
import com.loovjo.bloovtech.gui.BloovGuiHandler;
import com.loovjo.bloovtech.item.ItemElectricBag;
import com.loovjo.bloovtech.item.ItemOverPower;
import com.loovjo.bloovtech.item.ItemPowerStone;
import com.loovjo.bloovtech.proxy.CommonProxy;
import com.loovjo.bloovtech.tileentity.TileEntityCustomCraftingTable;
import com.loovjo.bloovtech.tileentity.TileEntityEnergyBarrel;
import com.loovjo.bloovtech.tileentity.TileEntityEnergyTransferer;
import com.loovjo.bloovtech.tileentity.TileEntityInfuser;
import com.loovjo.bloovtech.tileentity.TileEntityMagnetQuarry;
import com.loovjo.bloovtech.tileentity.TileEntityPowerPipe;
import com.loovjo.bloovtech.tileentity.TileEntitySteamGenerator;
import com.loovjo.bloovtech.tileentity.TileEntityTurbine;
import com.loovjo.bloovtech.tileentity.TileEntityWaterPump;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = BloovMain.MODID, version = BloovMain.VERSION)
public class BloovMain {
	public static final String MODID = "bloovtech";
	public static final String VERSION = "Pre-alpha 0.001";

	public static ArrayList<ItemOverPower> iOp = new ArrayList<ItemOverPower>();

	public static ArrayList<ArrayList<Object>> infuserRecipes = new ArrayList<ArrayList<Object>>();

	@Instance
	public static BloovMain instance;

	public static CreativeTabs bloovtab = new CreativeTabs("BloovTab") {

		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(blockPowerPipe);
		}
	};

	@SidedProxy(clientSide = "com.loovjo.bloovtech.proxy.ClientProxy", serverSide = "com.loovjo.bloovtech.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static Block blockPowerPipe = new BlockPowerPipe(Material.rock)
			.setCreativeTab(bloovtab).setBlockName("powerPipe").setHardness(3);
	public static Block blockSteamGenerator = new BlockFireDynamo(Material.rock)
			.setBlockName("steamGenerator").setCreativeTab(bloovtab);
	public static Block blockWaterPump = new BlockWaterPump(Material.rock)
			.setBlockName("waterPump").setCreativeTab(bloovtab);
	public static Block blockMagnetQuarry = new BlockMagnetQuarry(Material.rock)
			.setCreativeTab(bloovtab).setBlockName("magnetQuarry");
	public static Block blockTurbine = new BlockTurbine(Material.rock)
			.setCreativeTab(bloovtab).setBlockName("turbine");
	public static Block blockEnergyBarrelTier1 = new BlockEnergyBarrelTier1(
			Material.wood).setCreativeTab(bloovtab)
			.setBlockName("energyBarrel").setHardness(100).setResistance(100);
	public static Block blockEnergyTransferer = new BlockEnergyTransferer(
			Material.rock).setCreativeTab(bloovtab).setBlockName(
			"energyTransferer");
	public static Block blockCluster = new BlockCluster(Material.rock)
			.setBlockName("cluster")
			.setBlockTextureName(BloovMain.MODID + ":blockCluster")
			.setCreativeTab(bloovtab).setHardness(20);
	public static Block blockOverPowerer = new BlockInfuser(Material.rock)
			.setBlockName("infuser").setCreativeTab(bloovtab);

	public static ItemOverPower itemOverPowerIngot = (ItemOverPower) new ItemOverPower(
			20).setTextureName(MODID + ":overpowerium/0%")
			.setUnlocalizedName("overpoweringot").setCreativeTab(bloovtab);
	public static Item itemOverPowerium = new ItemOverPower(20)
			.setTextureName(MODID + ":overpowerium/20%")
			.setUnlocalizedName("overpowerium").setCreativeTab(bloovtab);
	public static Item itemPowerStone = new ItemPowerStone()
			.setCreativeTab(bloovtab).setTextureName(MODID + ":powerStone")
			.setUnlocalizedName("powerStone")
			.setMaxDamage(ItemPowerStone.powerMax);
	public static Item itemElectricBag = new ItemElectricBag()
			.setCreativeTab(bloovtab).setMaxStackSize(1)
			.setUnlocalizedName("electricBag")
			.setTextureName(MODID + ":electricbag");

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenderStuff();
		registerBlocks();
		registerTileEntities();
		registerItems();
		registerGuiStuff();
		registerCrafting();
		registerCraftingTables(Blocks.stone, Blocks.planks, Blocks.stonebrick,
				Blocks.dirt, Blocks.sand);
		registerOverPoverium();
		registerInfuserRecipes();
		MinecraftForge.EVENT_BUS.register(new BloovEventHandler());
	}

	private void registerInfuserRecipes() {
	}

	private void registerOverPoverium() {
		Item lastItem = itemOverPowerIngot;
		for (int i = 4; i < 20; i += 4) {
			ItemOverPower item = (ItemOverPower) new ItemOverPower(i)
					.setTextureName(MODID + ":overpowerium/" + i + "%")
					.setUnlocalizedName("op" + i).setCreativeTab(bloovtab);
			GameRegistry.registerItem(item, "overpowerium" + i + "%");
			// System.out.println(lastItem + ": " + item);
			GameRegistry.addShapelessRecipe(new ItemStack(item, 4),
					new Object[] { lastItem, lastItem, lastItem, lastItem,
							lastItem, lastItem, lastItem, lastItem });
			GameRegistry.addShapelessRecipe(new ItemStack(lastItem, 8),
					new Object[] { item, item, item, item });
			lastItem = item;
			iOp.add(item);
		}
		Item item = itemOverPowerium;
		GameRegistry.addShapelessRecipe(new ItemStack(item, 1), new Object[] {
				lastItem, lastItem, lastItem, lastItem, lastItem, lastItem,
				lastItem, lastItem });
		GameRegistry.addShapelessRecipe(new ItemStack(lastItem, 8),
				new Object[] { item });
		iOp.add((ItemOverPower) item);

	}

	private void registerInfuserRecipe(ItemStack result, Object... recipe) {
		infuserRecipes.add(new ArrayList<Object>(Arrays.asList(new Object[] {
				result, recipe })));
	}

	private void registerCrafting() {
		GameRegistry
				.addShapelessRecipe(new ItemStack(blockCluster), new Object[] {
						Blocks.iron_block, Blocks.coal_block,
						Blocks.diamond_block, Blocks.emerald_block,
						Blocks.redstone_block, Blocks.lapis_block,
						Blocks.gold_block, Items.slime_ball, Items.slime_ball });
		GameRegistry.addShapedRecipe(new ItemStack(blockMagnetQuarry), "ccc",
				"crc", "ctc", 'c', blockCluster, 'r', Blocks.redstone_block,
				't', Blocks.tnt);

	}

	private void registerCraftingTables(Block... types) {
		for (Block type : types) {
			Block b = new BlockCustomCraftingTable(type)
					.setCreativeTab(bloovtab);
			GameRegistry.registerBlock(b,
					"crafting_table_" + type.getUnlocalizedName().substring(5))
					.getLocalizedName();
			GameRegistry.registerTileEntity(
					TileEntityCustomCraftingTable.class,
					MODID + ":cct" + type.getUnlocalizedName());

			GameRegistry.addRecipe(new ItemStack(b), "aba", 'a',
					Items.iron_axe, 'b', type);

		}
	}

	private void registerGuiStuff() {
		NetworkRegistry.INSTANCE.registerGuiHandler(BloovMain.instance,
				new BloovGuiHandler());
	}

	private void registerItems() {
		GameRegistry.registerItem(itemElectricBag, "electricBag");
		GameRegistry.registerItem(itemPowerStone, "powerStone");
		GameRegistry.registerItem(itemOverPowerIngot, "overpoweringot");
		GameRegistry.registerItem(itemOverPowerium, "overpowerium");
	}

	private void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityPowerPipe.class, MODID
				+ ":powerPipe");
		GameRegistry.registerTileEntity(TileEntitySteamGenerator.class, MODID
				+ ":fireDynamo");
		GameRegistry.registerTileEntity(TileEntityWaterPump.class, MODID
				+ "waterPump");
		GameRegistry.registerTileEntity(TileEntityMagnetQuarry.class, MODID
				+ ":magnetQuarry");
		GameRegistry.registerTileEntity(TileEntityTurbine.class, MODID
				+ ":steam2p");
		GameRegistry.registerTileEntity(TileEntityEnergyBarrel.class, MODID
				+ ":energyBarrel");
		GameRegistry.registerTileEntity(TileEntityEnergyTransferer.class, MODID
				+ "energyTransferer");
		GameRegistry.registerTileEntity(TileEntityInfuser.class, MODID
				+ "infuser");
	}

	private void registerBlocks() {
		GameRegistry.registerBlock(blockPowerPipe, "powerPipe");
		GameRegistry.registerBlock(blockSteamGenerator, "fireDynamo");
		GameRegistry.registerBlock(blockWaterPump, "waterPump");
		GameRegistry.registerBlock(blockMagnetQuarry, "magnetQuarry");
		GameRegistry.registerBlock(blockCluster, "blockCluster");
		GameRegistry.registerBlock(blockTurbine, "steam2power");
		GameRegistry.registerBlock(blockEnergyBarrelTier1, "energybarreltier1");
		GameRegistry.registerBlock(blockEnergyTransferer, "energyTransferer");
		GameRegistry.registerBlock(blockOverPowerer, "infuser");
	}
}
