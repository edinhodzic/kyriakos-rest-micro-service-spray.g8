package io.otrl.service.$domain;format="lower"$

import akka.actor.ActorSystem
import io.otrl.domain.$domain;format="lower"$.$domain$
import io.otrl.library.repository.kamon.KamonRepositoryWrapper
import io.otrl.library.repository.{AbstractPartialCrudRepository, PartialUpdates}
import io.otrl.service.$domain;format="lower"$.converter.Implicits.HttpEntityConverter
import io.otrl.service.$domain;format="lower"$.repository.$domain$CrudRepository
import io.otrl.service.$domain;format="lower"$.router.$domain$RestRouter
import spray.routing.SimpleRoutingApp

import scala.language.postfixOps

object $domain$RestService extends App with SimpleRoutingApp {

  private implicit val actorSystem = ActorSystem("otrl-$domain;format="lower"$-rest-service")

  //  private implicit val $domain;format="lower"$CrudRepository: $domain$CrudRepository = new $domain$CrudRepository
  //  private implicit val $domain;format="lower"$CrudRepository: $domain$CrudRepository = new $domain$CrudRepository(new DbObjectConverter)
  private implicit val $domain;format="lower"$CrudRepository: AbstractPartialCrudRepository[$domain$] with PartialUpdates[$domain$] = new KamonRepositoryWrapper(new $domain$CrudRepository)

  startServer(interface = "localhost", port = 9001) {
    $domain$RestRouter.collectionRoute ~ $domain$RestRouter.itemRoute
  }

}
