<a href="https://github.com/encalmo/script-utils">![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)</a> <a href="https://central.sonatype.com/artifact/org.encalmo/script-utils_3" target="_blank">![Maven Central Version](https://img.shields.io/maven-central/v/org.encalmo/script-utils_3?style=for-the-badge)</a> <a href="https://encalmo.github.io/script-utils/scaladoc/org/encalmo/utils.html" target="_blank"><img alt="Scaladoc" src="https://img.shields.io/badge/docs-scaladoc-red?style=for-the-badge"></a>

# script-utils

Few handy commandline argument parsing and console printing utilities for use in Scala-CLI scripts.

## Table of contents

- [Dependencies](#dependencies)
- [Usage](#usage)
- [Examples](#examples)
- [Project content](#project-content)

## Dependencies

   - [Scala](https://www.scala-lang.org) >= 3.3.5
   - com.lihaoyi [**os-lib** 0.11.4](https://github.com/com-lihaoyi/os-lib)

## Usage

Use with SBT

    libraryDependencies += "org.encalmo" %% "script-utils" % "0.9.1"

or with SCALA-CLI

    //> using dep org.encalmo::script-utils:0.9.1

## Examples

```scala
execute("git status")

executeCommandArray(Array("git", "status"), showOutput = false)
```

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


## Project content

```
├── .github
│   └── workflows
│       ├── pages.yaml
│       ├── release.yaml
│       └── test.yaml
│
├── .gitignore
├── .scalafmt.conf
├── CommandLineUtils.scala
├── CommandLineUtils.test.scala
├── ConsoleUtils.scala
├── ConsoleUtils.test.scala
├── LICENSE
├── project.scala
├── README.md
└── test.sh
```

