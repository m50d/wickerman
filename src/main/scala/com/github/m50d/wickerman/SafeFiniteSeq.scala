package com.github.m50d.wickerman

trait SafeFiniteSeq[A] {
  def safeApply(i: Int): Option[A]
  def safeIndexWhere(p: A ⇒ Boolean): Option[Int]
}