/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.guice;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import com.google.inject.Module;

/**
 * Guice Modules Factory.
 * <p>
 * Created: 27th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public abstract class GuiceModulesFactory {
  /**
   * Retrieve the Guice modules.
   *
   * @return The Guice modules.
   */
  public abstract Collection<Module> getGuiceModules();
  
  /**
   * Create an instance of the Guice module with class with the given name.
   *
   * @param className The name of the class of the Guice module.
   * @return The Guice module.
   */
  protected Module createGuiceModule(String className) {
    try {
      return Class.forName(className).asSubclass(Module.class).newInstance();
    }
    catch (ClassNotFoundException cnfe) {
      throw new IllegalArgumentException(className, cnfe);
    }
    catch (IllegalAccessException iae) {
      throw new IllegalArgumentException(className, iae);
    }
    catch (InstantiationException ie) {
      throw new IllegalArgumentException(className, ie);
    }
  }
  
  /**
   * Set the property of the given Guice module with the given name to the
   * given value.
   * <p>
   * This method will ignore any checked exception that results from the
   * attempt to set the property value.
   *
   * @param guiceModule The Guice module.
   * @param propertyName The name of the property.
   * @param propertyValue The value of the property.
   */
  protected void setGuiceModuleProperty(Module guiceModule, String propertyName, String propertyValue) {
    String methodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
    
    try {
      guiceModule.getClass().getMethod(methodName, String.class).invoke(guiceModule, propertyValue);
    }
    catch (NoSuchMethodException nsme) {
    }
    catch (IllegalAccessException iae) {
    }
    catch (InvocationTargetException ite) {
    }
  }
}
