/* 
 * Copyright © 2011 Karl J. Ots <kjots@kjots.org>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kjots.lib.webapp.guice;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.kjots.lib.guice.GuiceModulesFactory;
import org.kjots.lib.guice.PropertiesGuiceModulesFactory;

/**
 * Guice Servlet Context Listener.
 * <p>
 * Created: 27th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class GuiceServletContextListener extends com.google.inject.servlet.GuiceServletContextListener {
  /** The name of the properties locations initialisation parameter. */
  public static final String PROPERTIES_LOCATIONS_INIT_PARAMETER_NAME = GuiceServletContextListener.class.getName() + ".propertiesLocations";
  
  /** The name of the properties character set initialisation parameter. */
  public static final String PROPERTIES_CHARSET_INIT_PARAMETER_NAME = GuiceServletContextListener.class.getName() + ".propertiesCharset";
  
  /** The default properties locations. */
  private static final String DEFAULT_PROPERTIES_LOCATIONS = "/WEB-INF/guiceModules.properties /WEB-INF/guiceModules/";
  
  /** The default properties character set. */
  private static final String DEFAULT_PROPERTIES_CHARSET = "UTF-8";
  
  /** The servlet context thread local. */
  private static final ThreadLocal<WeakReference<ServletContext>> servletContextThreadLocal = new ThreadLocal<WeakReference<ServletContext>>();
  
  /**
   * Receive notification that the context has been initialised.
   *
   * @param servletContextEvent The servlet context event.
   */
  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    servletContextThreadLocal.set(new WeakReference<ServletContext>(servletContextEvent.getServletContext()));
    
    super.contextInitialized(servletContextEvent);
  }

  /**
   * Receive notification that the context has been destroyed.
   *
   * @param servletContextEvent The servlet context event.
   */
  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    super.contextDestroyed(servletContextEvent);
    
    servletContextThreadLocal.remove();
  }
  
  /**
   * Retrieve the injector.
   *
   * @return The injector.
   */
  @Override
  protected Injector getInjector() {
    ServletContext servletContext = servletContextThreadLocal.get().get();
    
    Properties properties = this.getGuiceModulesProperties(servletContext);
    GuiceModulesFactory factory = new PropertiesGuiceModulesFactory(properties);
    
    return Guice.createInjector(factory.getGuiceModules());
  }
  
  /**
   * Retrieve the properties locations.
   *
   * @param servletContext The servlet context.
   * @return The properties locations.
   */
  private String getPropertiesLocations(ServletContext servletContext) {
    String propertiesLocations = servletContext.getInitParameter(PROPERTIES_LOCATIONS_INIT_PARAMETER_NAME);
    if (propertiesLocations != null && !propertiesLocations.isEmpty()) {
      return propertiesLocations;
    }
    
    return DEFAULT_PROPERTIES_LOCATIONS;
  }
  
  /**
   * Retrieve the properties character set.
   *
   * @param servletContext The servlet context.
   * @return The properties character set.
   */
  private String getPropertiesCharset(ServletContext servletContext) {
    String propertiesCharset = servletContext.getInitParameter(PROPERTIES_CHARSET_INIT_PARAMETER_NAME);
    if (propertiesCharset != null && !propertiesCharset.isEmpty()) {
      return propertiesCharset;
    }
    
    return DEFAULT_PROPERTIES_CHARSET;
  }

  /**
   * Retrieve the Guice modules properties.
   *
   * @param servletContext The servlet context.
   * @return The Guice modules properties.
   */
  private Properties getGuiceModulesProperties(ServletContext servletContext) {
    Properties properties = new Properties();
    StringBuilder guiceModulesPropertyBuilder = new StringBuilder();
    
    for (URL propertiesUrl : this.getGuiceModulesPropertiesUrls(servletContext)) {
      this.loadGuiceModulesProperties(servletContext, properties, propertiesUrl);
      
      String guiceModuleProperty = properties.getProperty(PropertiesGuiceModulesFactory.GUICE_MODULES_PROPERTY_NAME);
      if (guiceModuleProperty != null && !guiceModuleProperty.isEmpty()) {
        if (guiceModulesPropertyBuilder.length() != 0) {
          guiceModulesPropertyBuilder.append(",");
        }
        
        guiceModulesPropertyBuilder.append(guiceModuleProperty);
      }
    }
    
    properties.setProperty(PropertiesGuiceModulesFactory.GUICE_MODULES_PROPERTY_NAME, guiceModulesPropertyBuilder.toString());
    
    return properties;
  }
  
  /**
   * Retrieve the URLs of the Guice modules properties.
   *
   * @param servletContext The servlet context.
   * @return The URLs of the Guice modules properties.
   */
  private List<URL> getGuiceModulesPropertiesUrls(ServletContext servletContext) {
    List<URL> propertiesUrls = new LinkedList<URL>();
    
    for (String propertiesLocation : this.getPropertiesLocations(servletContext).trim().split("\\s+")) {
      try {
        this.getGuiceModulesPropertiesUrls(servletContext, propertiesUrls, propertiesLocation);
      }
      catch (MalformedURLException mue) {
        throw new IllegalArgumentException(propertiesLocation, mue);
      }
    }
    
    return propertiesUrls;
  }
  
  /**
   * Retrieve the URLs of the Guice modules properties for the given location
   * and add them to the given list.
   *
   * @param servletContext The servlet context.
   * @param propertiesUrls The URLs of the Guice modules properties.
   * @param propertiesLocation The location of the Guice modules properties.
   * @throws MalformedURLException
   */
  private void getGuiceModulesPropertiesUrls(ServletContext servletContext, List<URL> propertiesUrls, String propertiesLocation) 
    throws MalformedURLException {
    if (propertiesLocation.endsWith("/")) {
      for (Object resourcePath : servletContext.getResourcePaths(propertiesLocation)) {
        this.getGuiceModulesPropertiesUrls(servletContext, propertiesUrls, (String)resourcePath);
      }
    }
    else {
      URL propertiesUrl = servletContext.getResource(propertiesLocation);
      if (propertiesUrl != null) {
        propertiesUrls.add(propertiesUrl);
      }
    }
  }

  /**
   * Load the Guice modules properties.
   *
   * @param servletContext The servlet context.
   * @param properties The Guice modules properties.
   * @param propertiesUrl The Guice modules properties URL.
   */
  private void loadGuiceModulesProperties(ServletContext servletContext, Properties properties, URL propertiesUrl) {
    InputStream inputStream = null;
    try {
      inputStream = propertiesUrl.openStream();
      
      properties.load(new InputStreamReader(inputStream, this.getPropertiesCharset(servletContext)));
    }
    catch (IOException ioe) {
      throw new IllegalStateException(ioe);
    }
    finally {
      if (inputStream != null) {
        try {
          inputStream.close();
        }
        catch (IOException ioe) {
        }
      }
    }
  }
}
