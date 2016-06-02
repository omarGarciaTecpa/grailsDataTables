package datatables

import grails.transaction.Transactional

@Transactional
class PersonService {

    def search(String search, Map filterParams) {

        def query = {
            if(search){
                or{
                    ilike('nombre', "%${search}%")
                    ilike('paterno', "%${search}%")
                    ilike('materno', "%${search}%")
                }
            }
        }

        return  [
                list: Person.createCriteria().list(filterParams, query),
                count: Person.createCriteria().count(query) ?: Person.count
        ]
    }
}
