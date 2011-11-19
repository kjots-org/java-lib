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

import java.io.Serializable;

import org.kjots.lib.service.resource.shared.ResourceDescriptor;

/**
 * Resource Descriptor Implementation.
 * <p>
 * Created: 21st March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public class ResourceDescriptorImpl implements ResourceDescriptor, Serializable {
  /** The serial version UID. */
  private static final long serialVersionUID = 2489599678177967467L;

  /** The resource type. */
  private final String resourceType;
  
  /** The parent resource descriptor. */
  private final ResourceDescriptor parentDescriptor;
  
  /**
   * Construct a new Resource Descriptor Implementation.
   *
   * @param resourceType The resource type.
   */
  public ResourceDescriptorImpl(String resourceType) {
    this(resourceType, null);
  }

  /**
   * Construct a new Resource Descriptor Implementation.
   *
   * @param resourceType The resource type.
   * @param parentDescriptor The parent resource descriptor.
   */
  public ResourceDescriptorImpl(String resourceType, ResourceDescriptor parentDescriptor) {
    if (resourceType == null || resourceType.isEmpty()) throw new IllegalArgumentException("resourceType cannot be null or empty");
    
    this.resourceType = resourceType;
    this.parentDescriptor = parentDescriptor;
  }

  /**
   * Retrieve the resource type.
   *
   * @return The resource type.
   */
  @Override
  public String getResourceType() {
    return this.resourceType;
  }

  /**
   * Retrieve the parent resource descriptor.
   *
   * @return The parent resource descriptor or <code>null</code>.
   */
  @Override
  public ResourceDescriptor getParentDescriptor() {
    return this.parentDescriptor;
  }

  /**
   * Determine if this object is equal to the given object.
   *
   * @param object The object.
   * @return <code>true<code> if this object is equal to the given object.
   */
  @Override
  public final boolean equals(Object object) {
    return Util.equals(this, object);
  }
  
  /**
   * Calculate the hash code for this object.
   *
   * @return The hash code.
   */
  @Override
  public final int hashCode() {
    return Util.hashCode(this);
  }
  
  /**
   * Create a string representation of this object.
   *
   * @return The string representation of this object. 
   */
  @Override
  public final String toString() {
    return Util.toString(this);
  }
}
