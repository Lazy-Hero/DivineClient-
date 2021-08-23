// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module;

import net.minecraft.network.Packet;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;

public class Mod
{
    private String title;
    private String suffix;
    private Category category;
    private boolean enabled;
    protected Minecraft mc;
    private int key;
    
    public Mod(final String title, final Category category, final int key) {
        this.mc = Minecraft.func_71410_x();
        this.title = title;
        this.category = category;
        this.key = key;
    }
    
    public void worldRender() {
    }
    
    public void renderOverlay() {
    }
    
    public void updateLiving() {
    }
    
    public void update(final TickEvent.PlayerTickEvent e) {
    }
    
    protected void sendPacket(final Packet packet) {
        this.mc.func_147114_u().func_147297_a(packet);
    }
    
    public String toRender() {
        if (this.getSuffix() == null || this.getSuffix().length() < 1) {
            return this.title;
        }
        return this.title + " (" + this.replace(this.suffix) + ")";
    }
    
    private String replace(final String s) {
        return "";
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(final String title) {
        this.title = title;
    }
    
    public String getSuffix() {
        return this.suffix;
    }
    
    public void setSuffix(final String suffix) {
        this.suffix = suffix;
    }
    
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(final Category category) {
        this.category = category;
    }
    
    public int getKey() {
        return this.key;
    }
    
    public void setKey(final int key) {
        this.key = key;
    }
    
    public boolean isEnabled() {
        return this.enabled;
    }
    
    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }
    
    public void enable() {
    }
    
    public void disable() {
    }
    
    public void toggle() {
        this.setEnabled(!this.isEnabled());
        if (this.isEnabled()) {
            this.enable();
        }
        else {
            this.disable();
        }
    }
}
