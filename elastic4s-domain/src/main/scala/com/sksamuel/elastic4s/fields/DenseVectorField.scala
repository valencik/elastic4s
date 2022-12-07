package com.sksamuel.elastic4s.fields

object DenseVectorField {
  val `type`: String = "dense_vector"
}
case class DenseVectorField(name: String,
                            dims: Int,
                            index: Option[Boolean] = None, // https://www.elastic.co/guide/en/elasticsearch/reference/current/mapping-index.html
                            similarity: Option[String] = None) extends ElasticField {
  override def `type`: String = DenseVectorField.`type`
}
