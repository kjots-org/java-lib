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
package org.kjots.lib.service.resource.shared;

import java.net.URI;

import org.kjots.lib.service.common.shared.Service;

/**
 * Resource Service.
 * <p>
 * Created: 19th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public interface ResourceService extends Service {
  /**
   * Install the given resource descriptor.
   *
   * @param resourceDescriptor The resource descriptor.
   */
  public void installResourceDescriptor(ResourceDescriptor resourceDescriptor);
  
  /**
   * Create a resource URI.
   * <p>
   * This method is equivalent to the following:
   * <pre>
   *   {@link #createResourceUri(String, URI, String, String, String) createResourceUri}(resourceType, null, path, null, null);
   * </pre>
   *
   * @param resourceType The resource type.
   * @param path The path
   * @return The resource URI.
   */
  public URI createResourceUri(String resourceType, String path);

  /**
   * Create a resource URI.
   * <p>
   * This method is equivalent to the following:
   * <pre>
   *   {@link #createResourceUri(String, URI, String, String, String) createResourceUri}(resourceType, null, path, query, null);
   * </pre>
   *
   * @param resourceType The resource type.
   * @param path The path
   * @param query The query
   * @return The resource URI.
   */
  public URI createResourceUri(String resourceType, String path, String query);

  /**
   * Create a resource URI.
   * <p>
   * This method is equivalent to the following:
   * <pre>
   *   {@link #createResourceUri(String, URI, String, String, String) createResourceUri}(resourceType, null, path, query, fragment);
   * </pre>
   *
   * @param resourceType The resource type.
   * @param path The path
   * @param query The query
   * @param fragment The fragment
   * @return The resource URI.
   */
  public URI createResourceUri(String resourceType, String path, String query, String fragment);
  
  /**
   * Create a resource URI.
   * <p>
   * This method is equivalent to the following:
   * <pre>
   *   {@link #createResourceUri(String, URI, String, String, String) createResourceUri}(resourceType, parentResourceUri, path, null, null);
   * </pre>
   *
   * @param resourceType The resource type.
   * @param parentResourceUri The parent resource URI
   * @param path The path
   * @return The resource URI.
   */
  public URI createResourceUri(String resourceType, URI parentResourceUri, String path);

  /**
   * Create a resource URI.
   * <p>
   * This method is equivalent to the following:
   * <pre>
   *   {@link #createResourceUri(String, URI, String, String, String) createResourceUri}(resourceType, parentResourceUri, path, query, null);
   * </pre>
   *
   * @param resourceType The resource type.
   * @param parentResourceUri The parent resource URI
   * @param path The path
   * @param query The query
   * @return The resource URI.
   */
  public URI createResourceUri(String resourceType, URI parentResourceUri, String path, String query);
  
  /**
   * Create a resource URI.
   * <p>
   * This method will create a URI with the given format:
   * <pre>
   *   resourceType:[parentResourceUri.path/][path][?query][#fragment]
   * </pre>
   * 
   * @param resourceType The resource type.
   * @param parentResourceUri The parent resource URI
   * @param path The path
   * @param query The query
   * @param fragment The fragment
   * @return The resource URI.
   */
  public URI createResourceUri(String resourceType, URI parentResourceUri, String path, String query, String fragment);
}
