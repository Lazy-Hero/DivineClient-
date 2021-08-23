// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.player;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import org.lwjgl.input.Mouse;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class MiddleClickPearl extends Module
{
    private boolean clicked;
    
    public MiddleClickPearl() {
        super("MiddleClickPearl", "", Category.PLAYER);
    }
    
    @SubscribeEvent
    public void onUpdate(final TickEvent.ClientTickEvent event) {
        if (MiddleClickPearl.mc.field_71439_g == null || MiddleClickPearl.mc.field_71441_e == null) {
            return;
        }
        if (MiddleClickPearl.mc.field_71462_r == null) {
            if (Mouse.isButtonDown(2)) {
                if (!this.clicked) {
                    final RayTraceResult result = MiddleClickPearl.mc.field_71476_x;
                    if (result != null && result.field_72313_a == RayTraceResult.Type.MISS) {
                        final int pearlSlot = this.findPearlInHotbar(MiddleClickPearl.mc);
                        if (pearlSlot != -1) {
                            final int oldSlot = MiddleClickPearl.mc.field_71439_g.field_71071_by.field_70461_c;
                            MiddleClickPearl.mc.field_71439_g.field_71071_by.field_70461_c = pearlSlot;
                            MiddleClickPearl.mc.field_71442_b.func_187101_a((EntityPlayer)MiddleClickPearl.mc.field_71439_g, (World)MiddleClickPearl.mc.field_71441_e, EnumHand.MAIN_HAND);
                            MiddleClickPearl.mc.field_71439_g.field_71071_by.field_70461_c = oldSlot;
                        }
                        else {
                            Minecraft.func_71410_x().field_71439_g.func_145747_a((ITextComponent)new TextComponentString(ChatFormatting.GOLD + "Can't find pearl in hotbar!"));
                        }
                    }
                }
                this.clicked = true;
            }
            else {
                this.clicked = false;
            }
        }
    }
    
    private boolean isItemStackPearl(final ItemStack itemStack) {
        return itemStack.func_77973_b() instanceof ItemEnderPearl;
    }
    
    private int findPearlInHotbar(final Minecraft mc) {
        for (int index = 0; InventoryPlayer.func_184435_e(index); ++index) {
            if (this.isItemStackPearl(mc.field_71439_g.field_71071_by.func_70301_a(index))) {
                return index;
            }
        }
        return -1;
    }
}
