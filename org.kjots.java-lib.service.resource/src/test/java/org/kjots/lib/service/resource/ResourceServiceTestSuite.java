/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.service.resource;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import org.kjots.lib.service.resource.shared.impl.ResourceDescriptorImplTest;
import org.kjots.lib.service.resource.shared.impl.ResourceServiceImplBaseTest;

/**
 * Resource Service Test Suite.
 * <p>
 * Created: 19th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
@RunWith(Suite.class)
@SuiteClasses({
  ResourceServiceTestSuite.ResourceServiceImplTestSuite.class
})
public class ResourceServiceTestSuite {
  /**
   * Resource Service Implementation Test Suite.
   */
  @RunWith(Suite.class)
  @SuiteClasses({
    ResourceDescriptorImplTest.class,
    ResourceServiceImplBaseTest.class
  })
  public static class ResourceServiceImplTestSuite {
  }
}
