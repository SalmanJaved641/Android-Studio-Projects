package com.example.kotlin

class MyClass : OpenClass(),Interfaca {

    companion object{
        @JvmStatic
        fun main(args: Array<String>){
            println("Ma hun Salman")
            println("Mari awaz ha bari suriili")

// Variables
            Int
            String
            Float
            Byte
            Boolean
            Double
            Long
            Char
            Short

            var a : Int
            a =20
            val b =30 /*val is final and can't be reassign*/
            var name : String = "Salman"
            println("my name is $name")
            println("num = "+a)

// Methods , functions
            fun add(a:Int,b:Int): Any {

                return a+b
            }
            println("The sum is ${add(30, 20)}")

// Conditional Statements:
            if(b>100){
                println("greater")

            }else if (b == 100){
                println("equal")
            }else{
                println("smaller")

            }

            when{
                b>100->{
                    println("greater")
                }
                b<100->{
                    println("smaller")
                }
                else->{
                    println("equal")
                }
            }

            val num = 20
            val msg = if (num>100)"no greater" else "no less"
            println(msg)

// list
            val list= listOf("SLA", 12,'w') /*by default "any" type*/
            println(list)

            var mutableList = mutableListOf<Any>("ASD",9, true)
            mutableList.add(12.4)
            mutableList.add(0,"Asdf")
            println(mutableList)


// Set
            val set = setOf(1,3,5)

            var mSet = mutableSetOf(1,3,5)

// Map
            val aMap = mapOf<Any,String>(1 to "salman","sad" to "Javed", true to "Iqbal")
            println(aMap)

            val mMap = mutableMapOf<Any,String>(45 to "Shanza","dg" to "Javed", false to "Iqbal")
            mMap.putAll(aMap)
            mMap[1]="SALMAN"
            println(mMap)
// ArrayList
             val array = ArrayList<String>()
            array.add("A")
            array.add("Salman")
            array[0] = "Muhammad"
            println(array)
            array.remove("Salman")
//            array.removeAt(1) for index 1

// loop for:
            var number=0
            for (i in 0 ..  10)
                println("Number:${ number++ }")

            number=0
            for (i in 10 downTo   0 step 2)
                println("Number:${number++} $i")

// for each loop
            val arrNo=ArrayList<Int>()
            arrNo.add(3)
            arrNo.add(6)
            arrNo.add(7)
            arrNo.add(39)
            arrNo.add(12)
            for (i in arrNo)
                println("array no: $i ")

// while and do while loop
            while (number<20){
                println(number)
                number++
            }
            do {
                println(number)
                number--

            }while (number==19)

// Pair
            val (m,n)= Pair(true,"Salman");
            println("$m $n")
/*nested and in names val*/
            val names = Pair("A",Pair("B","C"))
            println("${names.first} ${names.second.first} ${names.second.second}")

// Triple
            val (x,y,z)= Triple("Salman","Javed","Iqbal")
            println("$x $y $z")

        }
    }
}