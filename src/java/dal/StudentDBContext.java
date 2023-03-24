/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendance;
import model.Course;
import model.Group;
import model.Lecturer;
import model.Room;
import model.Session;
import model.Student;
import model.Student_User;
import model.TimeSlot;

/**
 *
 * @author admin
 */
public class StudentDBContext extends DBContext<Student>{
 public Student getTimeTable(int sid) {
        Student student = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT s.sid,s.sname,ses.sessionid,ses.date,ses.status\n"
                    + "	,g.gid,g.gname,c.cid,c.cname,r.rid,r.rname,l.lid,l.lname,t.tid,t.description,att.aid,att.status as att_status		\n"
                    + "FROM Student s INNER JOIN [Student_Group]  sg ON s.sid = sg.sid\n"
                    + "						INNER JOIN [Group] g ON g.gid = sg.gid\n"
                    + "						INNER JOIN [Course] c ON g.cid = c.cid\n"
                    + "						INNER JOIN [Session] ses ON g.gid = ses.gid\n"
                    + "						INNER JOIN [TimeSlot] t ON t.tid = ses.tid\n"
                    + "						INNER JOIN [Room] r ON r.rid = ses.rid\n"
                    + "						INNER JOIN [Lecturer] l ON l.lid = ses.lid\n"
                    +"                                          left join Attendance att on att.sid=s.sid and att.sessionid=ses.sessionid"
                    + "WHERE s.sid = ? ";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            rs = stm.executeQuery();
            Group currentGroup = new Group();
            currentGroup.setGid(-1);
            while (rs.next()) {
                if(student == null)
                {
                    student = new Student();
                    student.setSid(rs.getInt("sid"));
                    student.setName(rs.getString("sname"));
                }
                int gid = rs.getInt("gid");
                if(gid != currentGroup.getGid())
                {
                    currentGroup = new Group();
                    currentGroup.setGid(rs.getInt("gid"));
                    currentGroup.setGname(rs.getString("gname"));
                    Course c = new Course();
                    c.setCid(rs.getInt("cid"));
                    c.setCname(rs.getString("cname"));
                    currentGroup.setCourse(c);
                    student.getGroup().add(currentGroup);
                }
                Session ses = new Session();
                ses.setSesid(rs.getInt("sessionid"));
                ses.setDate(rs.getDate("date"));
                ses.setStatus(rs.getBoolean("status"));
                ses.setGroup(currentGroup);
                
                Lecturer l = new Lecturer();
                l.setLid(rs.getInt("lid"));
                l.setLname(rs.getString("lname"));
                ses.setLecturer(l);
                Attendance att = new Attendance();
                att.setAid(rs.getInt("aid"));
                att.setStatus(rs.getBoolean("att_status"));
                att.setSession(ses);
                Room r = new Room();
                r.setRid(rs.getInt("rid"));
                r.setRname(rs.getString("rname"));
                ses.setRoom(r);
                
                TimeSlot t = new TimeSlot();
                t.setTid(rs.getInt("tid"));
                t.setDescription(rs.getString("description"));
                ses.setTimeslot(t);
                
                currentGroup.getSessions().add(ses);

            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return student;
    }
 public Student_User getsu (String username, String password) {
        String sql = "SELECT su.suid,su.username,su.password,s.sid,s.sname \n"
                + "FROM Student_User su inner join Student s on s.sid=su.sid\n"
                + "WHERE username = ? AND [password] = ?";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            
            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if(rs.next())
            {
                Student_User su = new Student_User();
                su.setSuid(rs.getInt("suid"));
                su.setUsername(rs.getString("username"));
                su.setPassword(rs.getString("password"));
                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                su.setStudent(s);
                
                return su;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    @Override
    public void insert(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Student get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Student> all() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
