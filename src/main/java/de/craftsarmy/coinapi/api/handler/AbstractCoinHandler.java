package de.craftsarmy.coinapi.api.handler;

import de.craftsarmy.coinapi.api.player.CoinPlayer;

public abstract class AbstractCoinHandler {

    public abstract void addCoins(CoinPlayer player, long amount);
    public abstract void removeCoins(CoinPlayer player, long amount);
    public abstract void setCoins(CoinPlayer player, long amount);
    public abstract void clearCoins(CoinPlayer player);

}
