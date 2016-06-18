package io.$org$.client.$domain;format="lower"$

import akka.actor.ActorSystem
import io.$org$.domain.$domain;format="lower"$.$domain$
import io.kyriakos.library.client.AbstractHttpCrudClient
import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContext.Implicits.global

class $domain$HttpCrudClient
(serviceHost: String)
(implicit actorSystem: ActorSystem, executionContext: ExecutionContext, manifest: Manifest[$domain$])
  extends AbstractHttpCrudClient[$domain$](serviceHost)
