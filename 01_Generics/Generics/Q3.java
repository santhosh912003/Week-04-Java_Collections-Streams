import java.util.*;

class Q3 {
    public static void main(String[] args) {
        List<Course<? extends CourseType>> all = new ArrayList<>();
        all.add(new Course<>(new ExamCourse("Data Structures", 4), "CSE"));
        all.add(new Course<>(new ExamCourse("Mega Structures", 4), "ME"));
        all.add(new Course<>(new ExamCourse("Engineering - DCE", 4), "DCE"));

        CourseUtility.displayAllCourses(all);
    }
}

abstract class CourseType {
    protected String title;
    protected int credits;

    public CourseType(String title, int credits) {
        this.title = title;
        this.credits = credits;
    }

    public abstract void evaluate();

    public void displayInfo() {
        System.out.println("Title: " + title + ", Credits: " + credits);
    }
}

class ExamCourse extends CourseType {
    public ExamCourse(String title, int credits) {
        super(title, credits);
    }

    @Override
    public void evaluate() {
        System.out.println(title + ": Evaluated through a final exam.");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title, int credits) {
        super(title, credits);
    }

    @Override
    public void evaluate() {
        System.out.println(title + ": Evaluated through assignments.");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String title, int credits) {
        super(title, credits);
    }

    @Override
    public void evaluate() {
        System.out.println(title + ": Evaluated through research paper.");
    }
}

class Course<T extends CourseType> {
    private T courseType;
    private String department;

    public Course(T courseType, String department) {
        this.courseType = courseType;
        this.department = department;
    }

    public void showDetails() {
        System.out.println("Department: " + department + " -> ");
        courseType.displayInfo();
        courseType.evaluate();
    }

    public T getCourseType() {
        return courseType;
    }
}

class CourseUtility {
    public static void displayAllCourses(List<? extends Course<? extends CourseType>> courses) {
        for (Course<? extends CourseType> c : courses) {
            c.showDetails();
            System.out.println("----------------------------------------");
        }
    }
}
