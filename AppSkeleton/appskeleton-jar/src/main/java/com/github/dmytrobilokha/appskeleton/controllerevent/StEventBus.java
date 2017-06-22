package com.github.dmytrobilokha.appskeleton.controllerevent;

import javax.enterprise.context.ApplicationScoped;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@ApplicationScoped
public class StEventBus {

    private Set<StEventListener> testSet = new HashSet<>();
    private Thread initThread = Thread.currentThread();
    private Map<StEvent.Type, Set<Reference<StEventListener>>> listenersMap
            = new EnumMap<>(StEvent.Type.class);

    public void subscribe(StEvent.Type type, StEventListener listener) {
        listenersMap.computeIfAbsent(type, eventType -> new HashSet<>())
                .add(new WeakReference<>(listener));
        //testSet.add(listener);
    }

    public int fire(StEvent event) {
        if (initThread != Thread.currentThread())
            throw new IllegalStateException("Event bus has been initialized from thread '" +  initThread
                        + "', but event is fired from another thread '" + Thread.currentThread() + '\'');
        Set<Reference<StEventListener>> registeredListeners = listenersMap.get(event.getType());
        if (registeredListeners == null)
            return 0;
        int notifiedListeners = 0;
        for (Reference<StEventListener> listener : registeredListeners) {
            if (listener.get() != null) {
                listener.get().onStEvent(event);
                notifiedListeners++;
            }
        }
        return notifiedListeners;
    }

/*    public void unsubscribe(StEventListener listener) {
        for (Set<StEventListener> listeners : listenersMap.values()) {
            listeners.remove(listener);
        }
    }*/

}
