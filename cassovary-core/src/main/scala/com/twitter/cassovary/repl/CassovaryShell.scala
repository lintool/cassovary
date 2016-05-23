package com.twitter.cassovary.repl

import scala.tools.nsc.Settings
import scala.tools.nsc.interpreter.ILoop

object CassovaryShell extends App {
  val settings = new Settings
  settings.usejavacp.value = true
  settings.deprecation.value = true

  new CassovaryILoop().process(settings)
}

class CassovaryILoop extends ILoop {
  override def prompt = "=> "

  override def printWelcome() {
    echo("\nWelcome to the Cassovary Shell!")
  }

  override def createInterpreter: Unit = {
    super.createInterpreter
    intp.interpret("import com.twitter.cassovary.graph._")
  }
}