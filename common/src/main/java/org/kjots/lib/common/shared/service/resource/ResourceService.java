/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.common.shared.service.resource;

import org.kjots.lib.common.shared.service.Service;

/**
 * Resource Service.
 * <p>
 * Created: 19th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 99-SNAPSHOT
 */
public interface ResourceService extends Service {
  /**
   * Create a resource descriptor.
   * <p>
   * This method will throw an {@link IllegalArgumentException} if the given
   * resource URI scheme is <code>null</code> or empty.
   *
   * @param resourceUriScheme The resource URI scheme.
   * @return The resource descriptor.
   */
  public ResourceDescriptor createResourceDescriptor(String resourceUriScheme);
  
  /**
   * Create a resource descriptor.
   * <p>
   * This method will throw an {@link IllegalArgumentException} if the given
   * resource URI scheme is <code>null</code> or empty.
   *
   * @param resourceUriScheme The resource URI scheme.
   * @param parentDescriptor The parent resource descriptor.
   * @return The resource descriptor.
   */
  public ResourceDescriptor createResourceDescriptor(String resourceUriScheme, ResourceDescriptor parentDescriptor);
}
