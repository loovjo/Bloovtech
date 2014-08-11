package com.loovjo.bloovtech.worldgen;

import java.util.Random;

import com.loovjo.bloovtech.BloovMain;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.dimensionId == 0) {
			//System.out.println("lal");
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}

	}

	private void generateSurface(World world, Random rand, int chunkX,
			int chunkZ) {
		for (int k = 0; k < 10; k++) {
			int firstBlockXCoord = chunkX + rand.nextInt(16);
			int firstBlockYCoord = rand.nextInt(256);
			int firstBlockZCoord = chunkZ + rand.nextInt(16);

			(new WorldGenMinable(BloovMain.blockOverPowerOre, 20))
					.generate(world, rand, firstBlockXCoord, firstBlockYCoord,
							firstBlockZCoord);
		}
	}

}