package lib.models;


public class ErrorModel {
    public String success;
    public Message error;

    public static class Message {
        public Integer code;
        public String type;
        public String info;
    }
}




