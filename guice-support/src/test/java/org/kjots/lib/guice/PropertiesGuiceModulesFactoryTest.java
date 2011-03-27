/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.guice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Module;

/**
 * Properties Guice Modules Factory Test.
 * <p>
 * Created: 27th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 99-SNAPSHOT
 */
public class PropertiesGuiceModulesFactoryTest {
  /**
   * Abstract Test Guice Module.
   */
  public static abstract class AbstractTestGuiceModule extends AbstractModule {
    /**
     * Configure the module.
     */
    @Override
    protected void configure() {
    }
  }
  
  /**
   * Test Guice Module A.
   */
  public static class TestGuiceModuleA extends AbstractTestGuiceModule {
  }
  
  /**
   * Test Guice Module B.
   */
  public static class TestGuiceModuleB extends AbstractTestGuiceModule {
  }
  
  /**
   * Test Guice Module C.
   */
  public static class TestGuiceModuleC extends AbstractTestGuiceModule {
    /** The first property. */
    private String property1;
    
    /** The second property. */
    private String property2;
    
    /** The third property. */
    private String property3;

    /**
     * Retrieve the first property.
     *
     * @return The first property.
     * @see #setProperty1(String)
     */
    public String getProperty1() {
      return this.property1;
    }

    /**
     * Set the first property.
     *
     * @param property1 The first property.
     * @see #getProperty1()
     */
    public void setProperty1(String property1) {
      this.property1 = property1;
    }

    /**
     * Retrieve the second property.
     *
     * @return The second property.
     * @see #setProperty2(String)
     */
    public String getProperty2() {
      return this.property2;
    }

    /**
     * Set the second property.
     *
     * @param property2 The second property.
     * @see #getProperty2()
     */
    public void setProperty2(String property2) {
      this.property2 = property2;
    }

    /**
     * Retrieve the third property.
     *
     * @return The third property.
     * @see #setProperty3(String)
     */
    public String getProperty3() {
      return this.property3;
    }

    /**
     * Set the third property.
     *
     * @param property3 The third property.
     * @see #getProperty3()
     */
    public void setProperty3(String property3) {
      this.property3 = property3;
    }
  }
  
  /**
   * Test the creation of a Guice module.
   * <p>
   * This test asserts that a Guice module is created correctly.
   */
  @Test
  public void testCreateGuiceModule() {
    Properties properties = new Properties();
    
    properties.setProperty(PropertiesGuiceModulesFactory.GUICE_MODULES_PROPERTY_NAME, TestGuiceModuleA.class.getName());
    
    PropertiesGuiceModulesFactory testPropertiesGuiceModulesFactory = new PropertiesGuiceModulesFactory(properties);
    
    Collection<Module> guiceModules = testPropertiesGuiceModulesFactory.getGuiceModules();
    
    assertNotNull(guiceModules);
    assertEquals(1, guiceModules.size());
    
    Module guiceModule = guiceModules.iterator().next();
    
    assertNotNull(guiceModule);
    assertTrue(guiceModule instanceof TestGuiceModuleA);
  }
  
  /**
   * Test the creation of a list of Guice modules.
   * <p>
   * This test asserts that a list of Guice modules is created correctly.
   */
  @Test
  public void testCreateGuiceModules() {
    Properties properties = new Properties();
    
    properties.setProperty(PropertiesGuiceModulesFactory.GUICE_MODULES_PROPERTY_NAME, TestGuiceModuleA.class.getName() + ", " + TestGuiceModuleB.class.getName());
    
    PropertiesGuiceModulesFactory testPropertiesGuiceModulesFactory = new PropertiesGuiceModulesFactory(properties);
    
    Collection<Module> guiceModules = testPropertiesGuiceModulesFactory.getGuiceModules();
    
    assertNotNull(guiceModules);
    assertEquals(2, guiceModules.size());
    
    Iterator<Module> it = guiceModules.iterator();
    
    Module guiceModuleA = it.next();
    
    assertNotNull(guiceModuleA);
    assertTrue(guiceModuleA instanceof TestGuiceModuleA);
    
    Module guiceModuleB = it.next();
    
    assertNotNull(guiceModuleB);
    assertTrue(guiceModuleB instanceof TestGuiceModuleB);
  }
  
  /**
   * Test the creation of a list of Guice modules with duplicates.
   * <p>
   * This test asserts that a list of Guice modules is created correctly, with
   * duplicate entries being ignored.
   */
  @Test
  public void testCreateGuiceModulesWithDuplicates() {
    Properties properties = new Properties();
    
    properties.setProperty(PropertiesGuiceModulesFactory.GUICE_MODULES_PROPERTY_NAME, TestGuiceModuleA.class.getName() + ", " + TestGuiceModuleA.class.getName());
    
    PropertiesGuiceModulesFactory testPropertiesGuiceModulesFactory = new PropertiesGuiceModulesFactory(properties);
    
    Collection<Module> guiceModules = testPropertiesGuiceModulesFactory.getGuiceModules();
    
    assertNotNull(guiceModules);
    assertEquals(1, guiceModules.size());
    
    Module guiceModule = guiceModules.iterator().next();
    
    assertNotNull(guiceModule);
    assertTrue(guiceModule instanceof TestGuiceModuleA);
  }
  
  /**
   * Test the creation of a Guice module with properties.
   * <p>
   * This test asserts that a Guice module is created correctly with properties.
   */
  @Test
  public void testCreateGuiceModuleWithProperties() {
    Properties properties = new Properties();
    
    properties.setProperty(PropertiesGuiceModulesFactory.GUICE_MODULES_PROPERTY_NAME, TestGuiceModuleC.class.getName());
    properties.setProperty(TestGuiceModuleC.class.getName() + ".property1", "property1Value");
    properties.setProperty(TestGuiceModuleC.class.getName() + ".property2", "");
    properties.setProperty(TestGuiceModuleC.class.getName() + ".property4", "property4Value");
    
    PropertiesGuiceModulesFactory testPropertiesGuiceModulesFactory = new PropertiesGuiceModulesFactory(properties);
    
    Collection<Module> guiceModules = testPropertiesGuiceModulesFactory.getGuiceModules();
    
    assertNotNull(guiceModules);
    assertEquals(1, guiceModules.size());
    
    Module guiceModule = guiceModules.iterator().next();
    
    assertNotNull(guiceModule);
    assertTrue(guiceModule instanceof TestGuiceModuleC);
    
    TestGuiceModuleC testGuiceModuleC = (TestGuiceModuleC)guiceModule;
    
    assertEquals("property1Value", testGuiceModuleC.getProperty1());
    assertEquals("", testGuiceModuleC.getProperty2());
    assertNull(testGuiceModuleC.getProperty3());
  }
}
