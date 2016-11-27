
private object a
private object b

object Program {
  def main(args: Array[String]): Unit = {
    val thread1 = new Thread {
        override def run {
            a.synchronized{
              Thread.sleep(2000)
              b.synchronized{
                println("test")
              }
            }
        }
    }
    thread1.start
    
      val thread2 = new Thread {
        override def run {
            b.synchronized{
              Thread.sleep(2000)
              a.synchronized{
                println("test")
              }
            }
        }
    }
    thread2.start
  }
  
  
}