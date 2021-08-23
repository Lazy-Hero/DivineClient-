import me.Divine.Divine;
import me.Divine.utils.MTSQL;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.Mod;

// 
// Decompiled by Procyon v0.5.36
// 

@Mod(modid = "divine", version = "b0.1")
public class Main
{
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        if (MTSQL.isOnBase()) {
            Divine.instance = new Divine();
        }
        else {
            MTSQL.shotdown();
        }
        Divine.instance.init();
    }
}
