package lib.models;

public class ErrorModel {
    private Boolean success;
    private Error error;


    public static class Error {
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
    public ErrorModel setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public ErrorModel setError(Error error) {
        this.error = error;
        return this;
    }

    //getters
    public Boolean getSuccess() {
        return success;
    }

    public Error getError() {
        return error;
    }
}
