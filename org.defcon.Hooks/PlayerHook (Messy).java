package org.defcon.Hooks;

import org.defcon.Client.Defcon;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.EnumAction;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.RenderPlayer;
import net.minecraft.src.Tessellator;

public class PlayerHook extends RenderPlayer {
	@Override
    protected void renderName(EntityPlayer par1EntityPlayer, double par2, double par4, double par6)
    {
        if (Minecraft.isGuiEnabled() /*&& par1EntityPlayer != this.renderManager.livingPlayer*/ && !par1EntityPlayer.getHasActivePotion())
        {
            float var8 = 1.6F;
            float var9 = 0.016666668F * var8;
            double var10 = par1EntityPlayer.getDistanceSqToEntity(this.renderManager.livingPlayer);
            float var12 = par1EntityPlayer.isSneaking() ? 100.0F : 100.0F;

            if (var10 < (double)(var12 * var12))
            {
                String var13 = par1EntityPlayer.username;
                int Health = par1EntityPlayer.getHealth();

                if (par1EntityPlayer.isSneaking() || !par1EntityPlayer.isSneaking())
                {
                	if(Defcon.ESP == true){
	                    FontRenderer var14 = this.getFontRendererFromRenderManager();
	                    GL11.glDisable(GL11.GL_DEPTH_TEST);
	                    GL11.glDisable(GL11.GL_CULL_FACE);
	                    GL11.glDisable(GL11.GL_LIGHTING);
	                    GL11.glPushMatrix();
	                    GL11.glTranslatef((float)par2 + 0.0F, (float)par4 + 2.3F, (float)par6);
	                    GL11.glNormal3f(0.0F, 1.0F, 0.0F);
	                    GL11.glRotatef(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
	                    GL11.glRotatef(this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
	                    GL11.glScalef(-var9, -var9, var9);
	                    /*GL11.glDisable(GL11.GL_LIGHTING);
	                    GL11.glTranslatef(0.0F, 0.25F / var9, 0.0F);
	                    GL11.glDepthMask(false);
	                    GL11.glEnable(GL11.GL_BLEND);
	                    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);*/
	                    /*Tessellator var15 = Tessellator.instance;
	                    GL11.glDisable(GL11.GL_TEXTURE_2D);
	                    var15.startDrawingQuads();
	                    int var16 = var14.getStringWidth("Name: " + var13) / 2;
	                    var15.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.25F);
	                    var15.addVertex((double)(-var16 - 1), -1.0D, 0.0D);
	                    var15.addVertex((double)(-var16 - 1), 8.0D, 0.0D);
	                    var15.addVertex((double)(var16 + 1), 8.0D, 0.0D);
	                    var15.addVertex((double)(var16 + 1), -1.0D, 0.0D);
	                    var15.draw();*/
	                    //GL11.glEnable(GL11.GL_TEXTURE_2D);
	                    //GL11.glDepthMask(true);
	                    var14.drawStringWithShadow("§8Name: §a" + var13, -var14.getStringWidth(var13) / 2, -20, 553648127);
	                    var14.drawStringWithShadow("§8Health: §a" + (Health * 5) + "%", -var14.getStringWidth(var13) / 2, -10, 553648127);
	                    if(par1EntityPlayer.inventory.getCurrentItem() == null){
	                    	var14.drawStringWithShadow("§8Weapon: §a" + "Hands", -var14.getStringWidth(var13) / 2, 0, 553648127);
	                    }else{
	                    	var14.drawStringWithShadow("§8Weapon: §a" + par1EntityPlayer.inventory.getCurrentItem().getDisplayName(), -var14.getStringWidth(var13) / 2, 0, 553648127);
	                    }
	                    GL11.glEnable(GL11.GL_LIGHTING);
	                    //GL11.glDisable(GL11.GL_BLEND);
	                    GL11.glColor4f(3.0F, 1.0F, 1.0F, 1.0F);
	                    GL11.glEnable(GL11.GL_DEPTH_TEST);
	                    GL11.glEnable(GL11.GL_CULL_FACE);
	                    GL11.glPopMatrix();
                	}else{
                		this.renderLivingLabel(par1EntityPlayer, var13, par2, par4, par6, 64);
	                }
                }
                else if (par1EntityPlayer.isPlayerSleeping())
                {
                    this.renderLivingLabel(par1EntityPlayer, var13, par2, par4 - 1.5D, par6, 64);
                }
                else
                {
                    this.renderLivingLabel(par1EntityPlayer, var13, par2, par4, par6, 64);
                }
            }
        }
    }
}
