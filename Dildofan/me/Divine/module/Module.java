// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module;

import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraft.network.Packet;
import me.Divine.value.ASD;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.common.MinecraftForge;
import java.util.List;
import me.Divine.value.Value;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;

public class Module
{
    protected static Minecraft mc;
    private ArrayList<Value> values;
    public String name;
    public List settings;
    protected boolean isEnabled;
    private String description;
    private int key;
    Category category;
    public boolean toggled;
    public boolean visible;
    private boolean enabled;
    public String suff;
    
    public Module(final String name, final String description, final Category category) {
        this.values = new ArrayList<Value>();
        this.settings = new ArrayList();
        this.visible = true;
        this.name = name;
        this.description = description;
        this.key = 0;
        this.category = category;
        this.toggled = false;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }
    
    public int getKey() {
        return this.key;
    }
    
    public void setKey(final int key) {
        this.key = key;
    }
    
    public boolean isToggled() {
        return this.toggled;
    }
    
    public void setToggled(final boolean toggled) {
        this.toggled = toggled;
        if (this.toggled) {
            this.onEnable();
        }
        else {
            this.onDisable();
        }
    }
    
    public void toggle() {
        this.toggled = !this.toggled;
        if (this.toggled) {
            this.onEnable();
        }
        else {
            this.onDisable();
        }
    }
    
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register((Object)this);
    }
    
    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister((Object)this);
    }
    
    public String getName() {
        if (this.suff == null) {
            return this.name;
        }
        return this.name + " &f" + this.suff;
    }
    
    public String getName2() {
        return this.name;
    }
    
    public Category getCategory() {
        return this.category;
    }
    
    public void onClientTick(final TickEvent.ClientTickEvent event) {
    }
    
    public void onUpdate() {
    }
    
    public void onRenderWorldLast(final RenderWorldLastEvent event) {
    }
    
    public void onRenderWorldLast(final float f) {
    }
    
    public boolean isEnabled() {
        return this.enabled;
    }
    
    public boolean getState() {
        return this.isEnabled;
    }
    
    public boolean onPacket(final Object packet, final ASD.Side side) {
        return true;
    }
    
    protected void sendPacket(final Packet packet) {
        Module.mc.func_147114_u().func_147297_a(packet);
    }
    
    public void onCameraSetup(final EntityViewRenderEvent.CameraSetup event) {
    }
    
    static {
        Module.mc = Minecraft.func_71410_x();
    }
}
