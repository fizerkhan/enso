package org.enso.projectmanager.data

import enumeratum._

/** Represents the unit used by progress updates. */
sealed trait ProgressUnit extends EnumEntry
object ProgressUnit extends Enum[ProgressUnit] with CirceEnum[ProgressUnit] {

  /** Indicates that progress is measured by amount of bytes processed. */
  case object Bytes extends ProgressUnit

  /** Indicates that progress is measured by some other unit or it is not
    * measured at all.
    */
  case object Other extends ProgressUnit

  override val values = findValues
}
