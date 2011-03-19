/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.common.shared.service.resource;

import org.junit.Test;

import org.kjots.lib.common.CommonTestBase;

/**
 * Resource Descriptor Test.
 * <p>
 * Created: 19th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 99-SNAPSHOT
 */
public class ResourceDescriptorTest extends CommonTestBase {
  /**
   * Dummy Resource Descriptor.
   */
  @SuppressWarnings("serial")
  public static class DummyResourceDescriptor extends ResourceDescriptor {
    /**
     * Construct a new Dummy Resource Descriptor.
     *
     * @param resourceUriScheme The resource URI scheme.
     * @param parentDescriptor The parent resource descriptor.
     */
    public DummyResourceDescriptor(String resourceUriScheme, ResourceDescriptor parentDescriptor) {
      super(resourceUriScheme, parentDescriptor);
    }
    
    /**
     * Retrieve the resource service.
     *
     * @return The resource service.
     */
    @Override
    public ResourceService getResourceService() {
      return null;
    }
  }
  
  /**
   * Test the the {@link ResourceDescriptor#ResourceDescriptor(String, ResourceDescriptor)}
   * constructor.
   * <p>
   * This test asserts that the {@link ResourceDescriptor#ResourceDescriptor(String, ResourceDescriptor)}
   * constructor throws an {@link IllegalArgumentException} when provided with
   * a <code>null</code> resource URI scheme.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithNullResourceUriScheme() {
    new DummyResourceDescriptor(null, null);
  }
  
  /**
   * Test the the {@link ResourceDescriptor#ResourceDescriptor(String, ResourceDescriptor)}
   * constructor.
   * <p>
   * This test asserts that the {@link ResourceDescriptor#ResourceDescriptor(String, ResourceDescriptor)}
   * constructor throws an {@link IllegalArgumentException} when provided with
   * an empty resource URI scheme.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWithEmptyResourceUriScheme() {
    new DummyResourceDescriptor("", null);
  }
}
