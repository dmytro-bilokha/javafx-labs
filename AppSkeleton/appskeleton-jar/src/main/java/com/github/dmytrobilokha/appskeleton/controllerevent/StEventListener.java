package com.github.dmytrobilokha.appskeleton.controllerevent;

@FunctionalInterface
public interface StEventListener<T> {

    void onStEvent(StEvent<T> stEvent);

}
