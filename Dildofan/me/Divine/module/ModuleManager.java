// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.module;

import java.util.Iterator;
import me.Divine.module.movement.Fly;
import me.Divine.module.movement.Jesus;
import me.Divine.module.combat.wTap;
import me.Divine.module.player.NoClip;
import me.Divine.module.render.FreeCam;
import me.Divine.module.combat.Criticals;
import me.Divine.module.movement.NoSlowdown;
import me.Divine.module.player.NoPush;
import me.Divine.module.render.Crown;
import me.Divine.module.render.Footprints;
import me.Divine.module.render.Inventory;
import me.Divine.module.player.MiddleClickPearl;
import me.Divine.module.render.SchalkerESP;
import me.Divine.module.render.EnderChestESP;
import me.Divine.module.render.ChestESP;
import me.Divine.module.misc.AutoRespawn;
import me.Divine.module.movement.InvWalk;
import me.Divine.module.player.FakePlayer;
import me.Divine.module.movement.AutoParkour;
import me.Divine.module.player.Derp;
import me.Divine.module.render.BlockOverlay;
import me.Divine.module.combat.Velocity;
import me.Divine.module.movement.AntiWeb;
import me.Divine.module.misc.NoChat;
import me.Divine.module.render.PlayerESP;
import me.Divine.module.misc.Daytime;
import me.Divine.module.combat.AutoTotem;
import me.Divine.module.combat.TriggerBot;
import me.Divine.module.render.NoHurtCam;
import me.Divine.module.render.Gamma;
import me.Divine.module.player.AutoGApple;
import me.Divine.module.combat.HitBox;
import me.Divine.module.combat.BowSpam;
import me.Divine.module.misc.Panic;
import me.Divine.module.movement.Sprint;
import me.Divine.module.render.HUD;
import me.Divine.module.render.ClickGUI;
import java.util.ArrayList;

public class ModuleManager
{
    public static ArrayList<Module> modules;
    
    public ModuleManager() {
        (ModuleManager.modules = new ArrayList<Module>()).clear();
        ModuleManager.modules.add(new ClickGUI());
        ModuleManager.modules.add(new HUD());
        ModuleManager.modules.add(new Sprint());
        ModuleManager.modules.add(new Panic());
        ModuleManager.modules.add(new BowSpam());
        ModuleManager.modules.add(new HitBox());
        ModuleManager.modules.add(new AutoGApple());
        ModuleManager.modules.add(new Gamma());
        ModuleManager.modules.add(new NoHurtCam());
        ModuleManager.modules.add(new TriggerBot());
        ModuleManager.modules.add(new AutoTotem());
        ModuleManager.modules.add(new Daytime());
        ModuleManager.modules.add(new PlayerESP());
        ModuleManager.modules.add(new NoChat());
        ModuleManager.modules.add(new AntiWeb());
        ModuleManager.modules.add(new Velocity());
        ModuleManager.modules.add(new BlockOverlay());
        ModuleManager.modules.add(new Derp());
        ModuleManager.modules.add(new AutoParkour());
        ModuleManager.modules.add(new FakePlayer());
        ModuleManager.modules.add(new InvWalk());
        ModuleManager.modules.add(new AutoRespawn());
        ModuleManager.modules.add(new ChestESP());
        ModuleManager.modules.add(new EnderChestESP());
        ModuleManager.modules.add(new SchalkerESP());
        ModuleManager.modules.add(new MiddleClickPearl());
        ModuleManager.modules.add(new Inventory());
        ModuleManager.modules.add(new Footprints());
        ModuleManager.modules.add(new Crown());
        ModuleManager.modules.add(new NoPush());
        ModuleManager.modules.add(new NoSlowdown());
        ModuleManager.modules.add(new Criticals());
        ModuleManager.modules.add(new FreeCam());
        ModuleManager.modules.add(new NoClip());
        ModuleManager.modules.add(new wTap());
        ModuleManager.modules.add(new Killaura());
        ModuleManager.modules.add(new Jesus());
        ModuleManager.modules.add(new Fly());
    }
    
    public Module getModule(final String name) {
        for (final Module m : ModuleManager.modules) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }
    
    public ArrayList<Module> getModuleList() {
        return ModuleManager.modules;
    }
    
    public ArrayList<Module> getModulesInCategory(final Category c) {
        final ArrayList<Module> mods = new ArrayList<Module>();
        for (final Module m : ModuleManager.modules) {
            if (m.getCategory() == c) {
                mods.add(m);
            }
        }
        return mods;
    }
    
    public static Module getModuleByName(final String string) {
        for (final Object modulew : ModuleManager.modules) {
            final Module module = (Module)modulew;
            if (module.name != string) {
                continue;
            }
            return module;
        }
        return null;
    }
}
