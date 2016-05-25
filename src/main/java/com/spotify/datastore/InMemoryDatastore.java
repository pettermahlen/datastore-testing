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

import com.google.cloud.datastore.Batch;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.ReadOption;
import com.google.cloud.datastore.Transaction;

import java.util.Iterator;
import java.util.List;

/**
 * In-memory implementation of a google cloud Datastore intended for use in unit tests.
 *
 * Has no support for:
 * - transactions
 */
public class InMemoryDatastore implements Datastore {

  public Transaction newTransaction() {
    return null;
  }

  public <T> T runInTransaction(TransactionCallable<T> callable) {
    return null;
  }

  public Batch newBatch() {
    return null;
  }

  public Key allocateId(IncompleteKey key) {
    return null;
  }

  public List<Key> allocateId(IncompleteKey... key) {
    return null;
  }

  public Entity add(FullEntity<?> entity) {
    return null;
  }

  public List<Entity> add(FullEntity<?>... entity) {
    return null;
  }

  public void update(Entity... entity) {

  }

  public void put(Entity... entity) {

  }

  public void delete(Key... key) {

  }

  public KeyFactory newKeyFactory() {
    return null;
  }

  public Entity get(Key key, ReadOption... options) {
    return null;
  }

  public Iterator<Entity> get(Iterable<Key> keys, ReadOption... options) {
    return null;
  }

  public List<Entity> fetch(Iterable<Key> keys, ReadOption... options) {
    return null;
  }

  public <T> QueryResults<T> run(Query<T> query, ReadOption... options) {
    return null;
  }

  public DatastoreOptions options() {
    return null;
  }

  public Entity get(Key key) {
    return null;
  }

  public Iterator<Entity> get(Key... key) {
    return null;
  }

  public List<Entity> fetch(Key... keys) {
    return null;
  }

  public <T> QueryResults<T> run(Query<T> query) {
    return null;
  }
}
