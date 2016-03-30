package io.otrl.service.$domain;format="lower"$.converter

import com.mongodb.DBObject
import com.mongodb.casbah.commons.MongoDBObject
import io.otrl.domain.$domain;format="lower"$.$domain$
import io.otrl.library.crud.Converter

class DbObjectConverter extends Converter[$domain$, DBObject] {

  override def serialise($domain;format="lower"$: $domain$): DBObject =
    MongoDBObject.newBuilder
      .+=("data" -> $domain;format="lower"$.data)
  .result()

  override def deserialise(dbObject: DBObject): $domain$ =
    $domain$(dbObject.get("data").asInstanceOf[String])

}
