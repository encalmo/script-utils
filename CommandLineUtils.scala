package org.encalmo.utils

import scala.io.AnsiColor.*

object CommandLineUtils {

  def optionalScriptParameter(shortName: Char, longName: String)(
      args: Array[String]
  ): Option[String] =
    args.zipWithIndex
      .find((a, i) =>
        a == s"-$shortName"
          || a.startsWith(s"-$shortName=")
          || a == s"--$longName"
          || a.startsWith(s"--${longName}=")
      )
      .flatMap((a, i) =>
        if (a.startsWith(s"--${longName}="))
        then Some(a.drop(s"--${longName}=".size))
        else if (a.startsWith(s"-$shortName="))
        then Some(a.drop(s"-$shortName=".size))
        else if (args.length > i + 1) then
          val value = args(i + 1)
          if (value.startsWith("-")) None
          else Some(value)
        else None
      )
      .orElse {
        val sysValue = System.getProperty(longName)
        if (sysValue != null) then Some(sysValue)
        else
          val envValue = System.getenv(longName.toUpperCase())
          if (envValue != null) then Some(envValue)
          else None
      }

  def optionalScriptParameter(longName: String)(
      args: Array[String]
  ): Option[String] =
    args.zipWithIndex
      .find((a, i) => a == s"--$longName" || a.startsWith(s"--${longName}="))
      .flatMap((a, i) =>
        if (a.startsWith(s"--${longName}="))
        then Some(a.drop(s"--${longName}=".size))
        else if (args.length > i + 1) then
          val value = args(i + 1)
          if (value.startsWith("-")) None
          else Some(value)
        else None
      )
      .orElse {
        val sysValue = System.getProperty(longName)
        if (sysValue != null) then Some(sysValue)
        else
          val envValue = System.getenv(longName.toUpperCase())
          if (envValue != null) then Some(envValue)
          else None
      }

  def requiredScriptParameter(shortName: Char, longName: String)(
      args: Array[String]
  ): String =
    optionalScriptParameter(shortName, longName)(args)
      .getOrElse {
        System.err.println(
          s"${RED}Required ${BOLD}-$shortName${RESET}${RED} or ${BOLD}--$longName${RESET}${RED} parameter is missing.${RESET}"
        )
        System.exit(1)
        ""
      }

  def requiredScriptParameter(longName: String)(
      args: Array[String]
  ): String =
    optionalScriptParameter(longName)(args)
      .getOrElse {
        System.err.println(
          s"${RED}Required ${BOLD}--$longName${RESET}${RED} parameter is missing.${RESET}"
        )
        System.exit(1)
        ""
      }

  inline def optionalScriptFlag(shortName: Char, longName: String)(
      args: Array[String]
  ): Boolean =
    args.exists(a =>
      a == s"-$shortName"
        || a.startsWith(s"-$shortName=")
        || a == s"--$longName"
        || a.startsWith(s"--$longName=")
    )

  inline def optionalScriptFlag(longName: String)(
      args: Array[String]
  ): Boolean =
    args.exists(a => a == s"--$longName" || a.startsWith(s"--$longName="))
}
