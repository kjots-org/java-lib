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
