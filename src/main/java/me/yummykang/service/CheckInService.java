package me.yummykang.service;

import me.yummykang.entity.tables.pojos.CheckIn;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static me.yummykang.entity.tables.CheckIn.CHECK_IN;

/**
 * write something to describe this file.
 *
 * @author demon
 * @since 2017-11-08 18:06.
 */
@Service
public class CheckInService {
    @Autowired
    private DSLContext dsl;

    public Object getCheckIns() {
        return dsl.selectFrom(CHECK_IN).fetch().into(CheckIn.class);
    }
}
