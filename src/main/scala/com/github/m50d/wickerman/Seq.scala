package com.github.m50d.wickerman

@deprecated("Contains many unsafe methods because it conflates finite and infinite collections. Use FiniteSeq or Stream instead", "2.13")
trait Seq[A] extends Iterable[A] {
  def length: Int
  @deprecated("Fails if i > length. Use safeApply instead", "2.13")
  def apply(i: Int): A
  @deprecated("Confused return type. Use safeIndexWhere instead", "2.13")
  def indexWhere(p: A ⇒ Boolean): Int
  def reverse: Seq[A]
}