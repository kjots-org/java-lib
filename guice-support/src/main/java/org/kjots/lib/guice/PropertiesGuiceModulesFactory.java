/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.guice;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import com.google.inject.Module;

/**
 * Properties Guice Modules Factory.
 * <p>
 * Created: 27th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 99-SNAPSHOT
 */
public class PropertiesGuiceModulesFactory extends GuiceModulesFactory {
  /** The name of the guice modules properties. */
  public static final String GUICE_MODULES_PROPERTY_NAME = "guiceModules";
  
  /** The properties. */
  private final Properties properties;
  
  /**
   * Construct a new Properties Guice Modules Factory.
   *
   * @param properties The properties.
   */
  public PropertiesGuiceModulesFactory(Properties properties) {
    this.properties = (Properties)properties.clone();
  }

  /**
   * Retrieve the Guice modules.
   *
   * @return The Guice modules.
   */
  @Override
  public Collection<Module> getGuiceModules() {
    Map<String, Module> guiceModules = new LinkedHashMap<String, Module>();
    
    for (String guiceModuleClassName : this.properties.getProperty(GUICE_MODULES_PROPERTY_NAME).split(",")) {
      guiceModuleClassName = guiceModuleClassName.trim();
      
      if (!guiceModules.containsKey(guiceModuleClassName)) {
        Module guiceModule = this.createGuiceModule(guiceModuleClassName);
        
        this.setGuiceModuleProperties(guiceModule);
        
        guiceModules.put(guiceModuleClassName, guiceModule);
      }
    }
    
    return guiceModules.values();
  }
  
  /**
   * Set the properties of the given Guice module.
   *
   * @param guiceModule The Guice module.
   */
  private void setGuiceModuleProperties(Module guiceModule) {
    String propertyNamePrefix = guiceModule.getClass().getName() + ".";
    
    for (Object key : this.properties.keySet()) {
      String propertyName = (String)key;
      
      if (propertyName.startsWith(propertyNamePrefix)) {
        this.setGuiceModuleProperty(guiceModule, propertyName.substring(propertyNamePrefix.length()), this.properties.getProperty(propertyName));
      }
    }
  }
}
