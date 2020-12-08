package com.aspire.schoolmanagement.controller

import com.aspire.schoolmanagement.service.CommonService
import spock.lang.Specification

class StudentControllerTests extends Specification {
    CommonService commonService = Mock()
    StudentController studentController = new StudentController(commonService)

    def "test getEmployee"() {
        given:
        long employeeID = 3L
        Map<String, Object> emp = new HashMap<>()
        emp.put("employeeID", 3L)
        emp.put("salary", 20000.0f)

        when:
        Map<String, Object> out = studentController.getEmployee(employeeID)

        then:
        1 * commonService.getEmployeeByID(employeeID) >> emp
        1 * commonService.getDummyString() >> "def"
        0 * _

        and:
        out == emp
        out.get("salary") == 20000.0f
    }
}
