package de.craftsarmy.coinapi;

import de.craftsarmy.coinapi.api.config.AbstractConfig;
import de.craftsarmy.coinapi.api.config.Config;
import de.craftsarmy.coinapi.api.handler.AbstractCoinHandler;
import de.craftsarmy.coinapi.api.handler.AbstractEventHandler;
import de.craftsarmy.coinapi.api.handler.CoinHandler;
import de.craftsarmy.coinapi.api.handler.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class CoinAPI extends JavaPlugin {

    private static CoinAPI instance;

    private AbstractConfig config;
    private AbstractCoinHandler coinHandler;
    private AbstractEventHandler eventHandler;

    @Override
    public void onEnable() {
        instance = this;
        config = new Config();
        coinHandler = new CoinHandler();
        eventHandler = new EventHandler();
    }

    @Override
    public void onDisable() {
        instance = null;
        config = null;
        coinHandler = null;
        eventHandler = null;
    }

    public AbstractConfig getCoinConfig() {
        return config;
    }
    public void setCoinConfig(AbstractConfig config) {
        this.config = config;
    }
    public AbstractCoinHandler getCoinHandler() {
        return coinHandler;
    }
    public void setCoinHandler(AbstractCoinHandler coinHandler) {
        this.coinHandler = coinHandler;
    }
    public AbstractEventHandler getEventHandler() {
        return eventHandler;
    }
    public void setEventHandler(AbstractEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }
    public String makePretty(long amount) {
        return String.format("%,d", amount);
    }
    public static CoinAPI api() {
        return instance;
    }

}
