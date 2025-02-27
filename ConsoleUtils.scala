package org.encalmo.utils

import scala.io.AnsiColor.*

object ConsoleUtils {

  def printlnMessageBoxed(
      size: Int = 90,
      margin: Int = 2,
      color: String,
      frame: Char,
      message: String,
      centered: Boolean = false
  ): Unit =
    print(color)
    println(s"$frame" * size)
    print(RESET)
    printlnMessage(size, margin, color, message, centered)
    print(color)
    println(s"$frame" * size)
    print(RESET)

  def printlnMessageOverlined(
      size: Int = 90,
      margin: Int = 2,
      color: String,
      frame: Char,
      message: String,
      centered: Boolean = false
  ): Unit =
    print(color)
    println(s"$frame" * size)
    print(RESET)
    printlnMessage(size, margin, color, message, centered)
    print(RESET)

  def printlnMessageUnderlined(
      size: Int = 90,
      margin: Int = 2,
      color: String,
      frame: Char,
      message: String,
      centered: Boolean = false
  ): Unit =
    printlnMessage(size, margin, color, message, centered)
    print(color)
    println(s"$frame" * size)
    print(RESET)

  def printlnMessage(
      size: Int,
      margin: Int,
      color: String,
      message: String,
      centered: Boolean = false
  ): Unit =
    print(color)
    print(" " * margin)
    val m1 = message.take(size - 2 * margin)
    val m2 =
      if (message.length() > m1.length())
      then
        val i = m1.lastIndexOf(" ")
        if (i > (size / 2) + (2 * margin))
        then
          if (m1(i - 1) == ',')
          then m1.substring(0, i)
          else m1.substring(0, i + 1)
        else m1
      else m1
    if (centered) then
      val padding = (size - margin - margin - m2.length()) / 2
      print(" " * padding)
    print(m2)
    println(" " * margin)
    print(RESET)
    if (message.length() > m2.length())
    then printlnMessage(size, margin, color, message.drop(m2.length()))
    else ()

  def printlnErrorMessage(message: String): Unit =
    println(s"$RED_B$WHITE$message$RESET")

  def printlnWarningMessage(message: String): Unit =
    println(s"$YELLOW$message$RESET")

  def printlnInfoMessage(message: String): Unit =
    println(s"$GREEN$message$RESET")
}
