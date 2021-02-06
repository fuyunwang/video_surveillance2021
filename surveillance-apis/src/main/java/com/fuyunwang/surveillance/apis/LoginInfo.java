package com.fuyunwang.surveillance.apis;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2021/2/6 15:13
 */
public class LoginInfo {

    /**
     * code : 0
     * result : {"role":{"roleName":"Super Admin","value":"super"},"userId":"1","username":"vben","token":"fakeToken1","realName":"Vben Admin","desc":"manager"}
     * message : ok
     * type : success
     */

    private int code;
    private ResultBean result;
    private String message;
    private String type;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class ResultBean {
        /**
         * role : {"roleName":"Super Admin","value":"super"}
         * userId : 1
         * username : vben
         * token : fakeToken1
         * realName : Vben Admin
         * desc : manager
         */

        private RoleBean role;
        private String userId;
        private String username;
        private String token;
        private String realName;
        private String desc;

        public RoleBean getRole() {
            return role;
        }

        public void setRole(RoleBean role) {
            this.role = role;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public static class RoleBean {
            /**
             * roleName : Super Admin
             * value : super
             */

            private String roleName;
            private String value;

            public String getRoleName() {
                return roleName;
            }

            public void setRoleName(String roleName) {
                this.roleName = roleName;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
