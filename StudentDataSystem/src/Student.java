public class Student {
    String name;
    String stuNo;
    String classes;
    Course trh;
    Course fzk;
    Course blj;
    double average;
    boolean isPass;
    Student(String name,String stuNo,String classes, Course trh, Course fzk, Course blj){
        this.name=name;
        this.stuNo=stuNo;
        this.trh=trh;
        this.fzk=fzk;
        this.blj=blj;
        this.average=0.0;
        this.isPass=false;}
    void addBulkExamNote(int note1,int note2,int note3,int oralnot1,int oralNot2,int oralNot3){
        if(note1 >=0 && note1 <=100){
            trh.note=note1*0.8+oralnot1*0.2;
        }
        if(note2 >=0 && note2 <=100){
            fzk.note=note2*0.8+oralNot2*0.2;
        }
        if(note3 >=0 && note3 <=100){
            blj.note=note3*0.8+oralNot3*0.2;

        }
    }
    void printNote(){
        System.out.println(trh.name+"  Not: "+ trh.note);
        System.out.println(fzk.name+"  Not: "+ fzk.note);
        System.out.println(blj.name+"  Not: "+ blj.note);
        System.out.println("Ortalama:" + this.average);
    }
    void isPass(){
        this.average=(this.trh.note+this.fzk.note+this.blj.note )/3.0;
        if(this.average>=55){
           System.out.println("Sınıfı geçtiniz");
        }else{System.out.println("Olmadı");}
    }
}
