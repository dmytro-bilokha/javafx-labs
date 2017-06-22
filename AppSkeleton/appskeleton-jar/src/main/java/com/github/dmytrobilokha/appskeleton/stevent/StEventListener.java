package com.github.dmytrobilokha.appskeleton.stevent;

@FunctionalInterface
public interface StEventListener<T> {

    void onStEvent(StEvent<T> stEvent);

}
