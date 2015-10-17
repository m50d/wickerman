package com.github.m50d.wickerman

trait FiniteSeq[A] extends Seq[A] {
  def safeApply(i: Int): Option[A]
  override def apply(i: Int) = safeApply(i).get
  def safeIndexWhere(p: A ⇒ Boolean): Option[Int]
  override def indexWhere(p: A ⇒ Boolean) = safeIndexWhere(p).getOrElse(-1)
  override def reverse: FiniteSeq[A]
}