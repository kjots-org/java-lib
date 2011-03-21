/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.common.shared.service.resource.impl;

import java.io.Serializable;

import org.kjots.lib.common.shared.service.resource.ResourceDescriptor;

/**
 * Resource Descriptor Implementation Base.
 * <p>
 * Created: 21st March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 99-SNAPSHOT
 */
public abstract class ResourceDescriptorImplBase implements ResourceDescriptor, Serializable {
  /** The serial version UID. */
  private static final long serialVersionUID = 6927249740786688383L;
  
  /** The resource URI scheme. */
  private final String resourceUriScheme;
  
  /** The parent resource descriptor. */
  private final ResourceDescriptor parentDescriptor;
  
  /**
   * Retrieve the resource URI scheme.
   *
   * @return The resource URI scheme.
   */
  @Override
  public String getResourceUriScheme() {
    return this.resourceUriScheme;
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
  public boolean equals(Object object) {
    if (object == this) {
      return true;
    }
    else if (object instanceof ResourceDescriptor) {
      ResourceDescriptor that = (ResourceDescriptor)object;
      
      return this.getResourceUriScheme().equals(that.getResourceUriScheme());
    }
    else {
      return false;
    }
  }
  
  /**
   * Calculate the hash code for this object.
   *
   * @return The hash code.
   */
  @Override
  public int hashCode() {
    return 629 * this.getResourceUriScheme().hashCode();
  }
  
  /**
   * Create a string representation of this object.
   *
   * @return The string representation of this object. 
   */
  @Override
  public String toString() {
    return this.getResourceUriScheme();
  }

  /**
   * Construct a new Resource Descriptor Implementation Base.
   *
   * @param resourceUriScheme The resource URI scheme.
   * @param parentDescriptor The parent resource descriptor.
   */
  protected ResourceDescriptorImplBase(String resourceUriScheme, ResourceDescriptor parentDescriptor) {
    if (resourceUriScheme == null || resourceUriScheme.isEmpty()) throw new IllegalArgumentException("resourceUriScheme cannot be null or empty"); 
    
    this.resourceUriScheme = resourceUriScheme;
    this.parentDescriptor = parentDescriptor;
  }
}
