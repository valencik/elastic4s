package com.sksamuel.elastic4s.handlers.fields

import com.sksamuel.elastic4s.fields.DenseVectorField
import com.sksamuel.elastic4s.json.{XContentBuilder, XContentFactory}

object DenseVectorFieldBuilderFn {
  def toField(name: String, values: Map[String, Any]): DenseVectorField = DenseVectorField(
    name,
    values.get("dims").map(_.asInstanceOf[Int]).get,
    values.get("index").map(_.asInstanceOf[Boolean]),
    values.get("similarity").map(_.asInstanceOf[String]),
  )


  def build(field: DenseVectorField): XContentBuilder = {

    val builder = XContentFactory.jsonBuilder()
    builder.field("type", field.`type`)
    builder.field("dims", field.dims)
    field.index.foreach(builder.field("index", _))
    field.similarity.foreach(builder.field("similarity", _))
    builder.endObject()
  }
}
