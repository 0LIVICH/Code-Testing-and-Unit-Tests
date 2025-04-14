package ru.netology;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainTest {


    @Test
    public void testParseCSV() throws Exception {

        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";


        List<Employee> employees = Main.parseCSV(columnMapping, fileName);


        Assertions.assertNotNull(employees);
        Assertions.assertEquals(2, employees.size());  // Ожидаем два сотрудника
        Assertions.assertEquals(1, employees.get(0).id);
        Assertions.assertEquals("John", employees.get(0).firstName);
        Assertions.assertEquals("USA", employees.get(0).country);
    }


    @Test
    public void testListToJson() {

        Employee emp1 = new Employee(1, "John", "Smith", "USA", 25);
        Employee emp2 = new Employee(2, "Inav", "Petrov", "RU", 23);
        List<Employee> list = List.of(emp1, emp2);


        String json = Main.listToJson(list);


        Assertions.assertNotNull(json);
        Assertions.assertTrue(json.contains("\"id\": 1"));
        Assertions.assertTrue(json.contains("\"firstName\": \"John\""));
        Assertions.assertTrue(json.contains("\"lastName\": \"Smith\""));
    }


    @Test
    public void testWriteString() {

        String json = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25}]";


        try {
            Main.writeString(json);
        } catch (IOException e) {
            e.printStackTrace();
        }


        File file = new File("data.json");
        Assertions.assertTrue(file.exists());
        Assertions.assertTrue(file.length() > 0);
    }
}
