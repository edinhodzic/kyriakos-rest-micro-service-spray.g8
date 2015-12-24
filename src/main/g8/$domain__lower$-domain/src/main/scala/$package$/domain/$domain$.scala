package io.otrl.domain.$domain;format="lower"$

import _root_.spray.http.ContentTypeRange
import _root_.spray.http.ContentTypes._
import _root_.spray.http.HttpEntity
import _root_.spray.http.MediaTypes
import _root_.spray.httpx.marshalling.Marshaller
import _root_.spray.httpx.unmarshalling.Unmarshaller
import _root_.spray.json.DefaultJsonProtocol
import _root_.spray.json.JsValue
import io.otrl.library.domain.Identifiable
import io.otrl.library.domain.Identifiable
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
      case HttpEntity.NonEmpty(contentType, data) =>
        val jsValue: JsValue = new String(data toByteArray).parseJson
        val fields: Map[String, JsValue] = jsValue.asJsObject.fields
        val data: String = fields("data").convertTo[String]
        $domain$(data)
    }

}
