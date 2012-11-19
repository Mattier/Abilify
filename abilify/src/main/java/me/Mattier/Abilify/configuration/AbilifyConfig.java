package me.Mattier.Abilify.configuration;

import java.io.File;

import org.spout.api.exception.ConfigurationException;
import org.spout.api.util.config.ConfigurationHolder;
import org.spout.api.util.config.ConfigurationHolderConfiguration;
import org.spout.api.util.config.yaml.YamlConfiguration;

public class AbilifyConfig extends ConfigurationHolderConfiguration {
	// Server config
	public static final ConfigurationHolder H2_DATABASE = new ConfigurationHolder("h2.database", "server", "h2");
	
	/*
	public static final ConfigurationHolder HOST = new ConfigurationHolder("127.0.0.1", "server", "host");
	public static final ConfigurationHolder PORT = new ConfigurationHolder(25565, "server", "port");
	public static final ConfigurationHolder DATABASE = new ConfigurationHolder("database name", "database", "name");
	public static final ConfigurationHolder USER = new ConfigurationHolder("database user", "database", "user");
	public static final ConfigurationHolder PASSWORD = new ConfigurationHolder("database password", "database", "password");
	*/
	
	public AbilifyConfig(File dataFolder) {
		super(new YamlConfiguration(new File(dataFolder, "config.yml")));
	}

	@Override
	public void load() throws ConfigurationException {
		super.load();
		super.save();
	}
}
