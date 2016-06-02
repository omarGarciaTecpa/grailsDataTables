import datatables.Person
import groovy.json.JsonSlurper

class BootStrap {

    def grailsApplication

    def init = { servletContext ->
        loadPeople()
    }

    def destroy = {
    }


    void loadPeople(){
        if(Person.count == 0){
            File jsonFile = grailsApplication.getMainContext().getResource('DATA/MOCK_DATA.json')?.file

            if(jsonFile){
                println("\n**Se encontro el archivo: ${jsonFile.getPath()}")
                JsonSlurper slurper = new JsonSlurper()
                def jsonData = slurper.parse(jsonFile)

                Person personInstance

                for(def dataItem in jsonData) {
                    personInstance = new Person()
                    personInstance.nombre = dataItem['nombre']
                    personInstance.paterno = dataItem['paterno']
                    personInstance.materno = dataItem['materno']
                    println("Importando ${personInstance}")
                    personInstance.save(flush: true, failOnError: true)
                }
            }
        }
    }
}
