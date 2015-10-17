//package com.github.m50d.wickerman
//
///**
// * The parts of an Iterable interface that are both safe,
// * and not excessively expensive for mutable collections
// */
//trait SafeIterable[A] {
//  def foldLeft[B](z: B)(op: (B, A) ⇒ B): B
//}