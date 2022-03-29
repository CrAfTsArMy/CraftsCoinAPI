package de.craftsarmy.coinapi.api.config;

import de.craftsarmy.coinapi.api.player.CoinPlayer;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public abstract class AbstractConfig {

    File file;
    YamlConfiguration configuration;

    public abstract void load(String path, String file, ConfigCreateConsumer consumer);
    public abstract void setCoins(CoinPlayer player, long amount);
    public abstract long getCoins(CoinPlayer player);
    public abstract void save();

}
