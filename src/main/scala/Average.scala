
case class Average(sum: Int, count: Int) {
  def combine(other: Average): Average =
    Average(this.sum + other.sum, this.count + other.count)
}
