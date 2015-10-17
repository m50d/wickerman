package com.github.m50d.wickerman

@deprecated("Contains many unsafe methods because it conflates finite and infinite collections. Use FiniteSeq or Stream instead", "2.13")
trait Iterable[A] {
  def iterator: Iterator[A]
  def isEmpty: Boolean
  def head: A
  def foldLeft[B](z: B)(op: (B, A) ⇒ B): B
    def foldRight[B](z: B)(op: (A, B) => B): B
  //  def view
  //  def to
  def map[B](f: A ⇒ B): Iterable[B]
  def flatMap[B](f: A => Iterable[B]): Iterable[B]
  def ++(other: Iterable[A]): Iterable[A]
  def zip[B](other: Iterable[B]): Iterable[(A, B)]
  def partition(p: A => Boolean): (Iterable[A], Iterable[A])
  def drop(i: Int): Iterable[A]
}