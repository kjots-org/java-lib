/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
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
