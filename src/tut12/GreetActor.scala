package tut12

import akka.

class GreetActorextends extends Actor
{
	val log = Logging(context.system, this)

	def receive =
	{
		case "Thomas" => log.info("received msg")
		case _ => log.info("received unknown message")
	}
}