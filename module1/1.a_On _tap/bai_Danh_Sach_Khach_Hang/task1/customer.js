class Customer {
    constructor(name, id_card,date_of_birth, email, add_ress, customer_type, discount,
                accompanying_person, rentDay, type_of_service,room_type) {
        this.name = name;
        this.id_card = id_card;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.add_ress = add_ress;
        this.customer_type = customer_type;
        this.discount = discount;
        this.accompanying_person =accompanying_person;
        this.rentDay = rentDay;
        this.type_of_service = type_of_service;
        this.room_type = room_type;
    }

    setName(name) {
        this.guest_name = name;
    }

    getName() {
        return  this.name ;
    }

    setId(id_card) {
        this.id_card = id_card;
    }

    getId() {
        return  this.id_card = id_card;
    }

    setBirth(date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    getBirth(date_of_birth) {
        return this.date_of_birth ;
    }

    setEmail(email) {
        this.email = email;
    }

    getEmail() {
        return this.email
    }

    setAddRess(add_ress) {
        this.add_ress = add_ress;

    }

    getAddRess() {
        return this.add_ress ;
    }

    setCustomerType(customer_type) {
        this.customer_type = customer_type;
    }

    getCustomerType() {
        return this.customer_type ;
    }

    setDiscout(discount) {
        this.discount = discount;
    }

    getDiscout() {
        return this.discount ;
    }

    setAccompanyingPerson(accompanying_person) {
        this.accompanying_person =accompanying_person;
    }

    getAccompanyingPerson() {
        return this.accompanyingPerson ;
    }

    setRentDay(rentDay) {
        this.rentDay = rentDay;
    }

    getRentDay() {
        return this.rentDay ;
    }
    setTypeOfService(type_of_service){
        this.type_of_service = type_of_service;
    }
    getTypeOfService(){
        return  this.type_of_service ;
    }
    setRoomType(room_type){
        this.room_type = room_type;

    }
    getRoomType(){
        return   this.room_type ;

    }
    totolPay(){
        let money=0;
        if(this.type_of_service==="Villa"){
            money =500;
        } else if (this.type_of_service()==="House"){
            money=300;

        } else if(this.type_of_service()==="Room"){
            money=200;
        }
        return this.getRentDay()*money*(1-this.getDiscout()/100);
    }



}
