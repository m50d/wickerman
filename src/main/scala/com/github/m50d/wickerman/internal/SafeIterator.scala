package com.github.m50d.wickerman.internal

final class SafeIterator[A](value: => Option[(A, SafeIterator[A])]) {
  def step = value
}