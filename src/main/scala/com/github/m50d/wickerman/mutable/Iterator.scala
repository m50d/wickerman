package com.github.m50d.wickerman.mutable

trait Iterator[A] {
  def hasNext: Boolean
  def next: A
}