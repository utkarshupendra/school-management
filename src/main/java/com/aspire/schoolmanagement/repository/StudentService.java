/*
package com.aspire.schoolmanagement.service;

import com.aspire.schoolmanagement.models.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public Map<String, Object> save(Map<String, Object> student) {
        //Select data from table

        */
/*jdbcTemplate.execute("CREATE TABLE if not exists employee (\n" +
                "\temployeeID bigserial PRIMARY KEY,\n" +
                "\tcontact bigint,\n" +
                "\taddress varchar(100),\n" +
                "\tsalary float,\n" +
                "\tdesignation varchar(20),\n" +
                "\tdepartment varchar(20),\n" +
                "\tcontractTenure varchar(20)\n" +
                ")");*//*



        */
/*dbcTemplate.update("insert into student(name, contact, address, grade, section, percentage) values(?,?,?,?,?,?)",
                student.get("name"),
                Long.parseLong((String) student.get("contact")),
                student.get("address"),
                Integer.parseInt((String) student.get("grade")),
                student.get("section"),
                Float.parseFloat((String) student.get("percentage")));*//*


        List<Map<String, Object>> studentList = jdbcTemplate.queryForList("select * from student where name=?", student.get("name"));
        List<Student> students = jdbcTemplate.query("select * from student", (resultSet, i) -> {
            Student student1 = new Student(resultSet.getString("name"), resultSet.getLong("studentID"), resultSet.getLong("contact"), null, 0, 'A');
            return student1;
        });

        Map<String, Object> sMap = jdbcTemplate.queryForMap("insert into student(name, contact, address, grade, section, percentage) values(?,?,?,?,?,?) RETURNING studentID",
                student.get("name"),
                Long.parseLong((String) student.get("contact")),
                student.get("address"),
                Integer.parseInt((String) student.get("grade")),
                student.get("section"),
                Float.parseFloat((String) student.get("percentage")));

        student.put("studentID", sMap.get("studentID"));
        return student;
    }

    // [1,4,2,3,6]
    //public List<Student> getAllStudents() {
        List<Map<String, Object>> students = jdbcTemplate.queryForList("select * from student");
        */
/*List<Student> studentList = new ArrayList<>();

        studentList = students.stream()
                .map(stringObjectMap -> new Student(stringObjectMap.get("name"), stringObjectMap.get("address"), stringObjectMap.get("contact")))
                .sorted((o1, o2) -> o1.getGrade() - o2.getGrade())
                .filter((o1) -> o1.getGrade() < 5)
                .collect(Collectors.toList());
*//*

        */
/*studentList = students.stream().map(new Function<Map<String, Object>, Student>() {
            @Override
            public Student apply(Map<String, Object> stringObjectMap) {
                return new Student(stringObjectMap.get("name"), stringObjectMap.get("address"), stringObjectMap.get("contact"));
            }
        }).sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getGrade() - o2.getGrade();
            }
        }).collect(Collectors.toList());*//*


               */
/* .forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student);
            }
        });*//*


        */
/*students.stream().sorted((o1, o2) -> {
            int x = ((Float) o1.get("percentage")).compareTo((Float) o2.get("percentage"));
            return x;
        });


        students.stream().sorted(new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                return ((Float) o1.get("percentage")).compareTo((Float) o2.get("percentage"));
            }
        })*//*

    //}

    */
/*public Student createStudent(Student student) {
        jdbcTemplate.update("insert into student(name, contact, address, grade, section, percentage) values (?,?,?,?,?,?)",
                student.getName(),
                student.getContact(),
                student.getAddress(),
                student.getGrade(),
                String.valueOf(student.getSection()),
        return student;
    }*//*


        */
/*Connection connection = PostgresManager.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student(name, contact, address, grade, section, percentage) values (?,?,?,?,?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setLong(2, student.getContact());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setInt(4, student.getGrade());
            preparedStatement.setString(5, String.valueOf(student.getSection()));
            preparedStatement.setFloat(6, student.getPercentage());
            preparedStatement.execute();
            preparedStatement = connection.prepareStatement("select * from student where name = ?");
            preparedStatement.setString(1, student.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Student(resultSet.getString("name"), resultSet.getLong("studentID"), resultSet.getLong("contact"), null, 0, 'A', 0, null);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }*//*


}
*/
