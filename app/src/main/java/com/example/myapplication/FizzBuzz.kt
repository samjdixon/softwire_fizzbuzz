import java.lang.NumberFormatException


fun main() {
    fun setup() {
        println("Welcome to FizzBuzz!")
    }
    setup()
    var play = true

    while (play) {
        try {
            println("What number would you like to go to?")
            var user_input = readLine()!!
            val to = user_input.toInt()
            if (to < 0) {
                println("You need to enter a number greater than or equal to zero!")
            }
            print(count(0, to))
        } catch (e: NumberFormatException) {

            println("You need to enter a number!")

            println("Would you like to quit? \nEnter Q if you do, anything else to keep playing.")
            var user_input = readLine()
            if (user_input == "Q" || user_input == "q") {
                play = false
            }
        }

    }

}

fun count(from: Int, to: Int): String {
    var display = ""
    for (i in from..to) {
        display += (fizzbuzz(i) + "\n")
    }
    return (display)
}

fun fizzbuzz(number: Int): String {
    var output = ""
    if (number.rem(3) == 0) {
        output = output + "Fizz"
    }
    if (number.rem(5) == 0) {
        output = output + "Buzz"
    }
    if (number.rem(7) == 0) {
        output = output + "Bang"
    }

    if (number.rem(11) == 0) {
        output = "Bong"
    }  //NB that Bong supersedses Fizz, Buzz and Bang

    if (number.rem(13) == 0) {
        //Fezz is inserted immediately before the first "B"
        var B_position = output.indexOf("B")
        if (B_position != -1) {
            output =
                output.slice(0..B_position - 1) + "Fezz" + output.slice(B_position..output.length - 1)
        }


    }
    if (number.rem(17) == 0) {
        //A multiple of 17 reverses the order of all the words.
        var length = (output.length) / 4
        if (length != 0) {

            val array: MutableList<String> = ArrayList()

            for (i in 0..(length - 1)) {
                array.add(output.slice(4 * i..4 * (i + 1) - 1))
            }
            output = ""
            for (i in 0..(length - 1)) {
                output = output + array[length - 1 - i]
            }
        }
    }

    if (output == "") {
        //If none of the cases apply, just print the number.
        output = number.toString()
    }
    return (output)

}
