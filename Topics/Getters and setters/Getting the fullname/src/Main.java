class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
       if(firstName != null && !firstName.equals("")){
           this.firstName = firstName;
       } else if (firstName == null){
           this.firstName = "";
       }
    }

    public void setLastName(String lastName) {
       if( lastName != null && !lastName.equals("")){
           this.lastName = lastName;
       } else if (lastName == null){
           this.lastName ="";
       }
    }

    public String getFullName() {

        if(this.firstName.equals("") && this.lastName.equals("")){
            return "Unknown";
        }

        if( this.lastName.length() > 0 && this.firstName.length() > 0 ){
                return this.firstName + " " + this.lastName;
        } else if (this.firstName.length() == 0){
            return this.lastName;
        } else {
            return this.firstName;
        }

    }
}