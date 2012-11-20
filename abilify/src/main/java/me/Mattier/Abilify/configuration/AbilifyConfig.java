package me.Mattier.Abilify.configuration;

import java.io.File;

import org.spout.api.exception.ConfigurationException;
import org.spout.api.util.config.ConfigurationHolderConfiguration;
import org.spout.api.util.config.yaml.YamlConfiguration;

/**
 * @see {@link org.spout.api.util.config.ConfigurationHolderConfiguration ConfigurationHolderConfiguration}
 */
public class AbilifyConfig extends ConfigurationHolderConfiguration {
	/*
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
