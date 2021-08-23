// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.movement;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class Sprint extends Module
{
    public Sprint() {
        super("Sprint", "Always holds down the sprint key", Category.MOVEMENT);
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent e) {
        KeyBinding.func_74510_a(Sprint.mc.field_71474_y.field_151444_V.func_151463_i(), true);
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
        KeyBinding.func_74510_a(Sprint.mc.field_71474_y.field_151444_V.func_151463_i(), false);
    }
}
