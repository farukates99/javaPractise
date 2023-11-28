public class Teacher {
    String name;
    String telNo;
    String branch;

    Teacher(String name,String telNo,String branch){
        this.name=name;
        this.telNo=telNo;
        this.branch=branch;
    }
    void print(){
        System.out.println("Adı:"+this.name);
        System.out.println("TelNo:"+this.telNo);
        System.out.println("Branch:"+this.branch);

    }
}
