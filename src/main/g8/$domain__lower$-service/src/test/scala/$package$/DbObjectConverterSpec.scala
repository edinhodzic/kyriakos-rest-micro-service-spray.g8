package io.otrl.service.$domain;format="lower"$.converter

import com.mongodb.casbah.commons.Imports.DBObject
import com.mongodb.casbah.commons.MongoDBObject
import io.otrl.domain.$domain;format="lower"$.$domain$
import org.specs2.mutable.SpecificationWithJUnit

class DbObjectConverterSpec extends SpecificationWithJUnit {

  private val dbObjectConverter: DbObjectConverter = new DbObjectConverter

  "Db object converter" should {
    "convert a $domain$ to a db object" in {
      val dbObject: DBObject = dbObjectConverter.serialise(new $domain$("some data here"))
      dbObject.get("data").toString must beEqualTo("some data here")
    }
    "convert a db object to a $domain$" in {
      val $domain;format="lower"$: $domain$ = dbObjectConverter.deserialise(MongoDBObject.newBuilder
        .+=("data" -> "some data here")
        .result())
      $domain;format="lower"$.data must beEqualTo("some data here")
    }
  }

}
