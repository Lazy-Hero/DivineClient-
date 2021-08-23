// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.misc;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class NoChat extends Module
{
    public NoChat() {
        super("NoChat", "", Category.MISC);
    }
    
    @SubscribeEvent
    public void onUpdate(final TickEvent.ClientTickEvent e) {
        Minecraft.func_71410_x().field_71456_v.func_146158_b().func_146231_a(true);
    }
}
