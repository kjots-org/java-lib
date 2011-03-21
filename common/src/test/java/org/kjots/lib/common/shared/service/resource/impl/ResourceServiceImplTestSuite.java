/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.common.shared.service.resource.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Resource Service Implementation Test Suite.
 * <p>
 * Created: 19th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 99-SNAPSHOT
 */
@RunWith(Suite.class)
@SuiteClasses({
  ResourceServiceImplBaseTest.class,
  ResourceDescriptorImplBaseTest.class
})
public class ResourceServiceImplTestSuite {
}
