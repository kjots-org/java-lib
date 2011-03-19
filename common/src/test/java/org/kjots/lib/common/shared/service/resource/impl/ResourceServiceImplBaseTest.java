/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.common.shared.service.resource.impl;

import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import org.kjots.lib.common.CommonTestBase;
import org.kjots.lib.common.shared.service.resource.ResourceDescriptor;

/**
 * Resource Service Implementation Base Test.
 * <p>
 * Created: 19th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 99-SNAPSHOT
 */
public class ResourceServiceImplBaseTest extends CommonTestBase {
  /**
   * Dummy Resource Service Implementation Base.
   */
  public static class DummyResourceServiceImplBase extends ResourceServiceImplBase {
    /**
     * Create a resource descriptor.
     *
     * @param resourceUriScheme The resource URI scheme.
     * @param parentDescriptor The parent resource descriptor.
     * @return The resource descriptor.
     */
    @Override
    public ResourceDescriptor createResourceDescriptor(String resourceUriScheme, ResourceDescriptor parentDescriptor) {
      return null;
    }
  }
  
  /** The test resource service implementation base. */
  private ResourceServiceImplBase testResourceServiceImplBase;
  
  /**
   * Setup the test environment.
   */
  @Before
  public void setup() {
    this.testResourceServiceImplBase = new DummyResourceServiceImplBase();
  }
  
  /**
   * Test the {@link ResourceServiceImplBase#createResourceDescriptor(String)} method.
   * <p>
   * This test asserts that the {@link ResourceServiceImplBase#createResourceDescriptor(String)}
   * method invokes the {@link ResourceServiceImplBase#createResourceDescriptor(String, ResourceDescriptor)}
   * method with the given argument and <code>null</code> parent resource
   * descriptor and returns the resulting resource descriptor.
   */
  @Test
  public void testCreateResourceDescriptorWithResourceUriScheme() {
    ResourceServiceImplBase testResourceServiceImplBase = spy(this.testResourceServiceImplBase);
    
    ResourceDescriptor mockResourceDescriptor = mock(ResourceDescriptor.class);
    
    when(testResourceServiceImplBase.createResourceDescriptor(anyString(), (ResourceDescriptor)any())).thenReturn(mockResourceDescriptor);
    
    ResourceDescriptor resourceDescriptor = testResourceServiceImplBase.createResourceDescriptor("testResourceUriScheme");
    
    verify(testResourceServiceImplBase).createResourceDescriptor("testResourceUriScheme", null);
    
    assertSame(mockResourceDescriptor, resourceDescriptor);
  }
}
