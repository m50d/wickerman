package com.github.m50d.wickerman.immutable

import com.github.m50d.wickerman.mutable.Iterator
import com.github.m50d.wickerman

@deprecated("""Unsafe operations on immutable collections don't make a lot of sense.
Safe code should use safe iteration methods like foreach and fold*.
High-performance code likely wants to use mutable collections instead.""", "2.13")
class Iterable[A](step: () ⇒ Option[(A, Iterable[A])]) extends ImmutableIterable[A](step) with com.github.m50d.wickerman.Iterable[A] {
  def iterator = new Iterator[A] {
    private[this] var current = Iterable.this: ImmutableIterable[A]
    override def hasNext = current.step().isDefined
    override def next = {
      val (r, c) = current.step().get
      current = c
      r
    }
  }
  /**
   * Overrides are not necessary but can make intent clearer and/or perform better
   */
  override def isEmpty = step().isEmpty
  override def head = step().get._1

  protected def reversePlus(tail: Iterable[A]): Iterable[A] = step() match {
    case None ⇒ tail
    case Some((a, n)) ⇒ n.reversePlus(new Iterable(() ⇒ Some((a, tail))))
  }

  def reverse = reversePlus(new Iterable(() ⇒ None))
}