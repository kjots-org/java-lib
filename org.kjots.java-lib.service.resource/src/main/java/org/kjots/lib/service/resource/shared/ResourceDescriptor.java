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

/**
 * Resource Descriptor.
 * <p>
 * Created: 19th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
public interface ResourceDescriptor {
  /**
   * Resource Descriptor Utility.
   * <p>
   * Created: 21st March 2011.
   */
  public static class Util {
    /**
     * Determine if the given resource descriptor is equal to the given object.
     *
     * @param resourceDescriptor The resource descriptor.
     * @param object The object.
     * @return <code>true<code> if the resource descriptor is equal to the object.
     */
    public static boolean equals(ResourceDescriptor resourceDescriptor, Object object) {
      if (object == resourceDescriptor) {
        return true;
      }
      else if (object instanceof ResourceDescriptor) {
        ResourceDescriptor that = (ResourceDescriptor)object;
        
        return resourceDescriptor.getResourceType().equals(that.getResourceType()) &&
               (resourceDescriptor.getParentDescriptor() != null ? resourceDescriptor.getParentDescriptor().equals(that.getParentDescriptor()) : that.getParentDescriptor() == null);
      }
      else {
        return false;
      }
    }
    
    /**
     * Calculate the hash code for the given resource descriptor.
     *
     * @param resourceDescriptor The resource descriptor.
     * @return The hash code.
     */
    public static int hashCode(ResourceDescriptor resourceDescriptor) {
      int hashCode = 17;
      
      hashCode = hashCode * 37 + resourceDescriptor.getResourceType().hashCode();
      hashCode = hashCode * 37 + (resourceDescriptor.getParentDescriptor() != null ? resourceDescriptor.getParentDescriptor().hashCode() : 0);
      
      return hashCode;
    }
    
    /**
     * Create a string representation of the given resource descriptor.
     *
     * @param resourceDescriptor The resource descriptor.
     * @return The string representation.
     */
    public static String toString(ResourceDescriptor resourceDescriptor) {
      return (resourceDescriptor.getParentDescriptor() != null ? resourceDescriptor.getParentDescriptor().toString() + "::" : "") + resourceDescriptor.getResourceType();
    }
  }
  
  /**
   * Retrieve the resource type.
   *
   * @return The resource type.
   */
  public String getResourceType();

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
  
  /**
   * Determine if this object is equal to the given object.
   * <p>
   * The implementation of this method should always delegate to 
   * {@link Util#equals(ResourceDescriptor, Object)}.
   *
   * @param object The object.
   * @return <code>true<code> if this object is equal to the given object.
   */
  @Override
  public boolean equals(Object object);
  
  /**
   * Calculate the hash code for this object.
   * <p>
   * The implementation of this method should always delegate to 
   * {@link Util#hashCode(ResourceDescriptor)}.
   *
   * @return The hash code.
   */
  @Override
  public int hashCode();
  
  /**
   * Create a string representation of this object.
   * <p>
   * The implementation of this method should always delegate to 
   * {@link Util#toString(ResourceDescriptor)}.
   *
   * @return The string representation of this object. 
   */
  @Override
  public String toString();
}
