
public class Main {
    public static void main(String[] args) {
      Teacher t1 = new Teacher("Ali",  "524003321","TRH");
      Teacher t2 = new Teacher("Mehmet",  "524003321","FZK");
      Teacher t3 = new Teacher("Ahmet","43233222","BLJ");
      Course tarih= new Course("Tarih", "110", "TRH");
      Course fzk=new Course("Fizik","111","FZK");
      Course blj=new Course("Biyoloji","112","BLJ");
      blj.addTeacher(t3);
      tarih.addTeacher(t1);
      fzk.addTeacher(t2);
      Student faruk= new Student("Faruk","217","A",tarih,fzk,blj);
      faruk.addBulkExamNote(100,45,80,50,45,100);
      faruk.isPass();
      faruk.printNote();
      Student yavuz = new Student("Yavuz","211","B",tarih,fzk,blj);
      yavuz.addBulkExamNote(30,23,3,100,100,100);
      yavuz.isPass();
      yavuz.printNote();
    }
    }
