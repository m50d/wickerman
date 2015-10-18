package com.github.m50d.wickerman.immutable
import com.github.m50d.wickerman
import scala.annotation.tailrec
import com.github.m50d.wickerman.FiniteSeq
import com.github.m50d.wickerman.SafeFiniteSeq

case class SafeList[A](step: Option[(A, SafeList[A])]) extends SafeFiniteSeq[SafeList, A] {
  /**
   * final to demonstrate the possibility of @tailrec
   * Real API would perhaps be trampolined or just stack-unsafe
   */
  @tailrec final override def foldLeft[B](z: B)(op: (B, A) ⇒ B): B = step match {
    case None ⇒ z
    case Some((a, n)) ⇒ n.foldLeft(op(z, a))(op)
  }

  /**
   * Arguably should be trampolined, or at least have a warning
   * about stack usage
   */
  def foldRight[B](z: B)(op: (A, B) ⇒ B): B = step match {
    case None ⇒ z
    case Some((a, n)) ⇒ op(a, n.foldRight(z)(op))
  }

  /**
   * proof-of-concept for accumulator approach which would be used
   * for safeIndexWhere etc.
   */
  @tailrec protected final def lengthPlus(i: Int): Int = step match {
    case None ⇒ i
    case Some((_, n)) ⇒ n.lengthPlus(i + 1)
  }

  def length = lengthPlus(0)

  def safeIndexWhere(p: A ⇒ Boolean): Option[Int] = step match {
    case None ⇒ None
    case Some((a, n)) ⇒ if (p(a)) Some(0) else n.safeIndexWhere(p).map(1.+)
  }

  override def ++(other: SafeList[A]) = step match {
    case None ⇒ other
    case Some((a, n)) ⇒ SafeList(Some(a, n ++ other))
  }

  override def safeDrop(i: Int): Option[SafeList[A]] =
    if (0 == i) Some(this)
    else step flatMap {
      case (_, n) ⇒ n.safeDrop(i - 1)
    }
  
  override def flatMap[B](f: A => SafeList[B]): SafeList[B] = step match {
    case None => SafeList(None)
    case Some((a, n)) => f(a) ++ (n flatMap f)
  }
  
  override def map[B](f: A => B): SafeList[B] = step match {
    case None => SafeList(None)
    case Some((a, n)) => SafeList(Some((f(a), n map f)))
  }

}