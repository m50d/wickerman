package com.github.m50d

package object wickerman {
	@deprecated("Use mutable.Iterator", "2.13")
  type Iterator[A] = mutable.Iterator[A]
  @deprecated("Use immutable.SafeIterable or mutable.Iterable", "2.13")
  type Iterable[A] = mutable.Iterable[A]
}