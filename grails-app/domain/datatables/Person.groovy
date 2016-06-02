package datatables

class Person {

    String nombre
    String paterno
    String materno

    static constraints = {

    }

    String toString(){
        "${paterno} ${materno} ${nombre}"
    }
}
