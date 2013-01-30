package org.defcon.Client;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.GuiIngame;

public class Defcon {
	public static boolean Sprint     = false;
	public static boolean AirJump    = false;
	public static boolean Fullbright = false;
	public static boolean XRay       = false;
	public static boolean ESP        = true;
	public static Minecraft mc;
	public static EntityClientPlayerMP Player;
	
	public static void GlobalHook(){
		Player = mc.thePlayer;
		
		if(Sprint){
			Player.setSprinting(Sprint);
		}else{
			Player.setSprinting(Player.isSprinting());
		}
		
		if(AirJump){
			Player.onGround = AirJump;
		}
	}
	
	public static void AddDefconMessage(String Message){
		Player.addChatMessage("§8[§cdefcon§8] " + Message);
	}
	
	public static void ChatHook(String FCommand){
		String Command = FCommand.replace("-", "").toLowerCase();
		if("sprint".equals(Command)){
			Sprint = !Sprint;
			AddDefconMessage("Sprint: " + Sprint);
		}
		else if(Command.startsWith("stepheight")){
			Command = Command.replace("stepheight ", "");
			Player.stepHeight = Integer.parseInt(Command);
			AddDefconMessage("Step Height: " + Player.stepHeight);
		}
		else if("airjump".equals(Command)){
			AirJump = !AirJump;
			AddDefconMessage("Air Jump: " + AirJump);
		}
		else if("help".equals(Command)){
			AddDefconMessage("Help Menu (Page 1/1)\n *§astepheight <int>  §7Change player's stepheight\n §8*§aairjump            §7Air jumping\n §8*§asprint              §7Auto sprinting\n §8*§afullbright          §7Brightness");
		}
		else if("fullbright".equals(Command)){
			Fullbright = !Fullbright;
			if(Fullbright){
				mc.gameSettings.gammaSetting = 1000f;
			}else{
				mc.gameSettings.gammaSetting = 0.0f;
			}
			AddDefconMessage("FullBright: " + Fullbright);
		}
		else if("xray".equals(Command)){
			XRay = !XRay;
			AddDefconMessage("XRay: " + XRay);
		}
		else if("esp".equals(Command)){
			ESP = !ESP;
			AddDefconMessage("ESP: " + ESP);
		}
	}
}
