package selab.mvc.models.entities;

import selab.mvc.models.DataSet;
import selab.mvc.models.Model;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Student implements Model {
    private String name;
    private String studentNo;
    private String courses ;
    private ArrayList<Integer> points;

    public Student() {
        courses = "";
        points = new ArrayList<>();
    }

    @Override
    public String getPrimaryKey() {
        return this.studentNo;
    }

    public void setName(String value) { this.name = value; }
    public String getName() { return this.name; }

    public void setStudentNo(String value) {
        if (!validateStudentNo(value))
            throw new IllegalArgumentException("The format is not correct");

        this.studentNo = value;
    }
    public String getStudentNo() { return this.studentNo; }

    public float getAverage() {
        // TODO: Calculate and return the average of the points
        if (points.size() == 0)
            return 0;
        double sum = 0;
        for (int point : points){
            sum += point;

        }
        float average = (float) (sum / points.size());
        return average;
    }

    public String getCourses() {
        return courses;
    }

    public void addCourse (String course){
        courses = courses.concat(course);
        courses = courses.concat(",");
    }

    /**
     *
     * @param studentNo Student number to be checeked
     * @return true, if the format of the student number is correct
     */
    private boolean validateStudentNo(String studentNo) {
        Pattern pattern = Pattern.compile("^[8-9]\\d{7}$");
        return pattern.matcher(studentNo).find();
    }

    public void addPoint(int parseInt) {
        points.add(parseInt);
    }
}
