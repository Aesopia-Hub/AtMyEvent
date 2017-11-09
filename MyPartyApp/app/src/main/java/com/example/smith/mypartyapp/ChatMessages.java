package com.example.smith.mypartyapp;



public class ChatMessages {

    final boolean left;
    String message;
    private String messageUser;
    private long messageTime;

    public ChatMessages(boolean left, String message ){

        super();

        this.left = left;
        this.message = message;

      //  messageTime = new Date().getTime();
    }

    // public ChatMessages(){
    // }

    //public ChatMessages(boolean left, String message) {
     // }

     // public String getMessageText(){
   //  return messageText;
   //  }

    // public void setMessageText(String messageText){
   //  this.messageText = messageText;
   //  }

     public String getMessageUser(){
      return messageUser;
      }

     public void setMessageUser(String messageUser){
      this.messageUser = messageUser;
     }

    public long getMessageTime(){
    return getMessageTime();
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
     }
}
