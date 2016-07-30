package models

import java.util.Calendar

import play.api.libs.json.{Json, _}

/**
  * Created by eduardo.sanson on 28/07/2016.
  */
object Orders {

  implicit val orderItemWrites = Json.writes[OrderItem]
  implicit val orderItemReads = Json.reads[OrderItem]

  implicit val transactionWrites = Json.writes[Transaction]
  implicit val transactionReads = Json.reads[Transaction]

  implicit val orderWrites = new Writes[Order] {
    def writes(order: Order) = Json.obj(
      "id" -> order.id,
      "items" -> order.items,
      "transactions"->order.transactions,
      "status" -> order.status,
      "created_at" -> order.created_at,
      "updated_at" -> order.updated_at,
      "notes" -> order.notes,
      "number" -> order.number,
      "price" -> order.price,
      "reference" -> order.reference
    )
  }

  implicit val orderReads = Json.reads[Order]

  implicit var orderItem = List(OrderItem(1,2,3),OrderItem(1,2,3))
  implicit var transactions = List(Transaction(1,"51",205,"teste","asdsad124","VISA","5468","5111"))

  implicit var now = Calendar.getInstance().getTime;

  val number : Option[String] = Some("Teste")
  val referencia : Option[String] = Some("Teste")
  val notes : Option[String] = Some("Teste")

  var orders = List(Order(2,number,referencia,"PAGO",now,now,orderItem,notes,transactions,80))

  def addOrder(o:Order) = orders = orders ::: List(o)

  def findOrderInList(id:Integer) = orders.find(o=>o.id==id)

}
