/* 
 * Copyright © 2011 Karl J. Ots.  All Rights Reserved.
 */
package org.kjots.lib.service.resource.shared.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.inOrder;

import static org.powermock.api.mockito.PowerMockito.verifyNoMoreInteractions;
import static org.powermock.api.mockito.PowerMockito.when;

import java.net.URI;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InOrder;
import org.mockito.Mock;

/**
 * Resource Service Implementation Base Test.
 * <p>
 * Created: 19th March 2011.
 *
 * @author <a href="mailto:kjots@kjots.org">Karl J. Ots &lt;kjots@kjots.org&gt;</a>
 * @since 1.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ResourceServiceImplBase.class)
public class ResourceServiceImplBaseTest {
  /** The test resource service implementation base. */
  @Mock
  private ResourceServiceImplBase testResourceServiceImplBase;
  
  /**
   * Test the {@link ResourceServiceImplBase#createResourceUri(String, String)}
   * method.
   * <p>
   * This test asserts that the {@link ResourceServiceImplBase#createResourceUri(String, String)}
   * method correctly invokes the {@link ResourceServiceImplBase#createResourceUri(String, URI, String, String, String)}
   * method.
   */
  @Test
  public void createResourceUri_String_String() {
    when(testResourceServiceImplBase.createResourceUri(anyString(), anyString())).thenCallRealMethod();
    
    URI mockResourceUri = URI.create("mockResourceUri:/");
    
    when(testResourceServiceImplBase.createResourceUri(anyString(), (URI)any(), anyString(), anyString(), anyString())).thenReturn(mockResourceUri);
    
    URI resourceUri = testResourceServiceImplBase.createResourceUri("testResourceType", "/test/path");
    
    InOrder inOrder = inOrder(testResourceServiceImplBase);
    
    inOrder.verify(testResourceServiceImplBase).createResourceUri("testResourceType", "/test/path");
    inOrder.verify(testResourceServiceImplBase).createResourceUri("testResourceType", null, "/test/path", null, null);
    
    assertSame(mockResourceUri, resourceUri);
    
    verifyNoMoreInteractions(testResourceServiceImplBase);
  }

  /**
   * Test the {@link ResourceServiceImplBase#createResourceUri(String, String, String)}
   * method.
   * <p>
   * This test asserts that the {@link ResourceServiceImplBase#createResourceUri(String, String, String)}
   * method correctly invokes the {@link ResourceServiceImplBase#createResourceUri(String, URI, String, String, String)}
   * method.
   */
  @Test
  public void createResourceUri_String_String_String() {
    when(testResourceServiceImplBase.createResourceUri(anyString(), anyString(), anyString())).thenCallRealMethod();
    
    URI mockResourceUri = URI.create("mockResourceUri:/");
    
    when(testResourceServiceImplBase.createResourceUri(anyString(), (URI)any(), anyString(), anyString(), anyString())).thenReturn(mockResourceUri);
    
    URI resourceUri = testResourceServiceImplBase.createResourceUri("testResourceType", "/test/path", "testQuery");
    
    InOrder inOrder = inOrder(testResourceServiceImplBase);
    
    inOrder.verify(testResourceServiceImplBase).createResourceUri("testResourceType", "/test/path", "testQuery");
    inOrder.verify(testResourceServiceImplBase).createResourceUri("testResourceType", null, "/test/path", "testQuery", null);
    
    assertSame(mockResourceUri, resourceUri);
    
    verifyNoMoreInteractions(testResourceServiceImplBase);
  }

  /**
   * Test the {@link ResourceServiceImplBase#createResourceUri(String, String, String, String)}
   * method.
   * <p>
   * This test asserts that the {@link ResourceServiceImplBase#createResourceUri(String, String, String, String)}
   * method correctly invokes the {@link ResourceServiceImplBase#createResourceUri(String, URI, String, String, String)}
   * method.
   */
  @Test
  public void createResourceUri_String_String_String_String() {
    when(testResourceServiceImplBase.createResourceUri(anyString(), anyString(), anyString(), anyString())).thenCallRealMethod();
    
    URI mockResourceUri = URI.create("mockResourceUri:/");
    
    when(testResourceServiceImplBase.createResourceUri(anyString(), (URI)any(), anyString(), anyString(), anyString())).thenReturn(mockResourceUri);
    
    URI resourceUri = testResourceServiceImplBase.createResourceUri("testResourceType", "/test/path", "testQuery", "testFragment");
    
    InOrder inOrder = inOrder(testResourceServiceImplBase);
    
    inOrder.verify(testResourceServiceImplBase).createResourceUri("testResourceType", "/test/path", "testQuery", "testFragment");
    inOrder.verify(testResourceServiceImplBase).createResourceUri("testResourceType", null, "/test/path", "testQuery", "testFragment");
    
    assertSame(mockResourceUri, resourceUri);
    
    verifyNoMoreInteractions(testResourceServiceImplBase);
  }

  /**
   * Test the {@link ResourceServiceImplBase#createResourceUri(String, URI, String)}
   * method.
   * <p>
   * This test asserts that the {@link ResourceServiceImplBase#createResourceUri(String, URI, String)}
   * method correctly invokes the {@link ResourceServiceImplBase#createResourceUri(String, URI, String, String, String)}
   * method.
   */
  @Test
  public void createResourceUri_String_URI_String() {
    when(testResourceServiceImplBase.createResourceUri(anyString(), (URI)any(), anyString())).thenCallRealMethod();
    
    URI mockResourceUri = URI.create("mockResourceUri:/");
    
    when(testResourceServiceImplBase.createResourceUri(anyString(), (URI)any(), anyString(), anyString(), anyString())).thenReturn(mockResourceUri);
    
    URI testParentResourceUri = URI.create("testParentResourceUri:/");
    
    URI resourceUri = testResourceServiceImplBase.createResourceUri("testResourceType", testParentResourceUri, "/test/path");
    
    InOrder inOrder = inOrder(testResourceServiceImplBase);
    
    inOrder.verify(testResourceServiceImplBase).createResourceUri("testResourceType", testParentResourceUri, "/test/path");
    inOrder.verify(testResourceServiceImplBase).createResourceUri("testResourceType", testParentResourceUri, "/test/path", null, null);
    
    assertSame(mockResourceUri, resourceUri);
    
    verifyNoMoreInteractions(testResourceServiceImplBase);
  }

  /**
   * Test the {@link ResourceServiceImplBase#createResourceUri(String, URI, String, String)}
   * method.
   * <p>
   * This test asserts that the {@link ResourceServiceImplBase#createResourceUri(String, URI, String, String)}
   * method correctly invokes the {@link ResourceServiceImplBase#createResourceUri(String, URI, String, String, String)}
   * method.
   */
  @Test
  public void createResourceUri_String_URI_String_String() {
    when(testResourceServiceImplBase.createResourceUri(anyString(), (URI)any(), anyString(), anyString())).thenCallRealMethod();
    
    URI mockResourceUri = URI.create("mockResourceUri:/");
    
    when(testResourceServiceImplBase.createResourceUri(anyString(), (URI)any(), anyString(), anyString(), anyString())).thenReturn(mockResourceUri);
    
    URI testParentResourceUri = URI.create("testParentResourceUri:/");
    
    URI resourceUri = testResourceServiceImplBase.createResourceUri("testResourceType", testParentResourceUri, "/test/path", "testQuery");
    
    InOrder inOrder = inOrder(testResourceServiceImplBase);
    
    inOrder.verify(testResourceServiceImplBase).createResourceUri("testResourceType", testParentResourceUri, "/test/path", "testQuery");
    inOrder.verify(testResourceServiceImplBase).createResourceUri("testResourceType", testParentResourceUri, "/test/path", "testQuery", null);
    
    assertSame(mockResourceUri, resourceUri);
    
    verifyNoMoreInteractions(testResourceServiceImplBase);
  }
  
  /**
   * Test the {@link ResourceServiceImplBase#createResourceUri(String, URI, String, String, String)}
   * method.
   * <p>
   * This test asserts that the {@link ResourceServiceImplBase#createResourceUri(String, URI, String, String, String)}
   * method throws an {@link IllegalArgumentException} when provided with a <code>null</code>
   * resource type.
   */
  @Test(expected = IllegalArgumentException.class)
  public void createResourceUri_String_URI_String_String_String__withNullResourceType() {
    when(testResourceServiceImplBase.createResourceUri(anyString(), (URI)any(), anyString(), anyString(), anyString())).thenCallRealMethod();
    
    testResourceServiceImplBase.createResourceUri(null, null, null, null, null);
  }
  
  /**
   * Test the {@link ResourceServiceImplBase#createResourceUri(String, URI, String, String, String)}
   * method.
   * <p>
   * This test asserts that the {@link ResourceServiceImplBase#createResourceUri(String, URI, String, String, String)}
   * method throws an {@link IllegalArgumentException} when provided with an
   * empty resource type.
   */
  @Test(expected = IllegalArgumentException.class)
  public void createResourceUri_String_URI_String_String_String__withEmptyResourceType() {
    when(testResourceServiceImplBase.createResourceUri(anyString(), (URI)any(), anyString(), anyString(), anyString())).thenCallRealMethod();
    
    testResourceServiceImplBase.createResourceUri("", null, null, null, null);
  }
  
  /**
   * Test the {@link ResourceServiceImplBase#createResourceUri(String, URI, String, String, String)}
   * method.
   * <p>
   * This test asserts that the {@link ResourceServiceImplBase#createResourceUri(String, URI, String, String, String)}
   * method throws an {@link IllegalArgumentException} when provided with a 
   * <code>null</code> parent resource URI, path and query.
   */
  @Test(expected = IllegalArgumentException.class)
  public void createResourceUri_String_URI_String_String_String__withNullParentResourceUriAndNullPathAndNullQuery() {
    when(testResourceServiceImplBase.createResourceUri(anyString(), (URI)any(), anyString(), anyString(), anyString())).thenCallRealMethod();
    
    testResourceServiceImplBase.createResourceUri("resourceType", null, null, null, null);
  }
  
  /**
   * Test the {@link ResourceServiceImplBase#createResourceUri(String, URI, String, String, String)}
   * method.
   * <p>
   * This test asserts that the {@link ResourceServiceImplBase#createResourceUri(String, URI, String, String, String)}
   * method correctly creates a resource URI.
   */
  @Test
  public void createResourceUri_String_URI_String_String_String() {
    when(testResourceServiceImplBase.createResourceUri(anyString(), (URI)any(), anyString(), anyString(), anyString())).thenCallRealMethod();
    
    String[][] allParams = {
      { "resourceType:?query", "resourceType", null, null, "query", null },
      { "resourceType:?query#fragment", "resourceType", null, null, "query", "fragment" },
      { "resourceType:/path", "resourceType", null, "/path", null, null },
      { "resourceType:/path#fragment", "resourceType", null, "/path", null, "fragment" },
      { "resourceType:/path?query", "resourceType", null, "/path", "query", null },
      { "resourceType:/path?query#fragment", "resourceType", null, "/path", "query", "fragment" },
      { "resourceType:/parentPath", "resourceType", "parentResourceType:/parentPath?parentQuery#parentFragment", null, null, null },
      { "resourceType:/parentPath#fragment", "resourceType", "parentResourceType:/parentPath?parentQuery#parentFragment", null, null, "fragment" },
      { "resourceType:/parentPath?query", "resourceType", "parentResourceType:/parentPath?parentQuery#parentFragment", null, "query", null },
      { "resourceType:/parentPath?query#fragment", "resourceType", "parentResourceType:/parentPath?parentQuery#parentFragment", null, "query", "fragment" },
      { "resourceType:/parentPath/path", "resourceType", "parentResourceType:/parentPath?parentQuery#parentFragment", "/path", null, null },
      { "resourceType:/parentPath/path?query", "resourceType", "parentResourceType:/parentPath?parentQuery#parentFragment", "/path", "query", null },
      { "resourceType:/parentPath/path?query#fragment", "resourceType", "parentResourceType:/parentPath?parentQuery#parentFragment", "/path", "query", "fragment" }
    };
    
    for (String[] params : allParams) {
      assertEquals(URI.create(params[0]), testResourceServiceImplBase.createResourceUri(params[1], params[2] != null ? URI.create(params[2]) : null, params[3], params[4], params[5]));
    }
  }
}
