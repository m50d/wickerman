package com.github.m50d.wickerman.mutable
import com.github.m50d.wickerman

trait Iterator[A] {
  def hasNext: Boolean
  def next: A
}