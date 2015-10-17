//package com.github.m50d.wickerman.mutable
//
//import com.github.m50d.wickerman.Iterable
//
//trait MutableIterable[A] extends Iterable[A] {
//  def isEmpty = !iterator.hasNext
//  def head = iterator.next
//  def foldLeft[B](z: B)(op: (B, A) => B) = {
//    var tmp = z
//    val it = iterator
//    while(it.hasNext)
//      tmp = op(z, it.next)
//    tmp
//  }
//}