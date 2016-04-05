package io.otrl.service.$domain;format="lower"$

import akka.actor.ActorSystem
import io.otrl.domain.$domain;format="lower"$.$domain$
import io.otrl.library.crud.kamon.KamonRepositoryWrapper
import io.otrl.library.crud.CrudOperations
import io.otrl.service.$domain;format="lower"$.converter.Implicits.HttpEntityConverter
import io.otrl.service.$domain;format="lower"$.converter.DbObjectConverter
import io.otrl.service.$domain;format="lower"$.repository.$domain$CrudRepository
import io.otrl.service.$domain;format="lower"$.router.$domain$RestRouter
import spray.routing.SimpleRoutingApp

import scala.language.postfixOps

object $domain$RestService extends App with SimpleRoutingApp {

  private implicit val actorSystem = ActorSystem("otrl-$domain;format="lower"$-rest-service")

  private implicit val $domain;format="lower"$CrudRepository: CrudOperations[$domain$] = new KamonRepositoryWrapper(new $domain$CrudRepository)
  // private implicit val $domain;format="lower"$CrudRepository: CrudOperations[$domain$] = new KamonRepositoryWrapper(new $domain$CrudRepository(new DbObjectConverter)) // for mongo

  startServer(interface = "localhost", port = 9001) {
    $domain$RestRouter.pingRoute ~ $domain$RestRouter.collectionRoute ~ $domain$RestRouter.itemRoute
  }

}
