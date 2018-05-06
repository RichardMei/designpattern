package com.richard.observer;

/*
 * 观察者模式定义了对象之间的一对多依赖，这样一来，当一个对象改变状态时，
 * 它的所有依赖者都会受到通知并自动更新
 */
public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
