package com.github.m50d.wickerman.mutable

trait Iterable[A] {
  def iterator: Iterator[A]
  def isEmpty = !iterator.hasNext
  def head = iterator.next
  def foldLeft[B](z: B)(op: (B, A) => B) = {
    var tmp = z
    val it = iterator
    while(it.hasNext)
      tmp = op(z, it.next)
    tmp
  }
}