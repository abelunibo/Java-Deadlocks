object Philosopher {

  def main(args: Array[String]) {
    val n = 10
    val f1 = new Fork(1)
    val fn = new Fork(n)
    val pn = new Philosopher(n, fn, f1)
    pn.start()
    pn.createTable(n - 1, f1, fn)
  }
}

class Philosopher(private var number: Int, private var left: Fork, private var right: Fork)
    extends Thread {

  override def toString(): String = "Fil no. " + number

  private def think() {
    println(this.toString + " is thinking")
  }

  private def eat() {
    left.synchronized {
      Thread.sleep(4000)
      println(this + " took left fork no. " + left.number)
      right.synchronized {
        println(this + " took right fork no. " + right.number)
        println(this + " is eating")
      }
    }
  }

  override def run() {
    think()
    eat()
    Thread.sleep(4000)
    this.run()
  }

  def createTable(n: Int, fl: Fork, fr: Fork) {
    if (n == 1) {
      val p1 = new Philosopher(n, fl, fr)
      p1.start()
    } else {
      val fll = new Fork(n)
      val p = new Philosopher(n, fll, fr)
      p.start()
      createTable(n - 1, fl, fll)
    }
  }
}

class Fork(var _number: Int){
  def number = _number
}
