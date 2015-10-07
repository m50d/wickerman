package com.github.m50d.wickerman

import com.github.m50d.wickerman.internal.SafeIterator

final class Iterator[A](initial: SafeIterator[A]) {
  private[this] var inner: SafeIterator[A] = initial
  private[this] var current: Option[Option[(A, SafeIterator[A])]] = None
  def hasNext(): Boolean = {
    current = Some(inner.step)
    current.get.isDefined
  }
  def next(): A = {
    val (r, s) = current.getOrElse(inner.step).get
    inner = s
    current = None
    r
  }
}