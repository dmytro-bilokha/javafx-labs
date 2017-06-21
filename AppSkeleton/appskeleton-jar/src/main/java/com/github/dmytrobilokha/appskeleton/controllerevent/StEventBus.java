package com.github.dmytrobilokha.appskeleton.controllerevent;

import javax.enterprise.context.ApplicationScoped;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@ApplicationScoped
public class StEventBus {

    private Thread initThread = Thread.currentThread();
    private Map<StEvent.Type, Set<StEventListener>> listenersMap
            = new EnumMap<>(StEvent.Type.class);

    public void subscribe(StEvent.Type type, StEventListener listener) {
        listenersMap.computeIfAbsent(type, eventType -> new HashSet<>()).add(listener);
    }

    public int fire(StEvent event) {
        if (initThread != Thread.currentThread())
            throw new IllegalStateException("Event bus has been initialized from thread '" +  initThread
                        + "', but event is fired from another thread '" + Thread.currentThread() + '\'');
        Set<StEventListener> registeredListeners = listenersMap.get(event.getType());
        if (registeredListeners == null)
            return 0;
        int notifiedListeners = 0;
        for (StEventListener listener : registeredListeners) {
            listener.onStEvent(event);
            notifiedListeners++;
        }
        return notifiedListeners;
    }

    public void unsubscribe(StEventListener listener) {
        for (Set<StEventListener> listeners : listenersMap.values()) {
            listeners.remove(listener);
        }
    }

}
