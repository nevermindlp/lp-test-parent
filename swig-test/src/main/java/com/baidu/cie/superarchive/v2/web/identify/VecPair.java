/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.1.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.baidu.cie.superarchive.v2.web.identify;

public class VecPair extends java.util.AbstractList<Pair> implements java.util.RandomAccess {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected VecPair(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(VecPair obj) {
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
        SearchDocModuleJNI.delete_VecPair(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public VecPair(Pair[] initialElements) {
    this();
    reserve(initialElements.length);

    for (Pair element : initialElements) {
      add(element);
    }
  }

  public VecPair(Iterable<Pair> initialElements) {
    this();
    for (Pair element : initialElements) {
      add(element);
    }
  }

  public Pair get(int index) {
    return doGet(index);
  }

  public Pair set(int index, Pair e) {
    return doSet(index, e);
  }

  public boolean add(Pair e) {
    modCount++;
    doAdd(e);
    return true;
  }

  public void add(int index, Pair e) {
    modCount++;
    doAdd(index, e);
  }

  public Pair remove(int index) {
    modCount++;
    return doRemove(index);
  }

  protected void removeRange(int fromIndex, int toIndex) {
    modCount++;
    doRemoveRange(fromIndex, toIndex);
  }

  public int size() {
    return doSize();
  }

  public VecPair() {
    this(SearchDocModuleJNI.new_VecPair__SWIG_0(), true);
  }

  public VecPair(VecPair other) {
    this(SearchDocModuleJNI.new_VecPair__SWIG_1(VecPair.getCPtr(other), other), true);
  }

  public long capacity() {
    return SearchDocModuleJNI.VecPair_capacity(swigCPtr, this);
  }

  public void reserve(long n) {
    SearchDocModuleJNI.VecPair_reserve(swigCPtr, this, n);
  }

  public boolean isEmpty() {
    return SearchDocModuleJNI.VecPair_isEmpty(swigCPtr, this);
  }

  public void clear() {
    SearchDocModuleJNI.VecPair_clear(swigCPtr, this);
  }

  public VecPair(int count, Pair value) {
    this(SearchDocModuleJNI.new_VecPair__SWIG_2(count, Pair.getCPtr(value), value), true);
  }

  private int doSize() {
    return SearchDocModuleJNI.VecPair_doSize(swigCPtr, this);
  }

  private void doAdd(Pair x) {
    SearchDocModuleJNI.VecPair_doAdd__SWIG_0(swigCPtr, this, Pair.getCPtr(x), x);
  }

  private void doAdd(int index, Pair x) {
    SearchDocModuleJNI.VecPair_doAdd__SWIG_1(swigCPtr, this, index, Pair.getCPtr(x), x);
  }

  private Pair doRemove(int index) {
    return new Pair(SearchDocModuleJNI.VecPair_doRemove(swigCPtr, this, index), true);
  }

  private Pair doGet(int index) {
    return new Pair(SearchDocModuleJNI.VecPair_doGet(swigCPtr, this, index), false);
  }

  private Pair doSet(int index, Pair val) {
    return new Pair(SearchDocModuleJNI.VecPair_doSet(swigCPtr, this, index, Pair.getCPtr(val), val), true);
  }

  private void doRemoveRange(int fromIndex, int toIndex) {
    SearchDocModuleJNI.VecPair_doRemoveRange(swigCPtr, this, fromIndex, toIndex);
  }

}
