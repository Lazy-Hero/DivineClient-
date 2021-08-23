// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.player;

import net.minecraft.block.Block;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.BlockHopper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.BlockAir;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import java.util.ArrayList;
import me.Divine.settings.Setting;
import me.Divine.Divine;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class NoClip extends Module
{
    public NoClip() {
        super("NoClip", "", Category.MOVEMENT);
        final Divine instance = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("Speed", this, 0.5, 0.3, 5.0, false));
        final ArrayList<String> mode = new ArrayList<String>();
        mode.add("Simple");
        final Divine instance2 = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("Mode", this, "Simple", mode));
    }
    
    @SubscribeEvent
    public void onLivingUpdate(final LivingEvent.LivingUpdateEvent livingUpdateEvent) {
        if (NoClip.mc.field_71439_g != null) {
            NoClip.mc.field_71439_g.field_70145_X = true;
            NoClip.mc.field_71439_g.field_70181_x = 0.0;
            NoClip.mc.field_71439_g.field_70122_E = false;
            NoClip.mc.field_71439_g.field_71075_bZ.field_75100_b = false;
            final StringBuilder sb = new StringBuilder();
            final Divine instance = Divine.instance;
            this.suff = sb.append(Divine.settingsManager.getSettingByName(this, "Speed").getValDouble()).append("").toString();
            final Divine instance2 = Divine.instance;
            if (Divine.settingsManager.getSettingByName(this, "Mode").getValString().equals("Simple")) {
                if (NoClip.mc.field_71474_y.field_74314_A.func_151470_d()) {
                    final EntityPlayerSP field_71439_g = NoClip.mc.field_71439_g;
                    final double field_70181_x = field_71439_g.field_70181_x;
                    final Divine instance3 = Divine.instance;
                    field_71439_g.field_70181_x = field_70181_x + (float)Divine.settingsManager.getSettingByName(this, "Speed").getValDouble();
                }
                if (NoClip.mc.field_71474_y.field_74311_E.func_151470_d()) {
                    final EntityPlayerSP field_71439_g2 = NoClip.mc.field_71439_g;
                    final double field_70181_x2 = field_71439_g2.field_70181_x;
                    final Divine instance4 = Divine.instance;
                    field_71439_g2.field_70181_x = field_70181_x2 - (float)Divine.settingsManager.getSettingByName(this, "Speed").getValDouble();
                }
            }
            else {
                float f = NoClip.mc.field_71439_g.field_70177_z;
                if (NoClip.mc.field_71439_g.field_191988_bg < 0.0f) {
                    f += 180.0f;
                }
                if (NoClip.mc.field_71439_g.field_70702_br > 0.0f) {
                    f -= 90.0f * ((NoClip.mc.field_71439_g.field_191988_bg < 0.0f) ? -0.5f : ((NoClip.mc.field_71439_g.field_191988_bg > 0.0f) ? 0.5f : 1.0f));
                }
                if (NoClip.mc.field_71439_g.field_70702_br < 0.0f) {
                    f += 90.0f * ((NoClip.mc.field_71439_g.field_191988_bg < 0.0f) ? -0.5f : ((NoClip.mc.field_71439_g.field_191988_bg > 0.0f) ? 0.5f : 1.0f));
                }
                final double cfr_ignored_0 = Math.cos(Math.toRadians(f + 90.0f)) * 1.273197475E-314;
                final double cfr_ignored_2 = Math.sin(Math.toRadians(f + 90.0f)) * 1.273197475E-314;
                final double d = NoClip.mc.field_71439_g.func_174811_aO().func_176730_m().func_177958_n() * 1.273197475E-15;
                final double d2 = NoClip.mc.field_71439_g.func_174811_aO().func_176730_m().func_177952_p() * 1.273197475E-15;
                NoClip.mc.field_71439_g.field_70181_x = 0.0;
                if (NoClip.mc.field_71474_y.field_74314_A.func_151470_d()) {
                    final EntityPlayerSP field_71439_g3;
                    final EntityPlayerSP entityPlayerSP = field_71439_g3 = NoClip.mc.field_71439_g;
                    field_71439_g3.field_70181_x += 4.24399158E-15;
                }
                if (NoClip.mc.field_71474_y.field_74311_E.func_151470_d()) {
                    final EntityPlayerSP field_71439_g4;
                    final EntityPlayerSP entityPlayerSP = field_71439_g4 = NoClip.mc.field_71439_g;
                    field_71439_g4.field_70181_x -= 4.24399158E-15;
                }
                if (NoClip.mc.field_71439_g.field_70123_F) {
                    NoClip.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketPlayer.Position(NoClip.mc.field_71439_g.field_70165_t, NoClip.mc.field_71439_g.field_70163_u + 1.273197475E-14, NoClip.mc.field_71439_g.field_70161_v, true));
                    NoClip.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketPlayer.Position(NoClip.mc.field_71439_g.field_70165_t + d * 0.0, NoClip.mc.field_71439_g.field_70163_u, NoClip.mc.field_71439_g.field_70161_v + d2 * 0.0, true));
                    NoClip.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketPlayer.Position(NoClip.mc.field_71439_g.field_70165_t, NoClip.mc.field_71439_g.field_70163_u, NoClip.mc.field_71439_g.field_70161_v, true));
                }
            }
        }
    }
    
    @Override
    public void onDisable() {
        NoClip.mc.field_71439_g.field_70145_X = false;
        NoClip.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketPlayer.PositionRotation(NoClip.mc.field_71439_g.field_70165_t, NoClip.mc.field_71439_g.func_174813_aQ().field_72338_b, NoClip.mc.field_71439_g.field_70161_v, NoClip.mc.field_71439_g.field_71109_bG, NoClip.mc.field_71439_g.field_70726_aT, NoClip.mc.field_71439_g.field_70122_E));
        super.onDisable();
    }
    
    public static boolean isInsideBlock() {
        for (int i = MathHelper.func_76128_c(Minecraft.func_71410_x().field_71439_g.func_174813_aQ().field_72340_a); i < MathHelper.func_76128_c(Minecraft.func_71410_x().field_71439_g.func_174813_aQ().field_72336_d) + 1; ++i) {
            for (int j = MathHelper.func_76128_c(Minecraft.func_71410_x().field_71439_g.func_174813_aQ().field_72338_b); j < MathHelper.func_76128_c(Minecraft.func_71410_x().field_71439_g.func_174813_aQ().field_72337_e) + 1; ++j) {
                for (int k = MathHelper.func_76128_c(Minecraft.func_71410_x().field_71439_g.func_174813_aQ().field_72339_c); k < MathHelper.func_76128_c(Minecraft.func_71410_x().field_71439_g.func_174813_aQ().field_72334_f) + 1; ++k) {
                    final Block block = Minecraft.func_71410_x().field_71441_e.func_180495_p(new BlockPos(i, j, k)).func_177230_c();
                    if (block != null) {
                        if (!(block instanceof BlockAir)) {
                            AxisAlignedBB axisAlignedBB = block.func_180646_a(Minecraft.func_71410_x().field_71441_e.func_180495_p(new BlockPos(i, j, k)), (IBlockAccess)Minecraft.func_71410_x().field_71441_e, new BlockPos(i, j, k));
                            if (block instanceof BlockHopper) {
                                axisAlignedBB = new AxisAlignedBB((double)i, (double)j, (double)k, (double)(i + 1), (double)(j + 1), (double)(k + 1));
                            }
                            if (axisAlignedBB != null) {
                                if (Minecraft.func_71410_x().field_71439_g.func_174813_aQ().func_72326_a(axisAlignedBB)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static void setMoveSpeedAris(final double d) {
        double d2 = Minecraft.func_71410_x().field_71439_g.field_71158_b.field_192832_b;
        double d3 = Minecraft.func_71410_x().field_71439_g.field_71158_b.field_78902_a;
        double d4 = Minecraft.func_71410_x().field_71439_g.field_70177_z;
        if ((d2 != 0.0 || d3 != 0.0) && d2 != 0.0) {
            if (d3 > 0.0) {
                d4 += ((d2 > 0.0) ? -45.0 : 45.0);
            }
            else if (d3 < 0.0) {
                d4 += ((d2 > 0.0) ? 45.0 : -45.0);
            }
            d3 = 0.0;
            if (d2 > 0.0) {
                d2 = 1.0;
            }
            else if (d2 < 0.0) {
                d2 = -1.0;
            }
        }
    }
}
