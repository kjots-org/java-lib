/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.service.resource.shared.impl;

import org.junit.Test;

import org.kjots.lib.service.resource.shared.ResourceDescriptor;

/**
 * Resource Descriptor Implementation Base Test.
 * <p>
 * Created: 19th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class ResourceDescriptorImplTest {
  /**
   * Test the {@link ResourceDescriptorImpl#ResourceDescriptorImpl(String)}
   * constructor.
   * <p>
   * This test asserts that the {@link ResourceDescriptorImpl#ResourceDescriptorImpl(String)}
   * constructor throws an {@link IllegalArgumentException} when provided with
   * a <code>null</code> resource type.
   */
  @Test(expected = IllegalArgumentException.class)
  public void ResourceDescriptorImpl_String__withNullResourceType() {
    new ResourceDescriptorImpl(null);
  }
  
  /**
   * Test the {@link ResourceDescriptorImpl#ResourceDescriptorImpl(String)}
   * constructor.
   * <p>
   * This test asserts that the {@link ResourceDescriptorImpl#ResourceDescriptorImpl(String)}
   * constructor throws an {@link IllegalArgumentException} when provided with
   * an empty resource type.
   */
  @Test(expected = IllegalArgumentException.class)
  public void ResourceDescriptorImpl_String__withEmptyResourceType() {
    new ResourceDescriptorImpl("");
  }
  
  /**
   * Test the {@link ResourceDescriptorImpl#ResourceDescriptorImpl(String, ResourceDescriptor)}
   * constructor.
   * <p>
   * This test asserts that the {@link ResourceDescriptorImpl#ResourceDescriptorImpl(String, ResourceDescriptor)}
   * constructor throws an {@link IllegalArgumentException} when provided with
   * a <code>null</code> resource type.
   */
  @Test(expected = IllegalArgumentException.class)
  public void ResourceDescriptorImpl_String_ResourceDescriptor__withNullResourceType() {
    new ResourceDescriptorImpl(null, null);
  }
  
  /**
   * Test the {@link ResourceDescriptorImpl#ResourceDescriptorImpl(String, ResourceDescriptor)}
   * constructor.
   * <p>
   * This test asserts that the {@link ResourceDescriptorImpl#ResourceDescriptorImpl(String, ResourceDescriptor)}
   * constructor throws an {@link IllegalArgumentException} when provided with
   * an empty resource type.
   */
  @Test(expected = IllegalArgumentException.class)
  public void ResourceDescriptorImpl_String_ResourceDescriptor__withEmptyResourceType() {
    new ResourceDescriptorImpl("", null);
  }
}
