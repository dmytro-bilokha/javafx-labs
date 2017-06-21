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
    private Map<StEvent.Type, Set<WeakReference<StEventListener>>> listenersMap
            = new EnumMap<>(StEvent.Type.class);

    public void subscribe(StEvent.Type type, StEventListener observer) {
        listenersMap.computeIfAbsent(type, eventType -> new HashSet<>());
        Set<WeakReference<StEventListener>> registeredListeners = listenersMap.get(type);
        removeDeadListeners(registeredListeners);
        registeredListeners.add(new WeakReference<>(observer));
    }

    private void removeDeadListeners(Collection<WeakReference<StEventListener>> listeners) {
        Iterator<WeakReference<StEventListener>> listenersIterator = listeners.iterator();
        while (listenersIterator.hasNext()) {
            getNextListenerOrNullAndDropDead(listenersIterator);
        }
    }

    private StEventListener getNextListenerOrNullAndDropDead(Iterator<WeakReference<StEventListener>> listenersIterator) {
        StEventListener listener = listenersIterator.next().get();
        if (listener == null)
            listenersIterator.remove();
        return listener;
    }

    public int fire(StEvent event) {
        if (initThread != Thread.currentThread())
            throw new IllegalStateException("Event bus has been initialized from thread '" +  initThread
                        + "', but event is fired from another thread '" + Thread.currentThread() + '\'');
        Set<WeakReference<StEventListener>> registeredListeners = listenersMap.get(event.getType());
        if (registeredListeners == null)
            return 0;
        int notifiedListeners = 0;
        Iterator<WeakReference<StEventListener>> listenersIterator = registeredListeners.iterator();
        while (listenersIterator.hasNext()) {
            StEventListener listener = getNextListenerOrNullAndDropDead(listenersIterator);
            if (listener != null) {
                listener.onStEvent(event);
                notifiedListeners++;
            }
        }
        return notifiedListeners;
    }

}
