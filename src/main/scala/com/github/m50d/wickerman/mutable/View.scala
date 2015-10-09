package com.github.m50d.wickerman.mutable

case class View[A](underlying: Iterable[A]) extends Iterable[A] {
  def iterator: Iterator[A] = underlying.iterator
}