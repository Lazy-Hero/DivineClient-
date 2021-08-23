// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.render;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.util.Iterator;
import net.minecraft.block.Block;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.tileentity.TileEntityShulkerBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import me.Divine.settings.Setting;
import me.Divine.Divine;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class SchalkerESP extends Module
{
    public SchalkerESP() {
        super("SchalkerESP", "", Category.RENDER);
        final Divine instance = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("Schalker", this, true));
        final Divine instance2 = Divine.instance;
        Divine.settingsManager.rSetting(new Setting("ColorShalker", this, false));
    }
    
    @SubscribeEvent
    public void EventRender3D(final RenderWorldLastEvent e) {
        for (final TileEntity tileEntity : SchalkerESP.mc.field_71441_e.field_147482_g) {
            final Divine instance = Divine.instance;
            if (Divine.settingsManager.getSettingByName(this, "Schalker").getValBoolean() && tileEntity instanceof TileEntityShulkerBox) {
                try {
                    final TileEntityShulkerBox X = (TileEntityShulkerBox)tileEntity;
                    final float a = tileEntity.func_174877_v().func_177958_n() - (float)SchalkerESP.mc.func_175598_ae().field_78730_l;
                    final float b = tileEntity.func_174877_v().func_177956_o() - (float)SchalkerESP.mc.func_175598_ae().field_78731_m;
                    final float c = tileEntity.func_174877_v().func_177952_p() - (float)SchalkerESP.mc.func_175598_ae().field_78728_n;
                    GlStateManager.func_179094_E();
                    GlStateManager.func_179090_x();
                    GlStateManager.func_179097_i();
                    GL11.glTranslated((double)a, (double)b, (double)c);
                    final float[] F = X.func_190592_s().func_193349_f();
                    final Divine instance2 = Divine.instance;
                    if (Divine.settingsManager.getSettingByName(this, "ColorShalker").getValBoolean()) {
                        GL11.glColor4f(F[0], F[1], F[2], 0.11f);
                        GL11.glBegin(7);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72339_c);
                        GL11.glEnd();
                    }
                    else {
                        GlStateManager.func_187441_d(2.0f);
                        GL11.glColor4f(F[0], F[1], F[2], 1.0f);
                        GL11.glBegin(3);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72339_c);
                        GL11.glEnd();
                        GL11.glBegin(3);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72339_c);
                        GL11.glEnd();
                        GL11.glBegin(1);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72339_c);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72336_d, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72338_b, Block.field_185505_j.field_72334_f);
                        GL11.glVertex3d(Block.field_185505_j.field_72340_a, Block.field_185505_j.field_72337_e, Block.field_185505_j.field_72334_f);
                        GL11.glEnd();
                    }
                    GlStateManager.func_179098_w();
                    GlStateManager.func_179126_j();
                    GlStateManager.func_179121_F();
                    GlStateManager.func_179117_G();
                }
                catch (Exception ex) {}
            }
        }
    }
}
