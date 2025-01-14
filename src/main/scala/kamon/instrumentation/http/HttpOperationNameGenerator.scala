package kamon.instrumentation.http

import kamon.instrumentation.http.HttpMessage.Request

/**
  * Generates an operation name based on information available on an HTTP request message. Implementations of this
  * class might be used to generate client and/or server side operation names.
  */
trait HttpOperationNameGenerator {

  /**
    * Returns the name to be assigned to the HTTP operation, or None if a name cannot be determined.
    */
  def name(request: Request): Option[String]

}

object HttpOperationNameGenerator {

  /**
    * Uses the request Host to assign a name.
    */
  object Hostname extends HttpOperationNameGenerator {
    override def name(request: Request): Option[String] =
      Option(request.host)
  }

  /**
    * Uses the request HTTP Method to assign a name.
    */
  object Method extends HttpOperationNameGenerator {
    override def name(request: Request): Option[String] =
      Option(request.method)
  }

}