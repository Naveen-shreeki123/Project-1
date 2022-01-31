package com.example.demo.employee;
import com.example.demo.employee.Model.Employee;
import com.example.demo.employee.Repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void CheckTestfindEmployeeByEmail() {
        //given
        String email = "shyam@gmail.com";
        Employee employee = new Employee("Shyam","shyam@gmail.com","887643321",21,27000,1);
        underTest.save(employee);

        //when
        boolean expected = underTest.findEmployeeByEmail(email);

        // then
        assertThat(expected).isTrue();
    }

    @Test
    void CheckTestselectExistsEmail() {
        //given
        String email = "shyam@gmail.com";
        //when
        boolean expected = underTest.findEmployeeByEmail(email);
        //then
        assertThat(expected).isFalse();
    }
}
