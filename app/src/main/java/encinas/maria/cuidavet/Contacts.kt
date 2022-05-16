package encinas.maria.cuidavet

data class Contacts(var name : String ?= null,var number : String ?= null){
    override fun toString() = name + "\t" + number
}