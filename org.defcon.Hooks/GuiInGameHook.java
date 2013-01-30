package org.defcon.Hooks;

import org.defcon.Client.Defcon;
import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiIngame;
import net.minecraft.*;

public class GuiInGameHook extends GuiIngame {
	public GuiInGameHook(Minecraft par1Minecraft) {
		super(par1Minecraft);
		Defcon.mc = par1Minecraft;
	}
	
	@Override
    public void renderGameOverlay(float par1, boolean par2, int par3, int par4) 
    {
		super.renderGameOverlay(par1, par2, par3, par4);
		Defcon.GlobalHook();
    }
}
