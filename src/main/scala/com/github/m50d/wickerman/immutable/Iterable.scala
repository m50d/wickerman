package com.github.m50d.wickerman.immutable

import com.github.m50d.wickerman.mutable.Iterator

@deprecated("""Unsafe operations on immutable collections don't make a lot of sense.
Safe code should use safe iteration methods like foreach and fold*.
High-performance code likely wants to use mutable collections instead.""", "2.13")
trait Iterable[A] extends SafeIterable[A] {
  def iterator = new Iterator[A] {
    private[this] var current = Iterable.this: SafeIterable[A]
    override def hasNext = current.step.isDefined
    override def next = {
      val (r, c) = current.step.get
      current = c
      r
    }
  }
  def isEmpty = step.isEmpty
  def head = step.get._1
}