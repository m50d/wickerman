package com.github.m50d.wickerman.immutable

import scala.annotation.tailrec

/**
 * Assumed immutable
 */
trait SafeIterable[A] {
  /**
   * The core operation
   */
  def step: Option[(A, SafeIterable[A])]

  /**
   * final to demonstrate the possibility of @tailrec
   * real API should probably not be final
   */
  @tailrec final def foldLeft[B](z: B)(op: (B, A) ⇒ B): B =
    step match {
      case None ⇒ z
      case Some((a, n)) ⇒ n.foldLeft(op(z, a))(op)
    }

  /**
   * Arguably should be trampolined, or at least have a warning
   * about stack usage
   */
  def foldRight[B](z: B)(op: (A, B) ⇒ B): B =
    step match {
      case None ⇒ z
      case Some((a, n)) ⇒ op(a, n.foldRight(z)(op))
    }

  @tailrec protected final def lengthPlus(i: Int): Int = step match {
    case None ⇒ i
    case Some((_, n)) ⇒ n.lengthPlus(i + 1)
  }
  
  def length = lengthPlus(0)
}