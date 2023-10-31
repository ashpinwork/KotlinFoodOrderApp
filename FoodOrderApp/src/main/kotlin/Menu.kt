// object
object Menu {
    var num = arrayOf<Int>(0, 1, 2, 3)
    var items = arrayOf<String>("Sandwich", "Waffles", "Pancakes", "Ice Cream")
    var price = arrayOf<Float>(200f, 300f,120f, 220f)

    fun displayMenu() {
        println("--------Menu---------")
        println("No \t Item \t    Price")
        for(i in (items.indices)) {
            println()
            println("${num[i]}\t ${items[i]} \t ${price[i]}")
        }
    }
}