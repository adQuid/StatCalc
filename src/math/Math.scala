package math

import ch.obermuhlner.math.big.BigDecimalMath;

class Math {
  def sum(input:Array[java.math.BigDecimal]): java.math.BigDecimal = {
    input.fold(new java.math.BigDecimal(0.0))(_.add(_))
  }
  def mean(input:Array[java.math.BigDecimal]): java.math.BigDecimal = {
    sum(input).divide(new java.math.BigDecimal(input.length),java.math.MathContext.DECIMAL128)
  }
  def variance(input:Array[java.math.BigDecimal]): java.math.BigDecimal = {
    sum(input.map(x => (x.subtract(mean(input)).multiply(x.subtract(mean(input)))))).divide(new java.math.BigDecimal(input.length),java.math.MathContext.DECIMAL128)
  }
  def standardDeviation(input:Array[java.math.BigDecimal]): java.math.BigDecimal = {
    BigDecimalMath.sqrt(variance(input),java.math.MathContext.DECIMAL128)
  }
  def standardError(input:Array[java.math.BigDecimal]): java.math.BigDecimal = {
    standardDeviation(input).divide(new java.math.BigDecimal(Math.sqrt(input.length)),java.math.MathContext.DECIMAL128)
  }
  
}