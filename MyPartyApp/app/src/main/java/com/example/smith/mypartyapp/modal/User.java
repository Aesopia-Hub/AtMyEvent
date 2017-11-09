package com.example.smith.mypartyapp.modal;

/**
 * Created by Smith on 2017/10/25.
 */

public class User {


        private int id;
        private int Event_ID;
        private String Username;
        private String Email;
        private String Password;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getEvent_ID(){
            return Event_ID;
        }

        public void setEvent_ID(int Event_ID){

            this.Event_ID = Event_ID;
        }

        public String getUsername() {
            return Username;
        }

        public void setUsername(String Username) {
            this.Username = Username;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String Email) {
            this.Email = Email;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String Password) {
            this.Password = Password;
        }
    }

