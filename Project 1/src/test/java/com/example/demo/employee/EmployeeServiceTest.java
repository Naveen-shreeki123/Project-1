package com.example.demo.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock private EmployeeRepository employeeRepository;
    private EmployeeService underTest;

    @BeforeEach
    void setUp() {
        underTest = new EmployeeService(employeeRepository);
    }

    @Test
    void getEmployees() {
        //when
        underTest.getEmployees();
        //then
        verify(employeeRepository).findAll();
    }

    @Test
    void addNewEmployee() {
        //given
        Employee employee = new Employee("Shyam","shyam@gmail.com","887643321",21,27000,"Q/A");
        //when
        underTest.addNewEmployee(employee);
        //then
        ArgumentCaptor<Employee> studentArgumentCaptor = ArgumentCaptor.forClass(Employee.class);

        verify(employeeRepository).save(studentArgumentCaptor.capture());
        Employee capturedStudent = studentArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(employee);
    }

    @Test
    void deleteEmployee() {
        long id = 10;
        given(employeeRepository.existsById(id))
                .willReturn(true);
        // when
        underTest.deleteEmployee(id);
        // then
        verify(employeeRepository).deleteById(id);
    }
}