package com.example.lenovo.xiangmu.Login.Bean;

/**
 * Created by lenovo on 2018/3/29.
 */

public class LoginBean {

    /**
     * result : {"password":"e10adc3949ba59abbe56e057f20f883e","sessionId":"20180329121539152","userName":"20180313112528","userId":152}
     * message : 用户登录成功
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
         * sessionId : 20180329121539152
         * userName : 20180313112528
         * userId : 152
         */

        private String password;
        private String sessionId;
        private String userName;
        private int userId;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
