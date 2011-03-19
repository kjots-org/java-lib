/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.common.service.resource.impl;

import org.kjots.lib.common.service.impl.ServiceImplBase;
import org.kjots.lib.common.service.resource.ResourceDescriptor;
import org.kjots.lib.common.service.resource.ResourceService;

/**
 * Resource Service Implementation Base.
 * <p>
 * Created: 19th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 99-SNAPSHOT
 */
public abstract class ResourceServiceImplBase extends ServiceImplBase implements ResourceService {
  /**
   * Create a resource descriptor.
   *
   * @param resourceUriScheme The resource URI scheme.
   * @return The resource descriptor.
   */
  @Override
  public ResourceDescriptor createResourceDescriptor(String resourceUriScheme) {
    return this.createResourceDescriptor(resourceUriScheme, null);
  }
}
