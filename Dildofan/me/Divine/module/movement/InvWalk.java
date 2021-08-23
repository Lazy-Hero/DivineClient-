// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module.movement;

import org.lwjgl.input.Keyboard;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import me.Divine.module.Category;
import me.Divine.module.Module;

public class InvWalk extends Module
{
    public InvWalk() {
        super("InvWalk", "InvWalk", Category.MOVEMENT);
    }
    
    @SubscribeEvent
    @Override
    public void onClientTick(final TickEvent.ClientTickEvent event) {
        if (!(InvWalk.mc.field_71462_r instanceof GuiContainer)) {
            return;
        }
        if (InvWalk.mc.field_71439_g.func_70090_H()) {
            return;
        }
        double speed = 0.05;
        if (!InvWalk.mc.field_71439_g.field_70122_E) {
            speed /= 4.0;
        }
        this.handleJump();
        this.handleForward(speed);
        if (!InvWalk.mc.field_71439_g.field_70122_E) {
            speed /= 2.0;
        }
        this.handleBack(speed);
        this.handleLeft(speed);
        this.handleRight(speed);
    }
    
    void moveForward(final double speed) {
        final float direction = this.getDirection();
        final EntityPlayerSP field_71439_g;
        final EntityPlayerSP player = field_71439_g = InvWalk.mc.field_71439_g;
        field_71439_g.field_70159_w -= MathHelper.func_76126_a(direction) * speed;
        final EntityPlayerSP field_71439_g2;
        final EntityPlayerSP player2 = field_71439_g2 = InvWalk.mc.field_71439_g;
        field_71439_g2.field_70179_y += MathHelper.func_76134_b(direction) * speed;
    }
    
    void moveBack(final double speed) {
        final float direction = this.getDirection();
        final EntityPlayerSP field_71439_g;
        final EntityPlayerSP player = field_71439_g = InvWalk.mc.field_71439_g;
        field_71439_g.field_70159_w += MathHelper.func_76126_a(direction) * speed;
        final EntityPlayerSP field_71439_g2;
        final EntityPlayerSP player2 = field_71439_g2 = InvWalk.mc.field_71439_g;
        field_71439_g2.field_70179_y -= MathHelper.func_76134_b(direction) * speed;
    }
    
    void moveLeft(final double speed) {
        final float direction = this.getDirection();
        final EntityPlayerSP field_71439_g;
        final EntityPlayerSP player = field_71439_g = InvWalk.mc.field_71439_g;
        field_71439_g.field_70179_y += MathHelper.func_76126_a(direction) * speed;
        final EntityPlayerSP field_71439_g2;
        final EntityPlayerSP player2 = field_71439_g2 = InvWalk.mc.field_71439_g;
        field_71439_g2.field_70159_w += MathHelper.func_76134_b(direction) * speed;
    }
    
    void moveRight(final double speed) {
        final float direction = this.getDirection();
        final EntityPlayerSP field_71439_g;
        final EntityPlayerSP player = field_71439_g = InvWalk.mc.field_71439_g;
        field_71439_g.field_70179_y -= MathHelper.func_76126_a(direction) * speed;
        final EntityPlayerSP field_71439_g2;
        final EntityPlayerSP player2 = field_71439_g2 = InvWalk.mc.field_71439_g;
        field_71439_g2.field_70159_w -= MathHelper.func_76134_b(direction) * speed;
    }
    
    void handleForward(final double speed) {
        InvWalk.mc.field_71439_g.func_70031_b(true);
        if (!Keyboard.isKeyDown(InvWalk.mc.field_71474_y.field_74351_w.func_151463_i())) {
            return;
        }
        this.moveForward(speed);
    }
    
    void handleBack(final double speed) {
        if (!Keyboard.isKeyDown(InvWalk.mc.field_71474_y.field_74368_y.func_151463_i())) {
            return;
        }
        this.moveBack(speed);
    }
    
    void handleLeft(final double speed) {
        InvWalk.mc.field_71439_g.func_70031_b(true);
        if (!Keyboard.isKeyDown(InvWalk.mc.field_71474_y.field_74370_x.func_151463_i())) {
            return;
        }
        this.moveLeft(speed * 0.8);
    }
    
    void handleRight(final double speed) {
        InvWalk.mc.field_71439_g.func_70031_b(true);
        if (!Keyboard.isKeyDown(InvWalk.mc.field_71474_y.field_74366_z.func_151463_i())) {
            return;
        }
        this.moveRight(speed * 0.8);
    }
    
    void handleJump() {
        if (InvWalk.mc.field_71439_g.field_70122_E && Keyboard.isKeyDown(InvWalk.mc.field_71474_y.field_74314_A.func_151463_i())) {
            InvWalk.mc.field_71439_g.func_70664_aZ();
        }
    }
    
    public float getDirection() {
        float var1 = InvWalk.mc.field_71439_g.field_70177_z;
        if (InvWalk.mc.field_71439_g.field_191988_bg < 0.0f) {
            var1 += 180.0f;
        }
        float forward = 1.0f;
        if (InvWalk.mc.field_71439_g.field_191988_bg < 0.0f) {
            forward = -0.5f;
        }
        else if (InvWalk.mc.field_71439_g.field_191988_bg > 0.0f) {
            forward = 0.5f;
        }
        if (InvWalk.mc.field_71439_g.field_70702_br > 0.0f) {
            var1 -= 90.0f * forward;
        }
        if (InvWalk.mc.field_71439_g.field_70702_br < 0.0f) {
            var1 += 90.0f * forward;
        }
        var1 *= 0.017453292f;
        return var1;
    }
}
