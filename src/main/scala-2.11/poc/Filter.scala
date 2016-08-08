package poc

import java.nio.file.{Paths, StandardOpenOption}

import akka.actor.ActorSystem
import akka.kafka.Subscriptions
import akka.kafka.scaladsl.{Consumer, Producer}
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.FileIO
import akka.util.ByteString

object Filter extends App with Config with ConsumerSettings with ProducerSettings {

  implicit val system = ActorSystem("filter-actor-system")
  implicit val materializer = ActorMaterializer()

  Consumer.committableSource(consumerSettings("filter-client"), Subscriptions.topics(Incoming))

  Consumer.committableSource(consumerSettings("filter-client"), Subscriptions.topics(Verified))
}

