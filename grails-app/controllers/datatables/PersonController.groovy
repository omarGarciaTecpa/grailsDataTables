package datatables

import grails.converters.JSON

class PersonController {
    def personService

    def list(){
        println("_________________________________________________________")
        println(params)
        def orderColumn = params.getLong('order[0][column]');
        String orderName = params.get("columns[${orderColumn}][data]".toString())
        String search = params.get("search[value]");
        println("Order Column: ${orderColumn}: ${orderName}")
        println("Search : ${search}")
        println("_________________________________________________________")


        Map srchParams = [
                offset: params.getLong('start'),
                max: params.getLong('length'),
                sort: orderName,
                order: params.get('order[0][dir]')
        ]

        Map resultSet = personService.search(search, srchParams)

        Map result =[
                draw: params.getInt('draw'),
                itemList: resultSet.list,
                recordsTotal: Person.count,
                recordsFiltered: resultSet.count
        ]

        render result as JSON
    }
}
