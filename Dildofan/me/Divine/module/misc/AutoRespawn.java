// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.misc;

import me.Divine.event.EventManager;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class AutoRespawn extends Module
{
    public AutoRespawn() {
        super("AutoRespawn", "AutoRespawn", Category.MISC);
    }
    
    @SubscribeEvent
    public void onPlayerTickEvent(final TickEvent.PlayerTickEvent playerTickEvent) {
        if (!this.isToggled()) {
            return;
        }
        if (Minecraft.func_71410_x().field_71462_r instanceof GuiGameOver) {
            Minecraft.func_71410_x().field_71439_g.func_71004_bE();
            Minecraft.func_71410_x().func_147108_a((GuiScreen)null);
        }
    }
    
    @Override
    public void onEnable() {
        EventManager.register(this);
        super.onEnable();
    }
    
    @Override
    public void onDisable() {
        EventManager.unregister(this);
        super.onDisable();
    }
}
