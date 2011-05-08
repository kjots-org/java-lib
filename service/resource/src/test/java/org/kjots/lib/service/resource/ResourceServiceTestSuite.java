/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.service.resource;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import org.kjots.lib.service.resource.shared.impl.ResourceServiceImplTestSuite;

/**
 * Resource Service Test Suite.
 * <p>
 * Created: 19th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 99-SNAPSHOT
 */
@RunWith(Suite.class)
@SuiteClasses({
  ResourceServiceImplTestSuite.class
})
public class ResourceServiceTestSuite {
}
