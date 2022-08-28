package com.raul.nextyearplan.database;

import com.raul.nextyearplan.utils.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    public static void createDB() {

        Connection conn = null;
        Statement ps = null;
        try {
            Class.forName(Constants.JDBC_DRIVER);

            conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
            ps = conn.createStatement();
            final String sql =

                    "CREATE TABLE IF NOT EXISTS GRADE " +
                            "(gradeId INTEGER not NULL, " +
                            " name VARCHAR(255), " +
                            " gradeCode INTEGER, " +
                            " PRIMARY KEY ( gradeId ));" +

                            "CREATE TABLE IF NOT EXISTS STUDENT " +
                            "(studentId INTEGER not NULL, " +
                            " gradeId INTEGER not NULL, " +
                            " studentCode VARCHAR(255), " +
                            " fileNumber INTEGER, " +
                            " fullName VARCHAR(255), " +
                            " age INTEGER, " +
                            " PRIMARY KEY ( studentId ), " +
                            " FOREIGN KEY (gradeId) REFERENCES GRADE(gradeId));" +

                            "CREATE TABLE IF NOT EXISTS SUBJECT " +
                            "(subjectId INTEGER not NULL, " +
                            " gradeId INTEGER not NULL, " +
                            " subjectName VARCHAR(255), " +
                            " subjectCode VARCHAR(255), " +
                            " optional BOOLEAN, " +
                            " PRIMARY KEY ( subjectId ), " +
                            " FOREIGN KEY (gradeId) REFERENCES GRADE(gradeId));" +

                            "CREATE TABLE IF NOT EXISTS TEACHER " +
                            "(teacherId INTEGER not NULL, " +
                            " fullName VARCHAR(255), " +
                            " age INTEGER, " +
                            " permanent BOOLEAN, " +
                            " PRIMARY KEY ( teacherId ));" +

                            "CREATE TABLE IF NOT EXISTS STUDENT_SUBJECT" +
                            "(studentSubjectId INTEGER not NULL, " +
                            " studentId INTEGER not NULL, " +
                            " subjectId INTEGER not NULL, " +
                            " PRIMARY KEY ( studentSubjectId ), " +
                            " FOREIGN KEY (studentId) REFERENCES STUDENT(studentId), " +
                            " FOREIGN KEY (subjectId) REFERENCES SUBJECT(subjectId));" +

                            "CREATE TABLE IF NOT EXISTS TEACHER_SUBJECT" +
                            "(teacherSubjectId INTEGER not NULL, " +
                            " teacherId INTEGER not NULL, " +
                            " subjectId INTEGER not NULL, " +
                            " PRIMARY KEY ( teacherSubjectId ), " +
                            " FOREIGN KEY (teacherId) REFERENCES TEACHER(teacherId), " +
                            " FOREIGN KEY (subjectId) REFERENCES SUBJECT(subjectId));";

            ps.executeUpdate(sql);

        } catch (final SQLException se) {
            se.printStackTrace();
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (final Exception e) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (final Exception e) {
            }
        }
    }
}
