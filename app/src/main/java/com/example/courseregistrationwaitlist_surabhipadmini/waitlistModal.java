package com.example.courseregistrationwaitlist_surabhipadmini;

public class waitlistModal {

    private String courseName;
    private String userPriority;
    private String studentName;
    private String studentDescription;
    private int id;

    public String getCourseName() { return courseName; }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public String getUserPriority()
    {
        return userPriority;
    }

    public void setUserPriority(String userPriority)
    {
        this.userPriority = userPriority;
    }

    public String getStudentName() { return studentName; }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getStudentDescription()
    {
        return studentDescription;
    }

    public void
    setStudentDescription(String studentDescription)
    {
        this.studentDescription = studentDescription;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public waitlistModal(String courseName,
                       String userPriority,
                       String studentName,
                       String studentDescription)
    {
        this.courseName = courseName;
        this.userPriority = userPriority;
        this.studentName = studentName;
        this.studentDescription = studentDescription;
    }
}

