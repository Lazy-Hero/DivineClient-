// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.movement;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class AntiWeb extends Module
{
    public AntiWeb() {
        super("AntiWeb", "", Category.MOVEMENT);
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent playerTickEvent) {
        final BlockPos blockPos = new BlockPos(AntiWeb.mc.field_71439_g.field_70165_t, AntiWeb.mc.field_71439_g.field_70163_u, AntiWeb.mc.field_71439_g.field_70161_v);
        final BlockPos blockPos2 = new BlockPos(AntiWeb.mc.field_71439_g.field_70165_t, AntiWeb.mc.field_71439_g.field_70163_u + 1.0, AntiWeb.mc.field_71439_g.field_70161_v);
        if ((AntiWeb.mc.field_71441_e.func_180495_p(blockPos).func_177230_c() == Blocks.field_150321_G || AntiWeb.mc.field_71441_e.func_180495_p(blockPos2).func_177230_c() == Blocks.field_150321_G) && AntiWeb.mc.field_71474_y.field_74351_w.func_151470_d()) {
            setMoveSpeed(0.25);
        }
    }
    
    public static void setMoveSpeed(final double d) {
        double d2 = AntiWeb.mc.field_71439_g.field_71158_b.field_192832_b;
        double d3 = AntiWeb.mc.field_71439_g.field_71158_b.field_78902_a;
        float f = AntiWeb.mc.field_71439_g.field_70177_z;
        if (d2 == 0.0 && d3 == 0.0) {
            AntiWeb.mc.field_71439_g.field_70159_w = 0.0;
            AntiWeb.mc.field_71439_g.field_70179_y = 0.0;
        }
        else {
            if (d2 != 0.0) {
                if (d3 > 0.0) {
                    f += ((d2 > 0.0) ? -45 : 45);
                }
                else if (d3 < 0.0) {
                    f += ((d2 > 0.0) ? 45 : -45);
                }
                d3 = 0.0;
                if (d2 > 0.0) {
                    d2 = 1.0;
                }
                else if (d2 < 0.0) {
                    d2 = -1.0;
                }
            }
            AntiWeb.mc.field_71439_g.field_70159_w = d2 * d * Math.cos(Math.toRadians(f + 90.0f)) + d3 * d * Math.sin(Math.toRadians(f + 90.0f));
            AntiWeb.mc.field_71439_g.field_70179_y = d2 * d * Math.sin(Math.toRadians(f + 90.0f)) - d3 * d * Math.cos(Math.toRadians(f + 90.0f));
        }
    }
}
