package com.example.unit2
import kotlin.math.PI
import kotlin.math.sqrt

    fun main() {
        val squareCabin = SquareCabin(6,50.0)
//        println("\nSquare Cabin\n============")
//        println("Capacity: ${squareCabin.capacity}")
//        println("Material: ${squareCabin.buildingMaterial}")
//        println("Has room? ${squareCabin.hasRoom()}")
        with(squareCabin){
          println("Floor area: ${floorArea()}")
          println("\nSquare Cabin\n============")
          println("Capacity: $capacity")
          println("Material: $buildingMaterial")
          println("Has room? ${hasRoom()}")
        }
        val roundHut = RoundHut(3,10.0 )
        with(roundHut) {
            println("\nRound Hut\n=========")
            println("Floor area: ${floorArea()}")
            println("Material: $buildingMaterial")
            println("Capacity: $capacity")
            println("Has room? ${hasRoom()}")
            getRoom()
            println("Has room? ${hasRoom()}")
            getRoom()
            println("Carpet Length: ${calculateMaxCarpetLength()}")
        }
        val roundTower = RoundTower(4, 15.5)
        with(roundTower) {
            println("\nRound Tower\n==========")
            println("Floor area: ${floorArea()}")
            println("Material: $buildingMaterial")
            println("Capacity: $capacity")
            println("Has room? ${hasRoom()}")
            println("Carpet Length: ${calculateMaxCarpetLength()}")
        }

    }
    abstract class Dwelling(private var residents:Int){
        abstract val buildingMaterial: String
        abstract val capacity: Int
        abstract fun floorArea():Double

        fun hasRoom():Boolean{
            return residents < capacity
        }
        fun getRoom(){
            if(hasRoom()){
                residents++
                println("you have a room!")
            } else{
                println("Sorry, at capacity and no rooms left.")
            }
        }

    }
    class SquareCabin(residents:Int, val length: Double) : Dwelling(residents){
        override val buildingMaterial= "Wood"
        override val capacity = 6
        override fun floorArea(): Double{
            return length *length
        }
    }
     open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents){
        override val buildingMaterial= "Straw"
        override val capacity= 4
        override fun floorArea(): Double {
             return PI * radius * radius
         }
         fun calculateMaxCarpetLength(): Double {
             return sqrt(2.0) * radius
         }
    }
    class RoundTower(residents: Int,radius: Double,
    val floors: Int=2) : RoundHut(residents, radius) {
        override val buildingMaterial = "Stone"
         override val capacity = 4 * floors
        override fun floorArea(): Double {
            return super.floorArea()* floors
        }

    }