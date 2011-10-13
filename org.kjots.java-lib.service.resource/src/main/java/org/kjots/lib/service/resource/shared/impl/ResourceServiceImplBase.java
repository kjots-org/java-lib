/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.service.resource.shared.impl;

import java.net.URI;
import java.net.URISyntaxException;

import org.kjots.lib.service.common.shared.impl.ServiceImplBase;

import org.kjots.lib.service.resource.shared.ResourceService;

/**
 * Resource Service Implementation Base.
 * <p>
 * Created: 19th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public abstract class ResourceServiceImplBase extends ServiceImplBase implements ResourceService {
  /**
   * Create a resource URI.
   *
   * @param resourceType The resource type.
   * @param path The path
   * @return The resource URI.
   */
  @Override
  public final URI createResourceUri(String resourceType, String path) {
    return this.createResourceUri(resourceType, null, path, null, null);
  }

  /**
   * Create a resource URI.
   *
   * @param resourceType The resource type.
   * @param path The path
   * @param query The query
   * @return The resource URI.
   */
  @Override
  public final URI createResourceUri(String resourceType, String path, String query) {
    return this.createResourceUri(resourceType, null, path, query, null);
  }

  /**
   * Create a resource URI.
   *
   * @param resourceType The resource type.
   * @param path The path
   * @param query The query
   * @param fragment The fragment
   * @return The resource URI.
   */
  @Override
  public final URI createResourceUri(String resourceType, String path, String query, String fragment) {
    return this.createResourceUri(resourceType, null, path, query, fragment);
  }
  
  /**
   * Create a resource URI.
   *
   * @param resourceType The resource type.
   * @param parentResourceUri The parent resource URI
   * @param path The path
   * @return The resource URI.
   */
  @Override
  public final URI createResourceUri(String resourceType, URI parentResourceUri, String path) {
    return this.createResourceUri(resourceType, parentResourceUri, path, null, null);
  }

  /**
   * Create a resource URI.
   *
   * @param resourceType The resource type.
   * @param parentResourceUri The parent resource URI
   * @param path The path
   * @param query The query
   * @return The resource URI.
   */
  @Override
  public final URI createResourceUri(String resourceType, URI parentResourceUri, String path, String query) {
    return this.createResourceUri(resourceType, parentResourceUri, path, query, null);
  }
  
  /**
   * Create a resource URI.
   * 
   * @param resourceType The resource type.
   * @param parentResourceUri The parent resource URI
   * @param path The path
   * @param query The query
   * @param fragment The fragment
   * @return The resource URI.
   */
  @Override
  public final URI createResourceUri(String resourceType, URI parentResourceUri, String path, String query, String fragment) {
    if (resourceType == null || resourceType.isEmpty()) throw new IllegalArgumentException("resourceType cannot be null or empty");
    if (parentResourceUri == null && path == null && query == null) throw new IllegalArgumentException("parentResourceUri, path and query cannot all be null");
    
    try {
      String actualPath = null;
      if (parentResourceUri != null || path != null) {
        StringBuilder actualPathBuilder = new StringBuilder();
        
        if (parentResourceUri != null) {
          actualPathBuilder.append(parentResourceUri.getPath());
        }
        
        if (path != null) {
          actualPathBuilder.append(path);
        }
        
        actualPath = actualPathBuilder.toString();
      }
      
      return new URI(resourceType, null, actualPath, query, fragment);
    }
    catch (URISyntaxException use) {
      throw new IllegalArgumentException(
        "resourceType=" + resourceType + ", parentResourceUri=" + parentResourceUri + ", path=" + path + ", query=" + query + ", fragment=" + fragment, use);
    }
  }
}
