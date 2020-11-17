package com.aspire.schoolmanagement.service;

import com.aspire.schoolmanagement.models.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentService {

    public Map<String, Object> save(Map<String, Object> student) {

        return student;
    }

    /*public Student createStudent(Student student) {
        jdbcTemplate.update("insert into student(name, contact, address, grade, section, percentage) values (?,?,?,?,?,?)",
                student.getName(),
                student.getContact(),
                student.getAddress(),
                student.getGrade(),
                String.valueOf(student.getSection()),
        return student;
    }*/

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
    }*/

}
