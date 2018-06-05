package multiple.datasource.unit.test

import grails.gorm.transactions.Transactional
import grails.test.hibernate.HibernateSpec
import grails.testing.gorm.DataTest

class HibernateDataTest extends HibernateSpec implements DataTest {

    def setupSpec() {
        mockDomains(Movie)
    }

    @Transactional('books')
    void testWithTransactional() {
        when:
        new Book(title: 'C').save(flush :true, failOnError: true)
        then:
        Book.count == 1
    }

    void testContrainedProperties() {
        expect:
        Movie.constrainedProperties
    }

    void testMappingContext() {
        expect:
        grailsApplication.mappingContext == hibernateDatastore.getMappingContext()
    }

    void testDataStore() {
        expect:
        getDataStore() == hibernateDatastore
    }
}
