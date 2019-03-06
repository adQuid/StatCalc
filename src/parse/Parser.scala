package parse

class Parser {
  
  def findNumbers(input: String): Array[java.math.BigDecimal] = {
    input.split("\n").map(str => new java.math.BigDecimal(str));
  }
  
}