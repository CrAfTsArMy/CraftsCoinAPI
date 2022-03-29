package de.craftsarmy.coinapi.api.handler;

import de.craftsarmy.coinapi.api.player.CoinPlayer;
import de.craftsarmy.coinapi.api.classes.Touch;
import de.craftsarmy.coinapi.api.events.EventType;
import de.craftsarmy.coinapi.api.events.IEvent;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class EventHandler extends AbstractEventHandler {

    private final ConcurrentHashMap<Class<? extends IEvent>, IEvent> events = new ConcurrentHashMap<>();
    private final Touch<IEvent> touch = new Touch<>();

    @Override
    public void trigger(CoinPlayer player, EventType type) {
        ConcurrentLinkedQueue<IEvent> to = new ConcurrentLinkedQueue<>();
        for (Class<? extends IEvent> clazz : events.keySet())
            to.add(events.get(clazz));
        switch (type) {
            case GENERIC:
                to.forEach(e -> e.onGenericUpdate(player));
                break;
            case ADD:
                to.forEach(e -> e.onCoinsAdd(player));
                break;
            case REMOVE:
                to.forEach(e -> e.onCoinsRemove(player));
                break;
            case CLEAR:
                to.forEach(e -> e.onCoinsClear(player));
                break;
        }
    }

    public void register(Class<? extends IEvent> clazz) {
        try {
            events.put(clazz, touch.touch(clazz));
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void unregister(Class<? extends IEvent> clazz) {
        events.remove(clazz);
    }

}
