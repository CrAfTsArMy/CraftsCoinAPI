package de.craftsarmy.coinapi.api.events;

import de.craftsarmy.coinapi.api.player.CoinPlayer;

public interface IEvent {

    default void onGenericUpdate(CoinPlayer player) {}

    default void onCoinsAdd(CoinPlayer player) {}
    default void onCoinsRemove(CoinPlayer player) {}
    default void onCoinsSet(CoinPlayer player) {}
    default void onCoinsClear(CoinPlayer player) {}

}
