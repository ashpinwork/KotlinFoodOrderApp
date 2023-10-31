
data class Review(var shopexp: Int) {

    companion object {
        fun showRev(num1: Int) {
            println("Your app experience: ${num1}")

            if(num1>2 && num1<6) {
                println("Thank your for the review!")
            }
            else if (num1<=2 && num1>=0) {
                println("We apologize for the disappointment. Please send us your feedback to feedback@taj.com")
            }
            else {
                println("Invalid rating")
            }
        }
    }


}
