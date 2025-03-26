package org.encalmo.utils

class CommandLineUtilsSpec extends munit.FunSuite {

  import CommandLineUtils.*

  test("CommandLineUtils should provide methods to retrieve script arguments") {

    val args = "--aaa=A --bbb BBB -d --check-it".split(" ")
    val args2 = "-a=A -b BBB -d --check-it".split(" ")

    assertEquals(requiredScriptParameter('a', "aaa")(args2), "A")
    assertEquals(requiredScriptParameter("aaa")(args), "A")

    assertEquals(optionalScriptParameter('b', "bbb")(args2), Some("BBB"))
    assertEquals(optionalScriptParameter("bbb")(args), Some("BBB"))
    assertEquals(optionalScriptParameter('c', "ccc")(args2), None)
    assertEquals(optionalScriptParameter("ccc")(args2), None)

    assertEquals(optionalScriptFlag("ccc")(args), false)
    assertEquals(optionalScriptFlag("aaa")(args), true)
    assertEquals(optionalScriptFlag("bbb")(args), true)
    assertEquals(optionalScriptFlag("ddd")(args), false)
    assertEquals(optionalScriptFlag("foo")(args), false)
    assertEquals(optionalScriptFlag('c', "ccc")(args2), false)
    assertEquals(optionalScriptFlag('a', "aaa")(args2), true)
    assertEquals(optionalScriptFlag('b', "bbb")(args2), true)
    assertEquals(optionalScriptFlag('d', "ddd")(args2), true)
    assertEquals(optionalScriptFlag('f', "foo")(args2), false)
    assertEquals(optionalScriptFlag("check-it")(args), true)
    assertEquals(optionalScriptFlag("check-it")(args2), true)
  }

  test("execute a command") {
    execute("git status")
  }

  test("execute a command array") {
    executeCommandArray(Array("git", "status"), showOutput = false)
  }
}
