// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.utils.system;

import java.lang.reflect.Constructor;
import net.minecraftforge.fml.common.eventhandler.ASMEventHandler;
import net.minecraftforge.fml.common.eventhandler.Event;
import java.util.Iterator;
import java.lang.reflect.Method;
import java.util.Set;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.eventhandler.IEventListener;
import java.util.ArrayList;
import java.lang.annotation.Annotation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import com.google.common.reflect.TypeToken;
import net.minecraftforge.fml.common.Loader;
import java.util.Map;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraftforge.fml.common.eventhandler.EventBus;

public class Nan0EventRegister
{
    public static void register(final EventBus bus, final Object target) {
        final ConcurrentHashMap<Object, ArrayList<IEventListener>> listeners = (ConcurrentHashMap<Object, ArrayList<IEventListener>>)ReflectionHelper.getPrivateValue((Class)EventBus.class, (Object)bus, new String[] { "listeners" });
        final Map<Object, ModContainer> listenerOwners = (Map<Object, ModContainer>)ReflectionHelper.getPrivateValue((Class)EventBus.class, (Object)bus, new String[] { "listenerOwners" });
        if (listeners.containsKey(target)) {
            return;
        }
        final ModContainer activeModContainer = (ModContainer)Loader.instance().getMinecraftModContainer();
        listenerOwners.put(target, activeModContainer);
        ReflectionHelper.setPrivateValue((Class)EventBus.class, (Object)bus, (Object)listenerOwners, new String[] { "listenerOwners" });
        final Set<? extends Class<?>> supers = (Set<? extends Class<?>>)TypeToken.of((Class)target.getClass()).getTypes().rawTypes();
        for (final Method method : target.getClass().getMethods()) {
            for (final Class<?> cls : supers) {
                try {
                    final Method real = cls.getDeclaredMethod(method.getName(), method.getParameterTypes());
                    if (real.isAnnotationPresent((Class<? extends Annotation>)SubscribeEvent.class)) {
                        final Class<?>[] parameterTypes = method.getParameterTypes();
                        final Class<?> eventType = parameterTypes[0];
                        register(bus, eventType, target, method, activeModContainer);
                        break;
                    }
                    continue;
                }
                catch (NoSuchMethodException ex) {}
            }
        }
    }
    
    private static void register(final EventBus bus, final Class<?> eventType, final Object target, final Method method, final ModContainer owner) {
        try {
            final int busID = (int)ReflectionHelper.getPrivateValue((Class)EventBus.class, (Object)bus, new String[] { "busID" });
            final ConcurrentHashMap<Object, ArrayList<IEventListener>> listeners = (ConcurrentHashMap<Object, ArrayList<IEventListener>>)ReflectionHelper.getPrivateValue((Class)EventBus.class, (Object)bus, new String[] { "listeners" });
            final Constructor<?> ctr = eventType.getConstructor((Class<?>[])new Class[0]);
            ctr.setAccessible(true);
            final Event event = (Event)ctr.newInstance(new Object[0]);
            final ASMEventHandler listener = new ASMEventHandler(target, method, owner);
            event.getListenerList().register(busID, listener.getPriority(), (IEventListener)listener);
            ArrayList<IEventListener> others = listeners.get(target);
            if (others == null) {
                others = new ArrayList<IEventListener>();
                listeners.put(target, others);
                ReflectionHelper.setPrivateValue((Class)EventBus.class, (Object)bus, (Object)listeners, new String[] { "listeners" });
            }
            others.add((IEventListener)listener);
        }
        catch (Exception ex) {}
    }
}
