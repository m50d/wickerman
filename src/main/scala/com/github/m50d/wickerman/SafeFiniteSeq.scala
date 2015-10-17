package com.github.m50d.wickerman

trait SafeFiniteSeq[A] {
  def safeApply(i: Int): Option[A]
  def safeIndexWhere(p: A ⇒ Boolean): Option[Int]
  def isEmpty: Boolean
  def headOption: Option[A]
  def foldLeft[B](z: B)(op: (B, A) ⇒ B): B
  def foldRight[B](z: B)(op: (A, B) ⇒ B): B
  //  def view
  //  def to
  def map[B](f: A ⇒ B): SafeFiniteSeq[B]
  def flatMap[B](f: A ⇒ SafeFiniteSeq[B]): SafeFiniteSeq[B]
  def ++(other: Iterable[A]): Iterable[A]
  def zip[B](other: Iterable[B]): Iterable[(A, B)]
  def partition(p: A ⇒ Boolean): (Iterable[A], Iterable[A])
  def drop(i: Int): Iterable[A]
}