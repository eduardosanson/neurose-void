package models

import play.api.libs.json.Json

/**
  * Created by eduardo.sanson on 28/07/2016.
  */
case class Transaction (
  id: Int,
  external_id: String,
  amount: Int,
  types: String,
  authorization_code: String,
  card_brand: String,
  card_bin: String,
  card_last: String

  ){
  implicit val transactionWrites = Json.writes[Transaction]
  implicit val transactionReads = Json.reads[Transaction]

}
