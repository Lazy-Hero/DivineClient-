// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.Notification;

import me.Divine.Divine;
import org.lwjgl.opengl.GL11;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class Notification
{
    private final ScaledResolution resolution;
    private double x;
    private double y;
    private double oldX;
    private double oldY;
    private double width;
    private double stayBar;
    private boolean done;
    private int stayTime;
    private final String text;
    private final NotificationType type;
    private long time;
    
    public Notification(final NotificationType type, final String text, final int stayTime) {
        this.resolution = new ScaledResolution(Minecraft.func_71410_x());
        this.x = this.resolution.func_78326_a() - 2;
        this.y = this.resolution.func_78328_b() - 2;
        this.width = Minecraft.func_71410_x().field_71466_p.func_78256_a(text) + 8;
        this.text = text;
        this.stayTime = stayTime;
        this.stayBar = stayTime;
        this.type = type;
        this.done = false;
        this.time = 0L;
    }
    
    public void draw(final float prevY) {
        if (this.done) {
            this.oldX = this.x;
            ++this.x;
            ++this.y;
        }
        if (!this.getMinX() && !this.done) {
            this.reset();
            this.oldX = this.x;
            --this.x;
        }
        else if (this.hasTimePassed(this.stayTime)) {
            this.done = true;
        }
        if (this.x < this.resolution.func_78326_a() - 2 - this.width) {
            this.oldX = this.x;
            ++this.x;
        }
        if (this.y != prevY) {
            if (this.y > prevY) {
                this.oldY = this.y;
                --this.y;
            }
            else if (this.y < prevY) {
                this.oldY = this.y;
                ++this.y;
            }
        }
        if (this.getMinX() && !this.done) {
            this.stayBar = (float)(this.stayTime - this.getTime());
        }
        final double finishedX = this.oldX + (this.x - this.oldX);
        final double finishedY = this.oldY + (this.y - this.oldY);
        int color;
        if (this.type == NotificationType.INFO) {
            color = new Color(41, 46, 52, 220).getRGB();
        }
        else if (this.type == NotificationType.WARNING) {
            color = new Color(248, 252, 0, 255).getRGB();
        }
        else {
            color = new Color(255, 0, 0, 255).getRGB();
        }
        GL11.glPushMatrix();
        this.drawRect(2, finishedX, finishedY, finishedX + this.width, finishedY + 16.0, color);
        this.drawRect(7, finishedX, finishedY, finishedX + this.width, finishedY + 16.0, new Color(51, 56, 62, 200).brighter().getRGB());
        this.drawRect(7, finishedX + 0.5, finishedY + 0.5, finishedX + 3.0, finishedY + 15.5, color);
        Minecraft.func_71410_x().field_71466_p.func_175065_a(this.text, (float)((int)finishedX + 5), (float)((int)finishedY + 5), new Color(124, 208, 0).brighter().getRGB(), true);
        if (!this.getMinX() && !this.done) {
            this.drawRect(7, finishedX + 1.0, finishedY + 15.0, this.width, 1.0, color);
        }
        else {
            this.drawRect(7, finishedX + 1.0, finishedY + 14.5, (this.width - 1.0) / this.stayTime * this.stayBar, 1.0, color);
        }
        GL11.glPopMatrix();
        if (this.deleteMinX()) {
            Divine.instance.notificationManager.getNotifications().remove(this);
        }
    }
    
    private final void drawRect(final int mode, double left, double top, double right, double bottom, final int color) {
        if (left < right) {
            final double i = left;
            left = right;
            right = i;
        }
        if (top < bottom) {
            final double j = top;
            top = bottom;
            bottom = j;
        }
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glColor4f((color >> 16 & 0xFF) / 255.0f, (color >> 8 & 0xFF) / 255.0f, (color & 0xFF) / 255.0f, (color >> 24 & 0xFF) / 255.0f);
        if (mode != 7) {
            GL11.glLineWidth(2.0f);
        }
        GL11.glBegin(mode);
        GL11.glVertex2d(left, top);
        GL11.glVertex2d(left, bottom);
        GL11.glVertex2d(right, bottom);
        GL11.glVertex2d(right, top);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }
    
    public boolean getMinX() {
        return this.x <= this.resolution.func_78326_a() - 2 - this.width;
    }
    
    public boolean deleteMinX() {
        return this.x >= this.resolution.func_78326_a() - 2 && this.done;
    }
    
    public long getTime() {
        return System.nanoTime() / 1000000L - this.time;
    }
    
    public boolean hasTimePassed(final long time) {
        return this.getTime() >= time;
    }
    
    public void reset() {
        this.time = System.nanoTime() / 1000000L;
    }
}
