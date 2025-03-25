<a href="https://github.com/encalmo/script-utils">![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)</a> <a href="https://central.sonatype.com/artifact/org.encalmo/script-utils_3" target="_blank">![Maven Central Version](https://img.shields.io/maven-central/v/org.encalmo/script-utils_3?style=for-the-badge)</a> <a href="https://encalmo.github.io/script-utils/scaladoc/org/encalmo/utils.html" target="_blank"><img alt="Scaladoc" src="https://img.shields.io/badge/docs-scaladoc-red?style=for-the-badge"></a>

# script-utils

Few handy commandline argument parsing and console printing utilities for use in Scala-CLI scripts.

## Table of contents

- [Dependencies](#dependencies)
- [Usage](#usage)
- [Examples](#examples)

## Dependencies

   - [Scala](https://www.scala-lang.org) >= 3.3.5

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
├── _site
│   └── scaladoc
│       ├── favicon.ico
│       ├── fonts
│       │   ├── dotty-icons.ttf
│       │   ├── dotty-icons.woff
│       │   ├── FiraCode-Regular.ttf
│       │   ├── Inter-Bold.ttf
│       │   ├── Inter-Medium.ttf
│       │   ├── Inter-Regular.ttf
│       │   └── Inter-SemiBold.ttf
│       │
│       ├── hljs
│       │   ├── highlight.pack.js
│       │   └── LICENSE
│       │
│       ├── images
│       │   ├── banner-icons
│       │   │   ├── error.svg
│       │   │   ├── info.svg
│       │   │   ├── neutral.svg
│       │   │   ├── success.svg
│       │   │   └── warning.svg
│       │   │
│       │   ├── bulb
│       │   │   ├── dark
│       │   │   │   └── default.svg
│       │   │   │
│       │   │   └── light
│       │   │       └── default.svg
│       │   │
│       │   ├── class-big.svg
│       │   ├── class-dark-big.svg
│       │   ├── class-dark.svg
│       │   ├── class.svg
│       │   ├── class_comp.svg
│       │   ├── def-big.svg
│       │   ├── def-dark-big.svg
│       │   ├── discord-icon-black.png
│       │   ├── discord-icon-white.png
│       │   ├── enum-big.svg
│       │   ├── enum-dark-big.svg
│       │   ├── enum-dark.svg
│       │   ├── enum.svg
│       │   ├── enum_comp.svg
│       │   ├── footer-icon
│       │   │   ├── dark
│       │   │   │   └── default.svg
│       │   │   │
│       │   │   └── light
│       │   │       └── default.svg
│       │   │
│       │   ├── github-icon-black.png
│       │   ├── github-icon-white.png
│       │   ├── gitter-icon-black.png
│       │   ├── gitter-icon-white.png
│       │   ├── given-big.svg
│       │   ├── given-dark-big.svg
│       │   ├── given-dark.svg
│       │   ├── given.svg
│       │   ├── icon-buttons
│       │   │   ├── arrow-down
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── arrow-right
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── close
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── copy
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── discord
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── gh
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── gitter
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── hamburger
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── link
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── menu-animated
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── menu-animated-open
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── minus
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── moon
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── plus
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── search
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   ├── sun
│       │   │   │   ├── dark
│       │   │   │   │   ├── active.svg
│       │   │   │   │   ├── default.svg
│       │   │   │   │   ├── disabled.svg
│       │   │   │   │   ├── focus.svg
│       │   │   │   │   ├── hover.svg
│       │   │   │   │   └── selected.svg
│       │   │   │   │
│       │   │   │   └── light
│       │   │   │       ├── active.svg
│       │   │   │       ├── default.svg
│       │   │   │       ├── disabled.svg
│       │   │   │       ├── focus.svg
│       │   │   │       ├── hover.svg
│       │   │   │       └── selected.svg
│       │   │   │
│       │   │   └── twitter
│       │   │       ├── dark
│       │   │       │   ├── active.svg
│       │   │       │   ├── default.svg
│       │   │       │   ├── disabled.svg
│       │   │       │   ├── focus.svg
│       │   │       │   ├── hover.svg
│       │   │       │   └── selected.svg
│       │   │       │
│       │   │       └── light
│       │   │           ├── active.svg
│       │   │           ├── default.svg
│       │   │           ├── disabled.svg
│       │   │           ├── focus.svg
│       │   │           ├── hover.svg
│       │   │           └── selected.svg
│       │   │
│       │   ├── info
│       │   │   ├── dark
│       │   │   │   └── default.svg
│       │   │   │
│       │   │   └── light
│       │   │       └── default.svg
│       │   │
│       │   ├── inkuire.svg
│       │   ├── method-big.svg
│       │   ├── method-dark-big.svg
│       │   ├── method-dark.svg
│       │   ├── method.svg
│       │   ├── no-results-icon.svg
│       │   ├── object-big.svg
│       │   ├── object-dark-big.svg
│       │   ├── object-dark.svg
│       │   ├── object.svg
│       │   ├── object_comp.svg
│       │   ├── package-big.svg
│       │   ├── package-dark-big.svg
│       │   ├── package-dark.svg
│       │   ├── package.svg
│       │   ├── scaladoc_logo.svg
│       │   ├── scaladoc_logo_dark.svg
│       │   ├── static-big.svg
│       │   ├── static-dark-big.svg
│       │   ├── static-dark.svg
│       │   ├── static.svg
│       │   ├── thick-dark.svg
│       │   ├── thick.svg
│       │   ├── trait-big.svg
│       │   ├── trait-dark-big.svg
│       │   ├── trait-dark.svg
│       │   ├── trait.svg
│       │   ├── trait_comp.svg
│       │   ├── twitter-icon-black.png
│       │   ├── twitter-icon-white.png
│       │   ├── type-big.svg
│       │   ├── type-dark-big.svg
│       │   ├── type-dark.svg
│       │   ├── type.svg
│       │   ├── val-big.svg
│       │   ├── val-dark-big.svg
│       │   ├── val-dark.svg
│       │   └── val.svg
│       │
│       ├── index.html
│       ├── inkuire-db.json
│       ├── META-INF
│       │   └── MANIFEST.MF
│       │
│       ├── org
│       │   └── encalmo
│       │       ├── utils
│       │       │   ├── CommandLineUtils$.html
│       │       │   └── ConsoleUtils$.html
│       │       │
│       │       └── utils.html
│       │
│       ├── scaladoc.version
│       ├── scripts
│       │   ├── common
│       │   │   ├── component.js
│       │   │   └── utils.js
│       │   │
│       │   ├── components
│       │   │   ├── DocumentableList.js
│       │   │   ├── Filter.js
│       │   │   ├── FilterBar.js
│       │   │   ├── FilterGroup.js
│       │   │   └── Input.js
│       │   │
│       │   ├── contributors.js
│       │   ├── data.js
│       │   ├── hljs-scala3.js
│       │   ├── inkuire-config.json
│       │   ├── inkuire-worker.js
│       │   ├── inkuire.js
│       │   ├── scaladoc-scalajs.js
│       │   ├── scastieConfiguration.js
│       │   ├── searchData.js
│       │   ├── theme.js
│       │   └── ux.js
│       │
│       ├── styles
│       │   ├── apistyles.css
│       │   ├── code-snippets.css
│       │   ├── content-contributors.css
│       │   ├── dotty-icons.css
│       │   ├── filter-bar.css
│       │   ├── fontawesome.css
│       │   ├── nord-light.css
│       │   ├── searchbar.css
│       │   ├── social-links.css
│       │   ├── staticsitestyles.css
│       │   ├── theme
│       │   │   ├── bundle.css
│       │   │   ├── components
│       │   │   │   ├── bundle.css
│       │   │   │   └── button
│       │   │   │       └── bundle.css
│       │   │   │
│       │   │   └── layout
│       │   │       └── bundle.css
│       │   │
│       │   └── versions-dropdown.css
│       │
│       └── webfonts
│           ├── fa-brands-400.eot
│           ├── fa-brands-400.svg
│           ├── fa-brands-400.ttf
│           ├── fa-brands-400.woff
│           ├── fa-brands-400.woff2
│           ├── fa-regular-400.eot
│           ├── fa-regular-400.svg
│           ├── fa-regular-400.ttf
│           ├── fa-regular-400.woff
│           ├── fa-regular-400.woff2
│           ├── fa-solid-900.eot
│           ├── fa-solid-900.svg
│           ├── fa-solid-900.ttf
│           ├── fa-solid-900.woff
│           └── fa-solid-900.woff2
│
├── CommandLineUtils.scala
├── CommandLineUtils.test.scala
├── ConsoleUtils.scala
├── ConsoleUtils.test.scala
├── LICENSE
├── project.scala
├── README.md
└── script-utils_3-0.9.1.zip
```