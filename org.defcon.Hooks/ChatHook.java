package org.defcon.Hooks;

import org.defcon.Client.Defcon;
import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.GuiIngame;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Packet3Chat;
import net.minecraft.src.Session;
import net.minecraft.src.World;
import net.minecraft.*;

public class ChatHook extends EntityClientPlayerMP {

	public ChatHook(Minecraft par1Minecraft, World par2World, Session par3Session, NetClientHandler par4NetClientHandler) {
		super(par1Minecraft, par2World, par3Session, par4NetClientHandler);
	}
	
	@Override
    public void sendChatMessage(String par1Str)
    {
    	if(par1Str.startsWith("-")){
    		Defcon.ChatHook(par1Str);
    	}else{
    		super.sendChatMessage(par1Str);
    	}
    }
	
}
