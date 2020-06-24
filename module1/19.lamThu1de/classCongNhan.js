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