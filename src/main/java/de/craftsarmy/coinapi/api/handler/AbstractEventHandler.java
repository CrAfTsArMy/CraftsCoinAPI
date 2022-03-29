package de.craftsarmy.coinapi.api.handler;

import de.craftsarmy.coinapi.api.player.CoinPlayer;
import de.craftsarmy.coinapi.api.events.EventType;

public abstract class AbstractEventHandler {

    public abstract void trigger(CoinPlayer player, EventType type);

}
