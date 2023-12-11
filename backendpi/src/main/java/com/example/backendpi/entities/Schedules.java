package com.example.backendpi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Schedules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private ClassRoom classRoom;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @ManyToOne
    @JoinColumn(name = "hours_id")
    private Hours hours;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(length = 500, nullable = false, name = "capacity_room")
    private String classRoomSize;

    @Column(length = 500, nullable = false, name = "type_room")
    private String classRoomType;

    @Column(length = 500, nullable = false, name = "floor_room")
    private String classRoomFloor;

    @Column(length = 500, nullable = false, name = "name_course")
    private String courseName;

    @Column(length = 500, nullable = false, name = "period_course")
    private String coursePeriod;

    @Column(length = 500, nullable = false, name = "name_discipline")
    private String disciplineName;

    @Column(length = 500, nullable = false, name = "time_start")
    private String hoursStart;

    @Column(length = 500, nullable = false, name = "time_end")
    private String hoursEnd;

    @Column(length = 500, nullable = false, name = "class_day")
    private String hoursDay;

    @Column(length = 500, nullable = false, name = "class_hour")
    private String hoursValue;

    @Column(length = 180, nullable = false, name = "name_teacher")
    private String teacherName;

    @Column(length = 100, nullable = false, name = "discipline_teacher")
    private String teacherDiscipline;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Hours getHours() {
        return hours;
    }

    public void setHours(Hours hours) {
        this.hours = hours;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getClassRoomSize() {
        return classRoomSize;
    }

    public void setClassRoomSize(String classRoomSize) {
        this.classRoomSize = classRoomSize;
    }

    public String getClassRoomType() {
        return classRoomType;
    }

    public void setClassRoomType(String classRoomType) {
        this.classRoomType = classRoomType;
    }

    public String getClassRoomFloor() {
        return classRoomFloor;
    }

    public void setClassRoomFloor(String classRoomFloor) {
        this.classRoomFloor = classRoomFloor;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCoursePeriod() {
        return coursePeriod;
    }

    public void setCoursePeriod(String coursePeriod) {
        this.coursePeriod = coursePeriod;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public String getHoursStart() {
        return hoursStart;
    }

    public void setHoursStart(String hoursStart) {
        this.hoursStart = hoursStart;
    }

    public String getHoursEnd() {
        return hoursEnd;
    }

    public void setHoursEnd(String hoursEnd) {
        this.hoursEnd = hoursEnd;
    }

    public String getHoursDay() {
        return hoursDay;
    }

    public void setHoursDay(String hoursDay) {
        this.hoursDay = hoursDay;
    }

    public String getHoursValue() {
        return hoursValue;
    }

    public void setHoursValue(String hoursValue) {
        this.hoursValue = hoursValue;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherDiscipline() {
        return teacherDiscipline;
    }

    public void setTeacherDiscipline(String teacherDiscipline) {
        this.teacherDiscipline = teacherDiscipline;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Schedules other = (Schedules) obj;
        return id != null && id.equals(other.id);
    }
}
