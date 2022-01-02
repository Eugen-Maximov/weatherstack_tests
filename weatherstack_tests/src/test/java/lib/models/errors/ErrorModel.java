package lib.models.errors;


public class ErrorModel {
    private String success;
    private Message error;

    public static class Message {
        private Integer code;
        private String type;
        private String info;

        //setters
        public void setCode(Integer code) {
            this.code = code;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        //getters
        public Integer getCode() {
            return code;
        }

        public String getType() {
            return type;
        }

        public String getInfo() {
            return info;
        }
    }

    //setters
    public void setSuccess(String success) {
        this.success = success;
    }

    public void setError(Message error) {
        this.error = error;
    }

    //getters
    public String getSuccess() {
        return success;
    }

    public Message getError() {
        return error;
    }
}




