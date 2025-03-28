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
  ): Boolean = {
    args.exists(a => a == s"--$longName" || a.startsWith(s"--$longName="))
  }

  def execute(
      command: String,
      cwd: os.Path = os.pwd,
      showOutput: Boolean = true
  ): Either[Iterable[String], Iterable[String]] = {
    executeCommandArray(
      command
        .replace(" \\", " ")
        .replace("\n", "")
        .replace("\r", "")
        .replace("\t", "  ")
        .split(" ")
        .filterNot(_.isBlank()),
      cwd,
      showOutput
    )
  }

  def executeCommandArray(
      commandArray: Array[String],
      cwd: os.Path = os.pwd,
      showOutput: Boolean = true
  ): Either[Iterable[String], Iterable[String]] = {
    if (commandArray.length > 0)
    then {
      println(s"${BLUE}${BOLD}${commandArray.mkString(" ")}${RESET}")
      val out = collection.mutable.Buffer[String]()
      val commandResult = os
        .proc(commandArray)
        .call(
          check = false,
          cwd = cwd,
          stdout = os.ProcessOutput.Readlines { line =>
            if (showOutput) then {
              print(BLUE)
              print(line)
              println(RESET)
            }
            out.append(line)
          },
          stderr = os.ProcessOutput.Readlines { line =>
            if (showOutput) then {
              print(RED)
              print(line)
              println(RESET)
            }
            out.append(line)
          }
        )
      if (commandResult.exitCode != 0)
      then {
        println(
          s"${WHITE}${RED_B}[FATAL] script's command ${YELLOW}${commandArray(
              0
            )}${WHITE} returned ${commandResult.exitCode} ${RESET}"
        )
        Left(out)
      } else {
        Right(out)
      }
    } else Left(Seq.empty)
  }

  extension [L, R](e: Either[L, R]) {
    def exitOfFailure: R =
      e.fold(
        _ => System.exit(2).asInstanceOf[R],
        identity
      )
  }

}
