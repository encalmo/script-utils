package org.encalmo.utils

import scala.io.AnsiColor

class ConsoleUtilsSpec extends munit.FunSuite {

  import ConsoleUtils.*

  val loremIpsum =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis porta ac lectus nec viverra. In hac habitasse platea dictumst. Nullam facilisis non magna ut pharetra. Nunc accumsan lacus ac ligula blandit laoreet. Etiam tristique, ex eu mollis fringilla, eros velit efficitur tortor, id tincidunt velit enim id sapien. Donec malesuada mauris lorem, in commodo quam suscipit et. Praesent non pulvinar mauris, eu scelerisque orci. Praesent accumsan viverra lorem nec dignissim. Curabitur elementum consectetur libero, ac sodales arcu interdum sit amet. Etiam malesuada, leo et fringilla luctus, ante augue lobortis diam, ut blandit felis quam eu orci. Morbi non faucibus libero, et mattis lorem. Nunc tristique quam leo, vel congue nunc ultrices non."

  test("ConsoleUtils should print messages") {

    printlnMessageBoxed(size = 30, margin = 2, message = loremIpsum, color = AnsiColor.CYAN, frame = '=')

    printlnMessageUnderlined(size = 40, margin = 3, message = loremIpsum, color = AnsiColor.CYAN, frame = '-')

    printlnMessageOverlined(size = 50, margin = 4, message = loremIpsum, color = AnsiColor.CYAN, frame = '*')

    printlnMessage(size = 60, margin = 4, color = AnsiColor.CYAN, message = loremIpsum)

    printlnErrorMessage("Error!")
    printlnWarningMessage("Warning!")
    printlnInfoMessage("Info!")
  }

}
