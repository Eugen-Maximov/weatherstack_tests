package lib.models;

import java.util.Objects;

public class ErrorModel {
    private String success;
    private Error error;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorModel that = (ErrorModel) o;
        return success.equals(that.success)
                && error.equals(that.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, error);
    }

    public static class Error {
        private Integer code;
        private String type;
        private String info;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Error error = (Error) o;
            return code.equals(error.code)
                    && type.equals(error.type)
                    && info.equals(error.info);
        }

        @Override
        public int hashCode() {
            return Objects.hash(code, type, info);
        }

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
    public ErrorModel setSuccess(String success) {
        this.success = success;
        return this;
    }

    public ErrorModel setError(Error error) {
        this.error = error;
        return this;
    }

    //getters
    public String getSuccess() {
        return success;
    }

    public Error getError() {
        return error;
    }
}
