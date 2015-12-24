package io.otrl.service.$domain;format="lower"$.converter

import com.typesafe.scalalogging.LazyLogging
import io.otrl.domain.$domain;format="lower"$.$domain$
import io.otrl.domain.$domain;format="lower"$.$domain$._
import io.otrl.library.repository.Converter
import spray.http.HttpEntity
import spray.httpx.marshalling._
import spray.httpx.unmarshalling._

object Implicits {

  implicit object HttpEntityConverter extends Converter[$domain$, HttpEntity] with LazyLogging {

    override def serialise($domain;format="lower"$: $domain$): HttpEntity =
      marshal($domain;format="lower"$) match {
      case Right(httpEntity) =>
        logger debug s"serialised \$$domain;format="lower"$ into \$httpEntity"
        httpEntity
      case Left(throwable) => throw throwable
    }

    override def deserialise(httpEntity: HttpEntity): $domain$ =
      httpEntity.as[$domain$] match {
        case Right($domain;format="lower"$) =>
      logger debug s"deserialised \$httpEntity into \$$domain;format="lower"$"
      $domain;format="lower"$
        case Left(deserializationError) => throw new RuntimeException(
          s"error deserialising \$httpEntity into $domain;format="lower"$ (info:\$deserializationError)")
      }
  }


}
