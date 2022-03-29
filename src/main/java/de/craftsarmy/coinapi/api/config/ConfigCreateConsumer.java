package de.craftsarmy.coinapi.api.config;

import org.bukkit.configuration.file.YamlConfiguration;

public interface ConfigCreateConsumer {

    void consume(YamlConfiguration configuration);

}
