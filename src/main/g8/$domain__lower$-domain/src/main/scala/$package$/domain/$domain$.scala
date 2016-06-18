package io.$org$.domain.$domain;format="lower"$

import io.kyriakos.library.domain.Identifiable
import spray.http.ContentTypes.`application/json`
import spray.http.{ContentTypeRange, HttpEntity, MediaTypes}
import spray.httpx.marshalling.Marshaller
import spray.httpx.unmarshalling.Unmarshaller

import scala.language.postfixOps

case class $domain$(data: String) extends Identifiable

object $domain$ {

  import spray.json._
  import DefaultJsonProtocol._

  implicit val $domain;format="lower"$Marshaller: Marshaller[$domain$] = Marshaller.of[$domain$](`application/json`) {
    ($domain;format="lower"$, contentType, marshallingContext) =>
      val jsonString: String = s"""{ "data" : "\${$domain;format="lower"$ data}" }"""
      marshallingContext marshalTo HttpEntity(contentType, jsonString)
  }

  implicit val $domain;format="lower"$Unmarshaller =
    Unmarshaller[$domain$](ContentTypeRange(MediaTypes.`application/json`)) {
      case HttpEntity.NonEmpty(contentType, content) =>
        val jsValue: JsValue = new String(content toByteArray).parseJson
        val fields: Map[String, JsValue] = jsValue.asJsObject.fields
        val data: String = fields("data").convertTo[String]
        $domain$(data)
    }

}
