class Empoloyee {
    constructor(name, birthday,email, id, phone, level, location) {
        this.name = name;
        this.birthday = birthday;
        this.email=email;
        this.id = id;
        this.phone = phone;
        this.level = level;
        this.location = location;
    }

    setName(name) {
        this.name = name;
    }

    getName() {
        return this.name;
    }

    setBirthday(birthday) {
        this.birthday = birthday;
    }

    getBirthday() {
        return this.birthday;
    }
    setEmail(email){
        this.email=email;
    }
    getEmail(){
        return this.email;
    }

    setId(id) {
        this.id = id;
    }

    getId() {
        return this.id;
    }

    setPhone(phone) {
        this.phone = phone;

    }

    getPhone() {
        return this.phone;
    }

    setLevel(level) {
        this.level = level;
    }

    getLevel() {
        return this.level;
    }

    setLocation(location) {
        this.location = location;
    }

    getLocation() {
        return this.location;
    }

    getSalary() {
        if (this.getLocation() === "Manager") {
            this.salary = 500;

        } else if (this.getLocation() === "Sale") {
            this.salary = 300;

        } else if (this.getLocation() === "le tan") {
            this.salary = 200;
        }
        return this.salary;



    }

}