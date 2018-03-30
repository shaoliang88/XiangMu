package com.example.lenovo.xiangmu.Register.Bean;

/**
 * Created by lenovo on 2018/3/29.
 */

public class RegisterBean {
    /**
     * result : {"password":"e10adc3949ba59abbe56e057f20f883e","userName":"20180329200048"}
     * message : 注册完成
     * status : 0000
     */
    private ResultBean result;
    private String message;
    private String status;
    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public static class ResultBean {
        /**
         * password : e10adc3949ba59abbe56e057f20f883e
         * userName : 20180329200048
         */

        private String password;
        private String userName;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
