import java.lang.NumberFormatException

fun main() {
    println("Welcome to FizzBuzz!")
    var valid_input = 0
    var to:Int = 10
    var play = true
    while(play) {
        try{
            println("What number would you like to go to?")

            to = readLine()?.toInt()?:100
            if(to<0){println("You need to enter a number greater than or equal to zero!")}
            print(count(0, to))
        }
        catch(e:NumberFormatException){println("You need to enter a number!")
            println("Would you like to quit? \nEnter Q if you do, anything else to keep playing.")
            var ip = readLine()
            if(ip == "Q"){play = false}}

    }
}

fun count(from:Int, to:Int):String{
    var display = ""
    for(i in from..to){display += (fizzbuzz(i) + "\n")}
    return(display)
}

fun fizzbuzz(number:Int):String{
    var output = ""
    if(number.rem(3)==0){output = output + "Fizz"}
    if(number.rem(5)==0){output = output + "Buzz"}
    if(number.rem(7)==0){output = output + "Bang"}

    if(number.rem(11)==0){output = "Bong"}  //NB that Bong supersedses Fizz, Buzz and Bang

    if(number.rem(13)==0){
        var B_position = output.indexOf("B")
        if(B_position != -1) {
            output = output.slice(0.. B_position-1) + "Fezz" + output.slice(B_position..output.length-1)
        }


    }
    if(number.rem(17)==0){
        var length = (output.length)/4
        if(length!=0){

            val array: MutableList<String> = ArrayList()

            for(i in 0..(length-1)){
                array.add(output.slice(4*i..4*(i+1)-1))
            }
            output = ""
            for(i in 0..(length-1)){
                output = output + array[length-1-i]
            }
        }
    }

    if(output == ""){output = number.toString()}
    return(output)

}
