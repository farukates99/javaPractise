public class Employee {
    String name;
    int salary;
    int workHours;
    int hireYear;

    Employee(String name,int salary,int workHours,int hireYear){
        this.name=name;
        this.salary=salary;
        this.hireYear=hireYear;
        this.workHours=workHours;
    }

    double tax(){
        if(this.salary<1000){
            return 0;
        }else return this.salary*0.03;
    }
    int bonus(){
        if(this.workHours>40){
            return (workHours-40)*30;
        }
        return 0;
    }
    double raiseSalary(){
        if((2021-this.hireYear)<10){
          return this.salary*0.05;
        } else if ((2021-this.hireYear)>9 && (2021-this.hireYear)<20){
            return this.salary*0.1;
        }else return this.salary*0.15;
    }
    void employeeInformation(){
        System.out.println("Adı : "+this.name);
        System.out.println("Maaşı : "+this.salary);
        System.out.println("Çalışma Saati : "+this.workHours);
        System.out.println("Başlangıç Yılı : "+this.hireYear);
        System.out.println("Vergi : "+this.tax());
        System.out.println("Bonus : "+this.bonus());
        System.out.println("Maaş Artışı : "+this.raiseSalary());
        System.out.println("Vergi ve Bonuslar ile birlikte maaş : "+(this.bonus()+this.salary-this.tax()));
        System.out.println("Toplam Maaş : "+(this.bonus()+this.salary+this.raiseSalary()-this.tax()));

    }
}
