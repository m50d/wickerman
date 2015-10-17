package com.github.m50d.wickerman

@deprecated("Use ImmutableIterable, MutableIterable or SafeIterable", "2.13")
trait Iterable[A] extends SafeIterable[A] {
  def iterator: Iterator[A]
  def isEmpty: Boolean
  def head: A
  def foldLeft[B](z: B)(op: (B, A) => B): B
}