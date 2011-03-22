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
   * Install the given resource descriptor.
   *
   * @param resourceDescriptor The resource descriptor.
   */
  public void installResourceDescriptor(ResourceDescriptor resourceDescriptor);
}
