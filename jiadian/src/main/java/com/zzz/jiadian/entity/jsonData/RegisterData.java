package com.zzz.jiadian.entity.jsonData;

import com.zzz.jiadian.entity.CtmMsg;
import com.zzz.jiadian.entity.User;

public class RegisterData {
    private User user;
    private CtmMsg ctmMsg;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CtmMsg getCtmMsg() {
        return ctmMsg;
    }

    public void setCtmMsg(CtmMsg ctmMsg) {
        this.ctmMsg = ctmMsg;
    }
}
