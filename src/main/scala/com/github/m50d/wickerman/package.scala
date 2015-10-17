package com.github.m50d

package object wickerman {
	@deprecated("Use mutable.Iterator", "2.13")
  type Iterator[A] = mutable.Iterator[A]
}