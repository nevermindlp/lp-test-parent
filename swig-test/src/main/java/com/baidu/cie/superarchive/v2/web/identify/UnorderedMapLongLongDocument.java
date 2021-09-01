/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.1.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.baidu.cie.superarchive.v2.web.identify;

public class UnorderedMapLongLongDocument extends java.util.AbstractMap<Long, Document> {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected UnorderedMapLongLongDocument(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(UnorderedMapLongLongDocument obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        SearchDocModuleJNI.delete_UnorderedMapLongLongDocument(swigCPtr);
      }
      swigCPtr = 0;
    }
  }


  public int size() {
    return sizeImpl();
  }

  public boolean containsKey(Object key) {
    if (!(key instanceof Long)) {
      return false;
    }

    return containsImpl((Long)key);
  }

  public Document get(Object key) {
    if (!(key instanceof Long)) {
      return null;
    }

    Iterator itr = find((Long) key);
    if (itr.isNot(end())) {
      return itr.getValue();
    }

    return null;
  }

  public Document put(Long key, Document value) {
    Iterator itr = find((Long) key);
    if (itr.isNot(end())) {
      Document oldValue = itr.getValue();
      itr.setValue(value);
      return oldValue;
    } else {
      putUnchecked(key, value);
      return null;
    }
  }

  public Document remove(Object key) {
    if (!(key instanceof Long)) {
      return null;
    }

    Iterator itr = find((Long) key);
    if (itr.isNot(end())) {
      Document oldValue = itr.getValue();
      removeUnchecked(itr);
      return oldValue;
    } else {
      return null;
    }
  }

  public java.util.Set<Entry<Long, Document>> entrySet() {
    java.util.Set<Entry<Long, Document>> setToReturn =
        new java.util.HashSet<Entry<Long, Document>>();

    Iterator itr = begin();
    final Iterator end = end();
    while (itr.isNot(end)) {
      setToReturn.add(new Entry<Long, Document>() {
        private Iterator iterator;

        private Entry<Long, Document> init(Iterator iterator) {
          this.iterator = iterator;
          return this;
        }

        public Long getKey() {
          return iterator.getKey();
        }

        public Document getValue() {
          return iterator.getValue();
        }

        public Document setValue(Document newValue) {
          Document oldValue = iterator.getValue();
          iterator.setValue(newValue);
          return oldValue;
        }
      }.init(itr));
      itr = itr.getNextUnchecked();
    }

    return setToReturn;
  }

  public UnorderedMapLongLongDocument() {
    this(SearchDocModuleJNI.new_UnorderedMapLongLongDocument__SWIG_0(), true);
  }

  public UnorderedMapLongLongDocument(UnorderedMapLongLongDocument other) {
    this(SearchDocModuleJNI.new_UnorderedMapLongLongDocument__SWIG_1(UnorderedMapLongLongDocument.getCPtr(other), other), true);
  }

  static protected class Iterator {
    private transient long swigCPtr;
    protected transient boolean swigCMemOwn;

    protected Iterator(long cPtr, boolean cMemoryOwn) {
      swigCMemOwn = cMemoryOwn;
      swigCPtr = cPtr;
    }

    protected static long getCPtr(Iterator obj) {
      return (obj == null) ? 0 : obj.swigCPtr;
    }

    @SuppressWarnings("deprecation")
    protected void finalize() {
      delete();
    }

    public synchronized void delete() {
      if (swigCPtr != 0) {
        if (swigCMemOwn) {
          swigCMemOwn = false;
          SearchDocModuleJNI.delete_UnorderedMapLongLongDocument_Iterator(swigCPtr);
        }
        swigCPtr = 0;
      }
    }

    private Iterator getNextUnchecked() {
      return new Iterator(SearchDocModuleJNI.UnorderedMapLongLongDocument_Iterator_getNextUnchecked(swigCPtr, this), true);
    }

    private boolean isNot(Iterator other) {
      return SearchDocModuleJNI
              .UnorderedMapLongLongDocument_Iterator_isNot(swigCPtr, this, Iterator.getCPtr(other), other);
    }

    private long getKey() {
      return SearchDocModuleJNI.UnorderedMapLongLongDocument_Iterator_getKey(swigCPtr, this);
    }

    private Document getValue() {
      return new Document(SearchDocModuleJNI.UnorderedMapLongLongDocument_Iterator_getValue(swigCPtr, this), true);
    }

    private void setValue(Document newValue) {
      SearchDocModuleJNI
              .UnorderedMapLongLongDocument_Iterator_setValue(swigCPtr, this, Document.getCPtr(newValue), newValue);
    }

  }

  public boolean isEmpty() {
    return SearchDocModuleJNI.UnorderedMapLongLongDocument_isEmpty(swigCPtr, this);
  }

  public void clear() {
    SearchDocModuleJNI.UnorderedMapLongLongDocument_clear(swigCPtr, this);
  }

  private Iterator find(long key) {
    return new Iterator(SearchDocModuleJNI.UnorderedMapLongLongDocument_find(swigCPtr, this, key), true);
  }

  private Iterator begin() {
    return new Iterator(SearchDocModuleJNI.UnorderedMapLongLongDocument_begin(swigCPtr, this), true);
  }

  private Iterator end() {
    return new Iterator(SearchDocModuleJNI.UnorderedMapLongLongDocument_end(swigCPtr, this), true);
  }

  private int sizeImpl() {
    return SearchDocModuleJNI.UnorderedMapLongLongDocument_sizeImpl(swigCPtr, this);
  }

  private boolean containsImpl(long key) {
    return SearchDocModuleJNI.UnorderedMapLongLongDocument_containsImpl(swigCPtr, this, key);
  }

  private void putUnchecked(long key, Document value) {
    SearchDocModuleJNI.UnorderedMapLongLongDocument_putUnchecked(swigCPtr, this, key, Document.getCPtr(value), value);
  }

  private void removeUnchecked(Iterator itr) {
    SearchDocModuleJNI.UnorderedMapLongLongDocument_removeUnchecked(swigCPtr, this, Iterator.getCPtr(itr), itr);
  }

}