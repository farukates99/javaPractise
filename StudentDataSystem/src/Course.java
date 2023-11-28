public class Course {
    Teacher teacher;
    String name;
    String code;
    String prefix;
    double note;
    int oralExam;
    Course ( String name, String code, String prefix){
        this.name=name;
        this.code=code;
        this.prefix=prefix;
        this.note=0;
        this.oralExam=0;
    }
    void printTeacherInfo(){
        this.teacher.print();
    }
    void addTeacher(Teacher teacher){
        if(teacher.branch.equals(this.prefix)){
            this.teacher=teacher;}
        else{
            System.out.println("Öğretmen ile ders uyuşmuyor");
        }
    }
}
