// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.movement;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.client.Minecraft;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class NoSlowdown extends Module
{
    public NoSlowdown() {
        super("NoSlowdown", "", Category.MOVEMENT);
    }
    
    public static boolean isMoving() {
        return NoSlowdown.mc.field_71439_g != null && (NoSlowdown.mc.field_71439_g.field_71158_b.field_192832_b != 0.0f || NoSlowdown.mc.field_71439_g.field_71158_b.field_78902_a != 0.0f);
    }
    
    public static void setMoveSpeed(final double d) {
        double d2 = NoSlowdown.mc.field_71439_g.field_71158_b.field_192832_b;
        double d3 = NoSlowdown.mc.field_71439_g.field_71158_b.field_78902_a;
        float f = NoSlowdown.mc.field_71439_g.field_70177_z;
        if (d2 == 0.0 && d3 == 0.0) {
            NoSlowdown.mc.field_71439_g.field_70159_w = 0.0;
            NoSlowdown.mc.field_71439_g.field_70179_y = 0.0;
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
            NoSlowdown.mc.field_71439_g.field_70159_w = d2 * d * Math.cos(Math.toRadians(f + 90.0f)) + d3 * d * Math.sin(Math.toRadians(f + 90.0f));
            NoSlowdown.mc.field_71439_g.field_70179_y = d2 * d * Math.sin(Math.toRadians(f + 90.0f)) - d3 * d * Math.cos(Math.toRadians(f + 90.0f));
        }
    }
    
    public static float getSpeed() {
        return (float)Math.sqrt(NoSlowdown.mc.field_71439_g.field_70159_w * NoSlowdown.mc.field_71439_g.field_70159_w + NoSlowdown.mc.field_71439_g.field_70179_y * NoSlowdown.mc.field_71439_g.field_70179_y);
    }
    
    public static double getBaseMoveSpeed() {
        double d = 0.2873;
        if (Minecraft.func_71410_x().field_71439_g != null && Minecraft.func_71410_x().field_71439_g.func_70644_a(Potion.func_188412_a(1))) {
            final int n = Minecraft.func_71410_x().field_71439_g.func_70660_b(Potion.func_188412_a(1)).func_76458_c();
            d *= 1.0 + 0.2 * (n + 1);
        }
        return d;
    }
    
    public static void setSpeed(final EntityLivingBase entityLivingBase, final double d) {
        final double[] arrd = forward(d);
        entityLivingBase.field_70159_w = arrd[0];
        entityLivingBase.field_70179_y = arrd[1];
    }
    
    public static double getDirection() {
        float f = NoSlowdown.mc.field_71439_g.field_70177_z;
        if (NoSlowdown.mc.field_71439_g.field_191988_bg < 0.0f) {
            f += 180.0f;
        }
        float f2 = 1.0f;
        if (NoSlowdown.mc.field_71439_g.field_191988_bg < 0.0f) {
            f2 = -0.5f;
        }
        else if (NoSlowdown.mc.field_71439_g.field_191988_bg > 0.0f) {
            f2 = 0.5f;
        }
        if (NoSlowdown.mc.field_71439_g.field_70702_br > 0.0f) {
            f -= 90.0f * f2;
        }
        if (NoSlowdown.mc.field_71439_g.field_70702_br < 0.0f) {
            f += 90.0f * f2;
        }
        return Math.toRadians(f);
    }
    
    public static double[] forward(final double d) {
        float f = Minecraft.func_71410_x().field_71439_g.field_71158_b.field_192832_b;
        float f2 = Minecraft.func_71410_x().field_71439_g.field_71158_b.field_78902_a;
        float f3 = Minecraft.func_71410_x().field_71439_g.field_70126_B + (Minecraft.func_71410_x().field_71439_g.field_70177_z - Minecraft.func_71410_x().field_71439_g.field_70126_B) * Minecraft.func_71410_x().func_184121_ak();
        if (f != 0.0f) {
            if (f2 > 0.0f) {
                f3 += ((f > 0.0f) ? -45 : 45);
            }
            else if (f2 < 0.0f) {
                f3 += ((f > 0.0f) ? 45 : -45);
            }
            f2 = 0.0f;
            if (f > 0.0f) {
                f = 1.0f;
            }
            else if (f < 0.0f) {
                f = -1.0f;
            }
        }
        final double d2 = Math.sin(Math.toRadians(f3 + 90.0f));
        final double d3 = Math.cos(Math.toRadians(f3 + 90.0f));
        final double d4 = f * d * d3 + f2 * d * d2;
        final double d5 = f * d * d2 - f2 * d * d3;
        return new double[] { d4, d5 };
    }
    
    @SubscribeEvent
    public void onPlayerTick(final TickEvent.PlayerTickEvent playerTickEvent) {
        if (isMoving() && NoSlowdown.mc.field_71439_g.func_184587_cr()) {
            if (NoSlowdown.mc.field_71439_g.field_70122_E) {}
            final float f = NoSlowdown.mc.field_71439_g.field_70177_z;
            final Vec3d vec3d = Vec3d.func_189986_a(0.0f, f);
            final Vec3d vec3d2 = Vec3d.func_189986_a(0.0f, f + 90.0f);
            double d = 0.0;
            double d2 = 0.0;
            boolean bl = false;
            if (NoSlowdown.mc.field_71439_g.field_71158_b.field_187255_c) {
                d += vec3d.field_72450_a / 20.0 * 3.6;
                d2 += vec3d.field_72449_c / 20.0 * 3.6;
                bl = true;
            }
            if (NoSlowdown.mc.field_71439_g.field_71158_b.field_187256_d) {
                d -= vec3d.field_72450_a / 20.0 * 3.4;
                d2 -= vec3d.field_72449_c / 20.0 * 3.4;
                bl = true;
            }
            NoSlowdown.mc.field_71439_g.field_70159_w = d;
            NoSlowdown.mc.field_71439_g.field_70179_y = d2;
        }
    }
}
