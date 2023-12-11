package com.example.backendpi.dtos;

public class SchedulesRequest {

    private Long id;
    private ClassRoomRequest classRoom;
    private CourseRequest course;
    private DisciplineRequest discipline;
    private HoursRequest hours;
    private StudentRequest student;
    private TeacherRequest teacher;
    private String classRoomSize;
    private String classRoomType;
    private String classRoomFloor;
    private String courseName;
    private String coursePeriod;
    private String disciplineName;
    private String hoursStart;
    private String hoursEnd;
    private String hoursDay;
    private String hoursValue;
    private String teacherName;
    private String teacherDiscipline;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassRoomRequest getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoomRequest classRoom) {
        this.classRoom = classRoom;
    }

    public CourseRequest getCourse() {
        return course;
    }

    public void setCourse(CourseRequest course) {
        this.course = course;
    }

    public DisciplineRequest getDiscipline() {
        return discipline;
    }

    public void setDiscipline(DisciplineRequest discipline) {
        this.discipline = discipline;
    }

    public HoursRequest getHours() {
        return hours;
    }

    public void setHours(HoursRequest hours) {
        this.hours = hours;
    }

    public StudentRequest getStudent() {
        return student;
    }

    public void setStudent(StudentRequest student) {
        this.student = student;
    }

    public TeacherRequest getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherRequest teacher) {
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
}
