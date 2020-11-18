package com.aspire.schoolmanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final JdbcTemplate jdbcTemplate;

    public Map<String, Object> save(Map<String, Object> student) {
        //Select data from table

        /*jdbcTemplate.execute("CREATE TABLE if not exists employee (\n" +
                "\temployeeID bigserial PRIMARY KEY,\n" +
                "\tcontact bigint,\n" +
                "\taddress varchar(100),\n" +
                "\tsalary float,\n" +
                "\tdesignation varchar(20),\n" +
                "\tdepartment varchar(20),\n" +
                "\tcontractTenure varchar(20)\n" +
                ")");*/


        /*dbcTemplate.update("insert into student(name, contact, address, grade, section, percentage) values(?,?,?,?,?,?)",
                student.get("name"),
                Long.parseLong((String) student.get("contact")),
                student.get("address"),
                Integer.parseInt((String) student.get("grade")),
                student.get("section"),
                Float.parseFloat((String) student.get("percentage")));*/

        /*List<Map<String, Object>> studentList = jdbcTemplate.queryForList("select * from student where name=?", student.get("name"));
        List<Student> students = jdbcTemplate.query("select * from student", new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student1 = new Student(resultSet.getString("name"), resultSet.getLong("studentID"), resultSet.getLong("contact"), null, 0, 'A');
                return student1;
            }
        });*/

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
