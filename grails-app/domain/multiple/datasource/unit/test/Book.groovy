package multiple.datasource.unit.test

import grails.gorm.annotation.Entity

@Entity
class Book {

    String title

    static mapping = {
        datasource 'books'
    }

    static constraints = {
        title nullable: false
    }
}
