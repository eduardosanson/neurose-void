package controllers

import play.api.libs.json._
import play.api.mvc._
import models._
import models.Orders._

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

}
