package megafon.internship.controllers;

import megafon.internship.repository.EmployeesRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class PostgresqlConnectionTest {

    @Autowired
    private EmployeesRepo employeesRepo;

    @Test
    public void testingConnection() {
        //тестируем подключение к БД sardor_internship
        //если сможем взять данные из таблицца Employees то значит есть подключение
        //в данный момент не имеет значение что возвращает метод findAll()
        //мы только проверяем тип возвращаемого объекта
        Assertions.assertEquals(employeesRepo.findAll().getClass(), ArrayList.class);
    }

}
