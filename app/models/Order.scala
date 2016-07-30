package models

import java.util.Date

import play.api.libs.json.{Json, Writes}

/**
  * Created by eduardo.sanson on 28/07/2016.
  */
case class  Order (
                   id: Int,
                   number: Option[String],
                   reference: Option[String],
                   status: String,
                   created_at: Date,
                   updated_at: Date,
                   items: List[OrderItem],
                   notes: Option[String],
                   transactions: List[Transaction],
                   price: Int

)


