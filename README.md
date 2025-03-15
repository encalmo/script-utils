![Maven Central Version](https://img.shields.io/maven-central/v/org.encalmo/script-utils_3?style=for-the-badge)

# script-utils

Few handy commandline argument parsing and console printing utilities for use in Scala-CLI scripts.

## Usage

Use with SBT

    libraryDependencies += "org.encalmo" %% "script-utils" % "0.9.1"

or with SCALA-CLI

    //> using dep org.encalmo::script-utils:0.9.1

## Examples

```scala
import org.encalmo.utils.CommandLineUtils.*

val functionName: String = 
    requiredScriptParameter('n', "function-name")(args)

val description: Option[String]                        =
  optionalScriptParameter('d', "description")(args)

val useS3Bucket: Boolean                       =
  optionalScriptFlag('b', "use-s3-bucket")(args)
```

```scala
import org.encalmo.utils.ConsoleUtils.*

printlnMessageBoxed(size = 30, margin = 2, message = loremIpsum, color = AnsiColor.CYAN, frame = '=')

printlnMessageUnderlined(size = 40, margin = 3, message = loremIpsum, color = AnsiColor.CYAN, frame = '-')

printlnMessageOverlined(size = 50, margin = 4, message = loremIpsum, color = AnsiColor.CYAN, frame = '*')

printlnMessage(size = 60, margin = 4, color = AnsiColor.CYAN, message = loremIpsum)

printlnErrorMessage("Error!")
printlnWarningMessage("Warning!")
printlnInfoMessage("Info!")
```
