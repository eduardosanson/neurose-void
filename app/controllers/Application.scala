package controllers

import java.io.File

import models.Orders._
import models._
import play.api.libs.json._
import play.api.mvc._

object Application extends Controller {

  def listOrders = Action {
    Ok(Json.toJson(orders))
  }

  def saveOrder = Action(BodyParsers.parse.json) {request =>
    val o = request.body.validate[Order]
    o.fold(
      errors => {
        BadRequest(Json.obj("status" ->"Ok","message" -> JsError.toFlatJson(errors)))
      },
      order => {
        addOrder(order)
        Created
      }
    )

  }

  def findOrder(id:Integer) = Action {
    val order = findOrderInList(id)

      if(order.isEmpty){
        NotFound
      }else{
        Ok(Json.toJson(order.get))
      }
  }

  def findFile() = Action{
    val path = "public/views/loaderio-3b184bcedbb109ef4d68387df9bc0f5c.txt"

   Ok.sendFile(new File(path))


  }
}
