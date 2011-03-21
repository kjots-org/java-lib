/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.common.shared.service.resource;

/**
 * Resource Descriptor.
 * <p>
 * Created: 19th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 99-SNAPSHOT
 */
public interface ResourceDescriptor {
  /**
   * Retrieve the resource service.
   *
   * @return The resource service.
   */
  public ResourceService getResourceService();

  /**
   * Retrieve the resource URI scheme.
   *
   * @return The resource URI scheme.
   */
  public String getResourceUriScheme();

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
  public ResourceDescriptor getParentDescriptor();
}
