package com.github.m50d.wickerman

trait FiniteSeq[A] extends SafeFiniteSeq[A] with Seq[A] {
  override def apply(i: Int) = safeApply(i).get
  override def indexWhere(p: A ⇒ Boolean) = safeIndexWhere(p).getOrElse(-1)
  override def reverse: FiniteSeq[A]
  override def map[B](f: A ⇒ B): FiniteSeq[B]
}