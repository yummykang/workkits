package me.yummykang.service;

import me.yummykang.constant.ErrorCode;
import me.yummykang.entity.tables.pojos.Users;
import me.yummykang.entity.tables.records.UsersRecord;
import me.yummykang.exceptions.BusinessErrorException;
import me.yummykang.utils.JwtTokenUtil;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static me.yummykang.entity.tables.Users.USERS;

/**
 * write something to describe this file.
 *
 * @author demon
 * @since 2017-11-08 17:56.
 */
@Service
public class UserService  {
    @Autowired
    private DSLContext dsl;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public Users loadUserByUsername(String username) {
        return dsl.selectFrom(USERS).where(USERS.USERNAME.eq(username)).fetchOne().into(Users.class);
    }

    public String login(Users users) throws BusinessErrorException {
        Users resultUser = loadUserByUsername(users.getUsername());
        if (resultUser != null) {
            return jwtTokenUtil.generateToken(resultUser);
        } else {
            throw new BusinessErrorException(ErrorCode.NAME_OR_PWD_ERROR);
        }
    }
}
