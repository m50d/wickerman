package com.github.m50d.wickerman

trait SafeFiniteSeq[C[X] <: SafeFiniteSeq[C, X], A] {
  def safeApply(i: Int): Option[A]
  def safeIndexWhere(p: A ⇒ Boolean): Option[Int]
  def isEmpty: Boolean
  def headOption: Option[A]
  def foldLeft[B](z: B)(op: (B, A) ⇒ B): B
  def foldRight[B](z: B)(op: (A, B) ⇒ B): B
  //  def view
  //  def to
  def map[B](f: A ⇒ B): C[B]
  def flatMap[B](f: A ⇒ C[B]): C[B]
  def ++(other: C[A]): C[A]
  def zip[B](other: C[B]): C[(A, B)]
  def partition(p: A ⇒ Boolean): (C[A], C[A])
  def safeDrop(i: Int): Option[C[A]]
}