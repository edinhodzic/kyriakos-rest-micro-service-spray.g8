package io.otrl.service.$domain;format="lower"$.$domain$

import io.otrl.domain.$domain;format="lower"$.$domain$
import io.otrl.service.$domain;format="lower"$.converter.Implicits.HttpEntityConverter.{deserialise, serialise}
import org.specs2.mutable.SpecificationWithJUnit
import spray.http.ContentTypes._
import spray.http.HttpEntity

class HttpEntityConverterSpec extends SpecificationWithJUnit {

  private val json: String = """{ "data" : "some data here" }"""

  "HTTP entity converter" should {

    "serialise a customer" in {
      serialise(new $domain$("some data here")).asString must beEqualTo(json)
    }

    "deserialise a http entity" in {
      val httpEntity: HttpEntity = HttpEntity(`application/json`, json)
      deserialise(httpEntity).data must beEqualTo("some data here")
    }

  }

}
