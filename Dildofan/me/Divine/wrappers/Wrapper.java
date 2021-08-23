// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.wrappers;

import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.Packet;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.Minecraft;

public class Wrapper
{
    public static volatile Wrapper INSTANCE;
    
    public Minecraft mc() {
        return Minecraft.func_71410_x();
    }
    
    public static EntityPlayerSP player() {
        return Wrapper.INSTANCE.mc().field_71439_g;
    }
    
    public WorldClient world() {
        return Wrapper.INSTANCE.mc().field_71441_e;
    }
    
    public GameSettings mcSettings() {
        return Wrapper.INSTANCE.mc().field_71474_y;
    }
    
    public FontRenderer fontRenderer() {
        return Wrapper.INSTANCE.mc().field_71466_p;
    }
    
    public void sendPacket(final Packet packet) {
        player().field_71174_a.func_147297_a(packet);
    }
    
    public InventoryPlayer inventory() {
        return player().field_71071_by;
    }
    
    public PlayerControllerMP controller() {
        return Wrapper.INSTANCE.mc().field_71442_b;
    }
    
    static {
        Wrapper.INSTANCE = new Wrapper();
    }
}
