
    package bai_lam_them.bai1;

    class StudentCodegym {
        private String name = "noname";
        private int id = 0;
        private String dateOfBirth;




        public StudentCodegym(int id, String name, String dateOfBirth) {
            this.name = name;
            this.id = id;
            this.dateOfBirth = dateOfBirth;


        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {

            this.dateOfBirth = dateOfBirth;
        }
    }


