// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.render;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import java.util.Iterator;
import me.Divine.utils.visual.RenderUtils;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class EnderChestESP extends Module
{
    public EnderChestESP() {
        super("EdnerChestESP", "", Category.RENDER);
    }
    
    @SubscribeEvent
    public void render3D2(final RenderWorldLastEvent event) {
        for (final TileEntity chest : EnderChestESP.mc.field_71441_e.field_147482_g) {
            if (chest instanceof TileEntityEnderChest) {
                final double x = chest.func_174877_v().func_177958_n() - EnderChestESP.mc.func_175598_ae().field_78730_l;
                final double y = chest.func_174877_v().func_177956_o() - EnderChestESP.mc.func_175598_ae().field_78731_m;
                final double z = chest.func_174877_v().func_177952_p() - EnderChestESP.mc.func_175598_ae().field_78728_n;
                GlStateManager.func_179094_E();
                GlStateManager.func_179090_x();
                GlStateManager.func_179097_i();
                GlStateManager.func_179137_b(x, y, z);
                GlStateManager.func_187441_d(2.0f);
                GlStateManager.func_179124_c(75.0f, 0.0f, 0.0f);
                if (chest instanceof TileEntityEnderChest) {
                    GlStateManager.func_179124_c(0.2f, 0.1f, 165.0f);
                }
                RenderUtils.drawOutlinedBox(Block.field_185505_j);
                GlStateManager.func_179126_j();
                GlStateManager.func_179098_w();
                GlStateManager.func_179121_F();
            }
        }
    }
}
