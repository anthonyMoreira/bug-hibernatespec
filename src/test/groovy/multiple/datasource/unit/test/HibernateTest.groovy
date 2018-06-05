package multiple.datasource.unit.test

import grails.test.hibernate.HibernateSpec

class HibernateTest extends HibernateSpec {

    void testContrainedProperties() {
        expect:
        Movie.constrainedProperties
    }

}
