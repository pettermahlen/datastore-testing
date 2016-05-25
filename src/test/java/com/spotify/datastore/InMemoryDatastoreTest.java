/*
 * -\-\-
 * Datastore testing
 * --
 * Copyright (C) 2013 - 2016 Spotify AB
 * --
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -/-/-
 */
package com.spotify.datastore;

import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.KeyFactory;
import com.google.common.collect.ImmutableSet;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class InMemoryDatastoreTest {
  InMemoryDatastore datastore;
  KeyFactory keyFactory;

  @Before
  public void setUp() throws Exception {
    datastore = new InMemoryDatastore();

    keyFactory = datastore.newKeyFactory();
  }

  @Test
  public void shouldBeAbleToReadBackAWrittenEntity() throws Exception {
    Entity entity = datastore.add(FullEntity.builder().set("floop", "floppity").build());

    assertThat(datastore.get(entity.key()).getString("floop"), is("floppity"));
  }

  @Test
  public void shouldBeAbleToReadBackMultipleWrittenEntities() throws Exception {
    FullEntity<IncompleteKey> incompleteKeyEntity1 = FullEntity.builder().set("floop", "floppity").build();
    FullEntity<IncompleteKey> incompleteKeyEntity2 = FullEntity.builder().set("floop", "flerp").build();
    List<Entity> entities = datastore.add(incompleteKeyEntity1, incompleteKeyEntity2);

    Set<String> floopProperties = entities.stream()
        .map(entity -> entity.getString("floop"))
        .collect(Collectors.toSet());

    assertThat(floopProperties, is(ImmutableSet.of("floppity", "flerp")));
  }
}