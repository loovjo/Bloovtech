package com.loovjo.bloovtech.renders;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import com.loovjo.bloovtech.BloovMain;

public class TileEntityCustomCraftingTableRenderer extends
		TileEntitySpecialRenderer {

	private ResourceLocation textureFront = new ResourceLocation(
			BloovMain.MODID,
			"textures/crafting_tables/crafting_table_front.png");
	private ResourceLocation textureSide = new ResourceLocation(
			BloovMain.MODID, "textures/crafting_tables/crafting_table_side.png");
	private ResourceLocation textureTop = new ResourceLocation(BloovMain.MODID,
			"textures/crafting_tables/crafting_table_top.png");

	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		GL11.glTranslated(var2, var4, var6);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_LIGHTING);
		draw(textureFront, textureSide, textureTop);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glTranslated(-var2, -var4, -var6);

	}

	private void draw(ResourceLocation textureFront,
			ResourceLocation textureSide, ResourceLocation textureTop) {
		bindTexture(textureFront);

		Tessellator t = Tessellator.instance;
		t.startDrawingQuads();
		{
			t.addVertexWithUV(0, 0, -0.01, 1, 1);
			t.addVertexWithUV(0, 1, -0.01, 1, 0);
			t.addVertexWithUV(1, 1, -0.01, 0, 0);
			t.addVertexWithUV(1, 0, -0.01, 0, 1);

			t.addVertexWithUV(-0.01, 0, 0, 0, 1);
			t.addVertexWithUV(-0.01, 0, 1, 1, 1);
			t.addVertexWithUV(-0.01, 1, 1, 1, 0);
			t.addVertexWithUV(-0.01, 1, 0, 0, 0);

		}
		t.draw();
		
		bindTexture(textureSide);
		t.startDrawingQuads();
		{
			t.addVertexWithUV(0, 0, 1.01, 1, 1);
			t.addVertexWithUV(0, 1, 1.01, 1, 0);
			t.addVertexWithUV(1, 1, 1.01, 0, 0);
			t.addVertexWithUV(1, 0, 1.01, 0, 1);

			t.addVertexWithUV(1.01, 0, 0, 0, 1);
			t.addVertexWithUV(1.01, 0, 1, 1, 1);
			t.addVertexWithUV(1.01, 1, 1, 1, 0);
			t.addVertexWithUV(1.01, 1, 0, 0, 0);
		}
		t.draw();
		
		bindTexture(textureTop);
		t.startDrawingQuads();
		{
			t.addVertexWithUV(0, 1.01, 0, 1, 1);
			t.addVertexWithUV(0, 1.01, 1, 1, 0);
			t.addVertexWithUV(1, 1.01, 1, 0, 0);
			t.addVertexWithUV(1, 1.01, 0, 0, 1);
		}
		t.draw();
	}

}
