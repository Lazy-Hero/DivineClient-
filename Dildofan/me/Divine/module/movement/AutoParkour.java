// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.movement;

import me.Divine.module.Category;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import me.Divine.module.Module;

public class AutoParkour extends Module
{
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent playerTickEvent) {
        if (isMoving() && AutoParkour.mc.field_71439_g.field_70122_E && !AutoParkour.mc.field_71439_g.func_70093_af() && !AutoParkour.mc.field_71474_y.field_74311_E.func_151470_d() && !AutoParkour.mc.field_71474_y.field_74314_A.func_151470_d() && AutoParkour.mc.field_71441_e.func_184144_a((Entity)AutoParkour.mc.field_71439_g, AutoParkour.mc.field_71439_g.func_174813_aQ().func_72317_d(0.0, -0.5, 0.0).func_72321_a(-0.001, 0.0, -0.001)).isEmpty() && AutoParkour.mc.field_71439_g.field_191988_bg != 0.0f) {
            AutoParkour.mc.field_71439_g.func_70664_aZ();
        }
    }
    
    public AutoParkour() {
        super("AutoParkour", "", Category.MOVEMENT);
    }
    
    public static boolean isMoving() {
        return AutoParkour.mc.field_71439_g != null && (AutoParkour.mc.field_71439_g.field_71158_b.field_192832_b != 0.0f || AutoParkour.mc.field_71439_g.field_71158_b.field_78902_a != 0.0f);
    }
}
