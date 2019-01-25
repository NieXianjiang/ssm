package com.nxj.service;

import com.nxj.entity.User;

public interface UserService {

    User selectByUserName(String username);

}
