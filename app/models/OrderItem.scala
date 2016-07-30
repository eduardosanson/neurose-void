package models

import play.api.libs.json.Json

/**
  * Created by eduardo.sanson on 28/07/2016.
  */
case class OrderItem (
  sku: Int,
  unit_price: Int,
  quantity: Int

                     ){
  implicit val orderItemWrites = Json.writes[OrderItem]
  implicit val orderItemReads = Json.reads[OrderItem]

}
