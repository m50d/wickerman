package com.github.m50d.wickerman

/**
 * FiniteSeq would be a supertrait of List and Vector
 * I think one of the biggest problems with Seq is
 * that it blurs the distinction between finite and
 * infinite; as a result it has a lot of unsafe methods
 */
@deprecated("Use FiniteSeq or Stream", "2.13")
trait Seq[A] extends Iterable[A] {

}