class CongNhan {
    constructor(stt, name, birthday, addRess, salary, position) {
        this.stt = stt;
        this.name = name;
        this.birthday = birthday;
        this.addRess = addRess;
        this.salary = salary;
        this.position = position;


    }

    setStt(stt) {
        this.stt = stt;
    }

    getStt() {
        return this.stt;
    }
    setName(name) {
        this.name=name;
    }

    getName() {
        return this.name;
    }

    setBirthday(birthday){
        this.birthday=birthday;
    }

    getBirthday(){
        return  this.birthday;
    }

    setAddRess(addRess){
        this.addRess=addRess;
    }
    getAddRess(){
        return this.addRess;
    }
    setSalary(salary){
        this.salary=salary;

    }
    getSalary(){
        return this.salary;
    }
    setPosition(position){
        this.position=position;
    }
    getPosition(){
        return this.position;
    }





}
congNhan1= new CongNhan(1,"Trương Tấn B","11-11-1997","Quảng Nam",2000,"Abc");
congNhan2= new CongNhan(2,"Trương Tấn A","11-11-1998","Đà Nẵng",2000,"Abc");
congNhan3= new CongNhan(3,"Trương Tấn C","11-11-1999","Huế",2000,"Abc");