package io.otrl.client.$domain;format="lower"$

import akka.actor.ActorSystem
import io.otrl.domain.$domain;format="lower"$.$domain$
import io.otrl.library.client.AbstractHttpCrudClient
import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContext.Implicits.global

class $domain$HttpCrudClient
(serviceHost: String)
(implicit actorSystem: ActorSystem, executionContext: ExecutionContext, manifest: Manifest[$domain$])
  extends AbstractHttpCrudClient[$domain$](serviceHost)
