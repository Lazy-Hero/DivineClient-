// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.render;

import org.lwjgl.opengl.GL11;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.math.BlockPos;
import me.Divine.utils.visual.RenderUtils;
import net.minecraft.block.Block;
import java.awt.Color;
import me.Divine.utils.BlockUtils;
import net.minecraft.util.math.RayTraceResult;
import me.Divine.wrappers.Wrapper;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class BlockOverlay extends Module
{
    private int color;
    
    public BlockOverlay() {
        super("BlockOverlay", "", Category.RENDER);
    }
    
    @Override
    public String getDescription() {
        return "Show";
    }
    
    @SubscribeEvent
    @Override
    public void onRenderWorldLast(final RenderWorldLastEvent event) {
        if (Wrapper.INSTANCE.mc().field_71476_x == null) {
            return;
        }
        if (Wrapper.INSTANCE.mc().field_71476_x.field_72313_a == RayTraceResult.Type.BLOCK) {
            final Block block = BlockUtils.getBlock(Wrapper.INSTANCE.mc().field_71476_x.func_178782_a());
            final BlockPos blockPos = Wrapper.INSTANCE.mc().field_71476_x.func_178782_a();
            glColor(new Color(255, 0, 0).getRGB());
            if (Block.func_149682_b(block) == 1) {
                return;
            }
            RenderUtils.drawBlockESP(blockPos, 1.0f, 4.0f, 1.0f);
        }
        super.onRenderWorldLast(event);
    }
    
    public static int rainbow(final int delay, final long index) {
        double rainbowState = Math.ceil((double)(System.currentTimeMillis() + index + delay)) / 15.0;
        rainbowState %= 360.0;
        return Color.getHSBColor((float)(rainbowState / 360.0), 0.4f, 1.0f).getRGB();
    }
    
    public static void glColor(final int hex) {
        final float alpha = (hex >> 24 & 0xFF) / 255.0f;
        final float red = (hex >> 16 & 0xFF) / 255.0f;
        final float green = (hex >> 8 & 0xFF) / 255.0f;
        final float blue = (hex & 0xFF) / 255.0f;
        GL11.glColor4f(red, green, blue, alpha);
    }
}
