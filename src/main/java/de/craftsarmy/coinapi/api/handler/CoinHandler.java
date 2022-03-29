package de.craftsarmy.coinapi.api.handler;

import de.craftsarmy.coinapi.CoinAPI;
import de.craftsarmy.coinapi.api.events.EventType;
import de.craftsarmy.coinapi.api.player.CoinPlayer;

public final class CoinHandler extends AbstractCoinHandler {

    @Override
    public void addCoins(CoinPlayer player, long amount) {
        CoinAPI.api().getCoinConfig().setCoins(player, (CoinAPI.api().getCoinConfig().getCoins(player) + amount));
        CoinAPI.api().getEventHandler().trigger(player, EventType.SET);
    }

    @Override
    public void removeCoins(CoinPlayer player, long amount) {
        CoinAPI.api().getCoinConfig().setCoins(player, (CoinAPI.api().getCoinConfig().getCoins(player) - amount));
        CoinAPI.api().getEventHandler().trigger(player, EventType.SET);
    }

    @Override
    public void setCoins(CoinPlayer player, long amount) {
        CoinAPI.api().getCoinConfig().setCoins(player, amount);
        CoinAPI.api().getEventHandler().trigger(player, EventType.SET);
    }

    @Override
    public void clearCoins(CoinPlayer player) {
        CoinAPI.api().getCoinConfig().setCoins(player, 0);
        CoinAPI.api().getEventHandler().trigger(player, EventType.CLEAR);
    }

}
