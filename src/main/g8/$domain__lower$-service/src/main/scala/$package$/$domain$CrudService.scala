package io.$org$.service.$domain;format="lower"$

import akka.actor.ActorSystem
import io.$org$.domain.$domain;format="lower"$.$domain$
import io.kyriakos.library.crud.kamon.KamonRepositoryWrapper
import io.kyriakos.library.crud.CrudOperations
import io.$org$.service.$domain;format="lower"$.converter.Implicits.HttpEntityConverter
import io.$org$.service.$domain;format="lower"$.converter.DbObjectConverter
import io.$org$.service.$domain;format="lower"$.repository.$domain$CrudRepository
import io.$org$.service.$domain;format="lower"$.router.$domain$CrudRouter
import spray.routing.SimpleRoutingApp

import scala.language.postfixOps

object $domain$CrudService extends App with SimpleRoutingApp {

  private implicit val actorSystem = ActorSystem("$org$-$domain;format="lower"$-crud-service")

  private implicit val $domain;format="lower"$CrudRepository: CrudOperations[$domain$] = new KamonRepositoryWrapper(new $domain$CrudRepository)
  // private implicit val $domain;format="lower"$CrudRepository: CrudOperations[$domain$] = new KamonRepositoryWrapper(new $domain$CrudRepository(new DbObjectConverter)) // for mongo

  startServer(interface = "localhost", port = 9001) {
    $domain$CrudRouter.pingRoute ~ $domain$CrudRouter.versionRoute ~ $domain$CrudRouter.collectionRoute ~ $domain$CrudRouter.itemRoute
  }

}
