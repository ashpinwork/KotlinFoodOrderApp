import java.io.File

open class Orders {
    private var i:Int = 0
    private var q:Int = 0
    var total = 0f
    private var opt = ""
    private var item = mutableListOf<Int>()
    private var quantity = mutableListOf<Int>()

    fun makeOrder() {
        println("------Place Your Order----")

        do{
            println("Enter your order num:");
            i = Integer.valueOf(readln());

            when(i) {
                1,2,3,0 -> item.add(i)
                else -> throw ErrorException("Invalid Menu Items!")
            }

            println("Enter quantity:")
            q = Integer.valueOf(readln())
            quantity.add(q)

            println("Do you want to add to this? (Y/N)")
            opt = readln()

            when(opt[0]) {
                'Y', 'N', 'y', 'n' -> continue
                else -> throw ErrorException("Invalid Entry!")
            }

        }while(opt[0] == 'y' || opt[0] == 'Y')

    }

    fun confirmation(BillFile: File) {

        BillFile.appendText("------Order Confirmation----\n")
        for(i in 0 until item.size) {
            BillFile.appendText("${quantity[i]}x ${Menu.items[item[i]]} : ${Menu.price[item[i]] * this.quantity[i]}\n")
        }
    }

    fun calculate():Float {
        for(i in 0 until item.size) {
            total += (Menu.price[item[i]] * quantity[i])
        }
        return total
    }



}