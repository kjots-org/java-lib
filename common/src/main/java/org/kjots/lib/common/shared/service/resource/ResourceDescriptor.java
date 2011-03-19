/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.common.shared.service.resource;

import java.io.Serializable;

/**
 * Resource Descriptor.
 * <p>
 * Created: 19th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 99-SNAPSHOT
 */
public abstract class ResourceDescriptor implements Serializable {
  /** The serial version UID. */
  private static final long serialVersionUID = -1877892716899526151L;

  /** The resource URI scheme. */
  private final String resourceUriScheme;
  
  /** The parent resource descriptor. */
  private final ResourceDescriptor parentDescriptor;
  
  /**
   * Retrieve the resource URI scheme.
   *
   * @return The resource URI scheme.
   */
  public String getResourceUriScheme() {
    return this.resourceUriScheme;
  }

  /**
   * Retrieve the parent resource descriptor.
   * <p>
   * If a resource descriptor has a parent, then the following conditions will
   * always be <code>true</code>:
   * <ul>
   * <li>The scheme of the parent resource URI must be equal to the resource
   *     URI scheme of the parent resource descriptor</li>
   * <li>The prefix of the path of the resource URI must be the entire path of
   *     the parent resource URI followed by a slash</li>
   * <li>A resource with the parent resource URI must exist at the time the
   *     resource is created</li>
   * <li>The resource with the parent resource URI cannot be deleted whilst the
   *     resource exists</li>
   * </ul>
   * <p>
   * This method will return <code>null</code> if this resource descriptor has
   * no parent.
   *
   * @return The parent resource descriptor or <code>null</code>.
   */
  public ResourceDescriptor getParentDescriptor() {
    return this.parentDescriptor;
  }
  
  /**
   * Retrieve the resource service.
   *
   * @return The resource service.
   */
  public abstract ResourceService getResourceService();
  
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
      
      return this.resourceUriScheme.equals(that.resourceUriScheme);
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
    return 629 * this.resourceUriScheme.hashCode();
  }
  
  /**
   * Create a string representation of this object.
   *
   * @return The string representation of this object. 
   */
  @Override
  public String toString() {
    return this.resourceUriScheme;
  }

  /**
   * Construct a new Resource Descriptor.
   *
   * @param resourceUriScheme The resource URI scheme.
   * @param parentDescriptor The parent resource descriptor.
   */
  protected ResourceDescriptor(String resourceUriScheme, ResourceDescriptor parentDescriptor) {
    if (resourceUriScheme == null || resourceUriScheme.isEmpty()) throw new IllegalArgumentException("resourceUriScheme cannot be null or empty"); 
    
    this.resourceUriScheme = resourceUriScheme;
    this.parentDescriptor = parentDescriptor;
  }
}
